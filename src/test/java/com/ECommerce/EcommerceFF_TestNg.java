package com.ECommerce;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Pages.DeliveryInformationPage;
import com.Pages.LoginPage;
import com.Pages.ProdDescriptionPage;
import com.Pages.ProductSearchPage;
import com.Utility.Library;

public class EcommerceFF_TestNg extends Library {

	public static WebDriver driver;
	

	@Test(priority=0)
	public void LauchBrowser() throws IOException {
		ReadPropertiesFile();
		System.setProperty("webdriver.gecko.driver",objProperties.getProperty("FireFoxDriverPath"));
		driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
	}

	@Test(priority=1)
	public void ValidateFlipKartLogin() throws IOException {
		driver.findElement(LoginPage.LoginLink).click();
		driver.findElement(LoginPage.EmailField).sendKeys(objProperties.getProperty("Mobile"));
		driver.findElement(LoginPage.RequestOTP).click();

		WebDriverWait wb = new WebDriverWait(driver, 50);
		WebElement element = wb.until(ExpectedConditions.visibilityOfElementLocated(ProductSearchPage.SearchProduct));
	}

	@Test(priority=2)
	public void ValidateProductSearchPage() throws IOException, InterruptedException {
		
		String ProductSearchpageTitle = driver.getTitle();
		System.out.println("ProductSearchpage-"+ProductSearchpageTitle);
		Assert.assertEquals(objProperties.getProperty("ProductSearchpage"), ProductSearchpageTitle);
		
		driver.findElement(ProductSearchPage.SearchProduct).sendKeys(objProperties.getProperty("SearchData"));
		driver.findElement(ProductSearchPage.SearchIcon).click();
		driver.findElement(ProductSearchPage.InternalStorageDiv).click();
		driver.findElement(ProductSearchPage.InternalStorage).click();
        
		WebDriverWait wb = new WebDriverWait(driver, 50);
		WebElement Productelem = wb.until(ExpectedConditions.visibilityOfElementLocated(ProductSearchPage.ProductLink));
				
		driver.findElement(ProductSearchPage.HighToLowLink).click();
		Thread.sleep(5000);					
		driver.findElement(ProductSearchPage.ProductLink).click();
		Thread.sleep(10000);
		
		String Title2 = driver.getTitle();
		System.out.println("ProductDescriptionTitle"+Title2);

		String ProductDescriptionTitle = driver.getTitle();
		System.out.println("ProductSearchpage-"+ProductDescriptionTitle);
		Assert.assertEquals(objProperties.getProperty("ProductDescriptionpage"), ProductDescriptionTitle);
	}
	
	@Test(priority=3)
	public void ValidateProductDescriptionPage() throws IOException, InterruptedException {
		Set<String> windowhandles = driver.getWindowHandles();

		Iterator<String> iterator = windowhandles.iterator();
		String ParentWindow = iterator.next();

		String ChildWindow = iterator.next();


		driver.switchTo().window(ChildWindow);
		Thread.sleep(5000);
		
		String Title2 = driver.getTitle();
		System.out.println("AddToCartPage"+Title2);
		
		String AddToCartPage = driver.getTitle();
		SoftAssert objSAssert = new SoftAssert();
	    objSAssert.assertEquals(AddToCartPage,objProperties.getProperty("AddToCartPage"));

		
		driver.findElement(ProdDescriptionPage.GoToCartLink).click();		
		Thread.sleep(5000);
		
		String ItemInCart = driver.findElement(ProdDescriptionPage.ItemsInCart).getText();
		Assert.assertEquals(objProperties.getProperty("ItemsInCart"), ItemInCart);
		
		driver.findElement(ProdDescriptionPage.PlaceOrderLink).click();
		Thread.sleep(5000);
		

	}
	
	@Test(priority=4)
	public void ValidateDeliveryInformationPage() throws IOException, InterruptedException {
		
		driver.findElement(DeliveryInformationPage.Name).sendKeys(objProperties.getProperty("Name"));
		driver.findElement(DeliveryInformationPage.Phone).sendKeys(objProperties.getProperty("Phone"));
		driver.findElement(DeliveryInformationPage.Pincode).sendKeys(objProperties.getProperty("Pincode"));
		driver.findElement(DeliveryInformationPage.addressLine2).sendKeys(objProperties.getProperty("addressLine2"));
		driver.findElement(DeliveryInformationPage.addressLine1).sendKeys(objProperties.getProperty("addressLine1"));
		WebElement Elemstate = driver.findElement(DeliveryInformationPage.state);
		Select StateSel = new Select(Elemstate);
		StateSel.selectByVisibleText(objProperties.getProperty("State"));
		driver.findElement(DeliveryInformationPage.landmark).sendKeys(objProperties.getProperty("landmark"));
		driver.findElement(DeliveryInformationPage.alternatePhone).sendKeys(objProperties.getProperty("alternatePhone"));
		
		String Title3 = driver.getTitle();
		System.out.println("DeliveryInformationPage"+Title3);
		
		String AddToCartPage = driver.getTitle();
		SoftAssert objSAssert = new SoftAssert();
	    objSAssert.assertEquals(AddToCartPage,objProperties.getProperty("DeliveryInformationPage"));		
		objSAssert.assertAll();
		
		driver.findElement(DeliveryInformationPage.SaveAndDeliverLink).click();
		WebDriverWait wbContinue = new WebDriverWait(driver, 50);
		WebElement ContinueElem = wbContinue.until(ExpectedConditions.visibilityOfElementLocated(DeliveryInformationPage.ContinueLink));
		
		
		driver.findElement(DeliveryInformationPage.ContinueLink).click();		
		driver.findElement(DeliveryInformationPage.AcceptAndContinueLink).click();
		
		String Title5 = driver.getTitle();
		System.out.println("DeliveryInformationPage"+Title5);
	}
}
