package testclass;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pomclasses.HomePage;
import pomclasses.LoginPage;
import rhl.data.DataReader;
import testcomponant.BrowserOpening;

public class LoginValidation extends BrowserOpening{

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
	public Object[][] getData()
	{
		//return new Object[][] {{"onepiece@gmail.com","monkey.dluffy"},{"jujutsukaisen@gmail.com","gojo_saturu"},{"hajimenoippo@gmai.com","ippo"},{"bakunohero@gmai.com","iszumi"}};
		
//		HashMap<String,String> hs = new HashMap<String,String>();
//		hs.put("email", "onepiece@gmail.com");
//		hs.put("pass", "monkey.dluffy");
//		HashMap<String,String> hs1 = new HashMap<String,String>();
//		hs1.put("email", "jujutsukaisen@gmail.com");
//		hs1.put("pass", "gojo_saturu");
//		return new Object[][] {{hs},{hs1}};
		
		DataReader dataReader = new DataReader();
		List<HashMap<String,String>> data = dataReader.getJsonData();
		return new Object [][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)}};
	}
	
}
