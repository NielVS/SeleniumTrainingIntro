import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.support.PageFactory;

import helpers.DriverManager;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;

public class Exercise10 {
	private static WebDriver driver= DriverManager.getDriver();
	private static MenuPage menu;
	private static LoginPage login;
	private static WelcomePage welcome;
	
	@BeforeAll
	public static void setupDriverAndPageObjects() {
		 menu = new MenuPage();
		login = new LoginPage();
		welcome = new WelcomePage();
			PageFactory.initElements(driver,menu);
			PageFactory.initElements(driver,login);
			PageFactory.initElements(driver,welcome);

		 
	}
@BeforeEach
public void openDriverAndLogOut() {
	driver.get("https://app-tst-training.azurewebsites.net/");
	
	menu.logOut();
}



	@ParameterizedTest
	@CsvSource({
		"admin,incorrectPassword,Unable to log in with the given credentials. Please try again.",
		"admin,/,Please fill in all the fields.",
		"/,/,Please fill in all the fields."
	})
	public void logInWithInCorrectCredentials(String username,String password, String error) {
	if(username.equals("/")) {
		username = "";
	}
	
	if(password.equals("/")) {
		password = "";
			}
	login.logIn(username,password );
	Assert.assertTrue("ERROR MESSAGE WAS NOT DISPLAYED", login.getError().equals(error));
	}
	
	
	}
