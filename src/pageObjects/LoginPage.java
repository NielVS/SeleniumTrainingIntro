package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	@FindBy(name = "language")
	private WebElement e;
	
	@FindBy(xpath = "//*[@id=\"errors\"]/p")
	private WebElement errorMessage;
	
	@FindBy(id = "username")
	private WebElement usernameInput;
	
	@FindBy(id = "password")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//label[contains(text(),'log in')]")
	private WebElement loginButton;
	
	public void setLanguage(String language) {
		Select languageSelectField = new Select(e);
		languageSelectField.selectByVisibleText(language);
	}
	
	public void logIn(String username, String password ) {
		usernameInput.clear();
		usernameInput.sendKeys(username);
		passwordInput.clear();
		passwordInput.sendKeys(password);
		loginButton.click();
	}
	
	public Boolean isErrorDisplayed() {
		return errorMessage.isDisplayed();
	}
	public String getError() {
		return errorMessage.getText();
	}

}
