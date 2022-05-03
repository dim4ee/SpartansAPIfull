package com.spartans.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = "id", allowSetters = true)
public class Spartan {

    private int id;
    private String name;
    private String gender;
    private long phone;
}
