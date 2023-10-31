package ru.yandex.praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.config.helpers.BaseTest;
import ru.yandex.praktikum.pages.LKPage;
import ru.yandex.praktikum.pages.LoginPage;
import ru.yandex.praktikum.pages.MainPage;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;
import static ru.yandex.praktikum.config.helpers.AppConfig.*;

public class LKTests extends BaseTest {
    String accessToken;

    @Test
    @DisplayName("Переход по клику на 'конструктор'")
    public void successTrasferViaConstructorButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        LKPage lkpage = new LKPage(driver);

        creds = getUserCreds();

        loginPage.loginUser(getUserEmail(creds), getUserPassword(creds));
        mainPage.accountButtonClick();
        lkpage.clickConstructorButton();
        mainPage.checkMainHeader();
        accessToken = getAccessToken();
    }

    @Test
    @DisplayName("Переход по клику на логотип 'Stellar burger'")
    public void successTransferViaLogoButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        LKPage lkpage = new LKPage(driver);

        creds = getUserCreds();

        loginPage.loginUser(getUserEmail(creds), getUserPassword(creds));
        mainPage.accountButtonClick();
        lkpage.clicklogoButton();
        mainPage.checkMainHeader();
        accessToken = getAccessToken();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void SuccessExitFromAccount() {
        MainPage mainPage = new MainPage(driver);
        LKPage lkPage = new LKPage(driver);

        creds = getUserCreds();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(getUserEmail(creds), getUserPassword(creds));

        new WebDriverWait(driver, ofSeconds(5))
                .until(urlMatches(APP_MAIN_PAGE_URL));

        mainPage.accountButtonClick();
        new WebDriverWait(driver, ofSeconds(5))
                .until(urlMatches(APP_LK_PAGE_URL));
        accessToken = getAccessToken();
        lkPage.clickExitButton();
        loginPage.checkEnterHeader();
    }

    @After
    public void deleteUser() {
        if (accessToken != null) {
            client.deleteUser(accessToken);
        }
    }
}