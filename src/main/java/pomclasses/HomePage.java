package pomclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rhabstractcommponant.AbstractCommponant;

public class HomePage extends AbstractCommponant {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[text()='Search Amazon.in']/following-sibling::input")
	private WebElement searchField;
	
	@FindBy(xpath="//input[contains(@id,'nav-search-submit-button')]")
	private WebElement searchIcon;
	
	@FindBy(xpath="//span[contains(text(),'Parker Frontier Fountain Pen')]/ancestor::div[contains(@data-cy,'title-recipe')]/following::div[@data-cy='add-to-cart'][1]//button[contains(.,'Add to cart')]")
	private WebElement parkerFountenBluePenAddToCartButton;
	
	@FindBy(xpath="(//span[contains(text(),'Parker Frontier Fountain Pen')])[2]")
	private WebElement parkerFountenBluePenText;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//button[text()='Continue shopping']")
	private WebElement continueShopping;
	
	@FindBy(xpath="//button[contains(@aria-label,'Delete Parker Frontier Fountain Pen')]")
	private WebElement deleteparkerFountenBluePenFromCart; 
	
	@FindBy(xpath="//span[contains(normalize-space(), 'was removed from Shopping Cart')]")
	private WebElement productRemoveFromCart;
	
	@FindBy(xpath="//div[@id='nav-link-accountList']")
	private WebElement accountAndList;
	
	@FindBy(xpath="//span[text()='Sign in']/parent::a")
	private WebElement signIn;
	
	@FindBy(xpath="//a[span[normalize-space()='Create a free business account']]")
	private WebElement createBusinessAccount;
	
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement lastSignInButton;
	
	public void sendDataInSerachField(String productName)
	{
		searchField.sendKeys(productName);
		actionMoveToElementAndClick(searchIcon);
	}
	
	public void clickOnparkerFountenBluePenAddToCartButton()
	{
		parkerFountenBluePenAddToCartButton.click();
	}

	public void addToaddToCart()
	{
		javaScriptScrollDownToElement(addToCart);
		addToCart.click();
	}
	
	public void clickOnContinueShopping()
	{
//		waitForElementToAppearUsingWebElement(continueShopping);
//		continueShopping.click();
		
			try 
			{
			 	waitForElementToAppearUsingWebElement(continueShopping);
				continueShopping.click();
		        System.out.println("Continue Shopping button found and clicked.");
		    } 
		    catch (Exception e) 
			{
		        System.out.println("Continue Shopping button NOT visible. Skipping...");
		    }
			
	}
	
	public String checkPenProductAddInCart()
	{
		waitForElementToAppearUsingWebElement(parkerFountenBluePenText);
		return parkerFountenBluePenText.getText();
	}
	
	public String clickOnDeleteparkerFountenBluePenFromCart()
	{
		//deleteparkerFountenBluePenFromCart.click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		//return productRemoveFromCart.getText();
		String fullText = productRemoveFromCart.getText().trim();
		String removedMsg = fullText.substring(fullText.indexOf("was removed")).trim();
		return removedMsg;
	}
	
	public LoginPage goToLoginPage()
	{		
		actionMoveToElement(accountAndList);
		actionMoveToElementAndClick(signIn);
		return new LoginPage(driver);
	}
//	public void login(String eml,String pass)
//	{
//		actionMoveToElement(accountAndList);
//		actionMoveToElementAndClick(signIn);
//		createBusinessAccount.click();
//		actionMoveToElementAndClick(signIn);
//		email.sendKeys(eml);
//		password.sendKeys(pass);
//		lastSignInButton.click();
//	}
	
}