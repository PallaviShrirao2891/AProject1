package com.PageDistribution.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBases.TestBase;
public class SearchResultPage extends TestBase {
	@FindBy(xpath="//input[@placeholder='search here']")
	private WebElement searchProductBox;
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchButton;
	@FindBy(xpath="//a[text()='All Products ...']")
	private WebElement allProductsLink;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() {
		return allProductsLink.isDisplayed();
	}
	public AddToCartPage clickOnProduct(String productName){
		
		return new AddToCartPage();
	}
}
