package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage {
		
	@FindBy(xpath = "//div[@style = 'display: block;' and @id='welcome']")
	private WebElement welcomeMessage;
		
	@FindBy(xpath = "//input[@value='Show me']")
	private WebElement showMeBtn;
	
	@FindBy(tagName = "img")
	private WebElement bearImage;
	
	
	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}
		

	public void displayTheBear() {
	showMeBtn.click();
	}
	
	public Boolean isTheBearDisplayed() {
		return bearImage.isDisplayed();
	}
	

}
