package org.selenium.pom.utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    public List<Cookie> convertRestAssuredCookieToSelenium(Cookies cookies){
        List<io.restassured.http.Cookie> restassuredcookies=new ArrayList<>();
        restassuredcookies=cookies.asList();
        List<Cookie> seleniumcookies=new ArrayList<>();
        for(io.restassured.http.Cookie cookie:restassuredcookies){
            seleniumcookies.add(new Cookie(cookie.getName(),cookie.getValue(),
                    cookie.getDomain(),cookie.getPath(),cookie.getExpiryDate(),
                    cookie.isSecured(),cookie.isHttpOnly(),cookie.getSameSite()));
        }
        return  seleniumcookies;
    }
}
