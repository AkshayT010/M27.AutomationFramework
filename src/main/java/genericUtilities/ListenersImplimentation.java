package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListeners Interface of TestNG
 * @author Acer
 */
public class ListenersImplimentation  implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		//Capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("#"+methodName+ "Test Script execution started #");
		
		//Intimate the extent report for test execution
		test = report.createTest(methodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		//Capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("#"+methodName+ "Test Script PASS #");
		
		//Log the status as PASS in extent report
		test.log(Status.PASS, methodName+ "Test Script PASS");
				
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//Capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("#"+methodName+ "Test Script FAIL #");
		
		//Capture Exception
		System.out.println(result.getThrowable());
		
		//Log the status as FAIL in extent report
		test.log(Status.FAIL, methodName+ "Test Script FAIL");
		
		//Log the exception captured  to extent report
		test.log(Status.WARNING, result.getThrowable());
		
		//Capture Screen shot
		Javautility j = new Javautility();
		SeleniumUtility s = new SeleniumUtility();
				
		String screenshotName = methodName+"-"+j.getSystemDate();
				
		try {
			
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			//Attach Screen shot to the Report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		//Capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("#"+methodName+ "Test Script SKIP #");
				
		//Capture Exception
		System.out.println(result.getThrowable());
		
		//Log the status as SKIP in Extent Report
		test.log(Status.SKIP, methodName+ "Test Script SKIP");
		
		//Log the exception captured to Extent Report
		test.log(Status.WARNING, result.getThrowable());
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("# Suite execution started #");
		
		//Basic configuration of Extent reports
									//import new extend sparkReported (String Path)
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+ new Javautility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Automation Execution Report");
		
		
		//Report Generation
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Reporter Name", "Akshay");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("# Suite execution finished #");
		
		//Generate extent report
		report.flush();
		
	}
	
	
}
