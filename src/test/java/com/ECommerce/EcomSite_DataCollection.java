package com.ECommerce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.Pages.ProductSearchPage;
import com.Pages.SearchPage;
import com.Utility.Library;


public class EcomSite_DataCollection extends Library {

	public static WebDriver driver;
	int no_of_Prices;
	List<WebElement> PNames;
	List<WebElement> PPrices;
	
	@Test(priority = 0)
	public void LauchBrowser() throws IOException, InterruptedException {
		ReadPropertiesFile();
		System.setProperty("webdriver.gecko.driver",
				"D:\\JavaWorkSpace\\Selenium_Projects\\src\\test\\resources\\firefoxdriver-v33\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	// div[@class='_4rR01T']
	// div[@class='_30jeq3 _1_WHN1']
	
	@Test(priority = 1)
	public void ValidateFlipKartSearch() throws IOException, InterruptedException {
		driver.findElement(ProductSearchPage.SearchProduct).sendKeys(objProperties.getProperty("SearchPhone"));
		driver.findElement(ProductSearchPage.SearchIcon).click();
		Thread.sleep(5000);
		List<WebElement> PNames = driver.findElements(SearchPage.ProductNames); 	
		List<WebElement> PPrices = driver.findElements(SearchPage.ProductPrices); 	
				
	}
	
	
	@Test(priority = 2)
	public void testResult() {
		
        // Get all the phone names    
	    PNames = driver.findElements(SearchPage.ProductNames); 	
		int no_of_Phones = PNames.size();
		
		for(int i=0 ; i < no_of_Phones-1;i++)
		{
			System.out.println(PNames.get(i).getText());
		}
		
		 // Get all the prices   
		PPrices = driver.findElements(SearchPage.ProductPrices); 	
	    no_of_Prices = PPrices.size();
		
		for(int i=0 ; i < no_of_Prices -1;i++)
		{
			System.out.println(PPrices.get(i).getText());
		}
		
				
	}
	
	@Test(priority = 3)
	public void write_Excel() throws IOException {
		
		File f=new File("D:\\Documents\\readData.xlsx");		
		
		XSSFWorkbook w= new XSSFWorkbook();
		XSSFSheet s=w.createSheet("project4output");
		XSSFRow r=s.createRow(0);
		r.createCell(0).setCellValue("Products");
		r.createCell(1).setCellValue("price");
		
		for(int i=0;i<=no_of_Prices-1;i++)
		{
			XSSFRow r1=s.createRow(i+1);
			r1.createCell(0).setCellValue(PNames.get(i).getText());
			r1.createCell(1).setCellValue(PPrices.get(i).getText());
		}
		
		FileOutputStream fop=new FileOutputStream(f);
		try {
			w.write(fop);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w.close();
		driver.close();	
		
		
	}
	
}
