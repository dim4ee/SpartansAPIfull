package com.spartans.step_definitions;

import com.github.javafaker.Faker;
import com.spartans.utils.ConfigurationReader;
import com.spartans.utils.DBUtils;
import com.spartans.utils.Spartan;
import com.spartans.utils.SpartanUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Test {


    @org.junit.jupiter.api.Test
    public void test1(){

        baseURI = "http://54.197.5.86:7000";
        basePath = "/api/spartans";

        String username = ConfigurationReader.getProperty("admin_username");
        String password = ConfigurationReader.getProperty("admin_password");



        Spartan spartan = given().accept(ContentType.JSON)
                .and().auth().basic(username,
                        password)
                .and().pathParam("id",7)
                .when().get("/{id}")
                .then().extract().jsonPath().getObject("",Spartan.class);

        System.out.println(spartan);


        DBUtils.createConnection();
        String query = "select NAME,GENDER,PHONE from SPARTANS where SPARTAN_ID=7";
        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        System.out.println(rowMap);

        Spartan spartan1 = new Spartan();
        spartan1.setName(rowMap.get("NAME").toString());
        spartan1.setGender(rowMap.get("GENDER").toString());
        spartan1.setPhone(Long.parseLong(rowMap.get("PHONE").toString()));

        System.out.println(spartan1);

        given().accept(ContentType.JSON)
                .and().auth().basic(username,
                        password)
                .and().pathParam("id",7)
                .body(spartan1)
                .contentType(ContentType.JSON)
                .when().put("/{id}")
                .then().log().all();




    }

}
