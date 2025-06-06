package ecommerceapp;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ecommerceapp.TestComponents.BaseTest;
import ecommerceapp.pageobjects.CartPage;
import ecommerceapp.pageobjects.ConfirmSectionPage;
import ecommerceapp.pageobjects.LoginPage;
import ecommerceapp.pageobjects.PlaceOrderPage;
import ecommerceapp.pageobjects.ProductPage;

public class FrameworkProjectTest extends BaseTest{

	    @Test
	    public void submitOrder() throws InterruptedException, IOException
	    {
		String prodName="ZARA COAT 3";
		String cvv="123";
		String name="Mrunal Mane";
		String couponcode="rahulshettyacademy";
		String country="india";
		
		
		//create object of the webdriverWait class
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(7000));
		
		//code for login page
		LoginPage logpage= lounchApp();
		ProductPage prodpage=logpage.LoginToApplication("mrunalv21@gmail.com","Bellus@123");
		
		//code for Product page
		
//		List<WebElement> Products =prodpage.getProductList();
		prodpage.addProductToCart(prodName);
		CartPage catrpage=prodpage.cartProduct();
		
		//code for cart page
		 PlaceOrderPage placeorderpage=catrpage.verifyProduct(prodName);
		
		//code for placeorder page
		placeorderpage.personalinfo(cvv,name,couponcode);
		ConfirmSectionPage confirmsectionpage=placeorderpage.selectCountry(country);
		
		//code for confirmsection  page
		confirmsectionpage.verifyingmessage();
	    }

		
		

		    

		    
					

	}


