package com.magento.testautomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/magento/testautomation/features", 
        glue = "com.magento.testautomation.stepdefinitions", 
        plugin = {"pretty", "html:target/cucumber-reports.html" }, 
        monochrome = true
)
public class TestRunner {
}
