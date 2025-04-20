package com.demo.ecommerce.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverManagers {

    private WebDriver driver;
    private Properties configProp;
    private FileInputStream propFilePath;
    private String browser;

    private String getProperties(String propertyName) throws IOException {
        configProp= new Properties();
        propFilePath = new FileInputStream("config.properties");
        configProp.load(propFilePath);
        return configProp.getProperty(propertyName);
    }

    public WebDriver initializeDriver() throws IOException {
        browser = getProperties("browser");
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}