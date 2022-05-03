package com.spartans.step_definitions;

import com.github.javafaker.Faker;
import com.spartans.utils.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Create_new_Spartan_step_definitions extends Base {



    @When("send POST request using editor credentials with valid request body")
    public void send_post_request_using_editor_credentials_with_valid_request_body() {
        String username = ConfigurationReader.getProperty("editor_username");
        String password = ConfigurationReader.getProperty("editor_password");


        response = given().accept(ContentType.JSON)
                .and().auth().basic(username, password)
                .and().contentType(ContentType.JSON)
                .and().body(GenerateSpartan.generateSparta())
                .when().post();

        DeleteSpartan.deleteSpartan(response.jsonPath().getInt("data.id"));


    }
    @Then("response body should contain {string}")
    public void response_body_should_contain(String confirmationMassage) {

        assertThat(response.jsonPath().getString("success"),is(confirmationMassage));

    }

    @When("send POST request using admin credentials with valid request body")
    public void sendPOSTRequestUsingAdminCredentialsWithValidRequestBody() {
        String username = ConfigurationReader.getProperty("admin_username");
        String password = ConfigurationReader.getProperty("admin_password");


        response = given().accept(ContentType.JSON)
                .and().auth().basic(username, password)
                .and().contentType(ContentType.JSON)
                .and().body(GenerateSpartan.generateSparta())
                .when().post();

        DeleteSpartan.deleteSpartan(response.jsonPath().getInt("data.id"));

    }

    @When("send POST request using invalid credentials with valid request body")
    public void sendPOSTRequestUsingInvalidCredentialsWithValidRequestBody() {
        Faker faker = new Faker();

        String username = faker.name().username();
        String password = faker.internet().password();

        response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().auth().basic(username,password)
                .and().body(GenerateSpartan.generateSparta())
                .when().post();




    }
}
