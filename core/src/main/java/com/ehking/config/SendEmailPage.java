package com.ehking.config;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendEmailPage {

	//收件人
	@FindBy(css = "input.nui-editableAddr-ipt")
	public WebElement receiver;
	//主题
	@FindBy(xpath = "//div[@id='dvContainer']//div[@aria-label='邮件主题输入框，请输入邮件主题']//input")
	public WebElement tittle;
	//正文
	@FindBy(xpath = "/html/body")
	public WebElement text;
	//发送
	@FindBy(xpath ="//div[@aria-label='写信']//span[2]" )
	public WebElement send;
	
	public SendEmailPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
