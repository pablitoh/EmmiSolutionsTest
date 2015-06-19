package com.pabloconde.emmisolutions.testemmisolutions.pageobjects;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pabloconde.emmisolutions.testemmisolutions.context.TestBaseContext;

/***
 * Single product page for Amazon
 * @author Pablitoh (pabloconde88@gmail.com)
 *
 */
public class SingleProductPage extends TestBaseContext{
	
	@FindBy(id="productTitle")
	private WebElement productTitle;
	
	public SingleProductPage(WebDriver driver)
	{
		super(driver);
	}

	public void verifyIfCorrectProduct(String productName) {
		assertThat(productTitle.getText(),CoreMatchers.equalTo(productName));
		
	}

}
