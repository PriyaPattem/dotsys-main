package org.selenium.pom.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDetailsModal {
    CarDetailsModal(){

    }

    String id;
    String regno;

    public String getMakeOfCar() {
        return makeOfCar;
    }

    public void setMakeOfCar(String makeOfCar) {
        this.makeOfCar = makeOfCar;
    }

    public String getModelOfCar() {
        return modelOfCar;
    }

    public void setModelOfCar(String modelOfCar) {
        this.modelOfCar = modelOfCar;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getYearOfRegistration() {
        return yearOfRegistration;
    }

    public void setYearOfRegistration(String yearOfRegistration) {
        this.yearOfRegistration = yearOfRegistration;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    String makeOfCar;
    String modelOfCar;
    String fuelType;
    String yearOfRegistration;
    String transmission;
    String vehicle;
    public CarDetailsModal(String id) throws IOException {
        CarDetailsModal[] uniqueNames = JacksonUtils.desearliaze("carDetails.json", CarDetailsModal[].class);
        for (CarDetailsModal uniqueName : uniqueNames) {
            if (uniqueName.getId().equals(id) ) {
                this.id = id;

               this.regno=uniqueName.getRegno();
               this.estimatedValue=uniqueName.getEstimatedValue();
               this.kilometers=uniqueName.getKilometers();
               this.modification=uniqueName.getModification();
               this.makeOfCar=uniqueName.getMakeOfCar();
               this.modelOfCar=uniqueName.getModelOfCar();
               this.fuelType=uniqueName.getFuelType();
               this.yearOfRegistration=uniqueName.getYearOfRegistration();
               this.transmission=uniqueName.getTransmission();
               this.vehicle=uniqueName.getVehicle();
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(String estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    String estimatedValue;
    String kilometers;
    String modification;
}
