package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementLocators {

	// Project 1 WebTesting

	public static By DraggableDebitBank = By.xpath("//li[@class='block14 ui-draggable']/a[@class=\"button button-orange\"][1]");
	public static By DroppableAccountBank = By.xpath("//ol[@class='field14 ui-droppable ui-sortable']");
	public static By DraggableDebitAmount = By.xpath("//li[@class='block13 ui-draggable']/preceding-sibling::li[@id='fourth']");
	public static By DroppableDebitAmount = By.xpath("//ol[@class='field13 ui-droppable ui-sortable' and @id='amt7']/li");
	public static By DraggableCreditSales = By.xpath("//li[@class='block15 ui-draggable']/a[@class='button button-orange']");
	public static By DroppableCreditSales = By.xpath("//ol[@class='field15 ui-droppable ui-sortable']");
	public static By DroppableCreditAmount = By.xpath("//ol[@class='field13 ui-droppable ui-sortable' and @id='amt8']");
	public static By DateOfBirthInput = By.id("dateOfBirthInput");
	public static By ElementMonth = By.xpath("//select[@class=\\\"react-datepicker__month-select\\\"]");
	public static By ElementYear = By.xpath("//select[@class=\\\"react-datepicker__year-select\\\"]");
	public static By ElementDay = By.xpath("//div[@class=\\\"react-datepicker__week\\\"]/div[text()='5']");
	public static By SeleniumLink = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Selenium')]");
	public static By RadioAndCheckBoxLink = By.xpath("//a[contains(text(),'Radio & Checkbox Demo')]");	
	public static By RadioOption1 = By.xpath("//input[@type='radio' and @value='Option 1']");
	public static By RadioOption2 = By.xpath("//input[@type='radio' and @value='Option 2']");
	public static By RadioOption3 = By.xpath("//input[@type='radio' and @value='Option 3']");	
	public static By CheckBoxOption1 = By.xpath("//input[@type='checkbox' and @value='checkbox1']");
	public static By CheckBoxOption2 = By.xpath("//input[@type='checkbox' and @value='checkbox2']");
	public static By CheckBoxOption3 = By.xpath("//input[@type='checkbox' and @value='checkbox3']");	
	public static By SliderElement = By.xpath("//div[contains(text(),'Resizable box, starting at 200x200')]/following-sibling::span");
	public static By Slider = By.xpath("//input[@type='range']");
	public static By ResizeElement = By.xpath("//div[contains(text(),'Resizable box, starting at 200x200')]/following-sibling::span");

	public static By Registerlink = By.xpath("//a[contains(text(),'REGISTER')]");
	public static By firstName = By.xpath("//input[@name='firstName']");
	public static By lastName = By.xpath("//input[@name='lastName']");
	public static By phone = By.xpath("//input[@name='phone']");
	public static By userName = By.xpath("//input[@name='userName']");
	public static By address1 = By.xpath("//input[@name='address1']");
	public static By city = By.xpath("//input[@name='city']");
	public static By state = By.xpath("//input[@name='state']");
	public static By postalCode = By.xpath("//input[@name='postalCode']");
	public static By country = By.xpath("//select[@name='country']");
	public static By email = By.xpath("//input[@name='email']");
	public static By password = By.xpath("//input[@name='password']");
	public static By confirmPassword = By.xpath("//input[@name='confirmPassword']");
	public static By SignOn = By.xpath("//a[contains(text(),'SIGN-ON')]");
	public static By SignIn = By.xpath("//a[contains(text(),' sign-in ')]");
	public static By LoginuserName = By.xpath("//input[@name='userName']");
	public static By LoginPassword = By.xpath("//input[@name='password']");
	public static By Submit = By.xpath("//input[@type=\"submit\"]");

	public static void SelectValueFromDropdown(List<WebElement> AllElements, WebElement DropDownValue) {
		// TODO Auto-generated method stub
		int TotalElements = AllElements.size();

		for (int i = 1; i <= TotalElements - 1; i++) {
			String DropDownFromScript = AllElements.get(i).getText();

			if (DropDownFromScript.equals(DropDownValue)) {
				AllElements.get(i).click();
				break;
			}
		}

	}

}
