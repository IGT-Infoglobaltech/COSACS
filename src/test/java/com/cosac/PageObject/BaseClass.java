package com.cosac.PageObject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cosac.Locators.Xpath;
import com.cosac.Utilities.ReadConfig;

public class BaseClass
{
	ReadConfig readconfig=new ReadConfig();
	public String url=readconfig.getURL();
	public String userName=readconfig.getUsername();
	public String passWord=readconfig.getPassword();
	
	public static WebDriver driver;
	protected Logger log;
	
	
	
	@BeforeClass
	@Parameters("browser")
	public void launchChrome(String brouse) throws InterruptedException, IOException
	{
		log=Logger.getLogger("cosac");
		PropertyConfigurator.configure("log4j.properties");
		if(brouse.equalsIgnoreCase("chrome"))
		{
		
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver=new ChromeDriver();
		}
		
		else if(brouse.equalsIgnoreCase("firefox"))
		{
		
		driver=new FirefoxDriver();

		}
		
		else if(brouse.equalsIgnoreCase("ie"))
		{
        
		System.setProperty("webdriver.ie.driver",readconfig.getIePath());
		driver=new InternetExplorerDriver();
			
			
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(Xpath.LoginPage.userName)).sendKeys(userName);
	    log.info("User Entered UserName");
		driver.findElement(By.xpath(Xpath.LoginPage.passWord)).sendKeys(passWord);
		log.info("User Entered PassWord");
		driver.findElement(By.xpath(Xpath.LoginPage.logIn)).click();
		log.info("User Clicked on Login");
		
		
	}

	@AfterClass 
	public void close() 
	{ 
		driver.quit(); 
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	 
}

