package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlaceAnOrder {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Read the data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//Read the data from Excel File
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("product");
		Row rw = sh.getRow(7);
		Cell cl = rw.getCell(2);
		Cell fn = rw.getCell(3);
		Cell ln = rw.getCell(4);
		Cell pc = rw.getCell(5);
		
		String PRODUCTNAME = cl.getStringCellValue();
		String FIRSTNAME = fn.getStringCellValue();
		String LASTNAME = ln.getStringCellValue();
		String PINCODE = pc.getStringCellValue();
		
		
		//Launch the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Load the URL
		driver.get(URL);
		
		//Login to Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
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
