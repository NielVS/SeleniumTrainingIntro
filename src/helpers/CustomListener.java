package helpers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class CustomListener implements WebDriverListener {

	public void afterClick(WebElement element){
		System.out.println("I clicked on: " + element.toString());
	}
	
	public void beforeClick(WebElement element){
		System.out.println("Im going to click on: " + element.toString());
	}
	
	public void onError(Object target,Method method, Object[] args, InvocationTargetException e) {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");  
		   String now = dtf.format(LocalDateTime.now());  
		if(e.getTargetException() instanceof NoSuchElementException) {
			System.out.println("NoSuchElementException found: " + e.getTargetException());		
			File f = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(f, new File("C:\\Users\\nvanschelvergem\\Desktop\\screenshots\\screenshot"+ now+".png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	}
}
