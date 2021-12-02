package com.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import com.TestBases.TestBase;

public class ExcelUtility extends TestBase {
	
	FileInputStream fis = null;
	Workbook wb = null;
	Sheet sh = null;

	public String getCellData(String filePath, String sheetName, int rownum, int colnum) {
		DataFormatter df = new DataFormatter();
		try {
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		sh = wb.getSheet(sheetName);
		Cell c = sh.getRow(rownum).getCell(colnum);
		return df.formatCellValue(c);
	}
	
	@Test
	public void test() {
		String jxlpath=System.getProperty("user.dir")+"/src/test/resources/Tj.xls";
		String poipath=System.getProperty("user.dir")+"/src/test/resources/TA.xlsx";
		System.out.println(getCellData(jxlpath, "login", 1, 1));
		System.out.println(getCellData(poipath, "login", 1, 1));
	}
}
