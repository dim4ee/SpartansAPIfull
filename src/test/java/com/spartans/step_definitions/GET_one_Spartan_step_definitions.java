package com.spartans.step_definitions;

import com.spartans.utils.Base;
import com.spartans.utils.SpartanUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GET_one_Spartan_step_definitions extends Base {


    @Given("accept ContentType.JSON")
    public void accept_content_type_json() {
        requestSpecification = given().accept(ContentType.JSON);
    }
    @Given("basic auth with user credentials")
    public void basic_auth_with_user_credentials() {
        SpartanUtils.userLogin();
    }
    @Given("path parameters {string} {int}")
    public void path_parameters(String id, int num) {
        requestSpecification.pathParam(id,num);
    }
    @When("send GET request")
    public void send_get_request() {
        response = requestSpecification.when().get("/{id}");
    }


    @And("basic auth with editor credentials")
    public void basicAuthWithEditorCredentials() {
        SpartanUtils.editorLogin();
    }

    @And("basic auth with admin credentials")
    public void basicAuthWithAdminCredentials() {
        SpartanUtils.adminLogin();
    }

    @And("basic auth with invalid credentials")
    public void basicAuthWithInvalidCredentials() {
        SpartanUtils.invalidLogin();
    }
}
