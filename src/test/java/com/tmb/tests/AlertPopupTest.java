package com.tmb.tests;

import static com.tmb.driver.DriverManager.getDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public final class AlertPopupTest extends BaseClass {
	private AlertPopupTest()
	{
		
	}

	@Test(priority=1,enabled=false)
	public void login() 
	{

		WebElement wb = getDriver().findElement(By.xpath("//span[normalize-space()='QA Automation']"));
		Actions action = new Actions(getDriver());
		action.moveToElement(wb).click().perform();
		wb.click();

		wb = getDriver().findElement(By.xpath("//span[normalize-space()='Practice Automation']"));
		action.moveToElement(wb).click().perform();

		wb = getDriver().findElement(By.xpath("//span[contains(text(),'Demo Site – Alert and Popup')]"));
		action.moveToElement(wb).click().perform();


	}
	
	@Test(priority=2,enabled=true)
	public void alertBox() throws InterruptedException
	{
		login();
		getDriver().findElement(By.cssSelector("button[name='alertbox']")).click();
		getDriver().switchTo().alert().accept();
	}
	
	@Test(priority=3,enabled=true)
	public void confirmAlertBox()
	{
		login();
		getDriver().findElement(By.cssSelector("button[name='confirmalertbox']")).click();
		//getDriver().switchTo().alert().accept();
		getDriver().switchTo().alert().dismiss();
		System.out.println(getDriver().findElement(By.id("demo")).getText());
	}
	
	@Test(priority=4,enabled=true)
	public void promptAlertBox() throws InterruptedException
	{
		login();
		getDriver().findElement(By.xpath("//button[contains(text(),'Prompt Alert Box')]")).click();	
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys("Yes");
		alert.accept();
		System.out.println(getDriver().findElement(By.id("demoone")).getText());
	}
}
