package packt.selenium.chap3_8;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class XPathExampleTest1 {
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
		driver.get("http://www.w3schools.com/xsl/xpath_intro.asp");
	}
	
	@After 
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test 
	public void testXPathExample() throws Exception {
		WebElement link = driver.findElement(By.xpath(".//*[@id='main']/h1"));
		String linkTest = link.getText();
		System.out.println(linkTest);
	}
}
