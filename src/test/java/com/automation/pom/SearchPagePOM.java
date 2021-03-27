package com.automation.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPagePOM {
	
	Logger logger = LogManager.getLogger();
	WebDriver driver;
	
	private By search_text_box = By.xpath("//input[@class='desktop-searchBar']");
	private By search_button = By.xpath("//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']");
	private By shirt_label = By.xpath("//label[@class= 'common-customCheckbox vertical-filters-label']");
	private By filtered_by_price = By.xpath("input[@class='price-input']");
	private By filtered_by_color = By.xpath("//div[@class='common-checkboxIndicator']");
	private By pricerange_filter = By.xpath("//div[@class='common-checkboxIndicator']");
	private By product_price_list = By.xpath("//div[@class='product-discountedPrice']");
	
	public SearchPagePOM(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchbox_visibility() {
		Boolean b = driver.findElement(search_text_box).isDisplayed();
		Assert.assertEquals("Search box is displayed", true, b);
		logger.info("Search box is displayed");
	}
	public void Setsearchbox(String productName) {
		WebElement searchbox = driver.findElement(search_text_box);
		searchbox.click();
		searchbox.sendKeys(productName);
		logger.info("Entered product name: " +productName);	
	}
	
	public void ClickedOnSearchButton() {
		driver.findElement(search_button).click();
	}
	
    public void ValidateSearchResult(String expectedTitle) {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
		Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title Validation",true, b);
		logger.info("Page title matched: " + expectedTitle );
	}
    
    public void SelectTextFromAutoSelectedDropdown(String PartialProductText) {
		WebElement searchbox = driver.findElement(search_text_box);
		searchbox.click();
		searchbox.sendKeys(PartialProductText);
		searchbox.sendKeys(Keys.ARROW_DOWN);
		searchbox.sendKeys(Keys.ENTER);
    }
    
    public void FilterProductAsPerPriceRange() {
    	driver.findElement(pricerange_filter).click();
    }
    
    public void VerifyFilterProductAsPerPriceRange(int min, int max) {
       List<WebElement> product_prices = driver.findElements(product_price_list);
       logger.info("Get all the product prices");
       int price_temp=0;
       boolean result=false;
       
       for(int i=0; i<product_prices.size(); i++) {
    	   price_temp=Integer.parseInt(product_prices.get(i).getText().replace(",", ""));
    	   
    	   if(price_temp>=min && price_temp<=max) {
    		   result=true;   
    	   }else {
    		   result=false;
    		   logger.info("Product price is not in the price range");
    	   }
    	   
       }
       
    } 
}





















