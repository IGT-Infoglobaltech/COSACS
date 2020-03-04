package com.cosac.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosac.Locators.Name;
import com.cosac.Locators.Xpath;
import com.cosac.PageObject.BaseClass;
import com.cosac.PageObject.Library;

public class COS10_SparePartsProductCreation extends BaseClass
{
	String locationId="123";
	String SalesSystemId="6789";
	String name="Agra";
	String ExpectedSparePartLabel="Create Spare Part";
	  
	@Test
	
	public void location() throws IOException {
		try {
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.LocationCreation.merchandising);
			Library.Interaction.print("User Clicked on Merchandising");
			Library.Interaction.userWait();
			Library.Interaction.moveToElement(Xpath.LocationCreation.create);
			Library.Interaction.print("User Clicked on Create");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SparePartsCreation.SparePart);
			Library.Interaction.print("User Clicked on Spare Part");
			String createSparePartLabel = driver.findElement(By.xpath(Xpath.SparePartsCreation.verifySparePartpage)).getText();
			Assert.assertEquals(createSparePartLabel,ExpectedSparePartLabel);
            log.info("User are in Create Spare Part Page");
			} 
		catch (Exception e) {
			captureScreen(driver, "location");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
     }

	@Test(dependsOnMethods = "location")
	public void createLocationForm() throws IOException {
		try {
		
		} 
		catch (Exception e) {
			captureScreen(driver, "createLocationForm");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
    }

}
