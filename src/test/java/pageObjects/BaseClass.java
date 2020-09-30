package pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;
import utilities.ReadUtility;

public class BaseClass {
	
	public WebDriver driver=null;
	ReadUtility ru = new ReadUtility();
	Helper hlpr = new Helper();
	public ExtentReports report = null;
	public ExtentTest logger = null;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(700,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);
		driver.get(ru.getWebsite());
		
		String reportPath = "./src/test/resources/reports/html"+hlpr.getTime()+"report.html";
		ExtentHtmlReporter ehr = new ExtentHtmlReporter(reportPath); 
		report = new ExtentReports();
		report.attachReporter(ehr);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult itr)
	{
		if(itr.getStatus()==ITestResult.SUCCESS)
		{
			hlpr.tkscrnSht(driver);
			try {
				logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(hlpr.tkscrnSht(driver)).build());
			} catch (IOException e) {
				System.out.println("Base Class, Tear down");
			}
		}
		report.flush();
	}
	
	@AfterClass
	public void tearDownClass()
	{
	driver.quit();	
	}
	

}
