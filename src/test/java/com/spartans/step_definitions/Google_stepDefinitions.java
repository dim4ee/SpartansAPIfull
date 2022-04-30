package com.spartans.step_definitions;

import com.spartans.utils.Driver;
import io.cucumber.java.en.Given;

public class Google_stepDefinitions {

    @Given("user is on google page")
    public void user_is_on_google_page() {
        Driver.getDriver().get("https://www.google.com/");

        System.out.println(Driver.getDriver().getCurrentUrl());
    }
}
