package org.selenium.pom.objects;

import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class customerScreenOneModal {
    customerScreenOneModal() {

    }

    int id;
    String title;
    String firstname;
    String lastname;
    String email;
    String mobile;

    public customerScreenOneModal(int id) throws IOException {
        customerScreenOneModal[] uniqueNames = JacksonUtils.desearliaze("customerScreenOne.json", customerScreenOneModal[].class);
        for (customerScreenOneModal uniqueName : uniqueNames) {
            if (uniqueName.getId() == id) {
                this.id = id;

                this.title = uniqueName.getTitle();
                this.firstname = uniqueName.getFirstname();
                this.lastname = uniqueName.getLastname();
                this.email = uniqueName.getEmail();
                this.mobile = uniqueName.getMobile();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}