package com.cosac.Locators;

public class Xpath 
{
	public static class LoginPage
	{
		public static String userName="//input[@name='username']";
		public static String passWord="//input[@name='password']";
		public static String logIn="//button[contains(text(),'Log In')]";
	}
	public static class LocationCreation
	{
		public static String merchandising="//a[contains(text(),'Merchandising')]/..";
		public static String create="//li[@class='ng-scope dropdown-submenu']//a[contains(text(),'Create')]";
		public static String location="//a[contains(text(),'Combo')]//../..//a[contains(text(),'Location')]";
		public static String locationID="//label[contains(text(),'Location Id')]/..//input[@class='form-control ng-pristine ng-invalid ng-invalid-required']";
		public static String verifyLocationPage="//h2[contains(text(),'Create Location')]";
		public static String fascia="//list[@name='fascia']//div[@class='list-arrow']";
		public static String fasciaSerch="//list[@name='fascia']//input[@class='ng-pristine ng-valid']";
		public static String fasciaName="//div[contains(text(),'Courts')][position()=1]";
		public static String StoreType="//list[@name='storeType']//div[@class='list-arrow']";
		public static String StoreTypeSearch="//list[@name='storeType']//input[@class='ng-pristine ng-valid']";
		public static String StoteName="//div[contains(text(),'All Courts')][position()=1]";
		
	}
	
	public static class SparePartsCreation
	{
		public static String SparePart="//a[contains(@href,'/Cosacs/Merchandising/SparePart')]";
		public static String verifySparePartpage="//div[@id='center']//h2";
		public static String logIn="//button[contains(text(),'Log In')]";
	}
	
}
