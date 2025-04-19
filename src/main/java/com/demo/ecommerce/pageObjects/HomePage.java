package com.demo.ecommerce.pageObjects;

import com.demo.ecommerce.utils.WebDriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    private WebDriver driver;
    private WebDriverWaits webDriverWaits;

    @FindBy(className = "header")
    private WebElement headerContainer;

    @FindBy(className = "header-logo")
    private WebElement logoContainer;

    @FindBy(xpath = "//div[@class='header-logo']/a")
    private WebElement logoLink;

    @FindBy(xpath = "//div[@class='header-logo']/a/img")
    private WebElement logoImage;

    @FindBy(className = "header-links-wrapper")
    private WebElement headerLinksWrapper;

    @FindBy(className = "header-links")
    private WebElement headerLinks;

    @FindBy(xpath = "//div[@class='header-links']/ul/li/a[@class='account']")
    private WebElement accountLink;

    @FindBy(xpath = "//div[@class='header-links']/ul/li/a[@class='ico-logout']")
    private WebElement logoutLink;

    @FindBy(id = "topcartlink")
    private WebElement shoppingCartLinkContainer;

    @FindBy(xpath = "//li[@id='topcartlink']/a[@class='ico-cart']")
    private WebElement shoppingCartLink;

    @FindBy(xpath = "//li[@id='topcartlink']/a[@class='ico-cart']/span[@class='cart-label']")
    private WebElement shoppingCartLabel;

    @FindBy(xpath = "//li[@id='topcartlink']/a[@class='ico-cart']/span[@class='cart-qty']")
    private WebElement shoppingCartQuantity;

    @FindBy(xpath = "//div[@class='header-links']/ul/li/a[@class='ico-wishlist']")
    private WebElement wishlistLink;

    @FindBy(xpath = "//div[@class='header-links']/ul/li/a[@class='ico-wishlist']/span[@class='cart-label']")
    private WebElement wishlistLabel;

    @FindBy(xpath = "//div[@class='header-links']/ul/li/a[@class='ico-wishlist']/span[@class='wishlist-qty']")
    private WebElement wishlistQuantity;

    @FindBy(id = "flyout-cart")
    private WebElement flyoutCart;

    @FindBy(xpath = "//div[@id='flyout-cart']/div[@class='mini-shopping-cart']/div[@class='count']")
    private WebElement flyoutCartCount;

    @FindBy(className = "search-box")
    private WebElement searchBoxContainer;

    @FindBy(xpath = "//form[@action='/search' and @method='get']/input[@id='small-searchterms']")
    private WebElement searchBoxInput;

    @FindBy(xpath = "//form[@action='/search' and @method='get']/input[@class='button-1 search-box-button']")
    private WebElement searchBoxButton;

    @FindBy(className = "header-selectors-wrapper")
    private WebElement headerSelectorsWrapper;

    @FindBy(className = "tax-display-type-selector")
    private WebElement taxDisplaySelector;

    @FindBy(className = "currency-selector")
    private WebElement currencySelector;

    @FindBy(className = "language-selector")
    private WebElement languageSelector;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWaits = new WebDriverWaits(this.driver);
        PageFactory.initElements(this.driver, this);
    }


    public boolean isHeaderDisplayed() {
        return headerContainer.isDisplayed();
    }

    public boolean isLogoDisplayed() {
        return logoContainer.isDisplayed();
    }

    public void clickLogo() {
        logoLink.click();
    }

    public String getLogoAltText() {
        return logoImage.getAttribute("alt");
    }

    public String getLogoSrc() {
        return logoImage.getAttribute("src");
    }

    public boolean isAccountLinkDisplayed() {
        return accountLink.isDisplayed();
    }

    public void clickAccountLink() {
        accountLink.click();
    }

    public String getAccountEmail() {
        return accountLink.getText();
    }

    public boolean isLogoutLinkDisplayed() {
        try {
            webDriverWaits.waitForVisibilityOfElement(logoutLink);
            return logoutLink.isDisplayed();
        } catch (Exception e) {
//            logger.error(e.getMessage());
            return false;
        }
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public boolean isShoppingCartLinkDisplayed() {
        return shoppingCartLinkContainer.isDisplayed();
    }

    public void clickShoppingCartLink() {
        shoppingCartLink.click();
    }

    public String getShoppingCartLabelText() {
        return shoppingCartLabel.getText();
    }

    public String getShoppingCartQuantity() {
        return shoppingCartQuantity.getText();
    }

    public boolean isWishlistLinkDisplayed() {
        return wishlistLink.isDisplayed();
    }

    public void clickWishlistLink() {
        wishlistLink.click();
    }

    public String getWishlistLabelText() {
        return wishlistLabel.getText();
    }

    public String getWishlistQuantity() {
        return wishlistQuantity.getText();
    }

    public boolean isFlyoutCartDisplayed() {
        return flyoutCart.isDisplayed();
    }

    public String getFlyoutCartText() {
        return flyoutCartCount.getText();
    }

    public boolean isSearchBoxDisplayed() {
        return searchBoxContainer.isDisplayed();
    }

    public void enterSearchTerm(String searchTerm) {
        searchBoxInput.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        searchBoxButton.click();
    }

    public boolean isTaxDisplaySelectorDisplayed() {
        return taxDisplaySelector.isDisplayed();
    }

    public boolean isCurrencySelectorDisplayed() {
        return currencySelector.isDisplayed();
    }

    public boolean isLanguageSelectorDisplayed() {
        return languageSelector.isDisplayed();
    }


}