package org.google.dataprovider;

import java.io.File;
import java.lang.reflect.Method;
import org.framework.utils.ExcelLibrary;
import org.testng.annotations.DataProvider;

public class DataDrivenTestingFromExcel {

	
	@DataProvider(name="excelSheetDataRead",parallel = true)
	public static Object[][] excelSheetDataRead(Method methodName) throws Exception{
		File file = new File("resources/ExcelSheetData/"+methodName.getName()+".xlsx");
		ExcelLibrary excel =  new ExcelLibrary(file.getAbsolutePath());
		 Object data[][] =	excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
		return data;
	}
}