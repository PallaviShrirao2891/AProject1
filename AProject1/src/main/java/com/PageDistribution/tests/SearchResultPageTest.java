package com.PageDistribution.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageDistribution.pages.IndexPage;
import com.PageDistribution.pages.SearchResultPage;
import com.TestBases.TestBase;


public class SearchResultPageTest extends TestBase{
	WebDriver driver;
	SearchResultPage searchResultPage;
	IndexPage ip;
	@BeforeMethod
	public void setUp() {
		driver =intialization();
		ip=new IndexPage(driver);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
	  @Test 
	  public void productAvailabilityTest(String productName) {
		  searchResultPage=ip.searchProduct(productName);
		  boolean result=searchResultPage.isProductAvailable();
			Assert.assertTrue(result);
	  }
}
