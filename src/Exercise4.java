import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise4 {
	static WebDriver chromeDriver = new ChromeDriver();
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium_Class\\drivers\\chromedriver-win64\\chromedriver.exe");
		chromeDriver.get("https://app-tst-training.azurewebsites.net/");
		
		logOut();
		logIn();
		navigateToNewMenu();
		addNewConnection();
	}
	
	private static void logOut() {
		WebElement logoutButton = chromeDriver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
		logoutButton.click();
	}

	
	private static void logIn() {
		WebElement usernameInput = chromeDriver.findElement(By.cssSelector("#username"));
		WebElement passwordInput = chromeDriver.findElement(By.cssSelector("#password"));
		WebElement loginButton = chromeDriver.findElements(By.className("content")).get(0);
		
		usernameInput.sendKeys("admin");
		passwordInput.sendKeys("superduper");
		loginButton.click();
	}
	
	private static void navigateToNewMenu() {
		WebElement menuItemNew = chromeDriver.findElement(By.cssSelector("#crudConnection"));
		menuItemNew.click();
	
	}
	
	private static void addNewConnection() {
		WebElement firstnameInput = chromeDriver.findElement(By.xpath("//*[@id=\"firstName\"]"));
		WebElement lastnameInput = chromeDriver.findElement(By.xpath("//*[@id=\"lastName\"]"));
		WebElement sexElement = chromeDriver.findElement(By.cssSelector("#sex"));
		Select sexSelectionField= new Select(sexElement);
		WebElement emailInput = chromeDriver.findElement(By.cssSelector("#email"));
		WebElement telephoneInput = chromeDriver.findElement(By.cssSelector("#telephone"));
		WebElement companyInput = chromeDriver.findElement(By.cssSelector("#company"));
		WebElement ssuElement = chromeDriver.findElement(By.xpath("//*[@id=\"SSU\"]"));
		Select ssuSelectionField = new Select(ssuElement);
		WebElement sentiorityElement = chromeDriver.findElement(By.cssSelector("#seniority"));
		Select seniorityInputField = new Select(sentiorityElement);
		WebElement addBtn = chromeDriver.findElement(By.xpath("//*[@id=\"add\"]"));
		
		firstnameInput.sendKeys("Niel");
		lastnameInput.sendKeys("Vans");
		sexSelectionField.selectByVisibleText("M");
		emailInput.sendKeys("test@test.be");
		telephoneInput.click();
		telephoneInput.sendKeys("1234567898");
		companyInput.sendKeys("CTG");
		ssuSelectionField.selectByVisibleText("Testing");
		seniorityInputField.selectByVisibleText("Experienced");
		
		addBtn.click();
			

		
		
	}
	

}
