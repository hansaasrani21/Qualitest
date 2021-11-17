package com.steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.pageObjects.ItemPage;
import com.utils.DriverUtil;

import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	DriverUtil driverManager;
	ItemPage product;
	public static Properties prop = new Properties();
	Scenario scenario;

	public StepDefinitions(DriverUtil driverManager) {
		loadProperties();
		this.driverManager = driverManager;
		product = new ItemPage(driverManager);

	}

	public void loadProperties() {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void testSetup(Scenario scenario) {
		this.scenario = scenario;

	}

	@Given("I add {string} different products to my wishlist")
	public void i_add_four_different_products_to_my_wishlist(String productCount) {
		loadProperties();
		driverManager.getDriver().get(prop.getProperty("url"));
		product.addProductToCart(productCount);
	}

	@When("I view my wishlist table")
	public void i_view_my_wishlist_table() {
		product.clickOnWishlist();
	}

	@Then("I find total four selected items in my wishlist")
	public void i_find_total_four_selected_items_in_my_wishlist() {
		product.wishListTable();
	}

	@When("I search for lowest price product")
	public void i_search_for_lowest_price_product() {
		product.getLowPriceItem();
	}

	@When("I am able to add the lowest price item to my cart")
	public void i_am_able_to_add_the_lowest_price_item_to_my_cart() {
		product.addLowPriceItem();
	}

	@Then("I am able to verify the item in my cart")
	public void i_am_able_to_verify_the_item_in_my_cart() {
		product.verifyItemInmyCart();
	}

	@After
	public void tearDown() {
		driverManager.getDriver().quit();
	}

}
