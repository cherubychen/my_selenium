package com.ibmtester.webdriver;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



@SuppressWarnings("deprecation")
public class MyFirstTest1 {
	@Test
	public void startWebDriver() {
		
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://seleniumsimplified.com");
		Assert.assertTrue("title should start differently", 
				          driver.getTitle().startsWith("Selenium Simplified"));
		driver.close();
	}

}
