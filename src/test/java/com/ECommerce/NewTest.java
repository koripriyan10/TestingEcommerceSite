package com.ECommerce;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Pages.ProductSearchPage;
import com.Pages.SearchPage;
import com.Utility.Library;

public class NewTest extends Library {
	
	public static WebDriver driver;
	
 @Test(priority=0)
  public static void LaunchBrowser()  {
	 try {
		ReadPropertiesFile();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 System.setProperty("webdriver.gecko.driver",
				"D:\\JavaWorkSpace\\Selenium_Projects\\src\\test\\resources\\firefoxdriver-v33\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();	 
		
		driver.findElement(ProductSearchPage.SearchProduct).sendKeys(objProperties.getProperty("SearchData"));
		driver.findElement(ProductSearchPage.SearchIcon).click();
		
		
		List<WebElement> PNames = driver.findElements(SearchPage.ProductNames); 	
		List<WebElement> PPrices = driver.findElements(SearchPage.ProductPrices); 	
		
	 
		
		for(int i =2; i< PNames.size();i++)
		{
		    String PName = PNames.get(i).getText();
		    String ExcelPath = "D:\\Documents\\readData.xlsx";
		    String SheetName = "ProductListing";
			try {
				WriteData(ExcelPath,SheetName,i,1,PName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
  }
  
 @Test(priority=1)
 public static void WriteData(String excelpath,String sheetname,int RowNumber,int ColumnNumber,String data) throws IOException
 {
	 System.out.println(excelpath);
	 System.out.println(sheetname);
	 System.out.println(RowNumber);
	 System.out.println(ColumnNumber);
	 System.out.println(data);
	 
	 File file = new File(excelpath);
	 XSSFWorkbook wb = new XSSFWorkbook();
	 XSSFSheet sheet = wb.getSheet(sheetname);
	 XSSFRow row = sheet.getRow(RowNumber);
	 XSSFCell cell = row.getCell(ColumnNumber);
	 
	 if(cell ==null)
	 {
		 row.createCell(ColumnNumber);
		 cell.setCellValue(data);
	 }
	 
	 else
	 {
		 cell.setCellValue(data);
	 }
	 
	 FileOutputStream fio = new FileOutputStream(file);
	 wb.write(fio);
	 wb.close();
	 fio.close();
 }
 
}
