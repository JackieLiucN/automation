package com.ehking.module.business;

import org.junit.BeforeClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import com.ehking.config.LoginPage;
import com.ehking.core.FrameCase;

public class BusinessCase extends FrameCase{
	protected FrameCase fc = new FrameCase();
	protected ITestContext iTestContext;
	
	@BeforeClass
	public void setUpITestContext(ITestContext iTestContext) {
		this.iTestContext = iTestContext;
	}
	//打开浏览器
	public void openBrowser(){
		driver = fc.createWebDriver(pro.getProperty("browser"));
//		driver.manage().window().maximize();
	}
	
	//登录126
	public void login(String url,String username,String password) throws Exception{
		
		LoginPage lp = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.get(url);
		wait.until(ExpectedConditions.elementToBeClickable(lp.loginbyemail));
		lp.loginbyemail.click();
		driver.switchTo().frame("x-URS-iframe");
		Thread.sleep(2000);
		lp.email.clear();
		lp.email.sendKeys(username);
		lp.password.clear();
		lp.password.sendKeys(password);
		lp.dologin.click();
		
		
//		wait.until(ExpectedConditions.titleContains("网易邮箱"));
	}
	
	//截取字符串
	public String stringSubString(String st,int start,int end){
		
		int endIndex =st.length()-end;
		int beginIndex = start;
		
		st = st.substring(beginIndex, endIndex);
		
		return st;
	}
	
	public static void main(String args[]){
		BusinessCase bc = new BusinessCase();
//		bc.openBrowser();
		String test = bc.stringSubString("<jackie_8902@126.com>" , 1, 1);
		System.out.println(test);
	}
}
