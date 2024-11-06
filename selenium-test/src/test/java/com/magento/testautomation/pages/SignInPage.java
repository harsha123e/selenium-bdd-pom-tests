package com.magento.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By signInButton = By.id("send2");
    private By errorMessage = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public String getErrorMessage() {
        String errorMessageText = driver.findElement(errorMessage).getText();
        return errorMessageText;
    }

}
