package org.google.modules;
import java.io.File;
import java.io.IOException;

import org.framework.utils.ExcelLibrary;
import org.google.dataprovider.DataDrivenTestingFromExcel;
import org.google.initializer.PageInitializer;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class SearchModuleTest extends PageInitializer{
	
	/*
	 * @author:hemanthsridhar
	 */
	
	
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
	
	@Features("Search Module")
	@Stories(value = { "Data Provider Testing Via Single excel but multiple sheets" })
	@Test(groups="regression",dataProvider="singleExcelMultipleSheets",dataProviderClass=DataDrivenTestingFromExcel.class)
	@TestCaseId("TC_003")
    public void loginTest1(String testCaseId,String userName,String password,String expectedNameOfTheUser)throws Exception {	 
		System.out.println(testCaseId);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(expectedNameOfTheUser);
	}
	
	@Features("Search Module")
	@Stories(value = { "Data Provider Testing Via Single excel but multiple sheets with multiple test data" })
	@Test(groups="regression",dataProvider="singleExcelMultipleSheets",dataProviderClass=DataDrivenTestingFromExcel.class)
	@TestCaseId("TC_004")
    public void loginTest2(String testCaseId,String userName,String password,String expectedNameOfTheUser)throws Exception {
	
		
		System.out.println(testCaseId);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(expectedNameOfTheUser);
	}
	
	@Test
	public void loginTest3() throws IOException{
		File file = new File("resources/GoogleTestData.xlsx");
		ExcelLibrary excel = new ExcelLibrary(file.getAbsolutePath(),"loginTest2");		
		
		System.out.println(excel.xlsxReadCell("Password", 2));
		
		//for row number and column number reading, make sure you provider 1 value less for the respective row number and the column number. 
		System.out.println(excel.xlsxReadCell(0, 2));
		
		ExcelLibrary excel1 = new ExcelLibrary(file.getAbsolutePath(),"loginTest1");
		
		System.out.println(excel1.xlsxReadCell("Password", 1));
		//for row number and column number reading, make sure you provider 1 value less for the respective row number and the column number. 
		
		System.out.println(excel1.xlsxReadCell(3, 1));
	}
}
