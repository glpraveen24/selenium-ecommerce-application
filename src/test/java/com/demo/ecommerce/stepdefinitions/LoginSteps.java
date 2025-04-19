package com.demo.ecommerce.stepdefinitions;

import com.demo.ecommerce.pageObjects.PageObjectFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginSteps {

    private PageObjectFactory page;

    public LoginSteps(PageObjectFactory page){
        this.page = page;
    }

    @Given("The user navigates to the e-commerce website")
    public void the_user_navigates_to_the_e_commerce_website() {
        page.getLandingPage().navigate_to_website("https://demowebshop.tricentis.com/tricentis");

    }

    @When("The user clicks on the Log in link")
    public void the_user_clicks_on_the_link() {
        page.getLandingPage().clickLoginLink();
    }

    @Then("The user should be on the login page")
    public void the_user_should_be_on_the_login_page() {
        assertEquals("Demo Web Shop. Login", page.getLandingPage().getPageTitle());

    }

    @When("The user enters valid email {string}")
    public void the_user_enters_valid_email(String string) {
        page.getLoginPage().enterEmail(string);

    }

    @When("The user enters valid password {string}")
    public void the_user_enters_valid_password(String string) {
        page.getLoginPage().enterPassword(string);

    }

    @When("The user clicks the Log in button")
    public void the_user_clicks_the_button() {
        page.getLoginPage().clickLoginButton();

    }

    @Then("The user should be successfully logged in")
    public void the_user_should_be_successfully_logged_in() {
        assertTrue(page.getHomePage().isLogoutLinkDisplayed(),"Failed to find Log out button");
    }


}