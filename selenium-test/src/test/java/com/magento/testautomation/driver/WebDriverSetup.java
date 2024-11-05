package com.magento.testautomation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {
    private static WebDriver driver;

    // Private constructor to prevent instantiation
    private WebDriverSetup() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {

            // Specify browser version to resolve ChromeDriver session start issues.
            WebDriverManager.chromedriver().browserVersion("130.0").setup();

            ChromeOptions options = new ChromeOptions();
            // Check if headless mode is enabled via system property
            if (isHeadlessMode()) {
                // Set Chrome options for headless mode
                options.addArguments("--disable-extensions");
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset driver to null to allow reinitialization
        }
    }

    private static boolean isHeadlessMode() {
        return System.getProperty("headless") != null && System.getProperty("headless").equalsIgnoreCase("true");
    }
}