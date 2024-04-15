import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise3 {
	static WebDriver chromeDriver = new ChromeDriver();

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Selenium_Class\\drivers\\chromedriver-win64\\chromedriver.exe");
		chromeDriver.get("https://app-tst-training.azurewebsites.net/");
		
		logOut();
		changeLanguage();
		logIn();
		navigateToNewMenu();
		addNewConnection();
	}
	
	private static void logOut() {
		WebElement logoutButton = chromeDriver.findElement(By.id("logout"));
		logoutButton.click();
	}
	
	private static void changeLanguage() {
		WebElement e = chromeDriver.findElement(By.name("language"));
		Select languageSelectField = new Select(e);
		languageSelectField.selectByVisibleText("French");
	}
	
	private static void logIn() {
		WebElement usernameInput = chromeDriver.findElement(By.id("username"));
		WebElement passwordInput = chromeDriver.findElement(By.id("password"));
		WebElement loginButton = chromeDriver.findElement(By.tagName("span"));
		
		usernameInput.sendKeys("admin");
		passwordInput.sendKeys("superduper");
		loginButton.click();
	}
	
	private static void navigateToNewMenu() {
		WebElement menuItemNew = chromeDriver.findElement(By.id("crudConnection"));
		menuItemNew.click();
	
	}
	
	private static void addNewConnection() {
		WebElement firstnameInput = chromeDriver.findElement(By.id("firstName"));
		WebElement lastnameInput = chromeDriver.findElement(By.id("lastName"));
		WebElement sexElement = chromeDriver.findElement(By.id("sex"));
		Select sexSelectionField= new Select(sexElement);
		WebElement emailInput = chromeDriver.findElement(By.id("email"));
		WebElement telephoneInput = chromeDriver.findElement(By.id("telephone"));
		WebElement companyInput = chromeDriver.findElement(By.id("company"));
		WebElement ssuElement = chromeDriver.findElement(By.id("SSU"));
		Select ssuSelectionField = new Select(ssuElement);
		WebElement sentiorityElement = chromeDriver.findElement(By.id("seniority"));
		Select seniorityInputField = new Select(sentiorityElement);
		WebElement addBtn = chromeDriver.findElement(By.id("add"));
		
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
