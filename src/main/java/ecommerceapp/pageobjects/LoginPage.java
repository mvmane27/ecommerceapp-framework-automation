package ecommerceapp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//	driver.findElement(By.id("userEmail")).sendKeys("mrunalv21@gmail.com");
//	driver.findElement(By.id("userPassword")).sendKeys("Bellus@123");
//	driver.findElement(By.id("login")).click();
	
    //pagefactory
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	public ProductPage LoginToApplication(String userEmail,String pwd) {
		email.sendKeys(userEmail);
		password.sendKeys(pwd);
		login.click();
		ProductPage prodpage=new ProductPage(driver);
		return prodpage;
	}
	
	public void goToUrl(){
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

}
