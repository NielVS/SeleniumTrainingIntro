package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class MenuPage {
	
	@FindBy(id = "logout")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//a[contains(text(),'Connections')]")
	private WebElement connectionsButton;
	
	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	private WebElement adminButton;
	
	@FindBy(xpath = "//a[contains(text(),'Stats')]")
	private WebElement statsButton;
	
	@FindBy(xpath = "//a[contains(text(),'XXX')]")
	private WebElement notExistingButton;
	
	
	public void logOut() {
		logoutButton.click();
	}
	
public void clickConnectionsBtn() {
	connectionsButton.click();
}

public void clickAdminBtn() {
	adminButton.click();
}

public void clickStatsBtn() {
	statsButton.click();
}

public void clickNotExistingBtn() {
	notExistingButton.click();
}

}
