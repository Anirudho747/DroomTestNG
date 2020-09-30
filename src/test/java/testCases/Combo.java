package testCases;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Combo {
	
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void acessDroom() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='q']")).clear();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("droom");
	    WebDriverWait wait = new WebDriverWait(driver,7000); 
	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='sbtc']//following::div[@class='sbl1']")));
	    List<WebElement> srchRslt = driver.findElements(By.xpath("//div[@class='sbtc']//following::div[@class='sbl1']"));
		for(WebElement we:srchRslt)
		{
			System.out.println(we.getText());
    	}
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@name='q']//following::a[@href=\"https://droom.in/\"][1]")).click();
		//driver.manage().timeouts().implicitlyWait(1060, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='d-text-yellow d-font-size-12 em-dont-show']")));
		driver.findElement(By.xpath("//a[@class='d-text-yellow d-font-size-12 em-dont-show']")).click();
		driver.findElement(By.id("new-checkbox")).click();
		driver.findElement(By.id("vehicle_type_span")).click();
		//driver.findElement(By.xpath("//span[text()='Bicycle']")).click();
		driver.findElement(By.cssSelector("#home_page_search_container > div > div > div > div.col-xl-10.col-lg-10.col-md-10.search-body > div:nth-child(2) > ul > li:nth-child(2) > div > div > div > ul > li:nth-child(4) > a")).click();
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions. stalenessOf(driver.findElement(By.xpath("//input[@value='Search']")))));
		Thread.sleep(1600);
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Reporter.log("Reached Alternate page");
		driver.findElement(By.xpath("//h2[text()='Filters']//following::i[@class='fa fa-caret-right'][2]")).click();
		Reporter.log("Clicked Filter");
		driver.findElement(By.xpath("//input[@id='ahmedabad']")).click();
		Reporter.log("Chosen Ahmedabad");
		driver.findElement(By.xpath("//h2[text()='Filters']//following::button[@class='btn btn-sm btn-primary apply-registration-filter' and text()='Apply'][1]")).click();
		
		try {
			for(int i=0;i<7;i++)
			{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Best Match ']")));		
		driver.findElement(By.xpath("//label[text()='Best Match ']")).click();
			}
			}catch(Exception e)
		{
			System.out.println("Best Match staled");
		}
		
		driver.findElement(By.xpath("//a[@data-query='sort_by=selling_price&sort_order=1']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='header_category_button']//following::img[contains(@src,'.jpg')][12]")));
		System.out.println(driver.getWindowHandle()+" Wind1");
		driver.findElement(By.xpath("//span[@id='header_category_button']//following::img[contains(@src,'.jpg')][12]")).click();
	
		//driver.manage().timeouts().implicitlyWait(1600,TimeUnit.SECONDS);	
		//wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		 String origWindow = driver.getWindowHandle();
	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cart_add']")));
		System.out.println(driver.getWindowHandle()+" Wind3");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		Set<String> wndws = driver.getWindowHandles();
		for(String s:wndws)
		{
			if(!s.equalsIgnoreCase(origWindow))
			{
				driver.switchTo().window(s);
			}
		}
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cart_add']")));
		System.out.println(driver.getWindowHandle()+" Wind4");
		System.out.println(driver.getCurrentUrl()+" URl2");
		System.out.println(driver.getTitle()+" Title 2");
		driver.findElement(By.xpath("//*[@id='cart_add']")).click();
		System.out.println("1");
	//	driver.findElement(By.id("add_listing_services_to_cart")).click();
	//	System.out.println("2");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Checkout Now']")));
		driver.findElement(By.xpath("//a[text()='Checkout Now']")).click();
		System.out.println("3");
		driver.findElement(By.id("proceed-to-checkout")).click();
	} 
	
	@AfterClass
	public void tearDown() throws InterruptedException{
	Thread.sleep(7000);
	//driver.close();
	}

}
