package com.tmb.tests;

import static com.tmb.driver.DriverManager.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class NextGenRegistrationTest extends BaseClass {

	private NextGenRegistrationTest()
	{

	}

	@Test(priority=1,enabled=true)
	public void login() 
	{

		WebElement wb = getDriver().findElement(By.xpath("//span[normalize-space()='QA Automation']"));
		Actions action = new Actions(getDriver());
		action.moveToElement(wb).click().perform();
		wb.click();

		wb = getDriver().findElement(By.xpath("//span[normalize-space()='Practice Automation']"));
		action.moveToElement(wb).click().perform();

		wb = getDriver().findElement(By.xpath("//span[contains(text(),'Demo Site – Registration Form')]"));
		action.moveToElement(wb).click().perform();


	}

	@Test(priority=2)
	public void registration() throws InterruptedException 
	{

		login();
		getDriver().findElement(By.id("vfb-5")).sendKeys("Rajesh");
		getDriver().findElement(By.id("vfb-7")).sendKeys("Kumar");
		getDriver().findElement(By.xpath("//input[@value='Male']")).click();
		getDriver().findElement(By.id("vfb-13-address")).sendKeys("Plot 564 , Blossom Green");
		getDriver().findElement(By.id("vfb-13-city")).sendKeys("Indore");
		getDriver().findElement(By.id("vfb-13-zip")).sendKeys("597009");
		Select select = new Select(getDriver().findElement(By.id("vfb-13-country")));
		select.selectByValue("India");
		getDriver().findElement(By.id("vfb-14")).sendKeys("abc22@gmail.com");
		getDriver().findElement(By.id("vfb-18")).click();

		for(int i=1;i<=12;i++)
		{
			WebElement wb = getDriver().findElement(By.xpath("//div[@class='ui-datepicker-title']"));
			if(wb.getText().contains("September"))
			{
				getDriver().findElement(By.linkText("23")).click();
				break;
			}

			else
				getDriver().findElement(By.xpath("//a[@title='Next']")).click();
		}


		WebElement wb = getDriver().findElement(By.id("vfb-16-hour"));
		JavascriptExecutor js =  (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].scrollIntoView();", wb);
		select = new Select(wb);
		select.selectByValue("08");

		select = new Select(getDriver().findElement(By.id("vfb-16-min")));
		select.selectByValue("30");

		List<WebElement> list = getDriver().findElements(By.xpath("//input[@type='checkbox']"));

		for(WebElement option : list)
		{
			System.out.println(option.getAttribute("value"));
			if(option.getAttribute("value").equalsIgnoreCase("TestNG")||option.getAttribute("value").equalsIgnoreCase("Selenium WebDriver"))
			{
				option.click();

			}
		}

		String verf = getDriver().findElement(By.xpath("//input[@id='vfb-3']/following-sibling::label")).getText();


		String input = verf.replaceAll("[^0-9]", "");

		getDriver().findElement(By.id("vfb-3")).sendKeys(input);
		getDriver().findElement(By.xpath("//input[@value=\"Submit\"]")).click();
		String message = getDriver().findElement(By.xpath("(//div[@class='elementor-shortcode'])[1]")).getText();
		System.out.println(message);
		Assert.assertTrue(message.contains("Registration Form is Successfully Submitted"),"Registration Failed");




	}



}
