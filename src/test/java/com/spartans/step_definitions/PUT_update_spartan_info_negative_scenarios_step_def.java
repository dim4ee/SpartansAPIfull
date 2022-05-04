package com.spartans.step_definitions;

import com.spartans.utils.Base;
import com.spartans.utils.ConfigurationReader;
import com.spartans.utils.SpartanUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class PUT_update_spartan_info_negative_scenarios_step_def extends Base {

    @Given("{string} path parameters")
    public void path_parameters(String pathParams) {

        requestSpecification.pathParam("id",SpartanUtils.id(pathParams));



    }
    @Given("{string} request body")
    public void request_body(String body) {
        requestSpecification.body(SpartanUtils.requestBody(body));
    }


    @And("basic auth with valid {string} and {string}")
    public void basicAuthWithValidAnd(String user, String pass) {
       String username = ConfigurationReader.getProperty(user);
       String password = ConfigurationReader.getProperty(pass);

       requestSpecification.auth().basic(username,password);
    }
}
