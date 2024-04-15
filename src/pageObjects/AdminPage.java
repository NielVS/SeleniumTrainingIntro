package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helpers.DriverManager;

public class AdminPage {
	
	@FindBy(xpath = "//label[contains(text(),'reset users')]")
	private WebElement resetUsersButton;
	
	@FindBy(xpath = "//label[contains(text(),'reset connections')]")
	private WebElement resetConnectionsButton;
	
	@FindBy(xpath = "//label[contains(text(),'populate records')]")
	private WebElement populateButton;
	
	@FindBy(id = "new_username")
	private WebElement newUsername;
	
	@FindBy(id = "new_password")
	private WebElement newPassword;
	
	@FindBy(xpath = "//span[contains(text(),'create')]")
	private WebElement createUserButton;
	
	public void clickResetUsersBtnAndConfirmAlert() {
		resetUsersButton.click();
		Alert alert = DriverManager.getDriver().switchTo().alert();
		alert.accept();
	}
	
	public void createNewUser(String username, String password) {
		newUsername.sendKeys(username);
		newPassword.sendKeys(password);
		createUserButton.click();
		
	}
	
	public void populateForTesting() {
		populateButton.click();
		Alert alert = DriverManager.getDriver().switchTo().alert();
		alert.accept();
		System.out.println("RECORDS WERE POPULATED");
	}
	
	public void resetConnections() {
		resetConnectionsButton.click();
		Alert alert = DriverManager.getDriver().switchTo().alert();
		alert.accept();
		System.out.println("CONNECTIONS RESETED");
	}
	

}
