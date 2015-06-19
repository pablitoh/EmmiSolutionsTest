package com.pabloconde.emmisolutions.testemmisolutions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pabloconde.emmisolutions.testemmisolutions.pageobjects.AmazonAfterSearchPage;
import com.pabloconde.emmisolutions.testemmisolutions.pageobjects.AmazonHomePage;
import com.pabloconde.emmisolutions.testemmisolutions.pageobjects.SingleProductPage;


/**
 * Amazon Test for Emmi Solutions 06/18/2015 10:30 pm by Pablo Conde.
 * @author Pablitoh (pabloconde88@gmail.com)
 */
public class AmazonTest 
   
{	
	private static final String KEYWORD = "Shoes";
	private static final String BRAND_FILTER = "Nine West";
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void searchForKeyWordAndApplyFiltering()
	{	
		
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver).goToHomePage();
		AmazonAfterSearchPage searchPage = amazonHomePage.searchForKeyword(KEYWORD);
		searchPage.verifyIfKeywordIsPresentInSearchResult(KEYWORD);
		searchPage.filterByBrandName(BRAND_FILTER);
		searchPage.verifyKeywordIsContainedInResults(KEYWORD);
		
		
		WebElement randomProduct = searchPage.getRandomProduct();
		String productName = randomProduct.getText();
		randomProduct.click();
		
		
		SingleProductPage singleProduct = new SingleProductPage(driver);
		singleProduct.verifyIfCorrectProduct(productName);
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
}
