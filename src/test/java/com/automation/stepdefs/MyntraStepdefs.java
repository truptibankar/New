package com.automation.stepdefs;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.automation.pageObjectModule.SignInPageobjects;
import com.automation.pom.HomePagePOM;
import com.automation.pom.SearchPagePOM;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;

public class MyntraStepdefs {
	
	private static final Logger logger = LogManager.getLogger(MyntraStepdefs.class);
	WebDriver driver;
	String url = "https://www.myntra.com/";
	Scenario scn;
	
	HomePagePOM homePagePOM;
	SearchPagePOM searchPagePOM;
	//driver.manage().timeouts().implicitlyWait(implicit_wait_time_in_sec, TimeUnit.SECONDS);

	
	@Before
	public void setUp(Scenario scn)
	{  
		this.scn= scn;
		driver = new ChromeDriver();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Browser invoked");

		homePagePOM= new HomePagePOM(driver);
		searchPagePOM = new SearchPagePOM(driver);
	}
	
	@After
	public void quit() {
		driver.quit();
	}

	
	@Given("user navigates to the application url")
	public void user_navigates_to_the_application_url() {
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(implicit_wait_time_in_sec, TimeUnit.SECONDS);
		
	}

	@Given("User is on profile icon")
	public void user_is_on_profile_icon() throws InterruptedException {
		homePagePOM.profileIcon();
	}
	@When("User clicked on Login\\/Signup button")
	public void user_clicked_on_login_signup_button() throws InterruptedException {
		homePagePOM.loginToApplication();
		}
	@When("User entered mobile no and clicked on continue")
	public void user_entered_mobile_no_and_clicked_on_continue() {
		homePagePOM.mobileNoEntry();
	}
	@Then("User is able to sign in the application")
	public void user_is_able_to_sign_in_the_application() {
		//homePagePOM.VerificationMsg(expected);
	}
	@Deprecated
	@Given("user Opened Browser")
	public void user_opened_browser() {
		
	}
	/*@Given("navigated to the application url")
	public void navigated_to_the_application_url() {
	}*/
	@When("user entered {string} brand name in search text box")
	public void user_entered_brand_name_in_search_text_box(String product) {
		searchPagePOM.Setsearchbox(product);
	}
	@When("clicked on search button")
	public void clicked_on_search_button() {
		searchPagePOM.searchbox_visibility();
		searchPagePOM.ClickedOnSearchButton();
	}
	@Then("search product results displayed")
	public void search_product_results_displayed() {
		String Expected = "Buy Blackberrys Clothing at Indias Best Fashion Store | Myntra";
		//String Actual = driver.getTitle();
		//Assert.assertEquals("Search result page title validation", Expected, Actual);
		searchPagePOM.ValidateSearchResult(Expected);
	}

	@Then("user can see and select the dropdown which starts with name {string}")
	public void user_can_see_and_select_the_dropdown_which_starts_with_name(String product) {
		searchPagePOM.Setsearchbox(product);
		searchPagePOM.SelectTextFromAutoSelectedDropdown(product);       
	}
	
	@When("user enter minimum and maximum price range as mentioned below table")
	public void user_enter_minimumand_maximum_price_range_as_mentioned_below_table(io.cucumber.datatable.DataTable dataTable) {
		searchPagePOM.FilterProductAsPerPriceRange();
	}

	@Then("search result get filter as below table")
	public void search_result_get_filter_as_below_table(int min, int max) {
		searchPagePOM.VerifyFilterProductAsPerPriceRange(min, max);
	}

}











