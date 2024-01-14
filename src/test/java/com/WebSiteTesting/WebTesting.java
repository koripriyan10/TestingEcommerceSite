package com.WebSiteTesting;

import org.testng.annotations.Test;

import com.Utility.Library;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import com.Pages.DeliveryInformationPage;
import com.Pages.WebElementLocators;

public class WebTesting extends Library {

//	Test the login screen with username and password
//	● Test online widgets like date pickers, tabs, sliders
//	● Test interactive actions like draggable, resizable, selectable etc.
//	● Test the filling up of registration form and submission
//	● Test frames and windows
//	● Test drop-down menus, alert boxes

	@BeforeSuite
	public void beforeSuite() throws IOException {
		ReadPropertiesFile();
		System.setProperty("webdriver.gecko.driver",objProperties.getProperty("FireFoxDriverPath"));
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1, enabled = false)
	public void RegisterScreenTest() throws InterruptedException {

		driver.navigate().to(objProperties.getProperty("RegisterScreenLink"));
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
		Thread.sleep(2000);
		driver.findElement(WebElementLocators.SignIn).click();
		Thread.sleep(3000);
	}

	@Test(priority = 2, enabled = false)
	public void LoginTest() throws InterruptedException {
		WebDriverWait wbContinue = new WebDriverWait(driver, 50);
		WebElement ContinueElem = wbContinue
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.LoginuserName));
		driver.findElement(WebElementLocators.LoginuserName).sendKeys(objProperties.getProperty("loginUsername"));
		driver.findElement(WebElementLocators.LoginPassword).sendKeys(objProperties.getProperty("loginPassword"));
		driver.findElement(WebElementLocators.Submit).click();
	}

	@Test(priority = 3, enabled = false)
	public void DragAndDrop() throws InterruptedException {

		driver.navigate().to(objProperties.getProperty("DragAndDropLink"));
		Thread.sleep(5000);

		WebElement DraggableDebitBank = driver.findElement(WebElementLocators.DraggableDebitBank);
		WebElement DroppableAccountBank = driver.findElement(WebElementLocators.DroppableAccountBank);
		WebElement DraggableDebitAmount = driver.findElement(WebElementLocators.DraggableDebitAmount);
		WebElement DroppableDebitAmount = driver.findElement(WebElementLocators.DroppableDebitAmount);
		WebElement DraggableCreditSales = driver.findElement(WebElementLocators.DraggableCreditSales);
		WebElement DroppableCreditSales = driver.findElement(WebElementLocators.DroppableCreditSales);
		WebElement DroppableCreditAmount = driver.findElement(WebElementLocators.DroppableCreditAmount);

		Actions objActions = new Actions(driver);

		objActions.dragAndDrop(DraggableDebitBank, DroppableAccountBank).build().perform();
		objActions.dragAndDrop(DraggableDebitAmount, DroppableDebitAmount).build().perform();

		objActions.dragAndDrop(DraggableCreditSales, DroppableCreditSales).build().perform();
		objActions.dragAndDrop(DraggableDebitAmount, DroppableCreditAmount).build().perform();

	}

	@Test(priority = 4, enabled = false)
	public void DatePicker() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/automation-practice-form");

		WebDriverWait wbContinue = new WebDriverWait(driver, 50);
		WebElement ContinueElem = wbContinue.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.DateOfBirthInput));
		driver.findElement(WebElementLocators.DateOfBirthInput).click();

		WebElement SelMonth = driver.findElement(WebElementLocators.ElementMonth);
		WebElement SelYear = driver.findElement(WebElementLocators.ElementYear);

		Select objSelectMonth = new Select(SelMonth);
		objSelectMonth.selectByVisibleText(objProperties.getProperty("Month"));

		Select objSelectYear = new Select(SelYear);
		objSelectYear.selectByVisibleText(objProperties.getProperty("Year"));

		WebElement day = driver.findElement(WebElementLocators.ElementDay);
		Actions objActions = new Actions(driver);
		objActions.click(day).build().perform();
		Thread.sleep(5000);
	}
	
	@Test(priority = 5,enabled=false)
	public void RadioAndCheckBoxValidate() throws InterruptedException {
		
		driver.navigate().to(objProperties.getProperty("NewToursLink"));
        driver.findElement(WebElementLocators.SeleniumLink).click();
        Thread.sleep(5000);      
//        WebDriverWait wbContinue = new WebDriverWait(driver, 50);
//		WebElement ContinueElem = wbContinue
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Radio & Checkbox Demo')]")));
        driver.findElement(WebElementLocators.RadioAndCheckBoxLink).click();
        
        WebDriverWait wbContinue2 = new WebDriverWait(driver, 50);
		WebElement ContinueElem2 = wbContinue2.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.RadioOption2));
        
		Thread.sleep(5000);
		
		driver.findElement(WebElementLocators.RadioOption2).click();
        driver.findElement(WebElementLocators.CheckBoxOption3).click();
        
        WebElement OptionValue =   driver.findElement(WebElementLocators.RadioOption2);
        WebElement CheckboxValue =    driver.findElement(WebElementLocators.CheckBoxOption3);
        String OptVal =  OptionValue.getAttribute("value");
        String CheckBoxVal =  CheckboxValue.getAttribute("value");
        
        System.out.println("OptionValue-"+OptVal);
        System.out.println("CheckboxValue-"+CheckBoxVal);
        
        WebElement Radiobutton1 = driver.findElement(WebElementLocators.RadioOption1);
        WebElement Radiobutton2 = driver.findElement(WebElementLocators.RadioOption2);
        WebElement Radiobutton3 = driver.findElement(WebElementLocators.RadioOption3);
        
        WebElement CheckBox1 = driver.findElement(WebElementLocators.CheckBoxOption1);
        WebElement CheckBox2 = driver.findElement(WebElementLocators.CheckBoxOption2);
        WebElement CheckBox3 = driver.findElement(WebElementLocators.CheckBoxOption3);
        
        if(Radiobutton1.isSelected()) {System.out.println("Option 1 Selected");}      
        if(Radiobutton2.isSelected()){System.out.println("Option 2 Selected");}    
        if(Radiobutton3.isSelected()){System.out.println("Option 3 Selected");}     
        if(CheckBox1.isSelected()){System.out.println("checkbox 1 Selected");}      
        if(CheckBox2.isSelected()){System.out.println("checkbox 2 Selected");}       
        if(CheckBox3.isSelected()){System.out.println("checkbox 3 Selected");}
        
		
	}
	
	@Test(priority = 6,enabled=false)
	public void Slider()  {
		driver.navigate().to(objProperties.getProperty("SliderLink"));	
		WebElement slider = driver.findElement(WebElementLocators.Slider); // Replace "slider-id" with the actual ID of your slider element
		int sliderWidth = 80;
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(sliderWidth, 0).release().perform();

	}
	
	@Test(priority = 7)
	public void Resizable()  {
		driver.navigate().to(objProperties.getProperty("ResizeableLink"));
		
		WebElement divElement = driver.findElement(WebElementLocators.ResizeElement); // Replace "slider-id" with the actual ID of your slider element
		resizeDivWithActions(driver, divElement, 50, 30);
	}
	
	private static void resizeDivWithActions(WebDriver driver, WebElement element, int xOffset, int yOffset) {
        Actions builder = new Actions(driver);
        builder.clickAndHold(element).moveByOffset(xOffset, yOffset).release().perform();
    }

	@BeforeTest
	public void beforeTest() {
		System.out.println("Beginning Test");
	}

}
