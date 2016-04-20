package packt.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Documentation {
	private WebDriver driver;
	
	public Documentation (WebDriver driver){ 
		this.driver = driver;
	}
	
	public WebDriverDocumentation navigateToWebDriverDocumentation(){
		driver.findElement(By.linkText("Selenium WebDriver")).click();
        return new WebDriverDocumentation(driver);
	}

	public TestDesignConsiderations navigateToTestDesignConsiderations() {
		driver.findElement(By.linkText("Test Design Considerations")).click();
		return new TestDesignConsiderations(driver);
	}
}
