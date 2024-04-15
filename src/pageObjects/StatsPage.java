package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatsPage {
	
	@FindBy(id="statTotalConn")
	private WebElement amountOfConnectionsField;
	
	public boolean hasConnections() {
		System.out.println(amountOfConnectionsField.getText());
		if(amountOfConnectionsField.getText().equals("N/A")) {
			return false;
		} else return true;
		
	}

}
