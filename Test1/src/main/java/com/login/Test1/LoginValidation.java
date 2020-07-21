package com.login.Test1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginValidation {
	public static void gmailloginvalidation() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\facadmin1\\eclipse-workspace1\\Test1\\src\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);

		// launch URL
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
		
		String child = driver.getWindowHandle();
		
		WebElement clickSignIn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a"));
		clickSignIn.click();
		Set<String> parent = driver.getWindowHandles();
		for (String listOfWindows : parent) {
			if (!listOfWindows.equals(child)) {
				driver.switchTo().window(listOfWindows);
				// wait for webdriver
				WebDriverWait wb = new WebDriverWait(driver, 20);
				WebElement username = driver.findElement(By.xpath("//input[@type='email']"));
				wb.until(ExpectedConditions.visibilityOf(username));
				//userName
				username.sendKeys("saranmani7378@gmail.com");
				Thread.sleep(1000);

				WebElement clickNext = driver
						.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
				clickNext.click();
				//password
				Thread.sleep(3000);
				WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
				password.sendKeys("pandiyan7378");
				WebElement clicknextOnPassword = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]"));
				clicknextOnPassword.click();
				Thread.sleep(3000);
				WebElement verify = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a/img"));
				boolean text = verify.isDisplayed();
				if (text==true) {
					System.out.println("Verify success login by user profile icon in top right corner");
					
				}
				else {
					System.out.println("failed login by user profile icon in top right corner");
				}
				driver.close();
			}
			
		}
		
		
		
		
		
		
	}
	
	public static void loginFailed() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\facadmin1\\eclipse-workspace1\\Test1\\src\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);

		// launch URL
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
		
		String child = driver.getWindowHandle();
		
		WebElement clickSignIn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a"));
		clickSignIn.click();
		Set<String> parent = driver.getWindowHandles();
		for (String listOfWindows : parent) {
			if (!listOfWindows.equals(child)) {
				driver.switchTo().window(listOfWindows);
				// wait for webdriver
				WebDriverWait wb = new WebDriverWait(driver, 20);
				WebElement username = driver.findElement(By.xpath("//input[@type='email']"));
				wb.until(ExpectedConditions.visibilityOf(username));
				//userName
				username.sendKeys("saranmani7378@gmail.com");
				Thread.sleep(1000);

				WebElement clickNext = driver
						.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
				clickNext.click();
				//password
				Thread.sleep(3000);
				WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
				password.sendKeys("pandiyan737");
				WebElement clicknextOnPassword = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]"));
				clicknextOnPassword.click();
				Thread.sleep(3000);
				WebElement failedText = driver.findElement(By.xpath("//div[@jsname='B34EJ']/span"));
				//String text = failedText.getText();
				if (failedText.getText().contains("Wrong password")) {
					System.out.println("verify the user should be get an error message when user enter the wrong password");
				}
				
				
				
			}
		}
	}
	public static void main(String[] args) throws Throwable {
		gmailloginvalidation();
		loginFailed();
	}
}
