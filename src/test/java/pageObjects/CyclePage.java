package pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CyclePage {
	
	public WebDriver driver=null;

	@FindBy(xpath="//h2[text()='Filters']//following::i[@class='fa fa-caret-right'][2]")
	WebElement cityFilter;
	
	@FindBy(xpath="//input[@id='ahmedabad']")
	WebElement Ahmdbd;
	
	@FindBy(xpath="//h2[text()='Filters']//following::button[@class='btn btn-sm btn-primary apply-registration-filter' and text()='Apply'][1]")
	WebElement cnfrmCity;
	
	@FindBy(xpath="//label[text()='Best Match ']")
	WebElement sortParameter;
	
	@FindBy(xpath="//a[@data-query='sort_by=selling_price&sort_order=1']")
	WebElement ascPrice;

	@FindBy(xpath="//span[@id='header_category_button']//following::img[contains(@src,'.jpg')][12]")
	WebElement chosenCycle;
	
	String origWndw = null;
	
	public CyclePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectCity()
	{
		cityFilter.click();
		Ahmdbd.click();
		cnfrmCity.click();
	}
	
	public void sortCycles()
	{
		
		try {
			for(int i=0;i<7;i++)
			{
		WebDriverWait  wait = new WebDriverWait(driver,2500);		
		wait.until(ExpectedConditions.elementToBeClickable(sortParameter));		
		sortParameter.click();
			}
			}catch(Exception e)
		{
			System.out.println("Best Match staled");
		}
		
		ascPrice.click();
		
	}
	
	public void selectCycle()
	{
		origWndw = driver.getWindowHandle();
		WebDriverWait  wait = new WebDriverWait(driver,2500);
		wait.until(ExpectedConditions.elementToBeClickable(chosenCycle));		
		chosenCycle.click();
		Set<String> wndws = driver.getWindowHandles();
		for(String s:wndws)
		{
			if(!s.equalsIgnoreCase(origWndw))
			{
				driver.switchTo().window(s);
			}
		}
	}
	

}
