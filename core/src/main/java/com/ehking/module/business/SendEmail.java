package com.ehking.module.business;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ehking.config.HomePage;
import com.ehking.config.SendEmailPage;

public class SendEmail extends BusinessCase {
	
	@BeforeMethod
	public void start(){
		openBrowser();
	}
	
	@Test
	public void sendEmail(ITestContext iTestContext) throws Exception {
		HomePage hg = new HomePage(driver);
		SendEmailPage sep = new SendEmailPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,60);
		
			login(pro.getProperty("url"),pro.getProperty("username"),pro.getProperty("password"));
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.visibilityOf(hg.sendemail));
			hg.sendemail.click();
			sep.receiver.sendKeys(pro.getProperty("recipients"));
			sep.tittle.sendKeys(pro.getProperty("tittle"));
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));
			sep.text.sendKeys("email sent by automation");
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			sep.send.click();
			//
			iTestContext.setAttribute("tittle",pro.getProperty("tittle"));
			iTestContext.setAttribute("addresser",pro.getProperty("username")+"@126.com");
			iTestContext.setAttribute("recipients",pro.getProperty("recipients"));
	}
	
	@AfterMethod
	public void end(){
		driver.quit();
	}
	
	
}
