package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtils {
	FileInputStream fis = null;
	public static Logger log = Logger.getLogger(PropertiesUtils.class);

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
}
