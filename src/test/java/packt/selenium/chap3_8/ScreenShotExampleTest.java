package packt.selenium.chap3_8;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class ScreenShotExampleTest {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setup() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.socks", "localhost");
		profile.setPreference("network.proxy.socks_port", 8888);
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/");
	}
	
	@AfterClass 
	public static void tearDown() throws Exception {
		driver.quit();
	}
	
	@Rule
	public ScreenShotRule screenShootRule = new ScreenShotRule(driver);
	
    @Test
    public void linkedInRegistrationShouldFail() {
    	driver.findElement(By.id("first-name")).sendKeys("CHEN");
    	//driver.findElement(By.id("last-name")).sendKeys("JIE YUN");
    	driver.findElement(By.id("lastname")).sendKeys("JIE YUN");
    	System.out.println("It should fail");
    	
    }

}

