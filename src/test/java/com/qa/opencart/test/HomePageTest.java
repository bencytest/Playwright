package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.pages.HomePage;
import com.qa.opencartfactory.PlaywrightFactory;

public class HomePageTest {
	PlaywrightFactory pf;
	Page page;
	HomePage homepage;
	@BeforeTest
	
	public void setUp()
	{
	pf = new PlaywrightFactory();
	page = pf.initBrowser("chromium");
	homepage = new HomePage(page);
	
	}
	@Test
	
	public void homePageTitleTest()
	{
		String actualTitle = homepage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Your Store");
		
	}
	@Test
	public void homepageUrlTest()
	{
		String actualURL = homepage.getHomePageUrl();
		Assert.assertEquals(actualURL, "https://naveenautomationlabs.com/opencart/");
		
	}
	
	@Test
	public void searchTest()
	{
        String actualsearchHeader=homepage.doSearch("Macbook");
        Assert.assertEquals(actualsearchHeader, "Search - Macbook");
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		page.context().browser().close();
		
	}

}
