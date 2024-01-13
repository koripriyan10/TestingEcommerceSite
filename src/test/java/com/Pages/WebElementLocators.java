package com.Pages;

import org.openqa.selenium.By;

public class WebElementLocators {
   public static By Registerlink  = By.xpath("//a[contains(text(),'REGISTER')]");
   public static By firstName  = By.xpath("//input[@name='firstName']");
   public static By lastName  = By.xpath("//input[@name='lastName']");
   public static By phone  = By.xpath("//input[@name='phone']");
   public static By userName  = By.xpath("//input[@name='userName']");
   public static By address1  = By.xpath("//input[@name='address1']");
   public static By city  = By.xpath("//input[@name='city']");
   public static By state  = By.xpath("//input[@name='state']");
   public static By postalCode  = By.xpath("//input[@name='postalCode']");
   public static By country  = By.xpath("//select[@name='country']");
   public static By email  = By.xpath("//input[@name='email']");
   public static By password  = By.xpath("//input[@name='password']");
   public static By confirmPassword  = By.xpath("//input[@name='confirmPassword']");
   public static By Submit  = By.xpath("//input[@type=\"submit\"]"); 
}
