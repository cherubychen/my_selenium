package packt.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {
	private WebDriver driver;
	private String baseURL;
	
	public Google(WebDriver driver) {
		this.driver = driver;
		baseURL = "https://www.google.com/";
		driver.get(baseURL);
		System.out.println(driver.getTitle());
		if (!driver.getTitle().equals("Google-test")) {
			throw new WrongPageException("Incorrect Page of google");
		}
	}
	
	public GoogleSearchPage goToSearchPage() {
		driver.findElement(By.id("lst-ib")).sendKeys("Mastering Selenium Testing");
		driver.findElement(By.name("btnG")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='resultStats']")));
		return new GoogleSearchPage(driver);
	}
	

}
