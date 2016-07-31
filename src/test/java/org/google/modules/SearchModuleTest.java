package org.google.modules;
import org.google.dataprovider.DataDrivenTestingFromExcel;
import org.google.initializer.PageInitializer;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class SearchModuleTest extends PageInitializer{
	
	
	
	@Features("Search Module")
	@Stories(value = { "Search Text Scenarios" })
	@Test(groups="regression",dataProvider="excelSheetDataRead",dataProviderClass=DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
    public void searchText_Scenarios(String testCaseId,String searchText)throws Exception {
		 
		landingPage().enterSearchText(searchText).clickOnSearchButton();
    }
	
	@Features("Search Module")
	@Stories(value = { "Search Fail Scenarios" })
	@Test(groups="regression")
	@TestCaseId("TC_002")
    public void failToAttachScreenshot()throws Exception {	 
		Assert.assertTrue(false);
    }
}
