package packt.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestDesignConsiderations {
	private WebDriver driver;
	
	public TestDesignConsiderations (WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("Test Design Considerations ¡ª Selenium Documentation")) {
			throw new WrongPageException("Incorrect Page for Test Design Considerations");
		}	
	}
	
	public String getTextHeadingPageObjectDesignPattern(){
		String actualHeading = driver.findElement(By.xpath("//div[@id='page-object-design-pattern']/h2")).getText();
		return actualHeading;
	}
	
	public TestDesignConsiderations navigateToWebDriverDocumentation() {return this;}
	
	
}

