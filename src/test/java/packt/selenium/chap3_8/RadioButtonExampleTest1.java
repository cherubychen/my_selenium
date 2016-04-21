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

public class RadioButtonExampleTest1 {
	private WebDriver driver;
	private List<WebElement> radioGroup;
	
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
	public void testGetSelectedRadioButton() throws Exception {
		navigateToRadioButton();
		for (WebElement element : radioGroup) {
			boolean isRadioSelected = element.isSelected();
			if (isRadioSelected == true) {
				System.out.println("Selected Radio button: " + element.getAttribute("value"));
			}
		}
	}

	//For navigation 
	public void navigateToRadioButton() {
		driver.get("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_input_radio");
		driver.switchTo().frame("iframeResult");
		radioGroup = driver.findElements(By.name("gender"));
		System.out.println("Number of Radio buttons: " + radioGroup.size());
	}
	
}
