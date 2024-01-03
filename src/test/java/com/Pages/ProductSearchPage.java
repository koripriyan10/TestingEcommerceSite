package com.Pages;

import org.openqa.selenium.By;

public class ProductSearchPage {
	public static By SearchProduct = By.xpath("//input[@title='Search for Products, Brands and More']");
	public static By EmailField = By.xpath("//input[@class='_2IX_2- VJZDxU']");
	public static By SearchIcon = By.xpath("//button[@type='submit']");
	public static By InternalStorageDiv = By.xpath("//div[contains(text(),'Internal')]");
	public static By InternalStorage = By.xpath("//div[contains(text(),'64 - 127.9 GB')]/preceding-sibling::div");
	public static By ProductLink = By.xpath("//div[contains(text(),'APPLE iPhone 11 Pro Max (Midnight Green, 64 GB)')]");
	public static By HighToLowLink = By.xpath("//div[contains(text(),'Price -- High to Low')]");
}
