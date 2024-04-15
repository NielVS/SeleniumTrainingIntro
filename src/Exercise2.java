import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise2 {
	static WebDriver chromeDriver = new ChromeDriver();

	public static void main(String[] args) {
		String firstTitle;
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Selenium_Class\\drivers\\chromedriver-win64\\chromedriver.exe");
		
		chromeDriver.get("https://www.google.be/");
		System.out.println("THE FIRST TIME THE TITLE IS: "+ chromeDriver.getTitle());
		firstTitle = chromeDriver.getTitle();
		
		chromeDriver.get("https://www.bing.be/");
		System.out.println("THE SECOND TIME THE TITLE IS: "+ chromeDriver.getTitle());
		
		chromeDriver.navigate().back();
		checkTitles(firstTitle);
		 chromeDriver.navigate().refresh();
		 checkTitles(firstTitle);
		 
		 chromeDriver.quit();

	}
	
	private static void checkTitles (String expectedTitle) {
		if(chromeDriver.getTitle().equals(expectedTitle)) {
		System.out.println("THE EXPECTED TITLE: "+ expectedTitle + " is the same as the actual title: " + chromeDriver.getTitle());	
		} else {System.out.println("TITLES DO NOT MATCH");}
	}

}
