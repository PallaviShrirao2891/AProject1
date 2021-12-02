package com.PageDistribution.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
@FindBy(xpath="//a[text()='newest additions']")
WebElement newestAdditionsLink;
public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

	public String getCurrURL() {
		String url=driver.getCurrentUrl();
		return url;
	}
	public NewProductPage clickOnNewestAdditionsLink() {
		newestAdditionsLink.click();
		return new NewProductPage(driver);
	}
}
