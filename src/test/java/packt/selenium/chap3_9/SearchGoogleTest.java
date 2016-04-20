package packt.selenium.chap3_9;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import packt.selenium.pageobject.Google;
import packt.selenium.pageobject.GoogleSearchPage;

public class SearchGoogleTest {
	private WebDriver driver;
	public Google googlePage;
	public GoogleSearchPage searchPage;
	
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
	
	//For validation 
	@Test
	public void testGoogleSearch() {
		googlePage = new Google(driver);
		searchPage = googlePage.goToSearchPage();
		searchPage.getNumberOfResults();
	}
	

}
