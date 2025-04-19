package com.demo.ecommerce.pageObjects;

import com.demo.ecommerce.base.TestContext;
import org.openqa.selenium.WebDriver;

public class PageObjectFactory {

    private WebDriver driver;
    private LoginPage loginPage;
    private LandingPage landingPage;
    private HomePage homePage;
    private TestContext testContext;

    public PageObjectFactory(TestContext testContext) {
        this.testContext = testContext;
        this.driver = testContext.getDriver();
        this.loginPage = new LoginPage(driver);
        this.landingPage= new LandingPage(driver);
        this.homePage = new HomePage(driver);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public LandingPage getLandingPage() {
        return landingPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
