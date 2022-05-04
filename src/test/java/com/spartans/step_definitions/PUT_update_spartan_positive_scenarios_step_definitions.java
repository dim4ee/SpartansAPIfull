package com.spartans.step_definitions;

import com.spartans.utils.Base;
import com.spartans.utils.GenerateSpartan;
import com.spartans.utils.Spartan;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class PUT_update_spartan_positive_scenarios_step_definitions extends Base {


    @Given("contentType ContentType.JSON")
    public void content_type_content_type_json() {
        requestSpecification.contentType(ContentType.JSON);
    }
    @Given("valid path parameters")
    public void valid_path_parameters() {
        requestSpecification.pathParam("id",7);
    }
    @Given("valid request body")
    public void valid_request_body() {
    requestSpecification.body(GenerateSpartan.generateSparta());


    }
    @When("user send PUT request")
    public void user_send_put_request() {

        response = requestSpecification.when().put();

    }


}
