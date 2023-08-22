package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.CarDetailsModal;

import java.io.IOException;
import java.time.Duration;



public class CarDetails extends BasePage {
    public CarDetails(WebDriver driver) {
        super(driver);
    }
    By cardetails= By.id("accHeading4");
    By carRegistrationValidationMessage=By.id("CV__IsCarReg");
    By estimatedValueValidationMessage=By.id("ctl00_MainContent_RequiredFieldValidator4");
    By selectYourKilometersValidationMessage=By.id("ctl00_MainContent_RequiredFieldValidator6");
    By carModifiedValidationMessage=By.id("CV__rblIsMod");
    By continueButton=By.id("ctl00_MainContent_Continue4");
    By carRegYes=By.xpath("//input[@id=\"IsCarReg-yes\"]/parent::label");

    By carRegNo=By.xpath("//input[@id=\"IsCarReg-no\"]/parent::label");

    By carMakeValidationMessage=By.id("ctl00_MainContent_RF__ddlMake");
    By selectCarModalValidationMessage=By.id("ctl00_MainContent_RF__ddlModel");

    By fuelTypeValidationMessage=By.id("ctl00_MainContent_RF__ddlFuel");

    By selectYearValidationMessage=By.id("ctl00_MainContent_RF__ddlYear");

    By transmissionValidationMessage=By.id("ctl00_MainContent_RF__ddlGears");
    By vehicleValidationMessage=By.id("ctl00_MainContent_RF__ddlDescription");

    By rightHandDriveYes=By.xpath("//input[@id=\"IsRightHandDrive-yes\"]/parent::label");
    By rightHandDriveNo=By.xpath("//input[@id=\"IsRightHandDrive-no\"]/parent::label");

    By rightHandDriveChecked=By.id("IsRightHandDrive-True");
    By rightHandDriveNotChecked=By.id("IsCarReg-False");
    By carRegistrationsearchValidationMessage=By.id("ctl00_MainContent_RE__Registration");
    By findCar=By.id("ctl00_MainContent_btnFindCar");

    By carRegistrationSearchBox=By.id("ctl00_MainContent_VehicleRegistration");

    By noCarResult=By.id("ctl00_MainContent_NoCarResult");
By searchResult=By.id("ctl00_MainContent_CarSearchResult");
By confirmCarRegistration=By.id("ctl00_MainContent_btnConfirmReg");
By carSuccessfullyAddedMessage=By.cssSelector(".addressHeading span");
By deviceTrackingStyle=By.id("TrackingDeviceQuestion");
By carEstimatedValue=By.id("ctl00_MainContent_VehicleCurrentValue");

By trackingDeviceValdilation=By.id("CV__IsTrackingDevice");

By trackingDeviceYes=By.xpath("//input[@id=\"IsTrackingDevice-yes\"]/parent::label");
By trackingDeviceNo=By.xpath("//input[@id=\"IsTrackingDevice-no\"]/parent::label");

By carModifiedYes=By.xpath("//input[@id=\"IsModified-yes\"]/parent::label");

By selectModificationsButton=By.className("m-multiselect-toggle");
By getmodificationsSelecteddata=By.className("m-multiselect-toggle__inner");

By travelKilometers=By.id("ctl00_MainContent_AnnualMileage");



public void waitForContinueButtonInvisible(){
    scrollAndwaitForInvisibility(continueButton);
}

public void selectTravelKilometers(String option){

    //scrollAndselectOptionsByVisibleText(travelKilometers,option);
}
public String getmodificationsSelecteddata(){
    return scrollAndGetText(getmodificationsSelecteddata);
}
public void SelectModifications(String part){

    scrollAndPerformClick(By.xpath(" //span[text()='"+part+"']"));

}

public void clickselectModificationsButton(){
    scrollAndPerformClick(selectModificationsButton);
}
public void clickCarModified(){
    scrollAndPerformClick(carModifiedYes);
}
public void clicktrackingDeviceYes(){
    scrollAndPerformClick(trackingDeviceYes);
}
public void clicktrackingDeviceNo(){
    scrollAndPerformClick(trackingDeviceNo);
}

public String isTrackingDeviceYes(){
    return scrollAndGetAttribute(By.id("IsTrackingDevice-True"),"class");
}
    public String isTrackingDeviceNo(){
        return scrollAndGetAttribute(By.id("IsTrackingDevice-False"),"class");
    }
public String gettrackingDeviceValdilation(){
    return scrollAndGetText(trackingDeviceValdilation);
}
public void selectCarEstimatedValue(String option){
    selectOptionsByVisibleText(carEstimatedValue,option);
}

public String getdeviceTrackingStyleAttribute(){
    return scrollAndGetAttribute(deviceTrackingStyle,"style");

}
public void clickconfirmCarRegistration(){
    scrollAndPerformClick(confirmCarRegistration);
    invisibleLoading();
}
public String getcarSuccessfullyAddedMessage(){
    return scrollAndGetText(carSuccessfullyAddedMessage);
    }
public String getSearchResult(){
    return scrollAndGetText(searchResult);
}
    public String getnoCarResultMessage(){
        return scrollAndGetText(noCarResult);
    }
    public void inputcarRegistrationSearchBox(String data){
        scrollAndSendKeys(carRegistrationSearchBox,data);
    }

    public void clickFindCar(){
        scrollAndPerformClick(findCar);
        invisibleLoading();
    }
    public void waitForVisibilityOfFindCar(){
    scrollAndWaitForVisibility(findCar);
    }

    public String getcarRegistrationsearchValidationMessage(){
        try {
            shortwait.until(ExpectedConditions.stalenessOf(driver.findElement(carRegistrationsearchValidationMessage)));
        }catch (Exception e){

        }
        return scrollAndGetText(carRegistrationsearchValidationMessage);
    }
    public String getcarRegistrationsearchValidationMessage1(){
        try {
            scrollup();
           new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.stalenessOf(driver.findElement(By.id("ctl00_MainContent_CV__VehicleRegistration"))));
        }catch (Exception e){

        }
        return scrollAndGetText(By.id("ctl00_MainContent_CV__VehicleRegistration"));
    }


    public String getrightHandDriveChecked() throws InterruptedException {
      scrollIntoView(rightHandDriveChecked);
        return getAttribute(rightHandDriveChecked,"class");
    }
    public String getrightHandDriveNotChecked(){
        scrollIntoView(rightHandDriveNotChecked);
        return getAttribute(rightHandDriveNotChecked,"class");
    }

    public void clickrightHandDriveNo(){
        scrollAndPerformClick(rightHandDriveNo);
    }
    public void clickRightHandDriveYes(){
        scrollAndPerformClick(rightHandDriveYes);
    }
    public String getvehicleValidationMessage(){
        return getText(vehicleValidationMessage);
    }

public String gettransmissionValidationMessage(){
    return getText(transmissionValidationMessage);
}

    public String getselectYearValidationMessage(){
        return getText(selectYearValidationMessage);
    }



    public String getfuelTypeValidationMessage(){
        return  getText(fuelTypeValidationMessage);
    }

    public String getselectCarModalValidationMessage(){
        return getText(selectCarModalValidationMessage);
    }

    public String  getcarMakeValidationMessage(){
        return getText(carMakeValidationMessage);
    }
    public void clickcarRegNo() throws InterruptedException {
        scrollIntoView(carRegNo);
        performClick(carRegNo);
    }

    public void visibilitycarRegNo(){
    scrollAndWaitForVisibility(carRegNo);
    }
    public void clickCarRegYes(){
        performClick(carRegYes);
    }

    public void clickContinueButton(){
    scrollIntoView(continueButton);
    performClick(continueButton);
    invisibleLoading();
    }
    public void visibilityContinueButton(){
    scrollAndWaitForVisibility(continueButton);
    }


    public String getcarModifiedValidationMessage(){
        return getText(carModifiedValidationMessage);
    }

    public String getselectYourKilometersValidationMessage(){
        return getText(selectYourKilometersValidationMessage);
    }


public String getestimatedValueValidationMessage(){
    return getText(estimatedValueValidationMessage);
}
    public String getcarRegistrationValidationMessage(){
        return getText(carRegistrationValidationMessage);
    }
    public void waitForVisibilityForCarDetailsHeading(){
    try {
        scrollAndWaitForVisibility(cardetails);
    }catch (Exception e){
        scrollAndWaitForVisibility(continueButton);
    }

    }
public void fillCardetailsWithRegistrationYes(CarDetailsModal carDetailsModal) throws IOException {
    try {
        clickCarRegYes();
        inputcarRegistrationSearchBox(carDetailsModal.getRegno());
        clickFindCar();
        try {
            getSearchResult();
        } catch (Exception e) {
            try {
                Thread.sleep(5000);
            } catch (Exception f) {

            }
            try {
                getSearchResult();
            } catch (Exception g) {
                try {
                    Thread.sleep(3000);
                } catch (Exception h) {

                }
                inputcarRegistrationSearchBox(carDetailsModal.getRegno());
                clickFindCar();
                getSearchResult();
            }
        }

        clickconfirmCarRegistration();
        getcarSuccessfullyAddedMessage();

    selectCarEstimatedValue(carDetailsModal.getEstimatedValue());
    clicktrackingDeviceYes();
    selectTravelKilometers(carDetailsModal.getKilometers());
    clickCarModified();
    clickselectModificationsButton();
    SelectModifications(carDetailsModal.getModification());
    System.out.println(getmodificationsSelecteddata());
    clickContinueButton();
        waitForContinueButtonInvisible();
    }
    catch (Exception manual){
        driver.navigate().refresh();
       CarDetails carDetails=new CarDetails(driver);
        clickCarRegYes();
        inputcarRegistrationSearchBox(carDetailsModal.getRegno());
        clickFindCar();
        try {
            getSearchResult();
        }catch (Exception h){
            clickFindCar();
            getSearchResult();
        }

        clickconfirmCarRegistration();
        getcarSuccessfullyAddedMessage();

        selectCarEstimatedValue(carDetailsModal.getEstimatedValue());
        clicktrackingDeviceYes();
        selectTravelKilometers(carDetailsModal.getKilometers());
        clickCarModified();
        clickselectModificationsButton();
        SelectModifications(carDetailsModal.getModification());
        System.out.println(getmodificationsSelecteddata());
        clickContinueButton();
        //  carDetails.fillCarDetailsWithRegistrationNo(new CarDetailsModal("no"));

        carDetails.waitForContinueButtonInvisible();
    }
}
By changeCarDetails=By.id("ctl00_MainContent_btnEditCar");

By clickCarDetailsHeading=By.id("div4");
public void clickCarDetailsHeading() throws InterruptedException {
    scrollAndPerformClick(clickCarDetailsHeading);
    Thread.sleep(2000);
    System.out.println("car heading cliekd");
}
public void clickChangeCarDetails(){
    scrollAndPerformClick(changeCarDetails);
}
String MAKEOFCARID="ctl00_MainContent_ddlMake";
By makeOfCar=By.id(MAKEOFCARID);
String MODELOFCARID="ctl00_MainContent_ddlModel";
By modelOfCar=By.id(MODELOFCARID);
String FUELTYPEID="ctl00_MainContent_ddlFuel";
By fuelType=By.id(FUELTYPEID);
String REGISTRATIONYEARID="ctl00_MainContent_ddlYear";
By registration=By.id(REGISTRATIONYEARID);

String TRANSMISSIONID="ctl00_MainContent_ddlGears";


By transmission=By.id(TRANSMISSIONID);


String VEHICLEID="ctl00_MainContent_ddlDescription";
By vehicle=By.id(VEHICLEID);
    public void selectvehicle(String option){
        selectOptionsByVisibleText(vehicle,option);
    }
    JavascriptExecutor js=(JavascriptExecutor) driver;
    public String getSelectVehicleJS(){
        return JSDropDownValue(VEHICLEID,driver);
    }

    public void selecttransmission(String option){
        selectOptionsByVisibleText(transmission,option);
    }
    public String getTransmissionJS(){
        return JSDropDownValue(TRANSMISSIONID,driver);
    }

public void selectRegistration(String option){
    selectOptionsByVisibleText(registration,option);
}
    public String getRegistrationJS(){
        return JSDropDownValue(REGISTRATIONYEARID,driver);
    }

public void selectFuelType(String option){
    selectOptionsByVisibleText(fuelType,option);
}
    public String getFuelTypeJS(){
        return JSDropDownValue(FUELTYPEID,driver);
    }


public void selectModelofCar(String option){
    scrollAndselectOptionsByVisibleText(modelOfCar,option);
}
    public String getselectModelofCarJS(){
        return JSDropDownValue(MODELOFCARID,driver);
    }
public void selectMakeOfCar(String option){
    scrollAndselectOptionsByVisibleText(makeOfCar,option);
}
    public String getselectMakeOfCarJS(){
        return JSDropDownValue(MAKEOFCARID,driver);
    }
public void fillCarDetailsWithRegistrationNo(CarDetailsModal carDetailsModal) throws InterruptedException {
    clickcarRegNo();
    selectMakeOfCar(carDetailsModal.getMakeOfCar());
    Thread.sleep(5000);

    selectModelofCar(carDetailsModal.getModelOfCar());
    Thread.sleep(1500);
    selectMakeOfCar(carDetailsModal.getMakeOfCar());
    selectFuelType(carDetailsModal.getFuelType());
    Thread.sleep(1500);
    selectRegistration(carDetailsModal.getYearOfRegistration());
    Thread.sleep(1500);
    selecttransmission(carDetailsModal.getTransmission());
    Thread.sleep(1500);
    selectvehicle(carDetailsModal.getVehicle());
    selectCarEstimatedValue(carDetailsModal.getEstimatedValue());
    clicktrackingDeviceYes();
   // selectTravelKilometers(carDetailsModal.getKilometers());
    clickCarModified();
    clickselectModificationsButton();
    SelectModifications(carDetailsModal.getModification());
    System.out.println(getmodificationsSelecteddata());
    clickContinueButton();
}
    public void fillCarDetailsWithRegistrationNoModificationsNo(CarDetailsModal carDetailsModal) throws InterruptedException {
        clickcarRegNo();
        selectMakeOfCar(carDetailsModal.getMakeOfCar());
        Thread.sleep(5000);

        selectModelofCar(carDetailsModal.getModelOfCar());
        Thread.sleep(1800);
       selectMakeOfCar(carDetailsModal.getMakeOfCar());
        selectFuelType(carDetailsModal.getFuelType());
        Thread.sleep(1800);
        selectRegistration(carDetailsModal.getYearOfRegistration());
        Thread.sleep(1800);
        selecttransmission(carDetailsModal.getTransmission());
        Thread.sleep(1800);
        selectvehicle(carDetailsModal.getVehicle());


        selectTravelKilometers(carDetailsModal.getKilometers());
       clickCarModifiedNo();
        Thread.sleep(1800);
        clickContinueButton();
    }


public void clickCarModifiedNo(){
        scrollAndPerformClick(By.xpath("//input[@id=\"IsModified-no\"]/parent::label"));
}

public String getCarRegistrationValueJS() {

    JavascriptExecutor js=(JavascriptExecutor) driver;
    return js.executeScript("return document.getElementById('IsCarReg-yes').value").toString();

}
    public String getRegisteredCarNumberJS() {


        return js.executeScript("return document.getElementById('ctl00_MainContent_VehicleRegistration').value").toString();

    }
    public String getCarResultNameJS() {


        return js.executeScript("return document.getElementById('ctl00_MainContent_CarSearchResult').innerText").toString();

    }

public String getCarEstimatedValueJS(){
    return js.executeScript("return document.getElementById(\"ctl00_MainContent_VehicleCurrentValue\").options[document.getElementById(\"ctl00_MainContent_VehicleCurrentValue\").selectedIndex].text").toString();
}
public String getDeviceTrackingFittedJS(){
    return js.executeScript("return document.getElementById('IsTrackingDevice-yes').value").toString();
}

public String getkilometerRangeJS(){
    return js.executeScript("return document.getElementById(\"ctl00_MainContent_AnnualMileage\").options[document.getElementById(\"ctl00_MainContent_AnnualMileage\").selectedIndex].text").toString();
}
public String carModifiedYesJS(){
    return js.executeScript("return document.getElementById('IsModified-yes').value").toString();
}
By carEstimatedModelToolTip=By.cssSelector("[aria-labelledby=\"VehicleCurrentValueTooltip\"]");
    public void clickcarEstimatedModelToolTip(){
        scrollAndPerformClick(carEstimatedModelToolTip);
    }
    By ModalText=By.cssSelector("[id=\"modalDescription\"] p");

    public String getModalText(){
        return getText(ModalText);

    }
    static final String SCROLLVALUE="600";
    static final String REGISTRATIONNOTFOUND="Vehicle Registration could not be found";
    static final String INSURANCEINIRELAND = "I currently have insurance in my own name in Ireland/UK";
    static final String NAMEDDRIVERINIRELAND = "I have been a named driver in Ireland";
    static final String NOPREVIOUSEXPERIENCE = "No previous experience";

    public void fillScreenOneTwoThreeData(WebDriver driver) throws IOException {

        new InsuranceDetails(driver).fillScreenOneAndTwodata(driver);
        InsuranceDetails insuranceDetails=new InsuranceDetails(driver);
        insuranceDetails.selectDrivingExperienceOption(NOPREVIOUSEXPERIENCE);
        insuranceDetails.clickContinueButton();
        //   InsuranceDetails insuranceDetails = new InsuranceDetails(driver);
        new CarDetails(driver).waitForVisibilityForCarDetailsHeading();
        insuranceDetails.scrolldown(SCROLLVALUE);

    }
}
