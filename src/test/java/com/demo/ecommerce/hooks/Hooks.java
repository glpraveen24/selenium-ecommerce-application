package com.demo.ecommerce.hooks;

import com.demo.ecommerce.base.TestContext;
import com.demo.ecommerce.base.WebDriverManagers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private WebDriver driver;
    private TestContext testContext;
    private WebDriverManagers webDriverManagers;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
        this.driver = testContext.getDriver(); // Get driver from TestContext
        this.webDriverManagers = testContext.getWebDriverManager();
        logger.info("hooks constructor");
    }

    @Before
    public void setup() {
        logger.info("@Before: Setting up the browser...");
        //Driver is already initialized in TestContext
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("@After: Scenario failed, taking screenshot...");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_scenario_screenshot");
        }
        logger.info("@After: Tearing down the browser...");
        webDriverManagers.quitDriver(); // Use WebDriverManager to quit
    }
}