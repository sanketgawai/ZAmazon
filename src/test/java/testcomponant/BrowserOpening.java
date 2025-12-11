package testcomponant;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BrowserOpening {

	public WebDriver driver;
	
//	Properties prop = new Properties();
//	File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\rhl\\resources\\GlobalData.Properties");
//	FileInputStream fis = new FileInputStream(file);
	
	
	public WebDriver initalizeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
		    File file = new File(System.getProperty("user.dir")
		            + "\\src\\main\\java\\rhl\\resources\\GlobalData.Properties");
		    fis = new FileInputStream(file);
		    prop.load(fis);
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		prop.load(fis);
		
		String browserName = "chrome";
		//if(browserName.equalsIgnoreCase("chrome")) 
		if(prop.getProperty("browserName").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		//else if(browserName.equalsIgnoreCase("edge")) 
		if(prop.getProperty("browserName").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		//else if(browserName.equalsIgnoreCase("firefox"))
		if(prop.getProperty("browserName").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	@BeforeMethod
	public void openBrowser() throws IOException
	{
		driver = initalizeDriver();
		driver.get("https://www.amazon.in");
	}
	
	//public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException 
	{		
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+"+.png");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+"+.png";
	}
}
