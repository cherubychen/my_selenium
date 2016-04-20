package packt.selenium.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumHQ {
	private WebDriver driver;
	private String baseUrl;

	public SeleniumHQ(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
		baseUrl = "http://www.seleniumhq.org";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + "/");
	}

	public Documentation clickDocumentation() {
		driver.findElement(By.linkText("Documentation")).click();
		return new Documentation(driver);	
	}

}
