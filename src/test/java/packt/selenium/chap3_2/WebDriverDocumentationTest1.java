package packt.selenium.chap3_2;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import packt.selenium.pageobject.Documentation;
import packt.selenium.pageobject.SeleniumHQ;

public class WebDriverDocumentationTest1 {
	private WebDriver driver;
	private SeleniumHQ seleniumHQ;
	private Documentation documentationPage;
	
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
	public void testVerifyTitle_WebDriverDocumentation() throws Exception {
		seleniumHQ = new SeleniumHQ(driver);
		seleniumHQ.clickDocumentation();
		documentationPage = new Documentation(driver);
		documentationPage.navigateToWebDriverDocumentation();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Selenium WebDriver ¡ª Selenium Documentation";
		assertEquals (expectedTitle, actualTitle);
	}

}
