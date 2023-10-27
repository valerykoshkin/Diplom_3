package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;
import static ru.yandex.praktikum.config.helpers.AppConfig.APP_LOGIN_PAGE_URL;
import static ru.yandex.praktikum.config.helpers.AppConfig.APP_MAIN_PAGE_URL;

public class LKPage {
    WebDriver driver;

    public LKPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле "Имя"
    private final By nameField = By.xpath(".//ul[@class='Profile_profileList__3vTor']/li[1]/div/div/input");

    //Поле "Логин"
    private final By emailField = By.xpath(".//ul[@class='Profile_profileList__3vTor']/li[2]/div/div/input");

    //Кнопка логотип "Stellar burger"
    private final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");

    //Кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//nav[@class = 'AppHeader_header__nav__g5hnF']/ul/li[1]/a");

    //Кнопка "Выход"
    private final By exitButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    //Клик по логотипу
    public void clicklogoButton() {
        driver.findElement(logoButton).click();
        new WebDriverWait(driver, ofSeconds(5))
                .until(urlMatches(APP_MAIN_PAGE_URL));
    }

    //Клик по кнопке "Конструктор"
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
        new WebDriverWait(driver, ofSeconds(5))
                .until(urlMatches(APP_MAIN_PAGE_URL));
    }

    //Клик по кнопке "Выход"
    public void clickExitButton() {
        driver.findElement(exitButton).click();
        new WebDriverWait(driver, ofSeconds(5))
                .until(urlMatches(APP_LOGIN_PAGE_URL));
    }

    //Ожидание загрузки страницы с данными
    public void waitUntilAccountDetails() {
        new WebDriverWait(driver, ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
    }

    //Получение имени пользователя
    public String getName() {
        return driver.findElement(nameField).getAttribute("value");
    }

    //Получение логина пользователя
    public String getEmail() {
        return driver.findElement(emailField).getAttribute("value");
    }

    //Проверка данных пользователя
    public void checkAccountsData(String name, String email) {
        waitUntilAccountDetails();
        String formattedEmail = email.toLowerCase(Locale.ROOT);

        assertEquals(formattedEmail, getEmail());
        assertEquals(name, getName());
    }
}