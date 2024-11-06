package com.magento.testautomation.stepdefinitions;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.magento.testautomation.driver.WebDriverSetup;
import com.magento.testautomation.pages.AccountDashboardPage;
import com.magento.testautomation.pages.SignInPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps {
    private WebDriver driver;
    private SignInPage signInPage;
    private AccountDashboardPage accountDashboardPage;
    private static final String LOGIN_URL = "https://magento.softwaretestingboard.com/customer/account/login/";
    private static final String DASHBOARD_URL = "https://magento.softwaretestingboard.com/customer/account/";
    private static final String ERROR_MESSAGE = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";

    @Before
    public void setup() {
        this.driver = WebDriverSetup.getDriver();
        this.signInPage = new SignInPage(driver);
        this.accountDashboardPage = new AccountDashboardPage(driver);
    }

    @Given("user navigates to the login page")
    public void user_navigates_to_the_login_page() {
        driver.get(LOGIN_URL);
    }

    @When("user enters {string} and {string}")
    public void user_enters_valid_credentials(String email, String password) {
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
    }

    @When("user clicks Sign In")
    public void user_clicks_sign_in() {
        signInPage.clickSignIn();
    }

    @Then("user should successfully log in")
    public void user_should_successfully_log_in() {
        assertEquals(DASHBOARD_URL, driver.getCurrentUrl());
    }

    @Then("user should see the account dashboard")
    public void user_should_see_the_account_dashboard() {
        assertTrue(accountDashboardPage.isMyAccountVisible());
    }

    @When("user enters invalid credentials {string} and {string}")
    public void user_enters_invalid_credentials(String email, String password) {
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
    }

    @Then("user should see an error message indicating incorrect credentials")
    public void user_should_see_an_error_message_indicating_incorrect_credentials() {
        assertNotNull(signInPage.getErrorMessage());
        assertEquals(ERROR_MESSAGE, signInPage.getErrorMessage());
    }

    @Given("user is logged into their account")
    public void user_is_logged_into_their_account() {
        driver.get(LOGIN_URL);
        signInPage.enterEmail("johnkoe@gmail.com");
        signInPage.enterPassword("password123@");
        signInPage.clickSignIn();
    }

    @When("user clicks on the logout button")
    public void user_clicks_on_the_logout_button() {
        accountDashboardPage.clickLogoutButton();
    }

    @Then("user should be redirected to the sign out page")
    public void user_should_be_redirected_to_the_homepage() {
        assertEquals("https://magento.softwaretestingboard.com/customer/account/logoutSuccess/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        WebDriverSetup.closeDriver();
    }
}
