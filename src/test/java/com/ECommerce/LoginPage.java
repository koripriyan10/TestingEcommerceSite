package com.ECommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

	public WebDriver Driver;

	public LoginPage(WebDriver driver) {
		this.Driver = driver;
	}

	// Web Elements on Page 1 of Flipkart

	By Login = By.xpath("//a[@title='Login']/span[contains(text(),'Login')]");
	WebElement EmailId = Driver.findElement(By.xpath("//span[contains(text(),'Enter Email/Mobile number')]"));
	By RequestOTP = By.xpath("//button[contains(text(),'Request OTP')]");

	// Operation on web elements

	public void Click_Login() throws InterruptedException {
		Driver.findElement(Login).click();
		Thread.sleep(3000);
	}

	public void enter_EmailId(String EmailID) {
		Actions objActions = new Actions(Driver);
		objActions.click(EmailId).build().perform();
		EmailId.sendKeys(EmailID);

	}

	public void Request_OTP() {
		Driver.findElement(RequestOTP).click();
	}
}
