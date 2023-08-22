package org.selenium.pom.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public Long getRandomNumber(){
        return new Faker().number().randomNumber(10,true);
    }
}
