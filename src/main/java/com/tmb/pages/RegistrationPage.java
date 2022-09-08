package com.tmb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public final class RegistrationPage {

	private WebDriver driver;

	RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
	}

	private final By first_name = By.id("vfb-5");
	private final By last_name = By.id("vfb-7");
	private final By male_radio_btn = By.xpath("//input[@type='radio' and @value='Male']");
	private final By female_radio_btn = By.xpath("//input[@type='radio' and @value='Female']");
	private final By address_field = By.id("vfb-13-address");
	private final By state_province = By.id("vfb-13-country");
	private final By email_address = By.id("vfb-14");
	private final By datepicker = By.id("vfb-18");
	private final By datepicker_title = By.xpath("//div[@class='ui-datepicker-title']");
	private final By next_btn = By.xpath("//a[@title='Next']");
	private final By timing_hr = By.id("vfb-16-hour");
	private final By timing_min = By.id("vfb-16-min");
	private final By course_list = By.xpath("//input[@type='checkbox']");
	private final By verification_msg = By.xpath("//input[@id='vfb-3']/following-sibling::label");
	private final By verification_txtbox = By.id("vfb-3");
	private final By submit_btn = By.xpath("//input[@value='Submit']");


	public RegistrationPage enterFirstName(String firstname)
	{
		driver.findElement(first_name).sendKeys(firstname);
		return this;
	}

	public RegistrationPage enterLastName(String lastname)
	{
		driver.findElement(last_name).sendKeys(lastname);
		return this;
	}

	public RegistrationPage selectGender(String gender)
	{
		if(gender.equalsIgnoreCase("Male"))
			driver.findElement(male_radio_btn).click();
		else
			driver.findElement(female_radio_btn).click();
		return this;
	}

	public RegistrationPage enterAddress(String address)
	{
		driver.findElement(address_field).sendKeys(address);
		return this;
	}

	public RegistrationPage selectState(String state)
	{
		driver.findElement(state_province).sendKeys(state);
		return this;
	}

	public RegistrationPage enterEmail(String email)
	{
		driver.findElement(email_address).sendKeys(email);
		return this;
	}

	public RegistrationPage datePicker()
	{
		driver.findElement(datepicker).click();
		return this;
	}

	public RegistrationPage selectDemoDate(String month,String date)
	{
		for(int i=1;i<=12;i++)
		{
			WebElement wb = driver.findElement(datepicker_title);
			if(wb.getText().contains(month))
			{
				driver.findElement(By.linkText(date)).click();
				break;
			}

			else
				driver.findElement(next_btn).click();
		}
		return this;
	}

	public RegistrationPage scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(timing_hr));
		return this;

	}

	public RegistrationPage selectTiming(String hr, String min)
	{
		Select select = new Select(driver.findElement(timing_hr));
		select.selectByValue(hr);

		select = new Select(driver.findElement(timing_min));
		select.selectByValue(min);

		return this;
	}

	public RegistrationPage selectCourse(List<String> courses)
	{
		List<WebElement> list = driver.findElements(course_list);
		for(String course : courses)
		{
			for(WebElement wb : list)
			{
				if(wb.getAttribute("value").equalsIgnoreCase(course))
				{
					wb.click();
					break;
				}
			}
		}
		return this;
	}

	public RegistrationPage performVerification()
	{
		String verf_text = driver.findElement(verification_msg).getText().replaceAll("[^0-9]", "");
		driver.findElement(verification_txtbox).sendKeys(verf_text);
		System.out.println(verf_text);
		return this;

	}

	public void submit()
	{
		driver.findElement(submit_btn).click();
	}


}
