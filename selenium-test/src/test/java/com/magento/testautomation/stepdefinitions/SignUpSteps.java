package com.magento.testautomation.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.openqa.selenium.WebDriver;

import com.magento.testautomation.driver.WebDriverSetup;
import com.magento.testautomation.pages.AccountDashboardPage;
import com.magento.testautomation.pages.SignUpPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSteps {
    private WebDriver driver;
    private SignUpPage signUpPage;
    private AccountDashboardPage accountDashboardPage;
    private String email;
    private static final String SIGN_UP_URL = "https://magento.softwaretestingboard.com/customer/account/create/";
    private static final String DASHBOARD_URL = "https://magento.softwaretestingboard.com/customer/account/";
    private static final String REGISTRATION_CONFIRMATION_MSG = "Thank you for registering with Main Website Store.";

    @Before
    public void setup() {
        this.driver = WebDriverSetup.getDriver();
        this.signUpPage = new SignUpPage(driver);
        this.accountDashboardPage = new AccountDashboardPage(driver);
    }

    @Given("user is on sign-up page")
    public void user_is_on_sign_up_page() {
        driver.get(SIGN_UP_URL);
    }

    @When("user enters valid details {string}, {string}, {string} and {string}")
    public void user_enters_valid_details_and(String firstName, String lastName, String email, String password) {
        this.email = generateUniqueEmail(firstName); // Generate a unique email
        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastName(lastName);
        signUpPage.enterEmail(this.email);
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
        assertEquals(REGISTRATION_CONFIRMATION_MSG, accountDashboardPage.getConfirmationMessage());
    }

    @Then("user should be redirected to the account dashboard")
    public void user_should_be_redirected_to_the_account_dashboard() {
        assertEquals(DASHBOARD_URL, driver.getCurrentUrl());
    }

    @Then("user should see their details on the account dashboard")
    public void user_should_see_their_details_on_the_account_dashboard() {
        assertTrue(accountDashboardPage.isMyAccountVisible());
        assertTrue(accountDashboardPage.getUserDetails().contains(email));
    }

    @When("user enters valid details {string}, {string}, existing {string} and {string}")
    public void user_enters_the_existing_email_and_valid_details(String firstName, String lastName, String email,
            String password) {
        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastName(lastName);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(password);
        signUpPage.enterConfirmPassword(password);
    }

    @Then("user should see an error message indicating the email is already in use")
    public void user_should_see_an_error_message_indicating_the_email_is_already_in_use() {
        assertTrue(signUpPage.isEmailInUseErrorMessageDisplayed());
    }

    @When("user enters {string}, {string}, {string} and weak password {string}")
    public void user_enters_and_weak_password(String firstName, String lastName, String email, String weakPassword) {
        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastName(lastName);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(weakPassword);
    }

    @Then("user should see an error message indicating the password does not meet strength requirements")
    public void user_should_see_an_error_message_indicating_the_password_does_not_meet_strength_requirements() {
        assertTrue(signUpPage.isPasswordStrengthErrorMessageDisplayed());
    }

    @After
    public void tearDown() {
        WebDriverSetup.closeDriver();
    }
}
