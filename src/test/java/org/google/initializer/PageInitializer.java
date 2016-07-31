package org.google.initializer;
import org.framework.maincontroller.CallApplication;
import org.google.pageobjects.LandingPageObjects;
import org.google.pageobjects.SearchPageObjects;

public class PageInitializer extends CallApplication{
	
	
	/*
	 * @author:hemanthsridhar
	 */
	
	
	public String landingPageObjects = "resources/PageObjects/LandingPageObjects.properties";
	
	public String searchPageObjects = "resources/PageObjects/SearchPageObjects.properties";
	
	public LandingPageObjects landingPage()
	{
		LandingPageObjects landingPage = new LandingPageObjects(getDriver());
		 return landingPage;
	}
	
	public SearchPageObjects searchPage()
	{
		SearchPageObjects searchPage = new SearchPageObjects(getDriver());
		 return searchPage;
	}
}
