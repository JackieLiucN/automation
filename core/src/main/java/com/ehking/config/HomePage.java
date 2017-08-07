package com.ehking.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	//收信
	@FindBy(xpath = "//nav[@role='navigation']//li[@class='js-component-component ra0 nb0']/span[2]")
	public WebElement receivemail;
	//写信
	@FindBy(xpath = "//nav[@role='navigation']//li[@class='js-component-component ra0 mD0']/span[2]")
	public WebElement sendemail;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
