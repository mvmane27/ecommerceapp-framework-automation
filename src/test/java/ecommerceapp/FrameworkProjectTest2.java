package ecommerceapp;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameworkProjectTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Mrunal\\TESTING\\Selenium\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		//create object of the webdriverWait class
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(7000));
		
		 //		code for login
		driver.findElement(By.id("userEmail")).sendKeys("mrunalv21@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Bellus@123");
		driver.findElement(By.id("login")).click();
		
		 //wait till all the elements of home page are visible
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("col-lg-4")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".col-lg-4")));
		
		
		//make a list of all web elements
//	    List<WebElement> products = driver.findElements(By.cssSelector("b"));
	    List<WebElement> Products = driver.findElements(By.cssSelector("b"));
		
		//Iterate the list and find ZARA COAR 3
		Iterator<WebElement> itr = Products.iterator();
	    for(int i=0;itr.hasNext();i++)
	    {
	    	String text=Products.get(i).getText();
	    	if(text.equalsIgnoreCase("ZARA COAT 3"))
	    	{
	    		driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[2]")).click();
	    		break;
	    	}
	    }
	    //wait until visibility of "product added to a cart massage" appear
        //invisibility of spinner
		
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='npx-spinner-overlay']")));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		Thread.sleep(2000);
		
		 //clicking on the cart button
	    driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
		
		 //wait until all element load into a cart
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='cartWrap ng-star-inserted']")));
        
	    //check wheather "ZARA COAT 3" is present in the cart or not
	    List<WebElement> cartProducts = driver.findElements(By.cssSelector("h3"));  
      	
	    //Iterate the list and find ZARA COAT 3
	    Iterator<WebElement> itr1 = cartProducts.iterator();
	    for(int j=0;itr1.hasNext();j++)
	    {
	    	String text1=cartProducts.get(j).getText();
	    	if(text1.equalsIgnoreCase("ZARA COAT 3"))
	    	{
	    		JavascriptExecutor js=(JavascriptExecutor)driver;
	    		js.executeScript("window.scrollBy(1039,574)");

	    		driver.findElement(By.xpath("//ul/li/button[@class='btn btn-primary']")).click();
	    		break;
	    	}
	    }

		//input: cvv,name,coupon
	    driver.findElement(By.xpath("(//input[@class='input txt'])[1]")).sendKeys("123");
	    driver.findElement(By.xpath("(//input[@class='input txt'])[2]")).sendKeys("Mrunal Mane");
	    driver.findElement(By.name("coupon")).sendKeys("rahulshettyacademy");
	    
	    //JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0, 500)");
			Thread.sleep(1000);
	      driver.findElement(By.xpath("//button[@type='submit']")).click();
	      
	      //wait until invisibility of the spinner
	      // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='npx-spinner-overlay']")));
	      Thread.sleep(3000);
	      
	      //handle auto suggestive drop down
	        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	        
	        List<WebElement> country = driver.findElements(By.cssSelector(".ta-item"));  
	        
	        //Iterate the list and find India
		    Iterator<WebElement> itr2 = country.iterator();
		    for(int k=0;itr2.hasNext();k++)
		    {
		    	String text2=country.get(k).getText();
		    	if(text2.equalsIgnoreCase("india"))
		    	{
		    		driver.findElement(By.xpath("//*[text()=' India']")).click();
		    		break;
		    	}
		    }
		    
		    //click on the place order button
		    driver.findElement(By.cssSelector(".action__submit")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		    
		    //validating success message
		    String text3=driver.findElement(By.cssSelector(".hero-primary")).getText();
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
