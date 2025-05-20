package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This method consist Basic configuration annotation of TestNG
 * @author Acer
 */

public class BaseClass {
	
	public Javautility jUtil = new  Javautility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public FileUtility fUtil = new FileUtility();
	
	public WebDriver driver ;
	
	//For Listeners
	public static WebDriver sdriver;
	
	@BeforeSuite (alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("====Database connection sucessful=====");
	}
	
	//@Parameters("browser")
	//@BeforeTest (alwaysRun = true)
	@BeforeClass (alwaysRun = true)
	public void bcConfig(/*String pValue*/) throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		
		driver = new EdgeDriver();
		
		//For cross browser execution -- This is example of Runtime Polymorphism - driver
		
//		if(pValue.equals("edge"))
//		{
//			driver= new EdgeDriver();
//		}
//		
//		else if(pValue.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		
//		else
//		{
//			driver = new EdgeDriver();
//		}
			
			
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitelyWait(driver);
		driver.get(URL);
		
		// For Listeners
		sdriver= driver; 
		
		System.out.println("\"====browser lauch sucessful=====\"");
		
	}
	
	@BeforeMethod (alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD =  fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		System.out.println("====Login to app sucessful=====");
	}
	
	@AfterMethod (alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.LogoutOfApp();
		
		System.out.println("====Logout of app sucessful=====");
	}
	
	//@AfterTest (alwaysRun = true)
	@AfterClass (alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("====Browser closure sucessful=====");
	}
	
	@AfterSuite (alwaysRun = true)
	public void asConfig()
	{
		System.out.println("====Database closure sucessful====");
	}

}
