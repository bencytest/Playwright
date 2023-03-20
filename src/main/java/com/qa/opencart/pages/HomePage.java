package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	//1. String Locators 
	private String search = "input[name ='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	
	//2. Page Constructor
	
	public HomePage(Page page) {
		this.page = page;
		
		
	}
	
	//page actions
	
	public String getHomePageTitle()
	{
		return page.title();
		
	}
	public String getHomePageUrl()
	{
		return page.url();
	}
	public String doSearch(String productName)
	{
		page.fill(search, productName);
		page.click(searchIcon);
		String header =page.textContent(searchPageHeader);
		System.out.println("Search Header is"+searchPageHeader);
		return header;
	}

}
