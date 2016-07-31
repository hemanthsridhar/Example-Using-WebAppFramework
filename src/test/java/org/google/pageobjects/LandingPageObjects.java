package org.google.pageobjects;

import org.framework.utils.PropertyFileReader;
import org.google.initializer.PageInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class LandingPageObjects extends PageInitializer{

	private WebDriver driver;
	
	public LandingPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	PropertyFileReader propertyRead = new PropertyFileReader();
	
	private String searchTextbox = propertyRead.propertiesReader(landingPageObjects, "searchTextboxLocator");
	
	By searchTextboxLocator = By.xpath(searchTextbox);

	@Step("enter search text {0}")
	public SearchPageObjects enterSearchText(String searchText) {
		driver.findElement(searchTextboxLocator).click();
		driver.findElement(searchTextboxLocator).sendKeys(searchText);
		return searchPage();
		
	}
	
	
	
}
