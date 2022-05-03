package com.spartans.utils;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteSpartan {


    public static void deleteSpartan(int id){
//        baseURI = "http://54.197.5.86:7000";
//        basePath = "/api/spartans";


        String username = ConfigurationReader.getProperty("admin_username");
        String password = ConfigurationReader.getProperty("admin_password");

        given().accept(ContentType.JSON)
                .and().auth().basic(username,password)
                .and().pathParam("id", id)
                .when().delete("/{id}");
    }

}
