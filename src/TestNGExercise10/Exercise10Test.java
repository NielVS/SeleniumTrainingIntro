package TestNGExercise10;

import org.testng.annotations.Test;

import helpers.DriverManager;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class Exercise10Test {
	
	private static WebDriver driver= DriverManager.getDriver();
	private static MenuPage menu;
	private static LoginPage login;
	private static WelcomePage welcome;
	
  /**
   * Setting up the driver and logout before each test
   */
	 @BeforeTest
	  public void openDriverAndLogOutTest() {
			driver.get("https://app-tst-training.azurewebsites.net/");
			menu.logOut();  }

	 /**
	  * Before each suite we initialise the pageobjects we are going to use
	  */
  @BeforeSuite
  public void beforeSuite() {
	  menu = new MenuPage();
		login = new LoginPage();
		welcome = new WelcomePage();
			PageFactory.initElements(driver,menu);
			PageFactory.initElements(driver,login);
			PageFactory.initElements(driver,welcome);

  }


  /**
   * 
   * @param username= The username that will be used to login, provided by the DataProvider
   * @param password= The password that will be used to login, provided by the DataProvider
   * @param error= The error message that we will verify appears on the screen
   */
  @Test(dataProvider = "test1")
  public void logInWithInCorrectCredentialsTest(String username,String password, String error) {
		if(username.equals("/")) {
			username = "";
		}
		
		if(password.equals("/")) {
			password = "";
				}
		login.logIn(username,password );
		Assert.assertTrue(login.getError().equals(error),"ERROR MESSAGE WAS NOT DISPLAYED");  }
  
  @DataProvider(name = "test1")
  public static Object[][] primeNumbers() {
     return new Object[][] {
    	 {"admin","incorrectPassword" ,"Unable to log in with the given credentials. Please try again."},
    	 {"admin","/" ,"Please fill in all the fields."},
    	 {"/","/","Please fill in all the fields."}
    	 };
  }
}
