package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver == null) {
			setChromeDriver();
		}
		return driver;
	}

	public static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium_Class\\drivers\\chromedriver-win64\\chromedriver.exe");	
		driver = new ChromeDriver();
	}
	
	public static void setFirefoxDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium_Class\\drivers\\chromedriver-win64\\chromedriver.exe");	
		driver = new FirefoxDriver();
	}
	
	public static void setEdgexDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium_Class\\drivers\\edgedriver-win64\\msedgedriver.exe");	
		driver = new FirefoxDriver();
	}
	
	
	public static void killDriver() {
		driver.close();
	}

}
