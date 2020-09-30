package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//*[@id='cart_add']")
	WebElement addToCart;
	
	@FindBy(xpath="//a[text()='Checkout Now']")
	WebElement checkOut;
	
	@FindBy(id="proceed-to-checkout")
	WebElement proceedToCheckOut;
	
	

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickButton()
	{
		WebDriverWait  wait = new WebDriverWait(driver,2500);
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(checkOut));
		checkOut.click();
		proceedToCheckOut.click();
	}

}
