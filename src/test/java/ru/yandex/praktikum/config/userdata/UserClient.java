package ru.yandex.praktikum.config.userdata;

import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UserClient {
    private final String API_AUTH_REGISTER = "api/auth/register";
    private final String API_AUTH_USER = "api/auth/user";

    public ValidatableResponse createUser(User user){
        return given().log().all()
                .contentType(JSON)
                .and()
                .body(user)
                .when()
                .post(API_AUTH_REGISTER)
                .then().log().all();

    }

    public ValidatableResponse logIn(Credentials creds) {
        return given().log().all()
                .contentType(JSON)
                .body(creds)
                .when()
                .post(API_AUTH_REGISTER)
                .then().log().all();
    }

    public ValidatableResponse deleteUser(String token){
        return given().log().all()
                .auth().oauth2(token)
                .when()
                .delete(API_AUTH_USER)
                .then().log().all();
    }
}
