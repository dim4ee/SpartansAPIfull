package com.spartans.utils;

import com.github.javafaker.Faker;

public class GenerateSpartan {



    public static Spartan generateSparta(){
        Faker faker = new Faker();
        Spartan spartan = new Spartan();

        String name = faker.name().name();

        if (name.length()>14){
            name = name.substring(0,14);
        }

        spartan.setGender(faker.options().option("Male","Female"));
        spartan.setName(name);
        spartan.setPhone(Long.parseLong(faker.number().digits(10)));

        return spartan;
    }
}
