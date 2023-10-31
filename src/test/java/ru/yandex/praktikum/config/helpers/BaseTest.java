package ru.yandex.praktikum.config.helpers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import ru.yandex.praktikum.config.userdata.Credentials;
import ru.yandex.praktikum.config.userdata.User;
import ru.yandex.praktikum.config.userdata.UserClient;
import ru.yandex.praktikum.config.userdata.UserGenerator;

import static io.restassured.RestAssured.baseURI;
import static ru.yandex.praktikum.config.helpers.AppConfig.APP_MAIN_PAGE_URL;

public class BaseTest {
    public WebDriver driver;
    String CHROME = "chrome";
    String YANDEX = "yandex";

    public User user;
    public Credentials creds;
    private final UserGenerator generator = new UserGenerator();
    public final UserClient client = new UserClient();

    public Credentials getUserCreds() {
        user = generator.random();
        client.createUser(user);
        return creds = Credentials.from(user);
    }

    public String getUserName(Credentials creds) {
        return creds.getName();
    }

    public String getUserEmail(Credentials creds) {
        return creds.getEmail();
    }

    public String getUserPassword(Credentials creds) {
        return creds.getPassword();
    }

    public String getAccessToken() {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        return localStorage.getItem("accessToken").substring(7);
    }

    @Before
    public void init() {
        baseURI = "https://stellarburgers.nomoreparties.site";
        driver = WebDriverFactory.createWebDriver();
        driver.get(APP_MAIN_PAGE_URL);

    }

    @After
    public void close() {
        driver.quit();
    }
}