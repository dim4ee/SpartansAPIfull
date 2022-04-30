package com.spartans.step_definitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GETrequest {

    @Given("send get request")
    public void send_get_request() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().auth().basic("user", "user")
                .when().get("http://54.197.5.86:7000/api/spartans")
                .then().statusCode(200).extract().response();

        response.body().prettyPrint();
    }
}
