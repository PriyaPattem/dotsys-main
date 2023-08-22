package org.selenium.pom.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class personalDetailsModal {
    String occupation;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCountryLicense() {
        return countryLicense;
    }

    public void setCountryLicense(String countryLicense) {
        this.countryLicense = countryLicense;
    }

    String countryLicense;
    personalDetailsModal(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
    String dob;
    String employeeStatus;
    String drivingLicense;
    public personalDetailsModal(int id) throws IOException {
        personalDetailsModal[] uniqueNames = JacksonUtils.desearliaze("personalDetails.json", personalDetailsModal[].class);
        for (personalDetailsModal uniqueName : uniqueNames) {
            if (uniqueName.getId() == id) {
                this.id = id;
                this.country=uniqueName.getCountry();
                this.dob=uniqueName.getDob();
                this.employeeStatus=uniqueName.getEmployeeStatus();
                this.drivingLicense=uniqueName.getDrivingLicense();
                this.yearsHeld=uniqueName.getYearsHeld();
                this.occupation=uniqueName.getOccupation();
                this.countryLicense=uniqueName.getCountryLicense();





            }
        }
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    String country;

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getYearsHeld() {
        return yearsHeld;
    }

    public void setYearsHeld(String yearsHeld) {
        this.yearsHeld = yearsHeld;
    }

    String yearsHeld;
}
