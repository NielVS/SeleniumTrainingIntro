import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import helpers.DriverManager;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;

public class Exercise5_6 {

static WebDriver driver = DriverManager.getDriver();

	public static void main(String[] args) {
		 driver.get("https://app-tst-training.azurewebsites.net/");
		logOut();
		loginAndCheckWelcomeMessage();
		clickBearButtonAndValidateIfBearIsVisible();
	}
	
	public static void logOut() {
		MenuPage menu = new MenuPage();
		PageFactory.initElements(driver,menu);
		menu.logOut();
	}
	
	
	public static void loginAndCheckWelcomeMessage() {
		LoginPage login = new LoginPage();
		PageFactory.initElements(driver,login);
		WelcomePage welcome = new WelcomePage();
		PageFactory.initElements(driver,welcome);
		login.setLanguage("French");
		login.logIn("admin","superduper");
		
		if(welcome.getWelcomeMessage().contains("Welcome to the exciting features provided to you by this Connection Management website, a glorified address book.")){
			System.out.println("WELCOME MESSAGE WAS CORRECT");
		} else {System.out.println("MESSAGE WAS INCORRECT");	
		}
		}
	
	public static void clickBearButtonAndValidateIfBearIsVisible() {
		WelcomePage welcome = new WelcomePage();
		PageFactory.initElements(driver,welcome);
		welcome.displayTheBear();
		
		if(welcome.isTheBearDisplayed()) {
			System.out.println("THE BEAR IMAGE IS DISPLAYED");
		} else {
			System.out.println("IMAGE NOT DISPLAYED");
		}
	}

	

}
