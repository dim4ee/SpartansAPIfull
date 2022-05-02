package com.spartans.step_definitions;

import com.github.javafaker.Faker;
import com.spartans.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class SPAR1_STEP_DEFINITIONS {

    static Response response;
    static RequestSpecification requestSpecification;

    @Given("base URL + {string}")
    public void base_url(String path) {
        baseURI = "http://54.197.5.86:7000";
        basePath = path;
    }

    @When("send GET request with user credentials")
    public void send_get_request_with_user_credentials() {
        String username = ConfigurationReader.getProperty("user_username");
        String password = ConfigurationReader.getProperty("user_password");

        response = given().auth().basic(username, password)
                .and().accept(ContentType.JSON)
                .when().get();
    }

    @Then("response code {int}")
    public void response_code(int responseCode) {
        assertThat(response.getStatusCode(), is(responseCode));
    }

    @Then("response Content Type {string}")
    public void response_content_type(String expectedContentType) {
        assertThat(response.getContentType(), is(expectedContentType));
    }


    @When("send GET request with admin credentials")
    public void sendGETRequestWithAdminCredentials() {
        String username = ConfigurationReader.getProperty("admin_username");
        String password = ConfigurationReader.getProperty("admin_password");

        response = given().auth().basic(username, password)
                .and().accept(ContentType.JSON)
                .when().get();
    }

    @When("GET request with editor credentials")
    public void getRequestWithEditorCredentials() {
        String username = ConfigurationReader.getProperty("editor_username");
        String password = ConfigurationReader.getProperty("editor_password");

        response = given().auth().basic(username, password)
                .and().accept(ContentType.JSON)
                .when().get();
    }

    @When("GET request with invalid credentials")
    public void getRequestWithInvalidCredentials() {
        Faker faker = new Faker();

        String username = faker.name().username();
        String password = faker.internet().password();

        response = given().auth().basic(username, password)
                .and().accept(ContentType.JSON)
                .when().get();

    }


    @When("GET request with no credentials")
    public void getRequestWithNoCredentials() {
        response = given().accept(ContentType.JSON)
                .when().get();
    }

    @And("response body {string}")
    public void responseBody(String errorMessage) {

        assertThat(response.jsonPath().getString("error"),is(errorMessage));
    }
}
