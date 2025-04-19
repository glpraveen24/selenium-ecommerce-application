package com.demo.ecommerce.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.demo.ecommerce.stepdefinitions", "com.demo.ecommerce.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml"
        },
        monochrome = true,
        publish = true // To publish reports on Cucumber Reports service
        //tags = "@Regression or @Smoke" // Example: Run scenarios tagged with @Regression OR @Smoke
        // tags = "@Regression and @Sanity" // Example: Run scenarios tagged with BOTH @Regression AND @Sanity
        // tags = "not @Ignore"           // Example: Run all scenarios EXCEPT those tagged with @Ignore
)
public class TestRunner {

}