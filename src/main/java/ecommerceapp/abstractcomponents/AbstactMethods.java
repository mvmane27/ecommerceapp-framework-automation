package ecommerceapp.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstactMethods {
	
//	FrameworkProjectTest  -->  ProductPage --> AbstractMethods
	
	WebDriver driver;
	public AbstactMethods(WebDriver driver) {
			
			this.driver=driver;
//			PageFactory.initElements(driver,this);
		}
	public void waitForElementToVisible(By locator) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(7000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public void waitForElementToInVisible(By locator) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(7000));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		
	}

}
