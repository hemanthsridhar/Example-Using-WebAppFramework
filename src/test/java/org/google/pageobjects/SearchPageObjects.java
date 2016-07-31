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
	
	private WebDriver driver;
	Waiting wait = new Waiting();
	
	public SearchPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	PropertyFileReader propertyRead = new PropertyFileReader();

	By searchResultsLocator = By.xpath(propertyRead.propertiesReader(searchPageObjects, "searchResultsLocator"));

	By searchButtonLocator = By.xpath(propertyRead.propertiesReader(searchPageObjects, "searchButtonLocator"));
	

	@Step("click on search button")
	public SearchPageObjects clickOnSearchButton() {
		driver.findElement(searchButtonLocator).click();
		return this;
	}
	
}
