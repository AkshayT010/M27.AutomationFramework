package objectRepository;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(className = "inventory_item_name")
	private List<WebElement> itemInfos;
	
	@FindBy(className = "inventory_item_name")
	private WebElement itemInfo;
	
	
	@FindBy(xpath = "//button[.='Remove']")
	private WebElement removeBtn;
	
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;
	
	@FindBy(id = "continue-shopping")
	private WebElement continueShopingBtn;
	
	

	//Initialization
	public CartPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	
	
	
	public WebElement getItemInfo() {
		return itemInfo;
	}

	public List<WebElement> getItemInfos() {
		return itemInfos;
	}


	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public WebElement getContinueShopingBtn() {
		return continueShopingBtn;
	}
	
	
	//Business Library
	
	
	/**
	 * This method will capture the product name and return to caller
	 * @return
	 */
	public String getItemName()
	{
		return itemInfo.getText();
	}
	
	
	
	/**
	 * This method will capture product names of multiple items and  return to caller 
	 * @param a
	 * @return
	 */
	public String getItemnames(int a)
	{
		return itemInfos.get(a).getText();
	}
	
	
	/**
	 * This method will click on remove button
	 */
	public void clickOnRemoveBtn()
	{
		removeBtn.click();
	}
	
	
	/**
	 * This method will click on checkOut button
	 */
	public void clickOnCheckoutBtn()
	{
		checkoutBtn.click();
	}
	
	
	/**
	 * This method will click on ContinueShopping button
	 */
	public void clickOnContinueShoppingBtn()
	{
		continueShopingBtn.click();
	}
	
}
