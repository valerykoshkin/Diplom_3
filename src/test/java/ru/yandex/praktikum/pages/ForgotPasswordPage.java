package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.yandex.praktikum.config.helpers.AppConfig.APP_PASSWORD_PAGE_URL;

public class ForgotPasswordPage {
    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        driver.get(APP_PASSWORD_PAGE_URL);
    }

    //Кнопка "Войти"
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    //Клик по кнопке "Войти"
    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }
}