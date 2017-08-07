package com.ehking.core;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ehking.util.*;

public class FrameCase {
	public static WebDriver driver;
	public static final String CONFIG = "src/main/resource/parameter.properties";
	public static Properties pro = com.ehking.util.LoadParameter.getProperties(CONFIG);
	
	public WebDriver createWebDriver(String browser){
		
		WebDriver dr = null;		
		
		if("firefox".equals(browser)){
//			System.setProperty("ebdriver.firefox.bin", pro.getProperty("firefox.path"));
			System.setProperty("webdriver.gecko.driver", pro.getProperty("firefox.path"));
			dr = new FirefoxDriver();
		}
		return dr;
	}
	
	public static void main (String[] args) throws Exception{
		FrameCase fc = new FrameCase();
		fc.createWebDriver("firefox");
	}
}
