package ecommerceapp.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

             public class CartPage {
	                     WebDriver driver;
             public CartPage(WebDriver driver) {
		
	                     this.driver=driver;
		                 PageFactory.initElements(driver,this);
	                       }
             
           //pageFactory
         	
    	     @FindBy(css="h3")
    	     List<WebElement> carProducts;
    	     
    	     @FindBy(xpath="//ul/li/button[@class='btn btn-primary']")
    	     WebElement chkButton;
    	     
    	     public List<WebElement> getcarProductList() {
    	    	 return carProducts;
    	     }
    	     
    	     public PlaceOrderPage verifyProduct(String cartProdName) throws InterruptedException {
                        //Iterate the list and find ZARA COAT 3
    	    	        List<WebElement> allProductInCart=getcarProductList();
                        Iterator itr1 = allProductInCart.iterator();
                       for(int j=0;itr1.hasNext();j++)
                          {
	                            String text1=allProductInCart.get(j).getText();
	                           if(text1.equalsIgnoreCase(cartProdName))
	                         {
		                     JavascriptExecutor js=(JavascriptExecutor)driver;
		                     js.executeScript("window.scrollBy(1039,574)");
		                     Thread.sleep(1000);
		                     chkButton.click();
		                      break;
	                         }
                          }
                       PlaceOrderPage placeorderpage=new PlaceOrderPage(driver);
                       return placeorderpage;
    	     }

             }
