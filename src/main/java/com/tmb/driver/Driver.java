package com.tmb.driver;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import static com.tmb.driver.DriverManager.*;

import com.tmb.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	private Driver()
	{

	}



	public static void initDriver(String browser) throws Exception
	{

		if(Objects.isNull(getDriver()))
		{
			switch (browser)
			{
			case "Chrome" :
			{
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("incognito","start-maximized");
				setDriver(new ChromeDriver(options));
				getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				getDriver().get(ReadPropertyFile.readProperty("url"));
				break;

			}
			case "Firefox" :
			{
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("incognito","start-maximized");
				setDriver(new FirefoxDriver(options));
				getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				getDriver().get(ReadPropertyFile.readProperty("url"));
				break;
			}
			case "Edge" :
			{

				WebDriverManager.edgedriver().setup(); 

				setDriver(new EdgeDriver());
				getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				getDriver().manage().window().maximize();
				getDriver().get(ReadPropertyFile.readProperty("url"));
				break;
			}
			default :
			{
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("incognito","start-maximized");
				setDriver(new ChromeDriver(options));
				getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				getDriver().get(ReadPropertyFile.readProperty("url"));
				break;
			}
			}

		}
	}

	public static void quitDriver()
	{
		if(Objects.nonNull(getDriver())) 
		{
			getDriver().quit();
			unload();
		}
	}

}
