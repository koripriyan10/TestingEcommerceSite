package com.WebSiteTesting;

import org.testng.annotations.Test;

import com.Utility.Library;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import com.Pages.WebElementLocators;

public class NewTest extends Library {

	@BeforeSuite
	public void beforeSuite() throws IOException {
		ReadPropertiesFile();
		System.setProperty("webdriver.gecko.driver",
				"D:\\JavaWorkSpace\\Selenium_Projects\\src\\test\\resources\\firefoxdriver-v33\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void RegisterScreenTest() throws InterruptedException {
		
		driver.navigate().to("https://demo.guru99.com/test/newtours");
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(WebElementLocators.Registerlink).click();
		driver.findElement(WebElementLocators.firstName).sendKeys(objProperties.getProperty("firstname"));
		driver.findElement(WebElementLocators.lastName).sendKeys(objProperties.getProperty("lastName"));
		driver.findElement(WebElementLocators.phone).sendKeys(objProperties.getProperty("phone"));
		driver.findElement(WebElementLocators.userName).sendKeys(objProperties.getProperty("userName"));
		driver.findElement(WebElementLocators.address1).sendKeys(objProperties.getProperty("address1"));
		driver.findElement(WebElementLocators.city).sendKeys(objProperties.getProperty("city"));
		driver.findElement(WebElementLocators.state).sendKeys(objProperties.getProperty("state"));
		driver.findElement(WebElementLocators.postalCode).sendKeys(objProperties.getProperty("postalCode"));
		WebElement Country = driver.findElement(WebElementLocators.country);		
		Select SelCountry = new Select(Country);
		SelCountry.selectByValue(objProperties.getProperty("country"));	
		Thread.sleep(2000);
		driver.findElement(WebElementLocators.email).sendKeys(objProperties.getProperty("email"));		
		driver.findElement(WebElementLocators.password).sendKeys(objProperties.getProperty("password"));
		driver.findElement(WebElementLocators.confirmPassword).sendKeys(objProperties.getProperty("confirmPassword"));
		driver.findElement(WebElementLocators.Submit).click();		
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Beginning Test");
	}

}
