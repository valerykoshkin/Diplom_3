package ru.yandex.praktikum.config.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    static WebDriver driver;

    public static WebDriver getBrowser(String browserName) {

        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                return driver;
            case "yandex":

                System.setProperty("webdriver.chrome.driver", "C:\\Users\\drPepper92\\Diplom\\Diplom_3\\src\\main\\resources\\WebDriver\\bin\\yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\drPepper92\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                driver = new ChromeDriver(options);
                return driver;
            default:
                throw new RuntimeException("Browser not found");
        }
    }
}