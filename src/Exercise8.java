import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import helpers.CustomListener;
import helpers.DriverManager;
import pageObjects.LoginPage;
import pageObjects.MenuPage;

public class Exercise8 {

	public static void main(String[] args) {
		 WebDriver driver = DriverManager.getDriver();
		 WebDriverListener listener = new CustomListener();
		 WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
		 
		 eventDriver.get("https://app-tst-training.azurewebsites.net/");

			MenuPage menu = new MenuPage();
			LoginPage login = new LoginPage();
			PageFactory.initElements(eventDriver,menu);
			PageFactory.initElements(eventDriver,login);


			menu.logOut();
			login.logIn("admin", "superduper");
			menu.clickNotExistingBtn();

	}

}
