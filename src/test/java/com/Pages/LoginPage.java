package com.Pages;

import org.openqa.selenium.By;

public class LoginPage {
    
	public static By LoginLink = By.xpath("//a[@title='Login']/span[contains(text(),'Login')]");
	public static By EmailField = By.xpath("//input[@class='_2IX_2- VJZDxU']");
	public static By RequestOTP = By.xpath("//button[contains(text(),'Request OTP')]");
}
