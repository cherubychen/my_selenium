package packt.selenium.chap3_8;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForComponentExampleTest1 {
	private WebDriver driver;

	@Before 
	public void setup() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.socks", "localhost");
		profile.setPreference("network.proxy.socks_port", 8888);
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@After 
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testWaitForComponent() throws Exception {
		shouldWaitForPageToLoad3();
		assertEquals(driver.getTitle(), "selenium web driver - Google Search");
	}

	
	//The best method, check if the wanted element is in the web page
	private void shouldWaitForPageToLoad3() {
		navigateToGoogleSearchPage();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='resultStats']")));
		
	}

	//success to run, but not efficient
	private void shouldWaitForPageToLoad2() {
		navigateToGoogleSearchPage();
		try {
			Thread.sleep(2000);
		}catch (Exception e){
			e.getMessage();
		}
		
	}
	

	//failed example 
	private void shouldWaitForPageToLoad1() {
		navigateToGoogleSearchPage();
	}
	
	

	private void navigateToGoogleSearchPage() {
		driver.findElement(By.id("lst-ib")).sendKeys("selenium web driver");
		driver.findElement(By.name("btnG")).click();
	}
	

}
