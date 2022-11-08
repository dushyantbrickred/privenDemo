package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	//reading config file
	public static Properties prop = new Properties();
	public static FileReader fr;

	@BeforeTest
	public void setUp() throws IOException {
		// we check if the driver has an instance
		if (driver == null) {
			// we use File reader to locate the file. by using System.getPropert("user.dir")
			// we ill make sure the other users can still find config file.
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\java\\configfiles\\config.properties");

			// once file is found, we load it
			prop.load(fr);

		}

		// check if the browser value from config file is
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			// start webdriver if it is the case
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// open Url in the config file
			driver.get(prop.getProperty("demoUrl"));
			driver.manage().window().maximize();
		}
		// if the above fails, check if it is firefox.
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			// start webdriver if it is the case
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			// open Url in the config file
			driver.get(prop.getProperty("demoUrl"));
			driver.manage().window().maximize();
		}
	}

	// Get element text
	public String getElementText(By pLocator) {
		String elementText = getElement(pLocator).getText();
		return elementText;
	}
	// Get element
	public WebElement getElement(By pLocator) {
		return driver.findElement(pLocator);
	}

	@AfterMethod
	// after our tests, we want to close the driver
	public void tearDown() {
		driver.quit();
		System.out.println("TearDown Successful");
	}

}
