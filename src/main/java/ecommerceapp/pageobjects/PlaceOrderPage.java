package ecommerceapp.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ecommerceapp.abstractcomponents.AbstactMethods;

//import ecommerceapp.abstractcomponents.AbstactMethods;

                public class PlaceOrderPage extends AbstactMethods {
	                    WebDriver driver;
	                       public PlaceOrderPage(WebDriver driver) {
	                    	   
	                    	super(driver);
			                this.driver=driver;
			                PageFactory.initElements(driver,this);
		                   }
	                       
	                     //pageFactory
	                    	
	              	     @FindBy(xpath="(//input[@class='input txt'])[1]")
	              	     WebElement cvv;
	              	     
	              	     @FindBy(xpath="(//input[@class='input txt'])[2]")
	              	     WebElement name;
	              	     
	              	     @FindBy(name="coupon")
	              	     WebElement couponcode;
	              	     
	              	     @FindBy(xpath="//button[@type='submit']")
	              	     WebElement applycoupon;
	              	     
	              	     @FindBy(xpath="//input[@placeholder='Select Country']")
	              	     WebElement countryName;
	              	     
	              	     @FindBy(css=".ta-item")
	              	     List<WebElement> allCountries;
	              	     
	              	     @FindBy(xpath="//*[text()=' India']")
	              	     WebElement indiacountry;
	              	    
	              	     @FindBy(css=".action__submit")
	              	     WebElement placeorderButton;
	              	  
	              	  
	              	     
	              	     By locator=By.cssSelector(".ta-results");
	              	     By locator1=By.cssSelector(".hero-primary");
	              	     
	              	     public void personalinfo(String cvvv,String Uname,String couponcodee) throws InterruptedException {
	              	    	 cvv.sendKeys(cvvv);
	              	    	name.sendKeys(Uname);
	              	    	couponcode.sendKeys(couponcodee);
	              	        //JavascriptExecutor js=(JavascriptExecutor)driver;
		              		//js.executeScript("window.scrollBy(0, 500)");
	              	    	Thread.sleep(1000);
	              	    	applycoupon.click();
	              	        //wait until invisibility of the spinner
//	              	       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='npx-spinner-overlay']")));
	              	       Thread.sleep(3000);
	              			
	              	     }
	              	     public ConfirmSectionPage selectCountry(String country) {
//	              	    	 handle auto suggestive drop down
	              	    	countryName.sendKeys(country);
	              	    	waitForElementToVisible(locator);
//	              	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	              	        
	              	        List<WebElement> countries = allCountries;  
	              	        
	              	        //Iterate the list and find India
	              		    Iterator<WebElement> itr2 = countries.iterator();
	              		    for(int k=0;itr2.hasNext();k++)
	              		    {
	              		    	String text2=countries.get(k).getText();
	              		    	if(text2.equalsIgnoreCase(country))
	              		    	{
	              		    		indiacountry.click();
	              		    		break;
	              		    	}
	              		    }
	              		    
	              		    //click on the place order button
	              		  placeorderButton.click();
	              		  waitForElementToVisible(locator1);
	              		ConfirmSectionPage confirmsectionpage=new ConfirmSectionPage(driver);
	              		  return confirmsectionpage;
	              	     }
	              	     
      
}
