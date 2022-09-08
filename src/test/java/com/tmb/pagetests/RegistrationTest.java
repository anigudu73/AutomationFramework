package com.tmb.pagetests;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;
import com.tmb.pages.HomePage;
import com.tmb.tests.BaseClass;

public final class RegistrationTest extends BaseClass {

	private RegistrationTest()
	{

	}

	@Test(priority=1)
	public void registrationTest() throws InterruptedException
	{
		//HomePage page = new HomePage(DriverManager.getDriver());
		//RegistrationPage rpage = page.clickQaAutomation().clickPracticeAutomation().clickRegistrationForm();

		new HomePage(DriverManager.getDriver()).clickQaAutomation().clickPracticeAutomation().clickRegistrationForm()
		.enterFirstName("Anish").enterLastName("Kumar")
		.selectGender("Male")
		.enterAddress("Bari Cooperative 421")
		.selectState("India")
		.enterEmail("xyz123@gmail.com")
		.datePicker()
		.selectDemoDate("September", "25")
		.scrollDown()
		.selectTiming("09", "30")
		.selectCourse(Arrays.asList("UFT","Others","TestNG"))
		.performVerification()
		.submit();


		Thread.sleep(4000);
	}

}
