package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opecart.base.baseclass;

import AppConstants.applicationConstants;

public class loginPageTest extends baseclass{
	@Test(priority=1)
	public void loginPageNavigationTest() {
		loginpage=homepage.NavigateToLoginPage();
		
		
	}
	@Test(priority=2)
	public void LoginPageTitleTest() {
		String loginPageTitle=loginpage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle,applicationConstants.loginpagetitle);
	}
	@Test(priority=3)
	public void AccountLoginTest() {
		Assert.assertTrue(loginpage.doLogin(prop));
	}

}
