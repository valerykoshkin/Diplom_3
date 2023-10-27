package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;
import static ru.yandex.praktikum.config.helpers.AppConfig.APP_LOGIN_PAGE_URL;
import static ru.yandex.praktikum.config.helpers.AppConfig.APP_MAIN_PAGE_URL;

public class LoginPage {
    WebDriver driver;

    //Поле email
    private final By emailInput = By.xpath(".//form/fieldset[1]/div/div/input");

    //Поле пароль
    private final By passwordInput = By.xpath(".//form/fieldset[2]/div/div/input");

    //Кнопка войти
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    //Кнопка "Зарегистрироваться"
    private final By registrationLink = By.xpath(".//a[text()='Зарегистрироваться']");

    //Кнопка "Вход"
    private final By enterHeader = By.xpath(".//h2[text()='Вход']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        driver.get(APP_LOGIN_PAGE_URL);
    }

    //Логин пользователя
    public void  loginUser(String email, String password){
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        new WebDriverWait(driver, ofSeconds(5))
                .until(urlMatches(APP_MAIN_PAGE_URL));
    }

    //Клик по кнопке регистрации
    public void registrationLinkClick(){
        driver.findElement(registrationLink).click();
    }

    //Проверка заголовка на странице логина
    public void checkEnterHeader(){
        boolean isDisplayed = driver.findElement(enterHeader).isDisplayed();
        assertTrue(isDisplayed);
    }
}