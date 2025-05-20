package practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.FileUtility;
import genericUtilities.Javautility;
import genericUtilities.SeleniumUtility;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class LoginWithGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//create object of Utilities 
		FileUtility fUtil = new FileUtility();
		Javautility jUtil = new Javautility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the data from property file using generic utility
				
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
				
		//launch The Browser
	    WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitelyWait(driver);
				
		//Load the URL
		driver.get(URL);
				
		//Login to the Application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();/
		
		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		
		lp.LoginToApp(USERNAME, PASSWORD);
		
		Thread.sleep(2000);
				
		//Logout the application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		
	}

}
