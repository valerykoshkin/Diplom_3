package ru.yandex.praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.config.helpers.BaseTest;
import ru.yandex.praktikum.config.userData.Credentials;
import ru.yandex.praktikum.pages.*;


public class LoginTests extends BaseTest {
    Credentials creds;

    @Test
    @DisplayName("Вход по кнопке 'войти в аккаунт'")
    public void successLoginViaGoToAccountButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        creds = getUserCreds();
        mainPage.goToAccountClick();
        loginPage.loginUser(getUserEmail(creds), getUserPassword(creds));
        mainPage.accountButtonClick();
        LKPage lkPage = new LKPage(driver);
        lkPage.checkAccountsData(getUserName(creds), getUserEmail(creds));
    }

    @Test
    @DisplayName("Вход по кнопке 'личный кабинет'")
    public void successLoginViaAccountButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        creds = getUserCreds();

        mainPage.accountButtonClick();
        loginPage.loginUser(getUserEmail(creds), getUserPassword(creds));
        mainPage.accountButtonClick();
        LKPage lkPage = new LKPage(driver);
        lkPage.checkAccountsData(getUserName(creds), getUserEmail(creds));
    }

    @Test
    @DisplayName("Вход по кнопке в форме регистрации")
    public void successLoginViaRegPageTest() {
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        creds = getUserCreds();

        registerPage.loginButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(getUserEmail(creds), getUserPassword(creds));
        mainPage.accountButtonClick();
        LKPage lkPage = new LKPage(driver);
        lkPage.checkAccountsData(getUserName(creds), getUserEmail(creds));
    }

    @Test
    @DisplayName("Вход по кнопке в форме восстновления пароля")
    public void successLoginViaRestorePasswordTest() {
        MainPage mainPage = new MainPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        creds = getUserCreds();

        forgotPasswordPage.loginButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(getUserEmail(creds), getUserPassword(creds));

        mainPage.accountButtonClick();
        LKPage lkPage = new LKPage(driver);
        lkPage.checkAccountsData(getUserName(creds), getUserEmail(creds));
    }
}