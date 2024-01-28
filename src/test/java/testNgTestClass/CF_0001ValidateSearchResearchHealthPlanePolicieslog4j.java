package testNgTestClass;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
public class CF_0001ValidateSearchResearchHealthPlanePolicieslog4j extends BaseClass {
	
	public static Logger logger;

	CoverFoxHomePage home;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxAdressDetailsPage adressDetailsPage;
	CoverFoxMemeberDetailsPage memeberDetailsPage;
	CoverFoxHealthPlanResultPage resultPage;
	
	@BeforeClass
	public void launchingBrowser() throws InterruptedException 
	{
		logger=Logger.getLogger("CoverFoxInsurance");
		PropertyConfigurator.configure("log4j.properties");
		//logger.fatal(adressDetailsPage);
		launchBrowser();
		logger.info("launching coverfox");
		home = new CoverFoxHomePage(driver);
		healthPlanPage= new CoverFoxHealthPlanPage(driver);
		adressDetailsPage= new CoverFoxAdressDetailsPage(driver);
		memeberDetailsPage = new CoverFoxMemeberDetailsPage(driver);
		resultPage = new CoverFoxHealthPlanResultPage(driver);
		Reporter.log("Opening Browser", true);
		driver.get("https://www.coverfox.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
	}
	@BeforeMethod
	public void enterMemberDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("Clicking on Gender Button", true);
		home.clickOnMaleButton();
		logger.info("Clicking On Male Button");
		Thread.sleep(1000);
		Reporter.log("Clicking On Next Button", true);
		healthPlanPage.clickOnNextButton();
		logger.info("Clicking On Next Button");
		Thread.sleep(1000);
		Reporter.log("Handling Age DropDown", true);
		logger.info("Handling Age DropDown");
		memeberDetailsPage.handleAgeDropDown(UtilityClass.dataFromExcelSheet(1, 0));
		Thread.sleep(1000);
		Reporter.log("Clicking On Next Button", true);
		memeberDetailsPage.clickOnNextButton();
		logger.info("Clicking On Next Button");
		Thread.sleep(1000);
		Reporter.log("Entering Pincode", true);
		logger.info("Entering Pincode");
		adressDetailsPage.enterPinCode(UtilityClass.dataFromExcelSheet(1, 1));
		Thread.sleep(1000);
		Reporter.log("Entering Mobile Number", true);
		logger.warn("Entering Mobile Number");
		logger.info("Entering Mobile Number");
		adressDetailsPage.enterMobileNumber(UtilityClass.dataFromExcelSheet(1, 2));
		Thread.sleep(1000);
		Reporter.log("Clicking On Continue Button", true);
		adressDetailsPage.clickOnContinueButton();
		logger.info("Clicking On Continue Button");
		
		Thread.sleep(1000);
	}

	
	
	@Test
  public void validateTestPlansFromTextAndBanners() throws InterruptedException, IOException 
  {
		//Reporter.log("Fatching Number Of Result From Text", true);
		logger.error("Fatching Number Of Result From Text");
		int textResult = resultPage.availablePlanNumberFromText();
		Thread.sleep(7000);
		//Reporter.log("Fatching Number Of Result From banners", true);
		logger.fatal("Fatching Number Of Result From banners");
		int bannerResult = resultPage.availablePlanNumberFromBanner();
		Thread.sleep(2000);
		SoftAssert soft = new SoftAssert();
	  soft.assertEquals(textResult,bannerResult,"Text result not matching with banner result so test case failled.");
	 // Reporter.log("Tc is passed", true);
	  logger.error("Tc is passed");
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
	logger.info("Closing Browser");
	Thread.sleep(10000);
	closeBrowser();
	}
}

	
	
 

