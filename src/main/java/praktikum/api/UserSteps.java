package praktikum.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_OK;

public class UserSteps {

    @Step("Создать пользователя")
    public static ValidatableResponse createUserStep(UserModel user) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(EndPoints.USER_REGISTER_PATH)
                .then().log().all()
                .statusCode(HTTP_OK);
    }

    @Step("Удалить пользователя")
    public static ValidatableResponse deletedUserStep(String accessToken) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .when()
                .delete(EndPoints.USER_OPTIONS_DEL_PATH)
                .then().log().all()
                .statusCode(HTTP_ACCEPTED);
    }

    @Step("Залогинить пользователя")
    public static ValidatableResponse loginUserStep(UserModel user) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(EndPoints.USER_LOGIN_PATH)
                .then().log().all()
                .statusCode(HTTP_OK);
    }

    @Step("Залогинить и удалить пользователя")
    public static void regAndDelUser(UserModel user){
        String accessToken;
        accessToken = loginUserStep(user)
                .extract().path("accessToken");
        if (accessToken != null) {
            deletedUserStep(accessToken);
        }
    }

}
