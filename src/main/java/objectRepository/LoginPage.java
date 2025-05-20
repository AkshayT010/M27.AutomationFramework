package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { // Rule 1 class name should be same 
   // as page title ending with "Page"
	
	//Declaration / Identify web element in the page using @FindBy,
	// @Findbys, @Findall and make element private 
	
	//Identify single web element through multiple locators - Or operator
	//called as Auto healing process
	@FindAll({@FindBy(id = "user-name"),@FindBy(xpath = "//input [@name ='user-name']")})
	private WebElement usernameEdt1;
	
	//Identify single web element through multiple locators - And operator(Both condition should be true)
	@FindBys({@FindBy(id = "user-name"),@FindBy(xpath = "//input [@name ='user-name']")})
	private WebElement usernameEdt2;
	
	@FindBy(id = "user-name")  //import @findBy from selenium.support
	private WebElement usernameEdt;
	
	@FindBy(id = "password")
	private WebElement passwordEdt;
	
	@FindBy(name = "login-button")
	private WebElement loginBtn;

	//Rule 3 Initialization 
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4 Utilization

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * This method will perform Login Operation
	 * @param un
	 * @param pwd
	 */
	//Business- Optimization- generic method
	
	public void LoginToApp(String un, String pwd )
	{
		usernameEdt.sendKeys(un);
		passwordEdt.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	
}
