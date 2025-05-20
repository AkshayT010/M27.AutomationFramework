package practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtility;
import genericUtilities.Javautility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class PlaceAnOrderWithGu {

	public static void main(String[] args) throws IOException {
		
		//Create object of utilities
		
		FileUtility fUtil = new FileUtility();
		Javautility jUtil = new Javautility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//Read the data from Excel File
		
		String PRODUCTNAME = fUtil.readDataFromExcelFile("product", 7, 2);
		String FIRSTNAME = fUtil.readDataFromExcelFile("product", 7, 3);
		String LASTNAME = fUtil.readDataFromExcelFile("product", 7, 4);
		String PINCODE = fUtil.readDataFromExcelFile("product", 7, 5);
		
		
		
		//Launch the Browser
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitelyWait(driver);
		
		//Load the URL
		driver.get(URL);
		
		//Login to Application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		
		//click on product
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
		
		//Add to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//click on checkout and enter details
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys(FIRSTNAME);
		driver.findElement(By.id("last-name")).sendKeys(LASTNAME);
		driver.findElement(By.id("postal-code")).sendKeys(PINCODE);
		
		//click on continue
		driver.findElement(By.id("continue")).click();
		
		//click on Finish 
		driver.findElement(By.id("finish")).click();
		
		//check whether confirmation is displayed or not
		String text = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();
		System.out.println(text);
	}

	}


