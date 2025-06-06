package ecommerceapp.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ecommerceapp.pageobjects.LoginPage;

public class BaseTest {

	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\vinay\\eclipse-workspace\\project\\src\\main\\java\\ecommerceapp\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Mrunal\\TESTING\\Selenium\\Drivers\\chromedriver.exe");

			// FIX: Assign to class-level driver, not create a local variable
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// Add Firefox setup
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Add Edge setup
		}

		// Now this will work, because driver is correctly initialized
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod
	 public LoginPage lounchApp() throws IOException {
		driver = initializeDriver();
		LoginPage logpage = new LoginPage(driver);
		logpage.goToUrl();
		return logpage;
	}

	@AfterMethod
	 public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}
}
