package com.PageDistribution.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageDistribution.pages.IndexPage;
import com.TestBases.TestBase;
import com.aventstack.extentreports.model.Log;

public class IndexPageTest extends TestBase {
	WebDriver driver;
	IndexPage ip;

	@BeforeMethod
	public void setUp() {
		driver =intialization();
		ip = new IndexPage(driver);
	}
	
	
	@AfterMethod()
	public void tearDown() {
	driver.quit();
	}
	
	@Test
	public void verifyLogo(){
		ip= new IndexPage(driver);
		boolean result=ip.validateLogo();
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void verifyTitle() {
		
		String actTitle=ip.getTitle();
		Assert.assertEquals(actTitle, "Zen Cart!, The Art of E-commerce");
		
	}

	
}
