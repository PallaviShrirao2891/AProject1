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

public class LoginPageTest extends TestBase{
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
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
	  @Test 
	  public void navigateToHomePage()
	  {		
		  hp=lp.login(); }
	 
	  @Test 
	  public void checkURL()
	  { 
		  String actualURL=driver.getCurrentUrl(); 
		  
		  String expectedURL="http://ingecnotechnologies.com/other/zenith/index.php?main_page=login";
	  
	  Assert.assertEquals(actualURL, expectedURL); }
	 
	
	  @Test 
	  public void newProducts() {
		  lp.login();
	  npp=lp.clickOnNewestAdditionsLink(); 
	  }
	 }
