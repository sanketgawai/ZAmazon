package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rhabstractcommponant.AbstractCommponant;

public class LoginPage extends AbstractCommponant {
 
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
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
	
	@FindBy(xpath="//div[normalize-space(text())='We cannot find an account with that email address']")
	private WebElement loginErrormassage;
	
	@FindBy(xpath="//h1[normalize-space(text())='Solve this puzzle to protect your account']")
	private WebElement puzzleErrormassage;
	
	public String login(String eml,String pass)
	{
		createBusinessAccount.click();
		actionMoveToElementAndClick(signIn);
		email.sendKeys(eml);
		password.sendKeys(pass);
		lastSignInButton.click();
		
//		if(puzzleErrormassage.isDisplayed())
//		{
//			waitForElementToAppearUsingWebElement(puzzleErrormassage);
//			return puzzleErrormassage.getText();
//		}else {
//			waitForElementToAppearUsingWebElement(loginErrormassage);
//			return loginErrormassage.getText();
//		}
		boolean puzzleShown = false;
	    try {
	        puzzleShown = puzzleErrormassage.isDisplayed();
	    } catch (Exception e) {
	        puzzleShown = false;  // puzzle not shown → continue to else
	    }

	    if (puzzleShown==true) {
	        waitForElementToAppearUsingWebElement(puzzleErrormassage);
	        return puzzleErrormassage.getText();
	    } 
	    else {
	        waitForElementToAppearUsingWebElement(loginErrormassage);
	        return loginErrormassage.getText();
	    }
	}
	
	
	
}
