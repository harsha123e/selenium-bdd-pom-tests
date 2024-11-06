package com.magento.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By createAccountButton = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private By userAlreadyExistsErrorMsg = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
    private By weakPasswordErrorMsg = By.id("password-error");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    public boolean isEmailInUseErrorMessageDisplayed() {
        return driver.findElement(userAlreadyExistsErrorMsg).isDisplayed();
    }

    public boolean isPasswordStrengthErrorMessageDisplayed() {
        return driver.findElement(weakPasswordErrorMsg).isDisplayed();
    }

}
