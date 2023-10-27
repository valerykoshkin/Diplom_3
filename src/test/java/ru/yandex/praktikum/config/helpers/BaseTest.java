package ru.yandex.praktikum.config.helpers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.config.userData.Credentials;
import ru.yandex.praktikum.config.userData.User;
import ru.yandex.praktikum.config.userData.UserClient;
import ru.yandex.praktikum.config.userData.UserGenerator;

import static ru.yandex.praktikum.config.helpers.AppConfig.APP_MAIN_PAGE_URL;

public class BaseTest {
    public WebDriver driver;
    String CHROME = "chrome";
    String YANDEX = "yandex";
    String token;

    public User user;
    public Credentials creds;
    private final UserGenerator generator = new UserGenerator();
    private final UserClient client = new UserClient();

    public Credentials getUserCreds() {
        user = generator.random();
        token = client.createUser(user).toString();
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

    @Before
    public void init() {
        driver = WebDriverFactory.getBrowser(CHROME);
        driver.get(APP_MAIN_PAGE_URL);

    }

    @After
    public void close() {
        driver.quit();
    }
}