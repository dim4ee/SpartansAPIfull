package com.spartans.utils;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class SpartanUtils extends Base {

    public static void userLogin() {
        String username = ConfigurationReader.getProperty("user_username");
        String password = ConfigurationReader.getProperty("user_password");

        requestSpecification.given().auth().basic(username, password);
    }

    public static void editorLogin() {
        String username = ConfigurationReader.getProperty("editor_username");
        String password = ConfigurationReader.getProperty("editor_password");

        requestSpecification.given().auth().basic(username, password);
    }

    public static void adminLogin() {
        String username = ConfigurationReader.getProperty("admin_username");
        String password = ConfigurationReader.getProperty("admin_password");

        requestSpecification.given().auth().basic(username, password);
    }

    public static void invalidLogin() {
        Faker faker = new Faker();

        String username = faker.name().username();
        String password = faker.internet().password();

        requestSpecification.given().auth().basic(username, password);
    }

    public static int id(String path) {

        int id = 0;

        Faker faker = new Faker();

        baseURI = "http://54.197.5.86:7000";
        basePath = "/api/spartans";

        String username = ConfigurationReader.getProperty("admin_username");
        String password = ConfigurationReader.getProperty("admin_password");

        Response response = given().accept(ContentType.JSON)
                .auth().basic(username, password)
                .when().get();

        List<Map<String, Object>> allSpartans = response.as(List.class);

        int maxId = (int) allSpartans.get(allSpartans.size() - 1).get("id");

        if (path.equalsIgnoreCase("valid")) {
            int randomValidId = faker.number().numberBetween(1, maxId);
            id = randomValidId;

        } else if (path.equalsIgnoreCase("invalid")) {
            int randomInvalidId = faker.number().numberBetween(maxId, maxId + 100);
            id = randomInvalidId;

        }

        return id;
    }

    public static Spartan requestBody(String body) {

        Spartan spartan = new Spartan();
        Faker faker = new Faker();
        String name = faker.name().name();

        if (body.equalsIgnoreCase("valid")) {

            baseURI = "http://54.197.5.86:7000";
            basePath = "/api/spartans";

            String username = ConfigurationReader.getProperty("admin_username");
            String password = ConfigurationReader.getProperty("admin_password");

            Response response = given().accept(ContentType.JSON)
                    .auth().basic(username, password)
                    .pathParam("id", SpartanUtils.id("valid"))
                    .when().get("/{id}");

            Spartan validSpartan = response.as(Spartan.class);

        } else if (body.equalsIgnoreCase("invalid")) {

            spartan.setGender(faker.options().option("Man", "Women"));
            spartan.setName(name);
            spartan.setPhone(Long.parseLong(faker.number().digits(8)));

        }

        return spartan;
    }

    public static Spartan getSpartanById(int id){
        baseURI = "http://54.197.5.86:7000";
        basePath = "/api/spartans";

        String username = ConfigurationReader.getProperty("user_username");
        String password = ConfigurationReader.getProperty("user_password");


        Spartan spartan = given().accept(ContentType.JSON)
                .and().auth().basic(username,
                        password)
                .and().pathParam("id",id)
                .when().get("/{id}")
                .then().extract().jsonPath().getObject("",Spartan.class);

        return spartan;
    }

    public static void updateSpartanInfo(Spartan spartan,int id){
        baseURI = "http://54.197.5.86:7000";
        basePath = "/api/spartans";

        String username = ConfigurationReader.getProperty("admin_username");
        String password = ConfigurationReader.getProperty("admin_password");

        given().accept(ContentType.JSON)
                .and().auth().basic(username,password)
                .and().pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(spartan)
                .when().put("/{id}");
    }

}
