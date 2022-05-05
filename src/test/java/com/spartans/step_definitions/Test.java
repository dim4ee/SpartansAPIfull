package com.spartans.step_definitions;

import com.github.javafaker.Faker;
import com.spartans.utils.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Test {


    @org.junit.jupiter.api.Test
    public void test1(){


        Spartan spartan = GenerateSpartan.generateSparta();


        baseURI = "http://54.197.5.86:7000";
        basePath = "/api/spartans";

        String username = ConfigurationReader.getProperty("admin_username");
        String password = ConfigurationReader.getProperty("admin_password");

        spartan = given().accept(ContentType.JSON)
                .and().auth().basic(username, password)
                .contentType(ContentType.JSON)
                .body(spartan)
                .when().post()
                .then().extract().jsonPath().getObject("data",Spartan.class);


        int id = spartan.getId();

        System.out.println(id);


    }

}
