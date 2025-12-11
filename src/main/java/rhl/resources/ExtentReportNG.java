package rhl.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"//reports//index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Automation Result");
		
		ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);   // ⭐ REQUIRED ⭐
		extent.setSystemInfo("Tester", "Sanket");
		extent.setSystemInfo("Envirnonment", "QA");
		extent.setSystemInfo("Browser", "Chrome");
		
		return extent;
	}
	
}
