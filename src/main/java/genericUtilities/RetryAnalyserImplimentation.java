package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyser Interface of TestNG
 * @author Acer
 */
public class RetryAnalyserImplimentation implements IRetryAnalyzer{

	int count = 0;
	int retrycount = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		//0<3 1<3 2<3 3<3No
		while(count<retrycount)
		{
			count++;
			return true;// retry retry retry
		}
	
		return false;//stop retry
	}

}
