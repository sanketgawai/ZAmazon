package testcomponant;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rhl.resources.ExtentReportNG;



public class Listeners extends BrowserOpening implements ITestListener {

	WebDriver driver;
	ExtentTest test;
	ExtentReportNG extentReporterNG = new ExtentReportNG();
	ExtentReports extent = extentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//Thread safe
	
	@Override
    public void onTestStart(ITestResult result){//this result variable hold the all info about test case {
        System.out.println("Starting Test: " + result.getName());
//        test = extent.createTest(result.getMethod().getMethodName());//*****crateTest method for entry in reports, in argument have to give test case name will create entry for that test case name
//        extentTest.set(test);
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
	}
	
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
       extentTest.get().log(Status.PASS, "TestPass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());    
        extentTest.get().fail(result.getThrowable());
        try {
			//here it will check class from xml, getRealClass- it will go testclass, getField give that class driver
        			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {//***** Exception e this is generic exception no need other exception then this is parent of all exception 
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
        String filePath=null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("All Tests Completed: " + context.getName());
        extent.flush();
    }
	
}
