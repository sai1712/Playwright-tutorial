package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
Playwright playwright;
Browser browser;
BrowserContext bc;
Properties prop;
Page page;
private static ThreadLocal<Playwright> tlPlaywright=new ThreadLocal<>();
private static ThreadLocal<BrowserContext> tlBrowserContext=new ThreadLocal<>();
private static ThreadLocal<Browser> tlBrowser=new ThreadLocal<>();
private static ThreadLocal<Page> tlPage=new ThreadLocal<>();
public static Playwright gettlPlaywright() {
	return tlPlaywright.get();
}
public static BrowserContext gettlBrowserContext() {
	return tlBrowserContext.get();
}
public static Browser getBrowser() {
	return tlBrowser.get();
}
public static Page gettlPage() {
	return tlPage.get();
}

	public Page initBrowser(Properties prop) {
		tlPlaywright.set(Playwright.create());
		String browserName=prop.getProperty("browser");
		switch(browserName.toLowerCase()){
			case "chromium":
				tlBrowser.set(gettlPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
				break;
			case "firefox":
				tlBrowser.set(gettlPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
				break;
			case "safari":
				tlBrowser.set(gettlPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
				break;
			case "chrome":
				tlBrowser.set(gettlPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false)));
			default:
				System.out.println("please pass the correct browser name...");
				}
		tlBrowserContext.set(getBrowser().newContext());
		tlPage.set(gettlBrowserContext().newPage());
		
		gettlPage().navigate(prop.getProperty("url"));
		return gettlPage();
	}
	public Properties initproperties() {
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\saihr\\OneDrive\\Desktop\\maven project testing\\PlaywrightTutorial\\src\\test\\resource\\config\\config.properties");
			prop=new Properties();
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
		
	}
	public static String takeScreenshot() {
		String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		gettlPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		return path;
	}
	
}
