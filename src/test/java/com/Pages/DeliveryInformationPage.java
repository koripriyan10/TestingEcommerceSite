package com.Pages;

import org.openqa.selenium.By;

public class DeliveryInformationPage {
	public static By AddNewAddressLink = By.xpath("//div[contains(text(),'Add a new address')]");
	public static By Name = By.xpath("//input[@name='name']");
	public static By Phone = By.xpath("//input[@name='phone']");
	public static By Pincode = By.xpath("//input[@name='pincode']");
	public static By addressLine2 = By.xpath("//input[@name='addressLine2']");
	public static By addressLine1 = By.xpath("//textarea[@name='addressLine1']");
	public static By city = By.xpath("//input[@name='city']");
	public static By state = By.xpath("//select[@name='state']");
	public static By landmark = By.xpath("//select[@name='state']");
	public static By alternatePhone = By.xpath("//select[@name='state']");
	public static By SaveAndDeliverLink = By.xpath("//button[contains(text(),'Save and Deliver Here')]");
	public static By ContinueLink = By.xpath("//button[contains(text(),'CONTINUE')]");
	public static By AcceptAndContinueLink = By.xpath("//button[contains(text(),'Accept & Continue')]");
}
