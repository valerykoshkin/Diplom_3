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
import static ru.yandex.praktikum.config.helpers.AppConfig.APP_MAIN_PAGE_URL;

public class MainPageTests extends BaseTest {
    String accessToken;

    @Test
    @DisplayName("Переход на секцию 'Соусы'")
    public void getSauceSectionTest() {

        MainPage mainPage = new MainPage(driver);

        new WebDriverWait(driver, ofSeconds(2))
                .until(urlMatches(APP_MAIN_PAGE_URL));

        mainPage.checkSaucesSection();
    }

    @Test
    @DisplayName("Переход на секцию 'Начинки'")
    public void getFillsSectionTest() {

        MainPage mainPage = new MainPage(driver);

        new WebDriverWait(driver, ofSeconds(2))
                .until(urlMatches(APP_MAIN_PAGE_URL));

        mainPage.checkFillsSection();
    }

    @Test
    @DisplayName("Переход на секцию 'Булки'")
    public void switchBunsSectionTest() {

        MainPage mainPage = new MainPage(driver);

        new WebDriverWait(driver, ofSeconds(2))
                .until(urlMatches(APP_MAIN_PAGE_URL));

        //Кликам на 'соусы', т.к. по дефолту открывается страница на секции 'булки'
        mainPage.checkSaucesSection();
        mainPage.checkBunsSection();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void successGoToLKTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        creds = getUserCreds();

        mainPage.goToAccountClick();
        loginPage.loginUser(getUserEmail(creds), getUserPassword(creds));
        mainPage.accountButtonClick();
        LKPage lkPage = new LKPage(driver);
        lkPage.checkAccountsData(getUserName(creds), getUserEmail(creds));
        accessToken = getAccessToken();
    }

    @After
    public void deleteUser() {
        if (accessToken != null) {
            client.deleteUser(accessToken);
        }
    }
}