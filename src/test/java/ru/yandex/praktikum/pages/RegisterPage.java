package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;
import static ru.yandex.praktikum.config.helpers.AppConfig.APP_REGISTER_PAGE_URL;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        driver.get(APP_REGISTER_PAGE_URL);
    }

    //Инпут "Имя"
    private final By nameInput = By.xpath(".//form/fieldset[1]/div/div/input");

    //Инпут "Email"
    private final By emailInput = By.xpath(".//form/fieldset[2]/div/div/input");

    //Инпут "Пароль"
    private final By passwordInput = By.xpath(".//form/fieldset[3]/div/div/input");

    //Кнопка "Зарегистрироваться"
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");

    //Кнопка "Войти"
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    //Сообщение об ошибке
    private final By error = By.xpath(".//form/fieldset[3]/div/p");

    //Регистрация пользователя
    public void userRegistration(String name, String email, String password){
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(registrationButton).click();
        new WebDriverWait(driver, ofSeconds(5))
                .until(urlMatches(APP_REGISTER_PAGE_URL));
    }

    //Проверка сообщения об ошибке
    public void checkError(){
        driver.findElement(error).isDisplayed();
    }

    //Клик по кнопке "Войти"
    public void loginButtonClick(){
        driver.findElement(loginButton).click();
    }
}