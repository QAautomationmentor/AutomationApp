package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListener extends Base implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// test.fail(result.getThrowable());
		WebDriver driver = null;
		extentTest.get().fail(result.getThrowable());
		Object instance = result.getInstance();
		Class testClass = result.getTestClass().getRealClass();
		try {
			driver = (WebDriver) testClass.getDeclaredField("driver").get(instance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(captureScreenshot(result.getMethod().getMethodName(), driver),
					result.getMethod().getMethodName());
		} catch (IOException e) {

		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		extent = ExtentReporterNG.extentReportGenerator();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
