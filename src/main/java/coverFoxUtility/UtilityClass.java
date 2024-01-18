package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class UtilityClass {
	

	public static String dataFromExcelSheet(int row , int cell) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream myfile = new FileInputStream("D:\\Book1.xlsx");
		Sheet mySheet = WorkbookFactory.create(myfile).getSheet("Sheet5");
		return mySheet.getRow(row).getCell(cell).getStringCellValue();
		
	}
	public static void takeScreenShot(WebDriver driver, String TC_ID) throws IOException
	{
		Reporter.log("Taking Screenshot", true);
		
		String timestamp= new SimpleDateFormat("yyyy.MM.dd,HH.mm.ss").format(new Date());
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\MyScreenshot\\Coverfox"+TC_ID+timestamp+".png");
		Reporter.log("Save Screenshot at destination" +dest , true);
		org.openqa.selenium.io.FileHandler.copy(src, dest);
	}
	public static void scrollIntoView(WebDriver driver,WebElement element) 
	{
		
	JavascriptExecutor js = (JavascriptExecutor)driver;
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	js.executeScript("arguments[0].scrollIntoView();",element );
	
	}
	public static void implicitwait (WebDriver driver , int time) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	
		
	}
	public static String readDataFromPropertyClass(String key) throws IOException 
	{
	       // Create Object Of Property class
			Properties prop = new Properties();
			//File location
			//Create Obj of FileinputStream
			//FileInputStream MyFile = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\seleniumshubham\\CoverFoxData.properties");
	         //load file
			
			FileInputStream MyFile = new FileInputStream(System.getProperty("user.dir")+ "\\Coverfoxdatamevan.properties");
			 prop.load(MyFile);
			 //pass the key for the data we want
			 String value = prop.getProperty(key);
		     // System.out.println(value);
			return value;
		      
		      
	
	}
	
	
	
}
