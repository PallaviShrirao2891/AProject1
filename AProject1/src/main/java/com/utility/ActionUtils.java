package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.TestBases.TestBase;

public class ActionUtils extends TestBase {
public void typeIn(WebElement element,String text) {
	element.sendKeys(text);
}
public void click(WebElement element) {
	element.click();
}
public void dragAndDrop(WebElement source,WebElement target) {
	Actions act=new Actions(driver);
	act.dragAndDrop(source, target);
}
public void moveAndClickElement(WebElement element) {
Actions act=new Actions(driver);
act.moveToElement(element).click().build().perform();
}
public WebElement getElement(String locType,String locValue) {
	if(locType.equals("xpath"))
		return driver.findElement(By.xpath(locValue));
	if(locType.equals("id"))
		return driver.findElement(By.id(locValue));
	return null;
		
}
}
