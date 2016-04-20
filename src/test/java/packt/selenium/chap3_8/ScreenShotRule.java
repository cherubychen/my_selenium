package packt.selenium.chap3_8;


import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotRule implements MethodRule{
	private WebDriver driver;
	
	public ScreenShotRule(WebDriver driver){
		this.driver = driver;
	}
	
	
	public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, Object object){
		return new Statement() {
			
			@Override
			public void evaluate() throws Throwable {
				try {
					statement.evaluate();
				} catch (Throwable throwable) {
					captureScreenShot(frameworkMethod.getName());
					throw throwable; 
				}
			}

			public void captureScreenShot(String fileName) {
				try {
					FileOutputStream out = new FileOutputStream("E:/selenium/screenshot-" + fileName + ".jpeg");
					out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
					out.close();
					
				} catch (Exception e) {
					 System.out.println("Failure to take screenshot " + e);
				}
				
			}
		};
		
	}

	
}
