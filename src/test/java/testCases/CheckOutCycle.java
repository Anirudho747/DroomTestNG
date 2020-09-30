package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.CheckOutPage;
import pageObjects.CyclePage;
import pageObjects.GooglePage;
import pageObjects.LandingPage;

public class CheckOutCycle extends BaseClass{
	
	public GooglePage gp ;
	public LandingPage lp;
	public CyclePage cp;
	public CheckOutPage cop;
	
	@Test(priority=1)
	public void googleDroom()
	{
		logger = report.createTest("googleDroom");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
		//logger.pass("googleDroom Test Passed");
		gp = new GooglePage(driver);
		gp.searchDroom();
		gp.goDroom();
	}

	@Test(priority=2,dependsOnMethods="googleDroom")
	public void moveToCycles() throws InterruptedException
	{
		logger = report.createTest("moveToCycles");
		Assert.assertEquals(driver.getCurrentUrl(), "https://droom.in/");
	    //logger.pass("moveToCycles Test Passed");
		lp = new LandingPage(driver);
		lp.remove_pop_up();
		lp.uncheckNewProduct();
		lp.searchCycle();
	}
	
	@Test(dependsOnMethods="moveToCycles")
	public void selectCycle()
	{
		logger = report.createTest("selectCycle");
		Assert.assertEquals(driver.getCurrentUrl(), "https://droom.in/bicycles/used?search=true");
		//logger.pass("selectCycle");
		cp = new CyclePage(driver);
		cp.selectCity();
		cp.sortCycles();
		Assert.assertEquals(driver.getCurrentUrl(), "https://droom.in/bicycles/used?page=1&tab=grid&search=true&location=ahmedabad&condition=used&sort_by=selling_price&sort_order=1");
		cp.selectCycle();
	}
	 
	@Test(dependsOnMethods="selectCycle")
	public void checkOutCycle()
	{
		logger = report.createTest("checkOutCycle");
	    cop = new CheckOutPage(driver);
	    cop.clickButton();
	    Assert.assertEquals(driver.getCurrentUrl(), "https://secure.droom.in/cart-checkout");
	    //logger.pass("checkOutCycle Test Passed");
	}
	
}
