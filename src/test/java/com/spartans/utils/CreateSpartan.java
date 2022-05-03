package com.spartans.utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class CreateSpartan {


    public static Map<String,Object> newSpartan(){
        Faker faker = new Faker();
        Map<String,Object> newSpartan = new HashMap<>();

        String gender = "";
        int i = faker.number().numberBetween(1, 2);
        if(i==1){
            gender = "Male";
        }else {
            gender = "Female";
        }

        newSpartan.put("gender",gender);
        newSpartan.put("name",faker.name());
        newSpartan.put("phone",faker.phoneNumber().phoneNumber());

        return newSpartan;

    }






}
