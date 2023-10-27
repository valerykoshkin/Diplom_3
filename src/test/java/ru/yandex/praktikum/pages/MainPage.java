package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;
import static ru.yandex.praktikum.config.helpers.AppConfig.APP_LK_PAGE_URL;
import static ru.yandex.praktikum.config.helpers.AppConfig.APP_MAIN_PAGE_URL;


public class MainPage {
    WebDriver driver;

    private final String AWAITING_CLASS = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

    //Кнопка "войти"
    private final By goToAccount = By.className("button_button__33qZ0");

    //Кнопка "Личный кабинет"
    private final By lkButton = By.xpath(".//nav/a");

    //Кнопка "Начинки"
    private final By fillsButton = By.xpath(".//div/span[text()='Начинки']/..");

    //Кнопка "Соусы"
    private final By sausesButton = By.xpath(".//div/span[text()='Соусы']/..");

    //Кнопка "Булки"
    private final By bunsButton = By.xpath(".//div/span[text()='Булки']/..");

    //Заголовок "Соберите бургер"
    private final By mainHeader = By.xpath(".//h1[text()='Соберите бургер']");

    public MainPage(WebDriver webDriver) {
        this.driver = webDriver;
        webDriver.get(APP_MAIN_PAGE_URL);
    }

    //Клик по кнопке "Личный кабинет"
    public void accountButtonClick() {
        driver.findElement(lkButton).click();
        new WebDriverWait(driver, ofSeconds(5))
                .until(urlMatches(APP_LK_PAGE_URL));
    }

    //Клик по кнопке "Войти"
    public void goToAccountClick() {
        driver.findElement(goToAccount).click();
    }

    //Клик по кнопке "Начинки"
    public void clickFillsButton() {
        driver.findElement(fillsButton).click();
    }

    //Клик по кнопке "Соусы"
    public void clickSaucesButton() {
        driver.findElement(sausesButton).click();
    }

    //Клик по кнопке "Булки"
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }

    //Проверка секции "Начинки"
    public void checkFillsSection() {
        clickFillsButton();
        new WebDriverWait(driver, ofSeconds(5))
                .until(attributeToBe(fillsButton, "class", AWAITING_CLASS));
    }

    //Проверка секции "Соусы"
    public void checkSaucesSection() {
        clickSaucesButton();
        new WebDriverWait(driver, ofSeconds(5))
                .until(attributeToBe(sausesButton, "class", AWAITING_CLASS));
    }

    //Проверка секции "Булки"
    public void checkBunsSection() {
        clickBunsButton();
        new WebDriverWait(driver, ofSeconds(5))
                .until(attributeToBe(bunsButton, "class", AWAITING_CLASS));
    }

    //Проверка залоговка "Соберите бургер"
    public void checkMainHeader() {
        boolean isDisplayed = driver.findElement(mainHeader).isDisplayed();
        assertTrue(isDisplayed);
    }
}