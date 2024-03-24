package testNgTestClass;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import coverFoxPom.CoverFoxAdressDetailsPage;
import coverFoxPom.CoverFoxHealthPlanPage;
import coverFoxPom.CoverFoxHealthPlanResultPage;
import coverFoxPom.CoverFoxHomePage;
import coverFoxPom.CoverFoxMemeberDetailsPage;
import coverFoxUtility.UtilityClass;
import coverFoxbase.BaseClass;


@Listeners(listners_study.ListnersCoverFox.class)
public class CF_001ValidateSearchResearchHealthPlanereadfrompropertiesfilePolicies2 extends BaseClass {
	

	CoverFoxHomePage home;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxAdressDetailsPage adressDetailsPage;
	CoverFoxMemeberDetailsPage memeberDetailsPage;
	CoverFoxHealthPlanResultPage resultPage;
	
	@BeforeClass
	public void launchingBrowser() throws InterruptedException 
	{
		launchBrowser();
		home = new CoverFoxHomePage(driver);
		healthPlanPage= new CoverFoxHealthPlanPage(driver);
		adressDetailsPage= new CoverFoxAdressDetailsPage(driver);
		memeberDetailsPage = new CoverFoxMemeberDetailsPage(driver);
		resultPage = new CoverFoxHealthPlanResultPage(driver);
		Reporter.log("Opening Browser", true);
		driver.get("https://www.coverfox.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		UtilityClass.implicitwait(driver, 5);
		
	}
	@BeforeMethod
	public void enterMemberDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("Clicking on Gender Button", true);
		home.clickOnMaleButton();
		Thread.sleep(1000);
		Reporter.log("Clicking On Next Button", true);
		healthPlanPage.clickOnNextButton();
		Thread.sleep(1000);
		Reporter.log("Handling Age DropDown", true);
		memeberDetailsPage.handleAgeDropDown(UtilityClass.readDataFromPropertyClass("age"));
		Thread.sleep(1000);
		Reporter.log("Clicking On Next Button", true);
		memeberDetailsPage.clickOnNextButton();
		Thread.sleep(1000);
		Reporter.log("Entering Pincode", true);
		adressDetailsPage.enterPinCode(UtilityClass.readDataFromPropertyClass("pincode"));
		Thread.sleep(1000);
		Reporter.log("Entering Mobile Number", true);
		adressDetailsPage.enterMobileNumber(UtilityClass.readDataFromPropertyClass("mobilenumber"));
		Thread.sleep(1000);
		Reporter.log("Clicking On Continue Button", true);
		adressDetailsPage.clickOnContinueButton();
		Thread.sleep(1000);
	}
	
	
	@Test
  public void validateTestPlansFromTextAndBanners() throws InterruptedException, IOException 
  {
		Reporter.log("Fatching Number Of Result From Text", true);
		int textResult = resultPage.availablePlanNumberFromText();
		Thread.sleep(7000);
		Reporter.log("Fatching Number Of Result From banners", true);
		int bannerResult = resultPage.availablePlanNumberFromBanner();
		Thread.sleep(2000);
		SoftAssert soft = new SoftAssert();
	  soft.assertEquals(textResult,bannerResult,"Text result not matching with banner result so test case failled.");
	  Reporter.log("Tc is passed", true);
	  //  UtilityClass.takeScreenShot(driver, " CF_001");
	  Reporter.log("Taking screenshot Of Final Result", true);
	  soft.assertAll();
  }
//	@Test
//	public void validatesortplanbutton() throws InterruptedException 
//	{
//		SoftAssert soft = new SoftAssert();
//		
//		Thread.sleep(500);
//		soft.assertTrue(resultPage.sortPlanElementPresency(),"sort plan field is not present,TC is Failled ");
//		soft.assertAll();
//	}
//	
	
	@AfterClass
	public void closingBrowser() throws InterruptedException
	{
		
	Reporter.log("Closing Browser", true);
	Thread.sleep(10000);
	closeBrowser();
	}
}

	
	
 

