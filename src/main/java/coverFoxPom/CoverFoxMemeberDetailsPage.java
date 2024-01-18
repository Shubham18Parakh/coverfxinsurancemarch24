package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverFoxMemeberDetailsPage {
	
	@FindBy(id = "Age-You") private WebElement ageDropDown;
	
	@FindBy(className = "next-btn") private WebElement next_Button;
	
	
	public CoverFoxMemeberDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this );
	}
public void handleAgeDropDown(String age)
{
	Select s = new Select(ageDropDown);
	s.selectByValue(age+"y");
}
public void clickOnNextButton() 
{
	next_Button.click();
}
}
