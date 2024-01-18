package coverFoxPom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanResultPage {

	
	@FindBy(xpath = "//div[contains(text(),'49 matching Health')]") private WebElement resultsInString;
	
	@FindBy(id = "plans-list") private  List<WebElement> plansList;
	
	@FindBy(xpath = "//div[text()='Sort Plans']") private WebElement sortPlansField;
	public CoverFoxHealthPlanResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver ,this);
		
	}
	
	
	
	
	public int availablePlanNumberFromText() 
	{
		String test = resultsInString.getText();
		//49 matching Health Insurance Plans
		String ar[]=test.split(" ");
		String numberOfResultsInString = ar[0];
		//now converting string into integer
		int numOfResultsIn_Int = Integer.parseInt(numberOfResultsInString);
		return numOfResultsIn_Int;
		
				
	}
	public int availablePlanNumberFromBanner()
	{

		int totalNumOfPlans = plansList.size();
		System.out.println(totalNumOfPlans);
		return totalNumOfPlans;
	}
	public boolean sortPlanElementPresency() 
	{
		Reporter.log(" Validating sortPlanElementPresency", true);
		boolean result = sortPlansField.isDisplayed();
		return result;
	}
	
}
