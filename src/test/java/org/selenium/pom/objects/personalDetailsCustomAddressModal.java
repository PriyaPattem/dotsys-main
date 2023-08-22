package org.selenium.pom.objects;

import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class personalDetailsCustomAddressModal {
    personalDetailsCustomAddressModal(){

    }
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getSubcounty() {
        return subcounty;
    }

    public void setSubcounty(String subcounty) {
        this.subcounty = subcounty;
    }

    String address1;
    String address2;
    String address3;
    String county;
    String subcounty;
    public personalDetailsCustomAddressModal(int id) throws IOException {
        personalDetailsCustomAddressModal[] uniqueNames = JacksonUtils.desearliaze("personalDetailsCustomAddress.json", personalDetailsCustomAddressModal[].class);
        for (personalDetailsCustomAddressModal uniqueName : uniqueNames) {
            if (uniqueName.getId() == id) {
                this.id = id;
                this.address1=uniqueName.getAddress1();
                this.address2=uniqueName.getAddress2();
                this.address3=uniqueName.getAddress3();
                this.county=uniqueName.getCounty();
                this.subcounty=uniqueName.getSubcounty();



            }
        }
    }

}
