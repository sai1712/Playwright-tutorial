package com.qa.opencart.factory;

import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;

public class LoginPage {
private Page page;
private String emailid="#input-email";
private String password="#input-password";
private String loginbtn="//input[@type='submit']";
private String forgotpwlink="//div[@class='form-group']//a";
private String logoutlink="//div[@class='list-group']//a[text()='Logout']";
public LoginPage(Page page) {
	this.page=page;
}
public String getLoginPageTitle() {
	String loginPageTitle=page.title();
	return loginPageTitle;
	}
public boolean forgotPasswordLink() {
	return page.locator(forgotpwlink).isVisible();
	
}
public boolean doLogin(Properties prop) {
	page.locator(emailid).fill(prop.getProperty("email").trim());
	page.locator(password).fill(prop.getProperty("password").trim());
	ScreenshotOptions screenshotoptions=new ScreenshotOptions();
	page.screenshot(screenshotoptions.setPath(Paths.get("./screenshot.png")));
	page.click(loginbtn);
	if(page.isVisible(logoutlink)) {
		System.out.println("user is logged in successfully");
		return true;
	}
	return false;
}
}
