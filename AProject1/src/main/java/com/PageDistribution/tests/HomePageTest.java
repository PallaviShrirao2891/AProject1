package com.PageDistribution.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageDistribution.pages.HomePage;
import com.PageDistribution.pages.IndexPage;
import com.PageDistribution.pages.LoginPage;
import com.PageDistribution.pages.NewProductPage;
import com.PageDistribution.pages.RegistrationPage;
import com.TestBases.TestBase;

public class HomePageTest extends TestBase{
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	RegistrationPage rp;
	NewProductPage npp;
	IndexPage ip;
	@BeforeMethod
	public void setUp() {
		driver =intialization();
		ip=new IndexPage(driver);
		lp=new LoginPage(driver);
		ip.clickOnLogYourselfInLink();
		hp=new HomePage(driver);
		lp.login();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
	 @Test 
	  public void navigateToNewProductPage()
	  {		
		  npp=hp.clickOnNewestAdditionsLink(); 
		  }
	 @Test 
	  public void checkURL()
	  { 
		  String actualURL=driver.getCurrentUrl(); 
		  
		  String expectedURL="http://ingecnotechnologies.com/other/zenith/index.php?main_page=index";
	  
	  Assert.assertEquals(actualURL, expectedURL); }
}
