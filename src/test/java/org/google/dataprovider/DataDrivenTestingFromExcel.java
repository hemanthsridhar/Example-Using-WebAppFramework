package org.google.dataprovider;

import java.io.File;
import java.lang.reflect.Method;
import org.framework.utils.ExcelLibrary;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataDrivenTestingFromExcel {

	/*
	 * @author:hemanthsridhar
	 */
	
	
	@DataProvider(name="excelSheetDataRead",parallel = true)
	public static Object[][] excelSheetDataRead(Method methodName) throws Exception{
		File file = new File("resources/"+methodName.getName()+".xlsx");
		ExcelLibrary excel =  new ExcelLibrary(file.getAbsolutePath());
		 Object data[][] =	excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
		return data;
	}
	
	@DataProvider(name="singleExcelMultipleSheets",parallel = true)
	public static Object[][] singleExcelMultipleSheets(Method methodName,ITestContext context) throws Exception{
		File file = new File("resources/"+context.getCurrentXmlTest().getParameter("Product Name")+"TestData.xlsx");
		ExcelLibrary excel =  new ExcelLibrary(file.getAbsolutePath(),methodName.getName());
		 Object data[][] =	excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}
}