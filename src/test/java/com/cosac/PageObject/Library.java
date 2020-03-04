package com.cosac.PageObject;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cosac.Locators.Xpath;

public class Library extends BaseClass
{
	public static class Interaction
	{
	//To Capture Screenshot
	protected static Logger log;
	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	// Send Data in Text Box by Xpath
	public static void setTextBoxByXpath(String xpath, String data) throws IOException
	{
		try
		{
		driver.findElement(By.xpath(xpath)).sendKeys(data);
		}
		catch (Exception e) 
		{
			captureScreen(driver, "setTextBoxByXpath");
            Assert.assertFalse(false);
            log.info("User not able to send data in Text Box 'Test Failed'");
		}
	}
	// Send Data in Text Box by Name
	public static void setTextBoxByName(String Name, String data) throws IOException
	{
		try
		{
		driver.findElement(By.name(Name)).sendKeys(data);
		}
		catch (Exception e) 
		{
			captureScreen(driver, "setTextBoxByName");
            Assert.assertFalse(false);
            log.info("User not able to send data in Text Box 'Test Failed'");
		}
	}
	
	// Send Data in Text Box by ID
		public static void setTextBoxByID(String id, String data) throws IOException
		{
			try
			{
			driver.findElement(By.id(id)).sendKeys(data);
			}
			catch (Exception e) 
			{
				captureScreen(driver, "setTextBoxByID");
	            Assert.assertFalse(false);
	            log.info("User not able to send data in Text Box 'Test Failed'");
			}
		}
	
	// Navigate Element
	public static void moveToElement(String xpath) throws IOException
	{
		try
		{
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath(xpath));
		act.moveToElement(ele).build().perform();
		}
		catch (Exception e) 
		{
			captureScreen(driver, "moveToElement");
            Assert.assertFalse(false);
            log.info("User not able to navigate to element 'Test Failed'");
		}
	}
	
	// Click to Element
	public static void click(String xpath) throws IOException
	{   
		try {
			WebElement ele=driver.findElement(By.xpath(xpath));
			ele.click();
		    } 
		catch (Exception e) 
		{
			captureScreen(driver, "loginTest");
            Assert.assertFalse(false);
            log.info("User not able to Click to element 'Test Failed'");
		}
	}
	
	//Search and Select element from Drop down 
	public static void selectAndSerachEle(String xpath1,String xpath2, String xpath3, String eleText) throws IOException
	{
		try
		{
		driver.findElement(By.xpath(xpath1)).click();
		driver.findElement(By.xpath(xpath2)).sendKeys(eleText);
		driver.findElement(By.xpath(xpath3)).click();
		}
		catch (Exception e) 
		{
			captureScreen(driver, "loginTest");
            Assert.assertFalse(false);
            log.info("User not able to Search and Select element 'Test Failed'");
		}
	}
	
	//Select Element by Text
	public static void selectEleByText(String xpath, String eleText) throws IOException
	{
		try
		{
		driver.findElement(By.xpath(xpath)).click();
		WebElement selectEle=driver.findElement(By.xpath(xpath));
		Select sel=new Select(selectEle);
		sel.selectByVisibleText(eleText);
		}
		catch (Exception e) 
		{
			captureScreen(driver, "moveToElement");
            Assert.assertFalse(false);
            log.info("User not able to Select element 'Test Failed'");
		}
	}
	
	//Select Element by Index
	public static void selectEleByIndex(String xpath, int IndText) throws IOException
	{
		try
		{
		WebElement selectEle=driver.findElement(By.xpath(xpath));
		Select sel=new Select(selectEle);
		sel.selectByIndex(IndText);
		}
		catch (Exception e) 
		{
			captureScreen(driver, "moveToElement");
            Assert.assertFalse(false);
            log.info("User not able to Select element 'Test Failed'");
		}
	}
	
	//Select Element by Value
	public static void selectEleByValue(String xpath, String ValText) throws IOException
	{
		try
		{
		WebElement selectEle=driver.findElement(By.xpath(xpath));
		Select sel=new Select(selectEle);
		sel.selectByValue(ValText);
		}
		catch (Exception e) 
		{
			captureScreen(driver, "moveToElement");
            Assert.assertFalse(false);
            log.info("User not able to Select element 'Test Failed'");
		}
	}

	//User defined wait
     public static boolean userDefinedWait(WebElement element) throws InterruptedException {
		int maxWait=1000;
		int intervalWait= 2;
		int counter=0;
		while(counter>maxWait) {
			Thread.sleep(intervalWait*1000);
			counter+=intervalWait;
			System.out.println("counter....... "+counter);
			try {
				if(element.isDisplayed()) {
					System.out.println("Element found...."+element.getText());
					return true;
				}
			}catch(NoSuchElementException noelememt)
			{
				noelememt.getMessage();
			}
			
		}
		return false;
	}
   //User defined wait
	public static boolean userWait() throws InterruptedException {
		int maxWait=2000;
		int intervalWait= 2;
		int counter=0;
		while(counter>maxWait) {
			Thread.sleep(intervalWait*20000);
			counter+=intervalWait;
			//System.out.println("counter....... "+counter);
		}
		return true;	
	}
	
	public static void print(String printText) throws IOException
	{
		System.out.println(printText);
	}
	
	}
}



