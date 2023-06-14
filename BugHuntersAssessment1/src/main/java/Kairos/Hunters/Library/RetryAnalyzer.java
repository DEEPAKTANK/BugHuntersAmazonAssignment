package Kairos.Hunters.Library;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int count=0;
	int retry=1;
	LoggerClass log=new LoggerClass();
	@Override
	public boolean retry(ITestResult result) {
		while (count<retry) {
			count++;
			log.info("Retrying "+count);

			return true;
		}
		return false;
	}

}
