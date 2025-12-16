package testclass;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pomclasses.HomePage;
import pomclasses.LoginPage;
import rhl.data.DataDrivenFromExcel;
import rhl.data.DataReader;
import testcomponant.BrowserOpening;

public class LoginValidationWithExcelData extends BrowserOpening {

	@Test(dataProvider="getData")
	//public void checkLogin(String email,String password)
	public void checkLogin(HashMap<String,String> input)
	{
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContinueShopping();
		LoginPage loginPage = homePage.goToLoginPage();
		//String actualErrorMsg=loginPage.login(email, password);
		
		String actualErrorMsg=loginPage.login(input.get("email"), input.get("password"));
		System.out.println(actualErrorMsg);
		String expectedErrorMsg ="Solve this puzzle to protect your account";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}
	
	 @DataProvider
	    public Object[][] getData() throws Exception 
	 {

		 DataDrivenFromExcel reader = new DataDrivenFromExcel();
	     return reader.getExcelData(
	     //System.getProperty("user.dir") + "C:\\Users\\sanke\\OneDrive\\Desktop\\Data Driven Excel\\AmezonLoginDataExcel.xlsx","Sheet1");
	     System.getProperty("user.dir") + "\\src\\test\\java\\rhl\\data\\AmezonLoginDataExcel.xlsx","Sheet1");		 
	 }
	
	
	
}
