package org.selenium.pom.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;
@JsonInclude(JsonInclude.Include.NON_NULL)

public class AdditionalDriversModal {
    int id;
    String title;
    String firstname;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    String occupation;
    String country;
AdditionalDriversModal(){

}
    public AdditionalDriversModal(int id) throws IOException {
        AdditionalDriversModal[] uniqueNames = JacksonUtils.desearliaze("AdditionalDrivers.json", AdditionalDriversModal[].class);
        for (AdditionalDriversModal uniqueName : uniqueNames) {
            if (uniqueName.getId()==id ) {
                this.id = id;
this.title=uniqueName.getTitle();
               this.firstname=uniqueName.getFirstname();
               this.surname=uniqueName.getSurname();
               this.dob=uniqueName.getDob();
               this.employmentStatus=uniqueName.getEmploymentStatus();
               this.drivingLicense=uniqueName.getDrivingLicense();
               this.yearsHeld=uniqueName.getYearsHeld();
               this.relationship=uniqueName.getRelationship();
               this.occupation=uniqueName.getOccupation();
               this.country=uniqueName.getCountry();
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    String surname;
    String dob;
    String employmentStatus;
    String drivingLicense;
    String yearsHeld;
    String relationship;

}
