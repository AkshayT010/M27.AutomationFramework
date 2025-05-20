package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItomPage {
	
	
	@FindBy(id = "add-to-cart")
	private WebElement addTocartBtn;
	
	@FindBy(id="back-to-products")
	private WebElement backToProduct;
	
	
	//Initialization
	
	public InventoryItomPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	
	public WebElement getAddTocartBtn() {
		return addTocartBtn;
	}
	
	public WebElement getBackToProduct() {
		return backToProduct;
	}

	//Business Library
	
	/**
	 * This method will click on add to cart button
	 */
	public void clickOnAddTocartBtn() {
		
		addTocartBtn.click();
	}
	
	
	public void clickOnBackToProductLnk() 
	{
		backToProduct.click();
	}
	
	

}
