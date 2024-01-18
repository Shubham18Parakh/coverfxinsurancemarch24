package testNgTestClass;


import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxPom.CoverFoxAdressDetailsPage;
import coverFoxPom.CoverFoxHealthPlanPage;
import coverFoxPom.CoverFoxHomePage;
import coverFoxPom.CoverFoxMemeberDetailsPage;
import coverFoxUtility.UtilityClass;
import coverFoxbase.BaseClass;
@Listeners(listners_study.ListnersCoverFox.class)
public class  CF_002Validate_Pincode_Error_Msg extends BaseClass
{
	
	
	CoverFoxHomePage home;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxMemeberDetailsPage memeberDetailsPage;
	CoverFoxAdressDetailsPage adressDetailsPage;
	
	@BeforeClass
	public void launchCoverFox() throws InterruptedException 
	{
		launchBrowser();
		home=new CoverFoxHomePage(driver);
		healthPlanPage=new CoverFoxHealthPlanPage(driver);
		memeberDetailsPage=new CoverFoxMemeberDetailsPage(driver);
		adressDetailsPage=new CoverFoxAdressDetailsPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@BeforeMethod
	public void enterUserDetails() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		home.clickOnMaleButton();
		Thread.sleep(1000);
		healthPlanPage.clickOnNextButton();
		Thread.sleep(1000);
		memeberDetailsPage.handleAgeDropDown(UtilityClass.dataFromExcelSheet(1, 0));
		memeberDetailsPage.clickOnNextButton();
		Thread.sleep(1000);
		adressDetailsPage.enterMobileNumber(UtilityClass.dataFromExcelSheet(1, 2));
		adressDetailsPage.clickOnContinueButton();
		Thread.sleep(1000);
		
	}
	
  @Test
  public void validate_Pincode_ErrorMsg() 
  {
	  Reporter.log("Validating Pincode Error Msg", true);
	 boolean result = adressDetailsPage.validatePinErrorMsg();
	 Assert.assertTrue(result,"Pincode Error Msg Is Not Displayed,So TC Is Failled");
	  Reporter.log("TC IS Passed", true);
	  
  }
  @AfterMethod
  public void closeCoverFox() throws InterruptedException 
  {
	  Reporter.log("Closing Browser", true);
	  Thread.sleep(5000);
	  closeBrowser();
	 
  }
}
