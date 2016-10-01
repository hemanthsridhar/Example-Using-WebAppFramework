package org.google.pageobjects;

import org.framework.utils.PropertyFileReader;
import org.framework.utils.Waiting;
import org.google.initializer.PageInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class SearchPageObjects extends PageInitializer{

	/*
	 * @author:hemanthsridhar
	 */
	
	PropertyFileReader propertyRead = new PropertyFileReader();
	
	private WebDriver driver;
	
	
	public SearchPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	Waiting wait = new Waiting(driver);
	
	

	By searchResultsLocator = By.xpath(propertyRead.propertiesReader(searchPageObjects, "searchResultsLocator"));

	By searchButtonLocator = By.xpath(propertyRead.propertiesReader(searchPageObjects, "searchButtonLocator"));
	

	@Step("click on search button")
	public SearchPageObjects clickOnSearchButton() {
		driver.findElement(searchButtonLocator).click();
		return this;
	}
	
}
