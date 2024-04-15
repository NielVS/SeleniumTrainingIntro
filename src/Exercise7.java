import java.awt.Window;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import helpers.DriverManager;
import pageObjects.AdminPage;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.StatsPage;
import pageObjects.WelcomePage;

public class Exercise7 {
	static WebDriver driver = DriverManager.getDriver();

	public static void main(String[] args) {
		 driver.get("https://app-tst-training.azurewebsites.net/");
		 String currentWIndow = driver.getWindowHandle();
		 String newWindow=null;
			LoginPage login = new LoginPage();
			MenuPage menu = new MenuPage();
			AdminPage admin = new AdminPage();
			WelcomePage welcome = new WelcomePage();
			StatsPage stats = new StatsPage();
			PageFactory.initElements(driver,login);
			PageFactory.initElements(driver,menu);
			PageFactory.initElements(driver,welcome);
			PageFactory.initElements(driver,admin);
			PageFactory.initElements(driver,stats);

			
			menu.logOut();
			login.logIn("admin", "superduper");
			menu.clickStatsBtn();
			
			menu.clickAdminBtn();
			
			
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows){
				if (!currentWIndow.equals(window)) {
					newWindow = window;	
					break;
				}
			}

			driver.switchTo().window(newWindow);
			admin.clickResetUsersBtnAndConfirmAlert();
			
			
			
			admin.createNewUser("niel", "test");
			admin.resetConnections();
			
			driver.switchTo().window(currentWIndow);
			driver.navigate().refresh();
			
			menu.clickStatsBtn();
			
			if(stats.hasConnections()==false) {
				System.out.println("THERE WERE NO CONNECTIONS");
			}else {System.out.println("THERE WERE CONNECTIONS");
}
			driver.switchTo().window(newWindow);
			admin.populateForTesting();
			driver.switchTo().window(currentWIndow);
			driver.navigate().refresh();
			
			menu.clickStatsBtn();
			if(stats.hasConnections()) {
				System.out.println("THERE WERE  CONNECTIONS");
			}else {System.out.println("THERE WERE NO CONNECTIONS");}
			

			
			
			menu.logOut();
			login.logIn("niel", "test");
			
			if(welcome.getWelcomeMessage().contains("Welcome to the exciting features provided to you by this Connection Management website, a glorified address book.")){
				System.out.println("WELCOME MESSAGE WAS CORRECT");
			} else {System.out.println("MESSAGE WAS INCORRECT");	
			}

		

		 

	}

}
