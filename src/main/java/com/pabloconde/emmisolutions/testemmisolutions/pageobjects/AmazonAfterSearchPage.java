package com.pabloconde.emmisolutions.testemmisolutions.pageobjects;

import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Random;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pabloconde.emmisolutions.testemmisolutions.context.TestBaseContext;

/***
 * 
 * Page object representing the after search amazon page.
 * 
 * @author Pablitoh (pabloconde88@gmail.com)
 *
 */
public class AmazonAfterSearchPage extends TestBaseContext {
	
	@FindBy(id="editableBreadcrumbContent")
	private WebElement searchResultBar;
	
	@FindBy(css = "#atfResults .s-access-detail-page")
	private List<WebElement> productList;
	
	@FindBy(className = "refinementLink")
	private List<WebElement> filters;
	
	
	public AmazonAfterSearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	/***
	 * Verifies that the keyword that was searched appears in the page
	 * @param textToVerify
	 */
	public void verifyIfKeywordIsPresentInSearchResult(String textToVerify)
	{
		assertThat(searchResultBar.getText(),CoreMatchers.containsString(textToVerify));
	}
	
	/***
	 * Verify that the provided keyword appears in at least one of the products
	 * @param textToVerify
	 */
	public void verifyKeywordIsContainedInResults(String textToVerify)
	{
		assertThat(verifyAtLeastOneResultIsContained(textToVerify),CoreMatchers.describedAs("Expected TRUE if The keyword was found in any product", CoreMatchers.is(true)));
	}
	
	/***
	 * Verify that the provided keyword appears in at least one of the products
	 * @param textToVerify
	 * @return {@link Boolean}
	 */
	private boolean verifyAtLeastOneResultIsContained(String textToVerify)
	{
		for(WebElement product:productList)
		{
			if(product.getText().contains(textToVerify))
			{
				return true;
			}
		}
		return false;
	}
	
	/***
	 * Gets a random product
	 * @return {@link WebElement}
	 */
	public WebElement getRandomProduct()
	{
		return productList.get(new Random().nextInt(productList.size()));	
	}

	/***
	 * Filters by brand name
	 * @param brandFilter
	 * @return {@link AmazonAfterSearchPage}
	 */
	public AmazonAfterSearchPage filterByBrandName(String brandFilter) {
		
		for(WebElement filter:filters)
		{
			if(filter.getText().equals(brandFilter))
			{
				filter.click();
				new WebDriverWait(getDriver(),30).until(ExpectedConditions.visibilityOfElementLocated(By.id("refinements")));
				return new AmazonAfterSearchPage(getDriver());
			}
		}
		throw new RuntimeException("No filter was found with the name ["+brandFilter+"]");
	}
	
	
	
}
