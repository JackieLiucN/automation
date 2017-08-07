package com.ehking.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReceiveEmailPage{

	//第一封邮件
	@FindBy(xpath = "//div[@class='tv0']/div[2]/div[1]/div[2]/span")
	public WebElement firstemail;
	//详细_标题
	@FindBy(xpath = "//div[@class='frame-main-cont-body nui-scroll ']//h1")
	public WebElement detail_tittle;
	//详细_发件人
	@FindBy(xpath = "//li[@class='ig0 ew0']//span[2]")
	public WebElement detail_addresser;
	//详细_收件人
	@FindBy(xpath = "//li[@class='ig0 fD0']//span[2]")
	public WebElement detail_recipients;

	
	public ReceiveEmailPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
