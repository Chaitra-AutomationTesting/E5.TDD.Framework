package swagLabs.Listeners;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import swagLabs.BaseTest.BaseClass;
import swagLabs.GenericUtilities.JavaUtility;
import swagLabs.GenericUtilities.WebDriverUtility;

/**
 * This class provides implementation for ITestListener Interface of TestNG
 * 
 * @author Chaitra M
 *
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " @Test Execution started");

		// create test for Extent Report
		test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " -> @Test Execution PASS");

		// Log the test status in Extent report
		test.log(Status.PASS, methodName + " -> @Test Execution PASS");
	}

	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " -> @Test Execution FAIL");

		// Capture Exception
		System.out.println("The Exception is -> " + result.getThrowable());

		// Log the test status in Extent report
		test.log(Status.FAIL, methodName + " -> @Test Execution FAIL");
		test.log(Status.WARNING, result.getThrowable());

		// Capture Screenshot
		WebDriverUtility w = new WebDriverUtility();
		JavaUtility j = new JavaUtility();

		// Create the screenshot name
		String screenshotname = methodName + "-" + j.getSystemDate();

		try {
			String path = w.captureScreenshot(BaseClass.sDriver, screenshotname);
			
			//Attach screenshot to report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " -> @Test Execution SKIP");

		// Capture Exception
		System.out.println("The Exception is -> " + result.getThrowable());

		// Log the test status in Extent report
		test.log(Status.FAIL, methodName + " -> @Test Execution FAIL");
		test.log(Status.WARNING, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

		System.out.println("Suite execution started");

		// Basic configuration of Extent Reports
		ExtentSparkReporter esr = new ExtentSparkReporter(
				".\\ExtentReports\\Report-" + new JavaUtility().getSystemDate() + ".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Swag Labs UI Automation Report");

		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "TestEnv.com");
		report.setSystemInfo("Reporter Name", "Chaitra");

	}

	public void onFinish(ITestContext context) {

		System.out.println("Suite Execution finished");

		// Generate Extent Report
		report.flush();

	}

}
