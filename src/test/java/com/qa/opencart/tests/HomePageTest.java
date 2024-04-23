package com.qa.opencart.tests;

import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.Properties;

import com.qa.opecart.base.baseclass;
import com.qa.opencart.factory.HomePage;
import com.qa.opencart.factory.PlaywrightFactory;

import AppConstants.applicationConstants;

public class HomePageTest extends baseclass {
	
	

@Test
public void homePageTitleTest() {
	String actualtitle=homepage.getHomePageTitle();
	Assert.assertEquals(actualtitle,applicationConstants.PageTitle);

}
@Test
public void pageUrlTest() {
	String url=homepage.urlValidation();
	Assert.assertEquals(url,applicationConstants.Url);
}
@Test
public void searchTest() {
	String productname=homepage.searchProduct("Macbook");
	Assert.assertEquals(productname,"Search - Macbook");
	
}

}
