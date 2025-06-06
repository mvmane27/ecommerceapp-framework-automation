package ecommerceapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmSectionPage {
	WebDriver driver;
	public ConfirmSectionPage(WebDriver driver) {
			
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	
    ///page factory
	
	@FindBy(css=".hero-primary")
    WebElement thankYouMsg;
	
	
	public void verifyingmessage() {
	String text3=thankYouMsg.getText();
    if(text3.equalsIgnoreCase("Thankyou for the order."))
    {
    	System.out.println("\nOrder placed successfully......");
    }
    else
    {
    	System.out.println("Message is wrong");
    }	    

}
}
