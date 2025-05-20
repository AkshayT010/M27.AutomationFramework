package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility{
	
	@FindBy(xpath = "//select [@class = 'product_sort_container']")
	private WebElement sortDropDown;
	
	@FindBy(xpath = "//a[@class = 'shopping_cart_link']")
	private WebElement cartContainerBtn;
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutLnk;

	
	//Initialization
	public InventoryPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	
	public WebElement getSortDropDown() {
		return sortDropDown;
	}


	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}


	public WebElement getMenuBtn() {
		return menuBtn;
	}


	public WebElement getLogoutLnk() {
		return logoutLnk;
	}
	
	//Business Library
	
	/**
	 * This method will click any product specified by caller
	 * @param driver
	 * @param productname
	 */
	public void clickOnAProduct(WebDriver driver, String productname)
	{
		driver.findElement(By.xpath("//div[.='"+productname+"']")).click();
	}
	

	/**
	 * This method will perform logout operation
	 */
	public void LogoutOfApp()
	{
		menuBtn.click();
		logoutLnk.click();
	}
	
	
	/**
	 * This method will sort for lowest price product and then click on it
	 * @param driver
	 * @param sortOption
	 * @param productname
	 */
	public void clickOnLowestPriceProduct(WebDriver driver, String sortOption, String productname)
	{
		handleDropDown(sortDropDown, sortOption);
		driver.findElement(By.xpath("//div[.='"+productname+"']")).click();
	}
	
	
	/**
	 * This mwthod will click on cart container button
	 */
	public void clickOnCartContainer()
	{
		cartContainerBtn.click();
	}
}
