package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	public WebDriver driver;

	@FindBy (xpath="//a[@class='d-text-yellow d-font-size-12 em-dont-show']")
	WebElement close_pop_up;
	
	@FindBy(id="new-checkbox")
	WebElement new_CheckBox;
	
	@FindBy(id="vehicle_type_span")
	WebElement vehicle_Type;
	
	@FindBy(xpath="//span[text()='Bicycle']")
	WebElement cycle;
	
	@FindBy(xpath="//input[@value='Search']")
	WebElement searchBtn;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void remove_pop_up()
	{
		WebDriverWait wait = new WebDriverWait(driver,7000); 
		wait.until(ExpectedConditions.elementToBeClickable(close_pop_up));
		close_pop_up.click();	
	}
	
	public void uncheckNewProduct()
	{
		new_CheckBox.click();
	}
	
	public void searchCycle() throws InterruptedException
	{
		vehicle_Type.click();
		cycle.click();
		Thread.sleep(3400);
		searchBtn.click();
	}
}
