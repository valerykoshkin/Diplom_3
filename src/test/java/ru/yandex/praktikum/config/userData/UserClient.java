package ru.yandex.praktikum.config.userData;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UserClient {
    private final String USER_API = "api/auth";

    public ValidatableResponse createUser(User user){
        return given().log().all()
                .contentType(JSON)
                .and()
                .body(user)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/register")
                .then().log().all();

    }

    public ValidatableResponse logIn(Credentials creds) {
        return given().log().all()
                .contentType(JSON)
                .body(creds)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/register")
                .then().log().all();
    }

    public ValidatableResponse deleteUser(String token){
        return given().log().all()
                .auth().oauth2(token)
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then().log().all();
    }
}
