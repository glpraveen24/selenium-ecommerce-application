package com.demo.ecommerce.pageObjects;

import com.demo.ecommerce.utils.WebDriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.fail;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWaits webDriverWaits;

    @FindBy(xpath = "//div[@class='page login-page']/div[@class='page-title']/h1")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='page login-page']/div[@class='page-body']/div[@class='customer-blocks']/div[@class='new-wrapper register-block']")
    private WebElement newCustomerBlock;

    @FindBy(xpath = "//div[@class='new-wrapper register-block']/div[@class='title']/strong")
    private WebElement newCustomerTitle;

    @FindBy(xpath = "//div[@class='new-wrapper register-block']/div[@class='text']")
    private WebElement newCustomerText;

    @FindBy(xpath = "//div[@class='new-wrapper register-block']/div[@class='buttons']/input[@class='button-1 register-button']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='page login-page']/div[@class='page-body']/div[@class='customer-blocks']/div[@class='returning-wrapper']")
    private WebElement returningCustomerBlock;

    @FindBy(xpath = "//div[@class='returning-wrapper']/div[@class='title']/strong")
    private WebElement returningCustomerTitle;

    @FindBy(xpath = "//div[@class='returning-wrapper']/form[@action='/login' and @method='post']")
    private WebElement loginForm;

    @FindBy(xpath = "//div[@class='returning-wrapper']/div[@class='form-fields']/div[@class='message-error']")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//div[@class='returning-wrapper']/div[@class='form-fields']/div[@class='inputs']/label[@for='Email']")
    private WebElement emailLabel;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//div[@class='returning-wrapper']/div[@class='form-fields']/div[@class='inputs']/span[@data-valmsg-for='Email']")
    private WebElement emailValidationMessage;

    @FindBy(xpath = "//div[@class='returning-wrapper']/div[@class='form-fields']/div[@class='inputs']/label[@for='Password']")
    private WebElement passwordLabel;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@class='returning-wrapper']/div[@class='form-fields']/div[@class='inputs']/span[@data-valmsg-for='Password']")
    private WebElement passwordValidationMessage;

    @FindBy(xpath = "//div[@class='returning-wrapper']/div[@class='form-fields']/div[@class='inputs reversed']/input[@id='RememberMe' and @type='checkbox']")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//div[@class='returning-wrapper']/div[@class='form-fields']/div[@class='inputs reversed']/label[@for='RememberMe']")
    private WebElement rememberMeLabel;

    @FindBy(xpath = "//div[@class='returning-wrapper']/div[@class='form-fields']/div[@class='inputs reversed']/span[@class='forgot-password']/a")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement loginButtonElement;

    @FindBy(xpath = "//div[@class='page login-page']/div[@class='page-body']/div[@class='external-authentication']")
    private WebElement externalAuthenticationBlock;

    @FindBy(xpath = "//div[@class='page login-page']/div[@class='page-body']/div[@class='topic-html-content']")
    private WebElement topicHtmlContentBlock;

    @FindBy(xpath = "//div[@class='topic-html-content']/div[@class='topic-html-content-title']/h2[@class='topic-html-content-header']")
    private WebElement aboutLoginRegistrationTitle;

    @FindBy(xpath = "//div[@class='topic-html-content']/div[@class='topic-html-content-body']/p")
    private WebElement aboutLoginRegistrationText;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWaits = new WebDriverWaits(this.driver);
        PageFactory.initElements(this.driver, this);
    }


    public String getPageTitle() {
        return pageTitle.getText();
    }

    public boolean isNewCustomerBlockDisplayed() {
        return newCustomerBlock.isDisplayed();
    }

    public String getNewCustomerTitle() {
        return newCustomerTitle.getText();
    }

    public String getNewCustomerText() {
        return newCustomerText.getText();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public boolean isReturningCustomerBlockDisplayed() {
        return returningCustomerBlock.isDisplayed();
    }

    public String getReturningCustomerTitle() {
        return returningCustomerTitle.getText();
    }

    public boolean isLoginFormDisplayed() {
        return loginForm.isDisplayed();
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    public String getEmailLabelText() {
        return emailLabel.getText();
    }

    public void enterEmail(String email) {
        try {
            webDriverWaits.waitForVisibilityOfElement(emailInput);
            emailInput.sendKeys(email);
        } catch (Exception e) {
//            logger.error(e.getMessage());
            fail("Failed to enter E-mail ID");
        }
    }

    public String getEmailValidationMessage() {
        return emailValidationMessage.getText();
    }

    public String getPasswordLabelText() {
        return passwordLabel.getText();
    }

    public void enterPassword(String password) {
        try {
            webDriverWaits.waitForVisibilityOfElement(passwordInput);
            passwordInput.sendKeys(password);
        } catch (Exception e) {
//            logger.error(e.getMessage());
            fail("Failed to enter Password");
        }
    }

    public String getPasswordValidationMessage() {
        return passwordValidationMessage.getText();
    }

    public void clickRememberMeCheckbox() {
        webDriverWaits.waitForElementToBeClickable(rememberMeCheckbox);
        rememberMeCheckbox.click();
    }

    public boolean isRememberMeCheckboxSelected() {
        return rememberMeCheckbox.isSelected();
    }

    public String getRememberMeLabelText() {
        return rememberMeLabel.getText();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void clickLoginButton() {
        try {
            webDriverWaits.waitForElementToBeClickable(loginButtonElement);
            loginButtonElement.click();
        } catch (Exception e) {
//            logger.info(e.getMessage());
            fail("Failed to click on Log in Button");
        }
    }

    public boolean isExternalAuthenticationBlockDisplayed() {
        return externalAuthenticationBlock.isDisplayed();
    }

    public boolean isTopicHtmlContentBlockDisplayed() {
        return topicHtmlContentBlock.isDisplayed();
    }

    public String getAboutLoginRegistrationTitle() {
        return aboutLoginRegistrationTitle.getText();
    }

    public String getAboutLoginRegistrationText() {
        return aboutLoginRegistrationText.getText();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}