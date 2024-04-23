package com.qa.opecart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.HomePage;
import com.qa.opencart.factory.LoginPage;
import com.qa.opencart.factory.PlaywrightFactory;

public class baseclass {
	PlaywrightFactory pf;
	Page page;
	protected HomePage homepage;
	protected Properties prop;
	protected LoginPage loginpage;
	@BeforeTest
	public void setup() {
		pf= new PlaywrightFactory();
		prop=pf.initproperties();
		page=pf.initBrowser(prop);
		homepage=new HomePage(page);
		
	}
	@AfterTest
	public void teardown(){
		page.context().close();
		
	}
}
