package com.spartans.utils;

import com.github.javafaker.Faker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class SpartanUtils extends Base {

    public static void userLogin(){
        String username = ConfigurationReader.getProperty("user_username");
        String password = ConfigurationReader.getProperty("user_password");

        requestSpecification.given().auth().basic(username,password);
    }

    public static void editorLogin(){
        String username = ConfigurationReader.getProperty("editor_username");
        String password = ConfigurationReader.getProperty("editor_password");

        requestSpecification.given().auth().basic(username,password);
    }

    public static void adminLogin(){
        String username = ConfigurationReader.getProperty("admin_username");
        String password = ConfigurationReader.getProperty("admin_password");

        requestSpecification.given().auth().basic(username,password);
    }

    public static void invalidLogin(){
        Faker faker = new Faker();

        String username = faker.name().username();
        String password = faker.internet().password();

        requestSpecification.given().auth().basic(username,password);
    }
}
