package com.PageDistribution.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBases.TestBase;

public class LoginPage extends TestBase {
	
	public WebDriver driver;
	
	IndexPage ip = new IndexPage(driver);
	@FindBy(xpath = "//a[text()='newest additions']")
	public WebElement newestAdditionsLink;
	@FindBy(xpath = "//input[@id='login-email-address']")
	WebElement email;
	@FindBy(id = "login-password")
	WebElement pass;
	@FindBy(xpath = "//input[@value='Sign In']")
	WebElement signInBtn;
	@FindBy(xpath="//input[@placeholder='search here']")
	private WebElement searchProductBox;
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchButton;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login() {
		email.sendKeys(readproperty("username"));
		pass.sendKeys(readproperty("password"));
		signInBtn.click();
		return new HomePage(driver);
	}
	public SearchResultPage searchProduct(String productName) {
		searchProductBox.clear();
		type(searchProductBox, productName);
		return new SearchResultPage();
	}
	public NewProductPage clickOnNewestAdditionsLink() {
		newestAdditionsLink.click();
		return new NewProductPage(driver);
	}
}
