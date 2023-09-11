package stepDefinations;

import java.util.Properties;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObject.AddCategoryPage;
import pageObject.AddManufacturerPage;
import pageObject.AddProductPage;
import pageObject.AddcustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCategoryPage;
import pageObject.SearchCustomerPage;
import pageObject.SearchManufacturerPage;
import pageObject.SearchProductPage;


public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddcustomerPage addCust;
	public SearchCustomerPage searchCust;
	public AddProductPage addprod;
	public SearchProductPage searchprod;
	public AddCategoryPage addcatg;
	public SearchCategoryPage searchcatg;
	public AddManufacturerPage addmanufac;
	public SearchManufacturerPage searchmanufac;
	public static Logger logger;
	public Properties configProp;
	
	// Created for generating random String for unique email
	public static String randomString() {
		String generatedstring1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedstring1);
	}

}
