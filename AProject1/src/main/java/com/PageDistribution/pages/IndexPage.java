package com.PageDistribution.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBases.TestBase;


public class IndexPage extends TestBase{
	@FindBy(xpath = "//a[text()='log yourself in']")
	public WebElement logYourselfInLink;
	@FindBy(xpath = "//img[@alt='Zen Cart Documentation']")
	private WebElement indexLogo;
	@FindBy(xpath="//input[@placeholder='search here']")
	private WebElement searchProductBox;
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchButton;
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getTitle() {
		String myTitel=driver.getTitle();
		return myTitel;
	}
	public boolean validateLogo() {
	return  indexLogo.isDisplayed();
	}
	public LoginPage clickOnLogYourselfInLink() {
		logYourselfInLink.click();
		return new LoginPage(driver);
	}
	public SearchResultPage searchProduct(String productName) {
		searchProductBox.clear();
		type(searchProductBox, productName);
		return new SearchResultPage();
	}
}
