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

public class ProductPage extends AbstactMethods {
	
//	
	WebDriver driver;
	public ProductPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	
	By locator= By.xpath("(//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted'])[1]");
	By locator1=By.xpath("//div[@class='npx-spinner-overlay']");
	By locator2=By.id("toast-container");
	By locator3=By.cssSelector(".cartWrap");
           
	    //pageFactory
	
	     @FindBy(css="b")
	     List<WebElement> Products;
	     
	     @FindBy(xpath="(//i[@class='fa fa-shopping-cart'])[2]")
	     WebElement pickedProd;
	     
	     @FindBy(css=".fa-shopping-cart")
	     WebElement cartSymbol;
	     
	     
	     
	    
	
      //List<WebElement> Products = driver.findElements(By.cssSelector("b"));
	public List<WebElement> getProductList() {
		waitForElementToVisible(locator);
		 return Products;
	}
	
	
	public WebElement getProductName() {
		
		List<WebElement> allProd=getProductList();
		Iterator<WebElement> itr = allProd.iterator();
	    for(int i=0;itr.hasNext();i++)
	    {
	    	String text=allProd.get(i).getText();
	    	if(text.equalsIgnoreCase("ZARA COAT 3"))
	    	{
	    		return pickedProd;
//	    		break;
	    	}
	    }
	    return pickedProd;
	}

	public void addProductToCart(String prodName) throws InterruptedException {
		
		WebElement prod=getProductName();
		prod.click();
		waitForElementToInVisible(locator1);
		waitForElementToVisible(locator2);
		   Thread.sleep(2000);
		
	}
	public CartPage cartProduct(){
		cartSymbol.click();
		waitForElementToVisible(locator3);
		CartPage catrpage=new CartPage(driver);
		return catrpage;
	}

}
