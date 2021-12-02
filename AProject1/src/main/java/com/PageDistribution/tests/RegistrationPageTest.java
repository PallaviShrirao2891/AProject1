package com.PageDistribution.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageDistribution.pages.RegistrationPage;
import com.TestBases.TestBase;
import com.utility.DataProviderUtils;

public class RegistrationPageTest extends TestBase {
	RegistrationPage rp;
	String sheetName = "registration";
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = intialization();
		rp = new RegistrationPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getRegistrationPageData() {
		Object data[][] = DataProviderUtils.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getRegistrationPageData")
	public void registrationPage(String ftName, String ltName, String countryName, String addressZ, String cityZ,
			String stateZ, String postCodeZ, String telephoneZ, String email, String pass, String passC) {
		rp.registrationForm(ftName, ltName, countryName, addressZ, cityZ, stateZ, postCodeZ, telephoneZ, email, pass,
				passC);
	}
}
