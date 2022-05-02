package com.spartans.step_definitions;

import com.github.javafaker.Faker;
import com.spartans.utils.ConfigurationReader;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test {


    @org.junit.jupiter.api.Test
    public void test1(){
        baseURI = "http://54.197.5.86:7000";
        basePath = "/api/spartans";

        Faker faker = new Faker();

        String username = faker.name().username();
        String password = faker.internet().password();

        given().auth().basic(username, password)
                .and().accept(ContentType.JSON)
                .when().get()
                .then().log().all();
    }

}
