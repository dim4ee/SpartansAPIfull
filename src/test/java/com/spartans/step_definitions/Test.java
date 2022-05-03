package com.spartans.step_definitions;

import com.github.javafaker.Faker;
import com.spartans.utils.ConfigurationReader;
import com.spartans.utils.Spartan;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Test {


    @org.junit.jupiter.api.Test
    public void test1(){
        baseURI = "http://54.197.5.86:7000";
        basePath = "/api/spartans";


        String username = ConfigurationReader.getProperty("admin_username");
        String password = ConfigurationReader.getProperty("admin_password");

        RequestSpecification requestSpecification = given().accept(ContentType.JSON);

        requestSpecification.and().auth().basic(username,password);

        Response response = requestSpecification.get();

        response.prettyPrint();


    }

}
