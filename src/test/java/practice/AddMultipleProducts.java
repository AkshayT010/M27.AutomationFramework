package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import net.bytebuddy.build.AndroidDescriptor;

public class AddMultipleProducts {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//read the data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//Launch the Browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Load the URL
		driver.get(URL);
		
		//Login to Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		//click on product - T-shirt Red
		WebElement product1 = driver.findElement(By.id("item_3_title_link"));
		String ProductToBeAdded1 = product1.getText();
		product1.click();
		
		
		//Add 1 item to the cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Back to home page
		driver.findElement(By.id("back-to-products")).click();
		
		//Click on 2nd Product
		WebElement product2 = driver.findElement(By.id("item_5_title_link"));
		String ProductToBeAdded2 = product2.getText();
		product2.click();
		
		//Add 2nd item to the cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Navigate to the cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Validate the product1
		String productAdded1 = driver.findElement(By.id("item_3_title_link")).getText();
		String productAdded2 = driver.findElement(By.id("item_5_title_link")).getText();
		
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
