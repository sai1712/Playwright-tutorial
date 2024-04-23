package com.qa.opencart.factory;

import com.microsoft.playwright.Page;

public class HomePage {
private Page page;
	private String searchbox="//input[@name='search']";
	private String searchicon="div#search button";
	private String searchPageHeader="div#content h1";
	private String Myaccountdropdown="//a[@title='My Account']";
	private String loginlink="//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'Login')]";
	public HomePage( Page page) {
		this.page=page;
	}
	
	public String urlValidation() {
		String HomePageurl=page.url();
		return HomePageurl;
	}
	public String getHomePageTitle(){
		return page.title();
	}
	public String searchProduct(String product) {
		page.fill(searchbox,product);
		page.click(searchicon);
		String searchedProduct=page.textContent(searchPageHeader);
		return searchedProduct;
	}
	public LoginPage NavigateToLoginPage() {
		page.click(Myaccountdropdown);
		page.click(loginlink);
		return new LoginPage(page);
	}
	
	
	
	
	
}
