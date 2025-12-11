package testclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomclasses.HomePage;
import testcomponant.BrowserOpening;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends BrowserOpening {
	
	
	//@Test(groups={"Regression"})
	@Test(groups= {"Regression"})
	public void addToCart() throws InterruptedException
	{		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContinueShopping();
		homePage.sendDataInSerachField("fountain pen for men");
		homePage.clickOnparkerFountenBluePenAddToCartButton();
		homePage.addToaddToCart();
		//Assert.assertEquals(homePage.checkPenProductAddInCart(),"Parker Frontier Fountain Pen | Matte Black Body with Gold Trim | Blue Color Ink | Refillable Fine Nib Pen for Smooth Writing | A Premium Writing Experience for Everyone");
		System.out.println(homePage.checkPenProductAddInCart());
		Assert.assertTrue(homePage.checkPenProductAddInCart().startsWith("Parker Frontier Fountain Pen |"));
	}
	
	@Test(groups="Regression")
	public void deleteProductFromCart() throws InterruptedException
	{		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContinueShopping();
		homePage.sendDataInSerachField("fountain pen for men");
		homePage.clickOnparkerFountenBluePenAddToCartButton();
		homePage.addToaddToCart();

		String afterDeleteProduct = homePage.clickOnDeleteparkerFountenBluePenFromCart();
		Assert.assertEquals(afterDeleteProduct, "was removed from Shopping Cart.");
	}
	
	
	@Test()
	public void addToCartForFil() throws InterruptedException
	{		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContinueShopping();
		homePage.sendDataInSerachField("fountain pen for men");
		//homePage.clickOnparkerFountenBluePenAddToCartButton();
		homePage.addToaddToCart();
		Assert.assertEquals(homePage.checkPenProductAddInCart(),"Parker Frontier Fountain Pen | Matte Black Body with Gold Trim | Blue Color Ink | Refillable Fine Nib Pen for Smooth Writing | A Premium Writing Experience for Everyone");
	}
}
