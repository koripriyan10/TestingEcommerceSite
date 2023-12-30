package com.ECommerce;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ECommerce.LoginPage;
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

//		LoginPage Login_POM = new LoginPage(driver); 
//		Login_POM.Click_Login();
//		Login_POM.enter_EmailId(objProperties.getProperty("EmailID"));
//		Login_POM.Request_OTP();

		By LoginLink = By.xpath("//a[@title='Login']/span[contains(text(),'Login')]");
		driver.findElement(LoginLink).click();

		WebElement EmailField = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
		EmailField.click();
		EmailField.sendKeys(objProperties.getProperty("EmailID"));

		By RequestOTP = By.xpath("//button[contains(text(),'Request OTP')]");
		driver.findElement(RequestOTP).click();

		// WebElement SearchLink = driver.findElement(By.xpath("//input[@title='Search
		// for Products, Brands and More']"));

		WebDriverWait wb = new WebDriverWait(driver, 50);
		WebElement element = wb.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@title='Search for Products, Brands and More']")));

		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"))
				.sendKeys(objProperties.getProperty("SearchData"));

		By SearchIcon = By.xpath("//button[@type='submit']");
		driver.findElement(SearchIcon).click();

		By InternalStorage = By.xpath("//div[contains(text(),'Internal')]");
		driver.findElement(InternalStorage).click();

		driver.findElement(By.xpath("//div[contains(text(),'64 - 127.9 GB')]/preceding-sibling::div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 11 Pro Max (Midnight Green, 64 GB)')]")).click();

		
		
//		String MainWindowTitle = driver.getTitle();
//		System.out.println("MainWindowTitle" + MainWindowTitle);
//		Set<String> AllWindows = driver.getWindowHandles();
//
//
//		for (String IndividualWindow : AllWindows) {
//			driver.switchTo().window(IndividualWindow);
//			
//			String NewWindowTitle = driver.getTitle();
//
//			System.out.println("NewWindowTitle" + NewWindowTitle);
//
//			if (NewWindowTitle.equals(objProperties.getProperty("ProductDescriptionPageTitle"))) {
//				driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
//			}
//		}
		
		String mainWindowHandle = driver.getWindowHandles().iterator().next();
		
	    Set<String> AllWindows = driver.getWindowHandles();
	    
	    for(String IndividualWindow :AllWindows)
		 {
	    	driver.switchTo().window(IndividualWindow);
	    	String NewWindowTitle = driver.getTitle();
	        if(NewWindowTitle.equals(objProperties.getProperty("ProductDescriptionPageTitle")))
	        {
	        	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
	        }		     
		 } 	    
	}

}
