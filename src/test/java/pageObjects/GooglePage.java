package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	
	public WebDriver driver=null;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchBar;
	
	@FindBy(xpath="//input[@name='q']//following::a[@href=\"https://droom.in/\"][1]")
	WebElement droomLink;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchDroom()
	{
		searchBar.clear();
		searchBar.sendKeys("droom");
		WebDriverWait wait = new WebDriverWait(driver,7000); 
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='sbtc']//following::div[@class='sbl1']")));
	    List<WebElement> srchRslt = driver.findElements(By.xpath("//div[@class='sbtc']//following::div[@class='sbl1']"));
		for(WebElement we:srchRslt)
		{
			System.out.println(we.getText());
    	}
			
			searchBar.sendKeys(Keys.ENTER);
	}
	
	public void goDroom()
	{
		droomLink.click();
	}

}
