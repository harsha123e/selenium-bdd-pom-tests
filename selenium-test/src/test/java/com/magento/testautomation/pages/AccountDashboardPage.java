package com.magento.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountDashboardPage {
    private WebDriver driver;

    private By confirmationMessageLabel = By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div");
    private By myAccountLabel = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span");
    private By userDetailsLabel = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[1]/p");
    private By actionSwitchButton = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]");
    private By signOutButton = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]");

    public AccountDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMessage() {
        WebElement confirmationMessageElement = driver.findElement(confirmationMessageLabel);
        return confirmationMessageElement.getText();
    }

    public boolean isMyAccountVisible() {
        return driver.findElement(myAccountLabel).isDisplayed();
    }

    public String getUserDetails() {
        WebElement userDetailsElement = driver.findElement(userDetailsLabel);
        return userDetailsElement.getText();
    }

    public void clickLogoutButton() {
        driver.findElement(actionSwitchButton).click();
        driver.findElement(signOutButton).click();
    }

}
