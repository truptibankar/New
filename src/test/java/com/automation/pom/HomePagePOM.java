package com.automation.pom;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import junit.framework.Assert;

public class HomePagePOM {
	
	public static final Logger logger = LogManager.getLogger(HomePagePOM.class);
	WebDriver driver;
	
	private By profile_icon = By.xpath("//div[@class='desktop-userIconsContainer']") ;
	private By login_signup_button = By.xpath("//a[@class='desktop-linkButton']");
	private By mob_no = By.xpath("//input[@class ='form-control mobileNumberInput']");
	private By continue_button= By.xpath("//div[@class='submitBottomOption']");
	
	public HomePagePOM(WebDriver driver) {
		this.driver = driver;
	}
	
	public void profileIcon() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(profile_icon)).build().perform();
		Thread.sleep(2000);
		}
	
	public void loginToApplication() {
		WebElement login = driver.findElement(login_signup_button);
		login.click();
	}
	
	public void mobileNoEntry() {
		WebElement mobNo = driver.findElement(mob_no);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		mobNo.sendKeys("9011831537");
		driver.findElement(continue_button).click();
	}
	
	public void VerificationMsg(String expected)
	{
		//String expectedtext = "Verify with OTP";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean b = wait.until(ExpectedConditions.titleContains("Verify with OTP"));
		Assert.assertEquals("Title is correct", true, b);

			}
	
	
	
	

}
