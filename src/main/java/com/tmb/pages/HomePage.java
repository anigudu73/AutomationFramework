package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private final By qa_automation = By.xpath("//span[normalize-space()='QA Automation']");
	private final By practice_automation = By.xpath("//span[normalize-space()='Practice Automation']");
	private final By registration_form = By.xpath("//span[contains(text(),'Demo Site – Registration Form')]");
	private final By alert_popup = By.xpath("//span[contains(text(),'Demo Site – Alert And Popup ')]");
	
	public HomePage clickQaAutomation()
	{
		driver.findElement(qa_automation).click();
		return this;
	}
	
	public HomePage clickPracticeAutomation()
	{
		driver.findElement(practice_automation).click();
		return this;
	}
	
	public RegistrationPage clickRegistrationForm()
	{
		driver.findElement(registration_form).click();
		return new RegistrationPage(driver);
	}
	
	

}
