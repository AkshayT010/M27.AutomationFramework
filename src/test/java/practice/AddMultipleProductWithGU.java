package practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.FileUtility;
import genericUtilities.Javautility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddMultipleProductWithGU {

	public static void main(String[] args) throws IOException {
		
		// Create Object of Utilities 
		FileUtility fUtil = new FileUtility();
		Javautility jUtil = new Javautility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//read the data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//Read data from excel file
		String PRODUCT1 = fUtil.readDataFromExcelFile("Product", 10, 2);
		String PRODUCT2 = fUtil.readDataFromExcelFile("Product", 11, 2);
				
	    //Launch the Browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitelyWait(driver);
				
		//Load the URL
		driver.get(URL);
				
		//Login to Application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		
		lp.LoginToApp(USERNAME, PASSWORD);
			
		//click on product - T-shirt Red
		WebElement product1 = driver.findElement(By.xpath("//div[text()='"+PRODUCT1+"']"));
		String ProductToBeAdded1 = product1.getText();
		product1.click();
				
				
		//Add 1 item to the cart
		driver.findElement(By.id("add-to-cart")).click();
				
		//Back to home page
		driver.findElement(By.id("back-to-products")).click();
				
		//Click on 2nd Product
		WebElement product2 = driver.findElement(By.xpath("//div[text()='"+PRODUCT2+"']"));
		String ProductToBeAdded2 = product2.getText();
		product2.click();
				
		//Add 2nd item to the cart
		driver.findElement(By.id("add-to-cart")).click();
				
		//Navigate to the cart
		driver.findElement(By.id("shopping_cart_container")).click();
				
		//Validate the product1
		String productAdded1 = driver.findElement(By.xpath("//div[text()='"+PRODUCT1+"']")).getText();
		String productAdded2 = driver.findElement(By.xpath("//div[text()='"+PRODUCT2+"']")).getText();
				
		System.out.println("Product 1 validation");
		if (productAdded1.equalsIgnoreCase(ProductToBeAdded1)) {
					
		System.out.println("PASS");
					
		}
		else
			{
				System.out.println("FAIL");
			}
				
		//Validate the 2nd product
		System.out.println("Product 2 Validation");
		if(productAdded2.equalsIgnoreCase(ProductToBeAdded2)) {
					
					System.out.println("PASS");
		}
				
		else
		{
			System.out.println("FAIL");
		}
		}

	}

