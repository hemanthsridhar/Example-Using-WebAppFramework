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
	private String searchResults = propertyRead.propertiesReader(searchPageObjects, "searchResults");
	private String searchButton = propertyRead.propertiesReader(searchPageObjects, "searchButton");

	By searchResultsLocator = By.xpath(searchResults);

	By searchButtonLocator = By.xpath(searchButton);
	

	@Step("click on search button")
	public SearchPageObjects clickOnSearchButton() {
		driver.findElement(searchButtonLocator).click();
		return this;
	}
	
}
