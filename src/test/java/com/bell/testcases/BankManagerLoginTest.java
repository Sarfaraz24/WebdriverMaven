package com.bell.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bell.base.TestBase;

public class BankManagerLoginTest extends TestBase{
@Test
public void bankManagerLoginTest() throws InterruptedException, IOException {
	verifyEquals("abc","xyz");
	Thread.sleep(2000);
	log.debug("inside login test");
	click("bmlBtn_CSS");
	//driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
	Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))),"Login not successful");
	//if login wont work then "Login not successful" message comes
	log.debug("inside successfully executed");
	//Assert.fail("Login not successful");
	System.out.println("This is BankmanagerLoginTest run successfully");
}}