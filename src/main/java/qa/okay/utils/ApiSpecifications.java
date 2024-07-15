package qa.okay.utils;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiSpecifications {

    @Step(value = "Installing base URL and Content Type header sub-step")
    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    @Step(value = "Installing expected status code of response=200 sub-step")
    public static ResponseSpecification responseSpecOK200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    @Step(value = "Installing expected status code of response=201 sub-step")
    public static ResponseSpecification responseSpecOK201() {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }

    @Step(value = "Installing expected status code of response=204 sub-step")
    public static ResponseSpecification responseSpecOK204() {
        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }

    @Step(value = "Installing expected status code of response=404 sub-step")
    public static ResponseSpecification responseSpecError404() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }

    @Step(value = "Installing API specifications step")
    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
