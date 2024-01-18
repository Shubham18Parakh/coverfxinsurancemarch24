package listners_study;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import coverFoxUtility.UtilityClass;
import coverFoxbase.BaseClass;

public class ListnersCoverFox extends BaseClass  implements ITestListener


{
@Override
public void onTestFailure(ITestResult result)
{
	
	try {
		UtilityClass.takeScreenShot(driver, result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Override
	public void onTestSuccess(ITestResult result) 
{
		
	
}
@Override
	public void onTestSkipped(ITestResult result)
{

	
}



	}
	

