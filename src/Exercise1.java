import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Selenium_Class\\drivers\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","C:\\Selenium_Class\\drivers\\geckodriver-win64\\geckodriver.exe");
		
		WebDriver chromeDriver = new ChromeDriver();
		//WebDriver fireFoxDriver = new FirefoxDriver();
		
		chromeDriver.get("https://be.ctg.com");
		System.out.println("TITLE OF THE DRIVER: " + chromeDriver.getTitle());
				
	}
	
}
