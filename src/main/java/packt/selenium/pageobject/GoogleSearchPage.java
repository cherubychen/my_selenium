package packt.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
	private WebDriver driver;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		System.out.println(driver.getTitle());
		if (!driver.getTitle().equals("Mastering Selenium Testing - Google Search")){
			throw new WrongPageException("Incorrect page for google search");
		}
	}
	
	public String getNumberOfResults() {
		String numberOfResult = driver.findElement(By.id("resultStats")).getText();
		System.out.println(numberOfResult);
		return numberOfResult;
	}

}
