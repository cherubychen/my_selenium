package packt.selenium.chap3_8;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class CheckboxesExampleTest {
	
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
		driver.get("http://www.w3schools.com/html/html_form_input_types.asp");
	}
	
	@After 
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test 
	public void testCheckboxes_W3Schools() throws Exception {
		WebElement checkbox1 = driver.findElement(By.name("vehicle1"));
		WebElement checkbox2 = driver.findElement(By.name("vehicle2"));
		boolean isFirstSelected = checkbox1.isSelected();
		assertFalse(isFirstSelected);
		boolean isSecondSelected = checkbox2.isSelected();
		assertFalse(isSecondSelected);
		
		System.out.println(checkbox1.getAttribute("value") + ": " + isFirstSelected);
		System.out.println(checkbox2.getAttribute("value") + ": " + isSecondSelected);
	}

}
