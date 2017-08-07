package com.ehking.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//邮箱登录
	@FindBy(xpath = "//*[@id=\"lbNormal\"]")
	public WebElement loginbyemail;
	//email名称
	@FindBy(name = "email")
	public WebElement email;
	//密码
	@FindBy(name = "password")
	public WebElement password;
	//登录
	@FindBy(id = "dologin")
	public WebElement dologin;
	
	//构造方法
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
