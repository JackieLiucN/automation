package com.ehking.module.business;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ehking.config.HomePage;
import com.ehking.config.ReceiveEmailPage;

public class ReceiveEmail extends BusinessCase {

	@BeforeMethod
	public void start(){
		openBrowser();
	}
	
	@Test
	public void receiveEmail(ITestContext iTestContext) throws Exception{
		
		HomePage hg = new HomePage(driver);
		ReceiveEmailPage re = new ReceiveEmailPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String tittle = null;
		String addresser = null;
		String recipients = null;
		
		login(pro.getProperty("url"),pro.getProperty("username"),pro.getProperty("password"));
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(hg.receivemail));
		Thread.sleep(10000);
		hg.receivemail.click();
		Thread.sleep(2000);
		tittle = iTestContext.getAttribute("tittle").toString();
		
		re.firstemail.click();
		Thread.sleep(2000);
		String add = stringSubString(re.detail_addresser.getText(),1,1);
		String rec = stringSubString(re.detail_recipients.getText(),1,1);
		addresser = iTestContext.getAttribute("addresser").toString();
		recipients = iTestContext.getAttribute("recipients").toString();
		Assert.assertEquals(re.detail_tittle.getText(),tittle);
		Assert.assertEquals(add,addresser);
		Assert.assertEquals(rec,recipients);
	}
	
	
	@AfterMethod
	public void end(){
		driver.quit();
	}
}
