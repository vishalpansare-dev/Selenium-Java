package com.cucumberFramework.stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.LoginLogoutPage;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class loginLogoutPageStepDefinitions extends TestBase {

	LoginLogoutPage loginPage = new LoginLogoutPage(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	@Given("^I am on the Login page URL \"([^\"]*)\"$")
	public void i_am_on_the_Login_page_URL(String arg1) throws Throwable {
		driver.get(arg1);
		//waitHelper = new WaitHelper(driver);
	}

	@Then("^I click on sign in button and wait for sign in page$")
	public void i_click_on_sign_in_button_and_wait_for_sign_in_page() throws Throwable {
		loginPage.clickSignInButton();
		waitHelper.WaitForElement(loginPage.userName, 60);
	}
	@Then("^I should get error msg$")
	public void i_should_get_error_msg() throws Throwable {
		waitHelper.WaitForElement(loginPage.errormsg, 60);
		loginPage.errormsg.isDisplayed();
		
	}
	
	@Then("^I can validate the Menu are available$")
	public void i_can_validate_the_Menu_are_available() throws Throwable {
		loginPage.menuItem.isDisplayed();
	    
	}
	@Then("^I should see Sign In Page$")
	public void i_should_see_Sign_In_Page() throws Throwable {
		waitHelper.WaitForElement(loginPage.userName, 60);
		loginPage.userName.isDisplayed();
	}
	@When("^I Click on DRESSES menu$")
	public void i_Click_on_DRESSES_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		waitHelper.WaitForElement(loginPage.DRESSESMenu, 60);
		loginPage.DRESSESMenu.click();
	}

	@Then("^I navigate to the DRESSES section$")
	public void i_navigate_to_the_DRESSES_section() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		waitHelper.WaitForElement(loginPage.DRESSESPage, 60);
		loginPage.DRESSESPage.isDisplayed();
		
	}
	@When("^I Click on T-shirts menu$")
	public void i_Click_on_Tshirts_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		waitHelper.WaitForElement(loginPage.TshirtsMenu, 60);
		loginPage.TshirtsMenu.click();
	}

	@Then("^I navigate to the T-shirts section$")
	public void i_navigate_to_the_Tshirts_section() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		waitHelper.WaitForElement(loginPage.TshirtsPage, 60);
		loginPage.TshirtsPage.isDisplayed();
		
	}
	@When("^I Click on Women menu$")
	public void i_Click_on_Women_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		waitHelper.WaitForElement(loginPage.womenMenu, 60);
		loginPage.womenMenu.click();
	}

	@Then("^I navigate to the Women section$")
	public void i_navigate_to_the_Women_section() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		waitHelper.WaitForElement(loginPage.womenPage, 60);
		loginPage.womenPage.isDisplayed();
		
	}

	@When("^I Select one product from the page$")
	public void i_Select_one_product_from_the_page() throws Throwable {
		waitHelper.WaitForElement(loginPage.firstProduct, 60);
		loginPage.addProductToCart();
		
	    
	}

	@Then("^I can see that prodcut is added in the cart$")
	public void i_can_see_that_prodcut_is_added_in_the_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		waitHelper.WaitForElement(loginPage.cartitem, 60);
		loginPage.cartitem.isDisplayed();
		
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String arg1) throws Throwable {
		loginPage.enterUserName(arg1);
	}

	@When("^I Click on Continue button$")
	public void i_Click_on_Continue_button() throws Throwable {
		loginPage.clickContinueButton();
		waitHelper.WaitForElement(loginPage.password, 60);
	}

	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String arg1) throws Throwable {
		loginPage.enterPassword(arg1);
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
		loginPage.clickLoginButton();
	}
	
	@When("^I am logged in$")
	public void i_am_already_logged_in() throws Throwable {
		waitHelper.WaitForElement(loginPage.logoutBtn, 60);
	    loginPage.logoutBtn.isDisplayed();
	}

	@When("^I Click on Sign out$")
	public void i_Click_on_Sign_out() throws Throwable {
		waitHelper.WaitForElement(loginPage.logoutBtn, 60);
	    loginPage.clickLogoutButton();
	    waitHelper.WaitForElement(loginPage.userName, 60);
	}

	@Then("^I got log out from the application and land on sign in page$")
	public void i_got_log_out_from_the_application_and_land_on_sign_in_page() throws Throwable {
		loginPage.userName.isDisplayed();
	}
	
	@Then("^I choose Electronincs>Headphones and headphones list out$")
	public void i_choose_Electronincs_Headphones_and_headphones_list_out() throws Throwable {
	    loginPage.clickHeadphonesLnk();
	}
	
	@Then("^I add first availabe headphone to cart$")
	public void i_add_first_availabe_headphone_to_cart() throws Throwable {
	    loginPage.AddHeadphoneToCart();
	}
	
	@Then("^I search \"([^\"]*)\" and add second available item to cart$")
	public void i_search_and_add_nd_available_item_to_cart(String arg1) throws Throwable {
	    loginPage.enterSearchItemandAddToCart(arg1);
	}
	
	@Then("^I clear cart items if any$")
	public void i_clear_cart_items_if_any() throws Throwable {
	    loginPage.clearCartItemifExist();
	}
	
	@Then("^I Select cart from home and remove the earlier added headphones$")
	public void i_Select_cart_from_home_and_remove_the_earlier_added_headphones() throws Throwable {
	    loginPage.cartButton.click();
	    loginPage.itemList.get(1).click();
	}
	
	@Then("^I Reduce the Quantity of the macbook pro product to one and proceed to checkout$")
	public void i_Reduce_the_Quantity_of_the_macbook_pro_product_to_one_and_proceed_to_checkout() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].innerText='1'",driver.findElement(By.className("a-dropdown-prompt")));
	}
	
	@Then("^I search different \"([^\"]*)\" from the search bar$")
	public void i_search_different_from_the_search_bar(String arg1) throws Throwable {
	    loginPage.itemSearchField.sendKeys(arg1);
	    loginPage.itemSearchField.submit();
	    Thread.sleep(5000);
	}
	@When("^I Click on the profile$")
	public void i_Click_on_the_profile() throws Throwable {
		waitHelper.WaitForElement(loginPage.profile, 60);
	    loginPage.profile.click();
	    
	}

	@Then("^I Navigate to the profile page$")
	public void i_Navigate_to_the_profile_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		waitHelper.WaitForElement(loginPage.myaccount, 60);
		loginPage.myaccount.isDisplayed();
		
	}

	@Then("^I can validate All the menu in My Account page$")
	public void i_can_validate_All_the_menu_in_My_Account_page(DataTable arg1) throws Throwable {
		List<List<String>> item=arg1.asLists(String.class);;
		loginPage.checkMenu(item);
	    
	}
	
	@When("^I Enter Wrong Email-id \"([^\"]*)\"$")
	public void i_Enter_Wrong_Email_id(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.enterUserName(arg1);
	}

	@Then("^I can see Error message is displayed$")
	public void i_can_see_Error_message_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}



	
}