package ru.yandex.praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.config.helpers.BaseTest;
import ru.yandex.praktikum.pages.LKPage;
import ru.yandex.praktikum.pages.LoginPage;
import ru.yandex.praktikum.pages.MainPage;
import ru.yandex.praktikum.pages.RegisterPage;

import static java.time.Duration.ofSeconds;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;
import static ru.yandex.praktikum.config.helpers.AppConfig.APP_LOGIN_PAGE_URL;

public class RegistrationTests extends BaseTest {
    private final String NAME = randomAlphanumeric(5, 10);
    private final String EMAIL = randomAlphanumeric(5, 10) + "@yandex.ru";
    private final String PASSWORD = randomAlphanumeric(6, 10);
    private final String INCORRECT_PASSWORD = randomAlphanumeric(3, 5);

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void successRegistrationTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.accountButtonClick();
        loginPage.registrationLinkClick();

        registerPage.userRegistration(NAME, EMAIL, PASSWORD);
        new WebDriverWait(driver, ofSeconds(5))
                .until(urlMatches(APP_LOGIN_PAGE_URL));
        loginPage.loginUser(EMAIL, PASSWORD);

        mainPage.accountButtonClick();
        LKPage lkPage = new LKPage(driver);
        lkPage.checkAccountsData(NAME, EMAIL);
    }

    @Test
    @DisplayName("Регистрация пользователя с некорректным паролем")
    public void failedRegistratonTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.accountButtonClick();
        loginPage.registrationLinkClick();
        registerPage.userRegistration(NAME, EMAIL, INCORRECT_PASSWORD);
        registerPage.checkError();
    }
}