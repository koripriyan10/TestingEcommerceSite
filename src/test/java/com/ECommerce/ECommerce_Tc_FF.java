package com.ECommerce;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pages.LoginPage;
import com.Pages.ProdDescriptionPage;
import com.Pages.ProductSearchPage;
import com.Pages.DeliveryInformationPage;
import com.Utility.Library;

public class ECommerce_Tc_FF extends Library {

	public static WebDriver driver;
//	public static Properties objProperties;

//	LoginPage Login_POM;

	/*
	 * Problem Statement 2: • Do login and validate if Login is successful. • Search
	 * for ‘iPhone 12’ and select a 64GB phone on product details page after
	 * selecting the phone from product listing page. • Add the product to cart and
	 * validate if the product added and available in Cart. • Add a new address for
	 * shipping and proceed to checkout page then validate it. • Same test to be
	 * repeated on Chrome browser (assuming you’re using Firefox as default browser
	 * else vice-versa). • Any actions in any page are welcome (like sorting the
	 * products in product listing page, page header assertions in each page to
	 * validate if on right page, etc).
	 */

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ReadPropertiesFile();
		System.setProperty("webdriver.gecko.driver",
				"D:\\JavaWorkSpace\\Selenium_Projects\\src\\test\\resources\\firefoxdriver-v33\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
//		driver.findElement(LoginPage.LoginLink).click();
//		driver.findElement(LoginPage.EmailField).sendKeys(objProperties.getProperty("EmailID"));
//		driver.findElement(LoginPage.RequestOTP).click();
//		
//		WebDriverWait wb = new WebDriverWait(driver, 50);
//		WebElement element = wb.until(ExpectedConditions.visibilityOfElementLocated(ProductSearchPage.SearchProduct));
		
		driver.findElement(ProductSearchPage.SearchProduct).sendKeys(objProperties.getProperty("SearchData"));
		driver.findElement(ProductSearchPage.SearchIcon).click();
		driver.findElement(ProductSearchPage.InternalStorageDiv).click();
		driver.findElement(ProductSearchPage.InternalStorage).click();
		driver.findElement(ProductSearchPage.ProductLink).click();
		
		// Get handles of the windows

		Set<String> windowhandles = driver.getWindowHandles();
		//System.out.println(windowhandles);

		Iterator<String> iterator = windowhandles.iterator();
		String ParentWindow = iterator.next();
		//System.out.println(ParentWindow);

		String ChildWindow = iterator.next();
		//System.out.println(ChildWindow);

		driver.switchTo().window(ChildWindow);
		Thread.sleep(5000);
		driver.findElement(ProdDescriptionPage.GoToCartLink).click();		
		Thread.sleep(5000);
		driver.findElement(ProdDescriptionPage.PlaceOrderLink).click();
		Thread.sleep(5000);
		driver.findElement(DeliveryInformationPage.AddNewAddressLink).click();
		driver.findElement(DeliveryInformationPage.Name).sendKeys(objProperties.getProperty("Name"));
		driver.findElement(DeliveryInformationPage.Phone).sendKeys(objProperties.getProperty("Phone"));
		driver.findElement(DeliveryInformationPage.Pincode).sendKeys(objProperties.getProperty("Pincode"));
		driver.findElement(DeliveryInformationPage.addressLine2).sendKeys(objProperties.getProperty("addressLine2"));
		driver.findElement(DeliveryInformationPage.addressLine1).sendKeys(objProperties.getProperty("addressLine1"));
		driver.findElement(DeliveryInformationPage.city).sendKeys(objProperties.getProperty("city"));
		WebElement Elemstate = driver.findElement(DeliveryInformationPage.state);
		Select StateSel = new Select(Elemstate);
		StateSel.selectByVisibleText(objProperties.getProperty("State"));
		driver.findElement(DeliveryInformationPage.landmark).sendKeys(objProperties.getProperty("landmark"));
		driver.findElement(DeliveryInformationPage.alternatePhone).sendKeys(objProperties.getProperty("alternatePhone"));
		driver.findElement(DeliveryInformationPage.SaveAndDeliverLink).click();
		driver.findElement(DeliveryInformationPage.ContinueLink).click();
		driver.findElement(DeliveryInformationPage.AcceptAndContinueLink).click();
		
//
//		WebElement EmailField = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
//		EmailField.click();
//		EmailField.sendKeys(objProperties.getProperty("EmailID"));
//
//		By RequestOTP = By.xpath("//button[contains(text(),'Request OTP')]");
//		driver.findElement(RequestOTP).click();
//
//		WebDriverWait wb = new WebDriverWait(driver, 50);
//		WebElement element = wb.until(ExpectedConditions
//		.visibilityOfElementLocated(By.xpath("//input[@title='Search for Products, Brands and More']")));
//
//		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"))
//		.sendKeys(objProperties.getProperty("SearchData"));
//
//		By SearchIcon = By.xpath("//button[@type='submit']");
//		driver.findElement(SearchIcon).click();
//
//		By InternalStorage = By.xpath("//div[contains(text(),'Internal')]");
//		driver.findElement(InternalStorage).click();
//
//		driver.findElement(By.xpath("//div[contains(text(),'64 - 127.9 GB')]/preceding-sibling::div")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 11 Pro Max (Midnight Green, 64 GB)')]"))
//				.click();
//
//		// Get handles of the windows
//
//		Set<String> windowhandles = driver.getWindowHandles();
//		System.out.println(windowhandles);
//
//		Iterator<String> iterator = windowhandles.iterator();
//		String ParentWindow = iterator.next();
//		System.out.println(ParentWindow);
//
//		String ChildWindow = iterator.next();
//		System.out.println(ChildWindow);
//
//		driver.switchTo().window(ChildWindow);
//		Thread.sleep(5000);
//		System.out.println(driver.getTitle());
//		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();
//		Thread.sleep(5000);
//		
////	    driver.findElement(By.xpath("//div[contains(text(),'Add a new address')]")).click();
//		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ABC");
//		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9380971751");
//		driver.findElement(By.xpath("//input[@name='pincode']")).sendKeys("620019");
//		driver.findElement(By.xpath("//input[@name='addressLine2']")).sendKeys("Thiruverumbur");
//		driver.findElement(By.xpath("//textarea[@name='addressLine1']")).sendKeys("No.30 Ramakrishna street west tambaram");
//		driver.findElement(By.xpath("//input[@name='city']")).clear();
//		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Tiruchirappalli");
//		WebElement Elemstate = driver.findElement(By.xpath("//select[@name='state']"));
//		Select StateSel = new Select(Elemstate);
//		StateSel.selectByVisibleText("Tamil Nadu");
//		driver.findElement(By.xpath("//input[@name='landmark']")).sendKeys("Near National Theatre");
//		driver.findElement(By.xpath("//input[@name='alternatePhone']")).sendKeys("8778338216");
//		driver.findElement(By.xpath("//button[contains(text(),'Save and Deliver Here')]")).click();
//		Thread.sleep(5000);	
//        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE')]")).click();
//        Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[contains(text(),'Accept & Continue')]")).click();
	}

}
