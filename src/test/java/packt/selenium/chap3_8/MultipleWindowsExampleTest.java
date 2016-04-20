package packt.selenium.chap3_8;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class MultipleWindowsExampleTest {
	private WebDriver driver;
	private JavascriptExecutor jse;
	String windowGoogle, windowBing; 

	@Before 
	public void setup() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.socks", "localhost");
		profile.setPreference("network.proxy.socks_port", 8888);
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		jse = (JavascriptExecutor) driver;
	}
	
	/*
	@After 
	public void tearDown() throws Exception {
		driver.quit();
	}
	*/
	
	@Test
	public void testWindowHandle() throws Exception {
		openFirstWindow();
		getNewWindow();
		System.out.println("Number of windows handle: " + driver.getWindowHandles().size());
		Thread.sleep(2000);
	    driver.switchTo().window(windowGoogle);
	    Thread.sleep(2000);
	    driver.switchTo().window(windowBing);
	}

	private void getNewWindow() {
		jse.executeScript("window.open('http://www.bing.com/');");
		System.out.println("here-before for interation");
	    for (String handleStr : driver.getWindowHandles()) {
	    	System.out.println(handleStr);
	    	if (handleStr != windowGoogle){
	    		 windowBing = handleStr;
	    	}
	    }
	    System.out.println("Second Window handle: " + windowBing);
	}

	private void openFirstWindow() {
		driver.get("https://www.google.com/");
		windowGoogle = driver.getWindowHandle();
		System.out.println("First window handle: " + windowGoogle);	
	}
}
