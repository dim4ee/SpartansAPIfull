package com.spartans.step_definitions;

import com.spartans.utils.Base;
import com.spartans.utils.CreateSpartan;
import com.spartans.utils.Spartan;
import com.spartans.utils.SpartanUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DELETE_Spartan_Step_Definitions extends Base {


    @And("valid path id parameters")
    public void validPathIdParameters() {
        Spartan spartan = SpartanUtils.postSpartan();
        int id = spartan.getId();
        requestSpecification.pathParam("id",id);
    }

    @When("user send DELETE request")
    public void user_send_delete_request() {
        response = requestSpecification.when().delete();
    }



}
