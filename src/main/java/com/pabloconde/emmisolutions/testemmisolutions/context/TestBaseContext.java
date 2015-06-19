package com.pabloconde.emmisolutions.testemmisolutions.context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/***
 * Context class for PageObjects to inherit.
 * @author Pablitoh (pabloconde88@gmail.com)
 *
 */
public abstract class TestBaseContext {
	
	private WebDriver driver;

	/***
	 * Set up the driver and instantiate the PageObject.
	 * @param driver
	 */
	public TestBaseContext(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
