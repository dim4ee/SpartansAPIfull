package com.spartans.utils;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartanTestBase {


    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://54.197.5.86:7000";
    }

}
