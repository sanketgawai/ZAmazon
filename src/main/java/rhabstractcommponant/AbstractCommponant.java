package rhabstractcommponant;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractCommponant {

	WebDriver driver;
	JavascriptExecutor js ;
	Actions act;
	WebDriverWait wait;
	Alert alt;
	public AbstractCommponant(WebDriver driver) 
	{
		this.driver= driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		this.js = (JavascriptExecutor) driver;
		this.act = new Actions(driver);
	}

	public void waitForWebElementToAppera(By locator)
	{
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElementToAppearUsingWebElement(WebElement webElement)
	{
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public void waitForElementToAppearUsingListOfWebElement(List<WebElement> countries)
	{
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(countries));
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void selectDropDown(WebElement ele,String txt)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(txt);
	}
	
	public void javaScriptScrollDownToElement(WebElement element)
	{
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void handleAlertPopUpAccept() {
	    wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	}

	public void handleAlertPopUpDismiss() {
	    wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().dismiss();
	}
	
	public void actionMoveToElement(WebElement element)
	{
		act.moveToElement(element).build().perform();
	}
	
	public void actionMoveToElementAndClick(WebElement element)
	{
		//Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}
	
}
