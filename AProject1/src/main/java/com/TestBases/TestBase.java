package com.TestBases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.PageDistribution.pages.LoginPage;
import com.utility.PropertiesUtils;
import com.utility.WaitUtility;
import com.utility.WebEventListener;

public class TestBase {
	public WaitUtility wu = null;
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log = Logger.getLogger(TestBase.class);
	FileInputStream fis = null;
	public String readproperty(String key) {
		log.info("Reading a Property From Property File");
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("value found in the property file for the "+key);
		return prop.getProperty(key);
		
	}
	public WebDriver intialization() {
		log.info("Launching an Application..");
		wu = new WaitUtility();
		if (readproperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readproperty("chromeDriverFilePath"));
			driver = new ChromeDriver();
			log.info("Chrome Browser initialized...");
			driver.get(readproperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(readproperty("pageload")), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(readproperty("pageload")), TimeUnit.SECONDS);
			//return driver;
		} else {
			System.setProperty("webdriver.gecko.driver", readproperty("geckoDriverFilePath"));
			driver = new FirefoxDriver();
			log.info("Firefox Browser initialized...");
			driver.get(readproperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(readproperty("pageload")), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(readproperty("pageload")), TimeUnit.SECONDS);
			//return driver;
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		return driver;
	}

	public LoginPage loadLoginPage() {
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	public boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}
	public void clickOnRadio(List<WebElement> radiooptions, String text)
	{
		for(WebElement radiooption : radiooptions)
		{
			if(radiooption.getAttribute("value").equalsIgnoreCase(text))
			{
				radiooption.click();
				break;
			}
		}
	}
}
