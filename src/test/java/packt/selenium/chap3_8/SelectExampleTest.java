package packt.selenium.chap3_8;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class SelectExampleTest {
	private WebDriver driver;
	private List<WebElement> options;
	
	@Before 
	public void setup() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.socks", "localhost");
		profile.setPreference("network.proxy.socks_port", 8888);
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
	}
	
	@After 
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test 
	public void testSelect_W3Schools() throws Exception {
		navigateToSelect();
		for(WebElement option : options) {
			System.out.println(option.getText());
		}
		driver.switchTo().defaultContent();
	}

	//For Navigation 
	private void navigateToSelect() {
		driver.switchTo().frame("iframeResult");
		Select dropDownList = new Select((driver.findElement(By.tagName("select"))));
		System.out.println("First selected item: " + dropDownList.getFirstSelectedOption().getText());
		
		options = dropDownList.getOptions();
		System.out.println("Number of items: " + options.size());
		
	}
	
}
