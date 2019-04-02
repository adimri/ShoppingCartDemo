package com.aus.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.aus.shoppingcart.controller.InventoryController;
import com.aus.shoppingcart.test.ShoppingCartApplicationTests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber.*;

public class InventoryControllerTest extends ShoppingCartApplicationTests {

	@Autowired
	InventoryController inventoryController;

	@Given("^I Fetch the inventory")
	public void i_fetch_the_invetory() {

	}

	@When("^I fetch the inventory$")
	public void when_i_fetch_the_inventory() {
	
	}

	@Then("^I receive inventory$")
	public void i_receive_inventory() {

	}

}
