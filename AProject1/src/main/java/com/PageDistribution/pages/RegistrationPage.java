package com.PageDistribution.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TestBases.TestBase;

public class RegistrationPage extends TestBase {
	public WebDriver driver;
	
	@FindBy(xpath="//a[text()='log yourself in']")
	public WebElement link;
	@FindBy(xpath="//input[@name='firstname']")
	public WebElement fname;
	@FindBy(xpath="//input[@name='lastname']")
	public WebElement lname;
	@FindBy(id="country")
	public WebElement country;
	@FindBy(xpath="//input[@name='street_address']")
	public WebElement address;
	@FindBy(xpath="//input[@name='city']")
	public WebElement city;
	@FindBy(xpath="//input[@name='state']")
	public WebElement state;
	@FindBy(xpath="//input[@name='postcode']")
	public WebElement postcode;
	@FindBy(xpath="//input[@name='telephone']")
	public WebElement telephone;
	@FindBy(id="email-address")
	public WebElement email_address;
	@FindBy(id="password-new")
	public WebElement password_new;
	@FindBy(id="password-confirm")
	public WebElement password_confirm;
	@FindBy(xpath="//label[@class='checkboxLabel']")
	public WebElement checkBoxbtn1;
	@FindBy(xpath="//label[text()='TEXT-Only']")
	public WebElement radiobtn1;
	@FindBy(xpath="//input[@value='Submit the Information']")
	public WebElement radiobtn2;
	@FindBy(xpath="//span[@class='cssButton normal_button button  button_continue']")
	public WebElement btn;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public RegistrationPage clickOnLogYourselfInLink() {
		link.click();
		return new RegistrationPage(driver);
	}
	public void registrationForm(String ftName, String ltName, String countryName, String addressZ, String cityZ,
		String stateZ, String postCodeZ, String telephoneZ, String email, String pass, String passC) {
		clickData1(link);
		sendData1(fname, ftName);
		sendData1(lname, ltName);
		sendData1(country, countryName);
		sendData1(address, addressZ);
		sendData1(city, cityZ);
		sendData1(state, stateZ);
		sendData1(postcode, postCodeZ);
		sendData1(telephone, telephoneZ);
		sendData1(email_address, email);
		sendData1(password_new, pass);
		sendData1(password_confirm, passC);
		clickData1(checkBoxbtn1);
		clickData1(radiobtn1);
		clickData1(radiobtn2);
		clickData1(btn);
}
	public void sendData1(WebElement element, String value) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().sendKeys(value).build().perform();
	}

	public void clickData1(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
}