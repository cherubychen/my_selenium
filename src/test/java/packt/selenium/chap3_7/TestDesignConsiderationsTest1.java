package packt.selenium.chap3_7;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import packt.selenium.pageobject.Documentation;
import packt.selenium.pageobject.SeleniumHQ;
import packt.selenium.pageobject.TestDesignConsiderations;

public class TestDesignConsiderationsTest1 {
	
	private WebDriver driver;
	private Documentation documentationPage;
	private SeleniumHQ seleniumHQ;
	private TestDesignConsiderations testDesignConsiderationsPage;
	
	@Before 
	public void setup() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.socks", "localhost");
		profile.setPreference("network.proxy.socks_port", 8888);
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After 
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testHeading_PageObjectDesignPattern() throws Exception {
		seleniumHQ = new SeleniumHQ(driver);
		documentationPage = seleniumHQ.clickDocumentation();
		testDesignConsiderationsPage = documentationPage.navigateToTestDesignConsiderations();
	
		String actualHeading = testDesignConsiderationsPage.getTextHeadingPageObjectDesignPattern();
		System.out.println("Actual Heading is: " + actualHeading);
		String expectedHeading = "Page Object Design Pattern";
		assertEquals (expectedHeading, actualHeading);
	}

}
