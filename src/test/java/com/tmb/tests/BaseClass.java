package com.tmb.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.tmb.driver.Driver;

public class BaseClass {

	//Creating a private constructor to prevent it's object creation outside package
	protected BaseClass()
	{

	}

	//static String browser;
	
	ThreadLocal<String> browser = new ThreadLocal<String>();
	


	/*@Parameters("browsername")
	@BeforeTest
	protected void browserType(String browsername)
	{
		//browser=browsername;
		browser.set(browsername);
	}
	*/

	@Parameters("browsername")
	@BeforeMethod
	protected void setup(String browsername) throws Exception
	{
		browser.set(browsername);
		Driver.initDriver(browser.get());
	}

	@AfterMethod
	protected void teardown()
	{
		Driver.quitDriver();
	}

}
