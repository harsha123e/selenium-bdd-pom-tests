package com.magento.testautomation.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.openqa.selenium.WebDriver;

import com.magento.testautomation.driver.WebDriverSetup;
import com.magento.testautomation.pages.AccountDashboardPage;
import com.magento.testautomation.pages.SignUpPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSteps {
    private WebDriver driver;
    private SignUpPage signUpPage;
    private AccountDashboardPage accountDashboardPage;
    private String email;

    @Before
    public void setup() {
        this.driver = WebDriverSetup.getDriver();
        this.signUpPage = new SignUpPage(driver);
        this.accountDashboardPage = new AccountDashboardPage(driver);
    }

    @Given("user is on sign-up page")
    public void user_is_on_sign_up_page() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @When("user enters valid details {string}, {string}, email and {string}")
    public void user_enters_valid_details_and(String firstName, String lastName, String password) {
        this.email = generateUniqueEmail(firstName); // Generate a unique email
        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastName(lastName);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(password);
        signUpPage.enterConfirmPassword(password);
    }

    private String generateUniqueEmail(String firstName) {
        return firstName.toLowerCase() + UUID.randomUUID().toString() + "@gmail.com";
    }

    @When("user clicks Create Account")
    public void user_clicks_create_account() {
        signUpPage.clickCreateAccount();
    }

    @Then("user should see a confirmation message")
    public void user_should_see_a_confirmation_message() {
        String expectedMessage = "Thank you for registering with Main Website Store.";
        assertEquals(expectedMessage, accountDashboardPage.getConfirmationMessage());
    }

    @Then("user should be redirected to the account dashboard")
    public void user_should_be_redirected_to_the_account_dashboard() {
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Then("user should see their details on the account dashboard")
    public void user_should_see_their_details_on_the_account_dashboard() {
        assertTrue(accountDashboardPage.isMyAccountVisible());
        assertTrue(accountDashboardPage.getUserDetails().contains(email));
    }

}
