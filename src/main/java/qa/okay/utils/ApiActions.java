package qa.okay.utils;

import io.qameta.allure.Step;
import qa.okay.domain.api.account.UserCredentials;
import qa.okay.domain.api.account.UserDetails;
import qa.okay.domain.api.account.UserLoginDetails;
import qa.okay.domain.api.account.UserToken;
import qa.okay.domain.api.book.CollectionOfIsbn;
import qa.okay.domain.api.book.PostCollection;
import qa.okay.domain.api.book.PostResponse;
import qa.okay.domain.api.book.PutCollection;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.emptyOrNullString;

import static io.restassured.RestAssured.given;
import static qa.okay.utils.PropertyGetter.getProperty;

public class ApiActions {
    private final static String URL = getProperty("home_url");

    @Step(value = "Registering User step")
    public static UserDetails registerUser(UserCredentials user) {
        ApiSpecifications.installSpecification(ApiSpecifications.requestSpec(URL), ApiSpecifications.responseSpecOK201());
        return given()
                .body(user)
                .when()
                .post("Account/v1/User")
                .then().log().all()
                .extract().as(UserDetails.class);
    }

    @Step(value = "Getting Token step")
    public static UserToken getToken(UserCredentials user) {
        ApiSpecifications.installSpecification(ApiSpecifications.requestSpec(URL), ApiSpecifications.responseSpecOK200());
        return given()
                .body(user)
                .when()
                .post("Account/v1/GenerateToken")
                .then().log().all()
                .extract().as(UserToken.class);
    }

    @Step(value = "Logining User step")
    public static UserLoginDetails loginUser(UserCredentials user) {
        ApiSpecifications.installSpecification(ApiSpecifications.requestSpec(URL), ApiSpecifications.responseSpecOK200());
        return given()
                .body(user)
                .when()
                .post("Account/v1/Login")
                .then().log().all()
                .extract().as(UserLoginDetails.class);
    }

    @Step(value = "Getting User step")
    public static UserDetails getUser(UserDetails user, UserToken token) {
        ApiSpecifications.installSpecification(ApiSpecifications.requestSpec(URL), ApiSpecifications.responseSpecOK200());
        return given()
                .header("Authorization", "Bearer " + token.getToken())
                .when()
                .get("Account/v1/User/" + user.getUserId())
                .then().log().all()
                .extract().as(UserDetails.class);
    }

    @Step(value = "Deleting User step")
    public static void deleteUser(UserDetails user, UserToken token) {
        ApiSpecifications.installSpecification(ApiSpecifications.requestSpec(URL), ApiSpecifications.responseSpecOK204());
        given()
                .header("Authorization", "Bearer " + token.getToken())
                .when()
                .delete("Account/v1/User/" + user.getUserId())
                .then().log().all()
                .body(is(emptyOrNullString()));
    }

    @Step(value = "Adding data to User step")
    public static PostResponse addCollectionOfIsbnToUser(UserDetails userDetails, ArrayList<CollectionOfIsbn> collectionOfIsbns, UserToken token) {
        ApiSpecifications.installSpecification(ApiSpecifications.requestSpec(URL), ApiSpecifications.responseSpecOK201());
        PostCollection postCollection = new PostCollection(userDetails.getUserId(), collectionOfIsbns);
        return given()
                .header("Authorization", "Bearer " + token.getToken())
                .body(postCollection)
                .when()
                .post("BookStore/v1/Books")
                .then().log().all()
                .extract().as(PostResponse.class);
    }

    @Step(value = "Updating User step")
    public static UserDetails putCollectionOfIsbn(UserDetails userDetails, String isbn, UserToken token) {
        ApiSpecifications.installSpecification(ApiSpecifications.requestSpec(URL), ApiSpecifications.responseSpecOK200());
        PutCollection putCollection = new PutCollection(userDetails.getUserId(), isbn);
        return given()
                .header("Authorization", "Bearer " + token.getToken())
                .body(putCollection)
                .when()
                .put("BookStore/v1/Books/" + userDetails.getBooks().get(0).getIsbn())
                .then().log().all()
                .extract().as(UserDetails.class);
    }
}
