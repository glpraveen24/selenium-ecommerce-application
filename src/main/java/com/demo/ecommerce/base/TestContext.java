package com.demo.ecommerce.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TestContext {

    private WebDriverManagers webDriverManagers;
    private WebDriver driver;
    protected static final Logger log = LogManager.getLogger();

    public TestContext() {
        this.webDriverManagers = new WebDriverManagers();
        this.driver = webDriverManagers.initializeDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverManagers getWebDriverManager() {
        return this.webDriverManagers;
    }
}