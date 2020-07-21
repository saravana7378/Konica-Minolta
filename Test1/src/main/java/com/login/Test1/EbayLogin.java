package com.login.Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EbayLogin {
	
	public static void verifyEbayLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\facadmin1\\eclipse-workspace1\\Test1\\src\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);

		// launch URL
		driver.get("https://www.ebay.com/");

		// wait for webdriver
		WebDriverWait wb = new WebDriverWait(driver, 20);
		WebElement tab = driver.findElement(By.xpath("//*[@id='gh-ac']"));
		wb.until(ExpectedConditions.visibilityOf(tab));
		Thread.sleep(1000);
        
		tab.sendKeys("Electric Guitar");
		WebElement searchbutton = driver.findElement(By.xpath("//*[@id='gh-btn']"));
		searchbutton.click();
		Thread.sleep(4000);
		
		String getAmount = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/div[4]/div[1]/span")).getText();
		Thread.sleep(1000);
		System.out.println(getAmount);
		Thread.sleep(1000);
		driver.close();
	}
	public static void main(String[] args) throws Throwable {
		verifyEbayLogin();
	}


}
