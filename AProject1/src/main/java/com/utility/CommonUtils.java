package com.utility;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import jxl.Sheet;
import jxl.Workbook;


public class CommonUtils {
public static void clearText(WebElement e) {
	e.clear();
}
public void click(WebElement e) {
	e.click();
}
public void sendKeys(WebElement e,String data) {
	e.sendKeys(data);
}
public String getTextData(WebElement e) {
	return e.getText();
}
public static ArrayList<String> readDataOfCol(String fileName,String sheetName,int colNo) throws Exception
{
	ArrayList<String> expList=new ArrayList<String>();
	FileInputStream fis=new FileInputStream(fileName);
	Workbook wb=Workbook.getWorkbook(fis);
	Sheet sh=wb.getSheet(sheetName);
	int row=sh.getRows();
	for(int i=1;i<row;i++) {
		expList.add(sh.getCell(colNo,i).getContents());
			}
	System.out.println(expList);
	return expList;
}
public static ArrayList<String> readDataOfRow(String fileName,String sheetName,int rowNo) throws Exception
{
	ArrayList<String> expList=new ArrayList<String>();
	FileInputStream fis=new FileInputStream(fileName);
	Workbook wb=Workbook.getWorkbook(fis);
	Sheet sh=wb.getSheet(sheetName);
	//int row=sh.getRows();
	int col=sh.getColumns();
	for(int i=0;i<col;i++) {
		expList.add(sh.getCell(i,rowNo).getContents());
			}
	System.out.println(expList);
	return expList;
}
public void sendData1(WebElement element, String value,WebDriver driver) {
	Actions act = new Actions(driver);
	act.moveToElement(element).click().sendKeys(value).build().perform();
}

public void clickData1(WebElement element,WebDriver driver) {
	Actions act = new Actions(driver);
	act.moveToElement(element).click().perform();
}

public static void waitBeforeBrowserClose() throws Exception {
	Thread.sleep(2000);
}
}
