package com.pabloconde.emmisolutions.testemmisolutions.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pabloconde.emmisolutions.testemmisolutions.context.TestBaseContext;

/***
 * 
 * Page object representing the Amazon home page.
 * 
 * @author Pablitoh (pabloconde88@gmail.com)
 *
 */

public class AmazonHomePage extends TestBaseContext {
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBar;
	
	public AmazonHomePage(WebDriver driver)
	{
		super(driver);
	}
	
	/***
	 * Goes to Amazon Home Page
	 * @return {@link AmazonAfterSearchPage}
	 */
	public AmazonHomePage goToHomePage()
	{
		getDriver().get("http://www.amazon.com");
		return new AmazonHomePage(getDriver());
	}
	
	/***
	 * Search Amazon for a specific Keyword
	 * @param textToSearch
	 * @return {@link AmazonAfterSearchPage}
	 */
	public AmazonAfterSearchPage searchForKeyword(String textToSearch)
	{
		searchBar.sendKeys(textToSearch);
		searchBar.sendKeys(Keys.ENTER);
		return new AmazonAfterSearchPage(getDriver());
	}

}
