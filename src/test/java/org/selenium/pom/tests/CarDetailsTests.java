package org.selenium.pom.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.CarDetailsModal;
import org.selenium.pom.objects.customerScreenOneModal;
import org.selenium.pom.objects.personalDetailsModal;
import org.selenium.pom.pages.CarDetails;
import org.selenium.pom.pages.CustomerScreenOne;
import org.selenium.pom.pages.InsuranceDetails;
import org.selenium.pom.pages.PersonalDetails;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;
import java.io.IOException;

import static org.selenium.pom.constants.BrowserStackConstants.FAILED;
import static org.selenium.pom.constants.BrowserStackConstants.PASSED;
import static org.selenium.pom.tests.InsuranceDetailsTests.NOPREVIOUSEXPERIENCE;


public class CarDetailsTests extends BaseTest {
    static final String SCROLLVALUE="600";
    static final String REGISTRATIONNOTFOUND="Vehicle Registration could not be found";

  /*  public void fillScreenOneTwoThreeData() throws IOException {
        CustomerScreenOne customerScreenOne = new CustomerScreenOne(getDriver());
        customerScreenOne.load();
        customerScreenOneModal customerScreenOneModal = new customerScreenOneModal(1);
        System.out.println(customerScreenOneModal.getEmail());
        System.out.println(customerScreenOneModal.getTitle());
        customerScreenOne.fillCustomerScreenFormAndContinue(customerScreenOneModal);
        PersonalDetails personalDetails = new PersonalDetails(getDriver());
        personalDetails.waitforVisibiliyofAddressSearchBar();
        personalDetailsModal personalDetailsModal = new personalDetailsModal(1);
        personalDetails.fillPersonalDetailsAndContinue(personalDetailsModal);
        personalDetails.invsibilityContinueButton();
        InsuranceDetails insuranceDetails = new InsuranceDetails(getDriver());
//

        insuranceDetails.selectDrivingExperienceOption(NOPREVIOUSEXPERIENCE);
        insuranceDetails.clickContinueButton();

        new CarDetails(getDriver()).waitForVisibilityForCarDetailsHeading();
         insuranceDetails.scrolldown(SCROLLVALUE);


    }*/
    public void fillScreenOneTwoThreeData() throws IOException {
        new CarDetails(getDriver()).fillScreenOneTwoThreeData(getDriver());
    }

    @Test
    public void verifyValidationMessagesInCarDetailsPage() throws IOException {
        boolean error = false;
        String reason = " ";
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
        carDetails.clickContinueButton();
        System.out.println(carDetails.getcarRegistrationValidationMessage());
        System.out.println(carDetails.getestimatedValueValidationMessage());
     //   System.out.println(carDetails.getselectYourKilometersValidationMessage());
        System.out.println(carDetails.getcarModifiedValidationMessage());
        if (!(carDetails.getcarRegistrationValidationMessage().equals("Please select an option"))) {
            error = true;
            reason = reason + "Unable to verify car registration validation message";
        }
        if (!(carDetails.getestimatedValueValidationMessage().equals("Please select your current estimated car value"))) {
            error = true;
            reason = reason + "Unable to verify estimated car value validation message";
        }
//        if (!(carDetails.getselectYourKilometersValidationMessage().equals("Please select your kilometres"))) {
//            error = true;
//            reason = reason + "Unable to verify Please select your kilometres validation message";
//        }
        if (!(carDetails.getcarModifiedValidationMessage().equals("Please select an option"))) {
            error = true;
            reason = reason + "Unable to verify car modified validation message";
        }
        if (!(error)) {
            setTestStatus(PASSED, true, "Able to verify validation Messages");
        } else {
            setTestStatus(FAILED, false, "Unable to verify following validation messages " + reason);
        }
    }


    @Test
    public void verifyCarRegistrationValidationMessagesInCarDetails() throws IOException, InterruptedException {
        boolean error = false;
        String reason = " ";
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
        carDetails.clickcarRegNo();
        carDetails.clickContinueButton();
        System.out.println(carDetails.getcarMakeValidationMessage());
        System.out.println(carDetails.getselectCarModalValidationMessage());
        System.out.println(carDetails.getfuelTypeValidationMessage());
        System.out.println(carDetails.getselectYearValidationMessage());
        System.out.println(carDetails.gettransmissionValidationMessage());
        System.out.println(carDetails.getvehicleValidationMessage());

        if (!(carDetails.getcarMakeValidationMessage().equals("Please select car make"))) {
            error = true;
            reason = reason + "Please select car make";
        }
        if (!(carDetails.getselectCarModalValidationMessage().equals("Please select car model"))) {
            error = true;
            reason = reason + "Please select car model";
        }
        if (!(carDetails.getfuelTypeValidationMessage().equals("Please select fuel type"))) {
            error = true;
            reason = reason + "Please select fuel type";
        }
        if (!(carDetails.getselectYearValidationMessage().equals("Please select year"))) {
            error = true;
            reason = reason + "Please select year";
        }
        if (!(carDetails.gettransmissionValidationMessage().equals("Please select transmission"))) {
            error = true;
            reason = reason + "Please select transmission";
        }
        if (!(carDetails.getvehicleValidationMessage().equals("Please select vehicle"))) {
            error = true;
            reason = reason + "Please select vehicle";
        }
        if (!(error)) {
            setTestStatus(PASSED, true, "Able to verify validation messages");
        } else {
            setTestStatus(FAILED, false, "Unable to verify following validation messages " + reason);
        }
    }

    @Test
    public void verifyCarRightHandDriveDefaultSelectionInCarDetails() throws IOException, InterruptedException {
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
        carDetails.clickcarRegNo();

        System.out.println(carDetails.getrightHandDriveChecked());
        if (carDetails.getrightHandDriveChecked().contains("checked")) {
            setTestStatus(PASSED, true, "pass");
        } else {
            setTestStatus(FAILED, false, "failed to verify default selection");
        }


    }

    @Test
    public void verifyCarRightHandDriveNoSelectionInCarDetails() throws InterruptedException, IOException {
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
        carDetails.clickcarRegNo();
        carDetails.clickrightHandDriveNo();
        Thread.sleep(1000);
        System.out.println(carDetails.getrightHandDriveNotChecked());
        if (carDetails.getrightHandDriveNotChecked().contains("checked")) {
            setTestStatus(PASSED, true, "pass");
        } else {
            setTestStatus(FAILED, false, "failed to verify default selection");
        }

    }

    @Test
    public void verifyCarRegistrationNumberValidationMessage() throws IOException {
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
        carDetails.clickCarRegYes();
        carDetails.clickFindCar();

        System.out.println(carDetails.getcarRegistrationsearchValidationMessage1());
        if (carDetails.getcarRegistrationsearchValidationMessage1().equals("Please enter your registration")) {
            setTestStatus(PASSED, true, "Able to verify validation message");
        } else {
            setTestStatus(FAILED, false, "Unable to verify Please enter your registration ");
        }
    }

    public void noSearchResult(String regNo) throws IOException {
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
        carDetails.clickCarRegYes();
        carDetails.inputcarRegistrationSearchBox(regNo);
        carDetails.clickFindCar();
        System.out.println(carDetails.getnoCarResultMessage());
        if(carDetails.getnoCarResultMessage().contains(REGISTRATIONNOTFOUND)){
            setTestStatus(PASSED,true,"Able to verify"+REGISTRATIONNOTFOUND);
        }else {
            setTestStatus(FAILED,false,"Unable to verify"+REGISTRATIONNOTFOUND);
        }
    }
@Test
    public void verifyCarRegistrationSearchWithValidStructureAndInvalidRegistration() throws IOException {
 noSearchResult("12LH455677");
}
@Test
public void verifyCarRegistrationSearchWithInValidStructureAndInvalidRegistration() throws IOException {
    fillScreenOneTwoThreeData();
    CarDetails carDetails = new CarDetails(getDriver());
    carDetails.clickCarRegYes();

    try {
        carDetails.inputcarRegistrationSearchBox("df");
    }catch (StaleElementReferenceException e){
      try {
          Thread.sleep(5000);
      }catch (Exception f){

      }
        carDetails.inputcarRegistrationSearchBox("df");
    }
    carDetails.clickFindCar();
    System.out.println(carDetails.getcarRegistrationsearchValidationMessage());
    if (carDetails.getcarRegistrationsearchValidationMessage().equals("Please enter a valid registration")){
        passStatus("Able to verify validation message");
    }else {
        failStatus("Unable to verify Please enter a valid registration validation message");
    }
    }

    @Test
public void verifyTheCarAddWithYesOption() throws IOException {
        String reason=" ";
        boolean error=false;
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
        carDetails.clickCarRegYes();
        carDetails.inputcarRegistrationSearchBox("12d151");
        carDetails.clickFindCar();

System.out.println(carDetails.getSearchResult());
if(!(carDetails.getSearchResult().contains("BENZ"))){
    error=true;
    reason=reason+"Unable to verify search result";
}
carDetails.clickconfirmCarRegistration();
System.out.println(carDetails.getcarSuccessfullyAddedMessage());
if(!(carDetails.getcarSuccessfullyAddedMessage().equals("Car successfully added"))){
    error=true;
    reason=reason+"Car not successfully added";
}

if(!(error)){
    passStatus("Able to add car");
}else {
    failStatus("Unable to add car "+reason);
}

    }


    @Test
    public void verifyConditionalTrackingDeviceFitted() throws IOException {
        String value="€105001 - €155000";

        String reason=" ";
        boolean error=false;
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
carDetails.selectCarEstimatedValue(value);
System.out.println(carDetails.getdeviceTrackingStyleAttribute());
if(!(carDetails.getdeviceTrackingStyleAttribute().contains("display: block"))){
    error=true;
    reason=reason+ "Unable to verify tracking device fitted block";
}

carDetails.clickContinueButton();
System.out.println(carDetails.gettrackingDeviceValdilation());
if(!(carDetails.gettrackingDeviceValdilation().equals("Please confirm if your car has a tracking device."))){
    error=true;
    reason=reason+"Unable to verify Please confirm if your car has a tracking device. message";
}
carDetails.clicktrackingDeviceYes();

System.out.println("tracking device yes "+carDetails.isTrackingDeviceYes());
if(!(carDetails.isTrackingDeviceYes().contains("checked"))){
    error=true;
    reason=reason+"Unable to verify tracking device selection with option yes";
}

carDetails.clicktrackingDeviceNo();
System.out.println("tracking device no "+carDetails.isTrackingDeviceNo());
if(!(carDetails.isTrackingDeviceNo().contains("checked"))){
    error=true;
    reason=reason+"Unable to verify tracking device selection with option no";
}
if(!(error)){
    passStatus("Able to verify device fitted block");
}else {
    failStatus("Unable to verify following conditions "+reason);
}

    }

    @Test
    public void verifyCarModificationPartsInCarDetails() throws IOException {
        String reason=" ";
        boolean error=false;
        String BODYKITS="Body Kits";
        String SELECTALL="Select all";
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
carDetails.clickCarModified();
        carDetails.clickselectModificationsButton();
        carDetails.SelectModifications(BODYKITS);
        System.out.println(carDetails.getmodificationsSelecteddata());
        if(!(carDetails.getmodificationsSelecteddata().equals(BODYKITS))){
            error=true;
            reason=reason+BODYKITS+" selection failed";
        }
        carDetails.SelectModifications(SELECTALL);
        System.out.println(carDetails.getmodificationsSelecteddata());
        if(!(carDetails.getmodificationsSelecteddata().equals("All selected"))){
            error=true;
            reason=reason+"All selected selection failed";
        }
        if(!(error)){
            passStatus("Able to verify modifications block");
        }else {
            failStatus("Unable to verify modifications block "+reason);
        }
    }


    @Test
    public void fillCarDetailsWithCarRegistrationYes() throws IOException, InterruptedException {
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
        CarDetailsModal carDetailsModal=new CarDetailsModal("yes");
        carDetails.fillCardetailsWithRegistrationYes(carDetailsModal);
        carDetails.waitForContinueButtonInvisible();
//carDetails.scrollup();
        carDetails.clickCarDetailsHeading();
        carDetails.clickChangeCarDetails();
        carDetails.waitForVisibilityOfFindCar();
        System.out.println(carDetails.carModifiedYesJS());
      //  System.out.println(carDetails.getkilometerRangeJS());
        System.out.println(carDetails.getCarEstimatedValueJS());
        System.out.println(carDetails.getCarResultNameJS());
        System.out.println(carDetails.getRegisteredCarNumberJS());
        System.out.println(carDetails.carModifiedYesJS());
carDetails.scrolldown(SCROLLVALUE);
        System.out.println(carDetails.getmodificationsSelecteddata());
String reason=" ";
boolean error=false;
if(!(carDetails.carModifiedYesJS().toLowerCase().equals(carDetailsModal.getId()))){
    error=true;
    reason=reason+"failed to verify car registration type";
}
//        if(!(carDetails.getkilometerRangeJS().equals(carDetailsModal.getKilometers()))){
//            error=true;
//            reason=reason+"failed to verify"+carDetailsModal.getKilometers();
//        }
        if(!(carDetails.getCarEstimatedValueJS().equals(carDetailsModal.getEstimatedValue()))){
            error=true;
            reason=reason+"failed to verify"+carDetailsModal.getEstimatedValue();
        }
        if(!(carDetails.getCarResultNameJS().contains("BENZ"))){
            error=true;
            reason=reason+"failed to verify car BENZ";
        }
        if(!(carDetails.getRegisteredCarNumberJS().equals(carDetailsModal.getRegno()))){
            error=true;
            reason=reason+"failed to verify"+carDetailsModal.getRegno();
        }
        if(!(carDetails.carModifiedYesJS().toLowerCase().equals(carDetailsModal.getId()))){
            error=true;
            reason=reason+"failed to verify car modified yes";
        }
        if(!(carDetails.getmodificationsSelecteddata().equals(carDetailsModal.getModification()))){
            error=true;
            reason=reason+"failed to verify car modified data"+carDetailsModal.getModification();
        }

        if(!(error)){
            passStatus("Able to verify data");
        }else {
            failStatus("Unable to verify data"+reason);
        }

     /*   try {
            carDetails.waitForContinueButtonInvisible();
            passStatus("Able to submit data");
        }catch (Exception e)
        {
            failStatus("Unable to submit data");
        }*/



    }
    @Test
    public void updateCarDetailsWithCarRegistrationYes() throws IOException, InterruptedException {
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
        CarDetailsModal carDetailsModal1=new CarDetailsModal("yes");
        carDetails.fillCardetailsWithRegistrationYes(carDetailsModal1);
        carDetails.waitForContinueButtonInvisible();
//carDetails.scrollup();
        carDetails.clickCarDetailsHeading();
        carDetails.clickChangeCarDetails();
        carDetails.waitForVisibilityOfFindCar();
        CarDetailsModal carDetailsModal=new CarDetailsModal("yes1");
        carDetails.fillCardetailsWithRegistrationYes(carDetailsModal);
        carDetails.waitForContinueButtonInvisible();
//carDetails.scrollup();
        carDetails.clickCarDetailsHeading();
        carDetails.clickChangeCarDetails();
        carDetails.waitForVisibilityOfFindCar();
        System.out.println(carDetails.carModifiedYesJS());
       // System.out.println(carDetails.getkilometerRangeJS());
        System.out.println(carDetails.getCarEstimatedValueJS());
        System.out.println(carDetails.getCarResultNameJS());
        System.out.println(carDetails.getRegisteredCarNumberJS());
        System.out.println(carDetails.carModifiedYesJS());
        carDetails.scrolldown(SCROLLVALUE);
        System.out.println(carDetails.getmodificationsSelecteddata());
        String reason=" ";
        boolean error=false;
        if(!(carDetails.carModifiedYesJS().toLowerCase().equals("yes"))){
            error=true;
            reason=reason+"failed to verify car registration type";
        }
//        if(!(carDetails.getkilometerRangeJS().equals(carDetailsModal.getKilometers()))){
//            error=true;
//            reason=reason+"failed to verify"+carDetailsModal.getKilometers();
//        }
        if(!(carDetails.getCarEstimatedValueJS().equals(carDetailsModal.getEstimatedValue()))){
            error=true;
            reason=reason+"failed to verify"+carDetailsModal.getEstimatedValue();
        }
        if(!(carDetails.getCarResultNameJS().contains("BENZ"))){
            error=true;
            reason=reason+"failed to verify car BENZ";
        }
        if(!(carDetails.getRegisteredCarNumberJS().equals(carDetailsModal.getRegno()))){
            error=true;
            reason=reason+"failed to verify"+carDetailsModal.getRegno();
        }
        if(!(carDetails.carModifiedYesJS().toLowerCase().equals("yes"))){
            error=true;
            reason=reason+"failed to verify car modified yes";
        }
        if(!(carDetails.getmodificationsSelecteddata().equals("All selected"))){
            error=true;
            reason=reason+"failed to verify car modified data All selected";
        }

        if(!(error)){
            passStatus("Able to verify data");
        }else {
            failStatus("Unable to verify data"+reason);
        }

     /*   try {
            carDetails.waitForContinueButtonInvisible();
            passStatus("Able to submit data");
        }catch (Exception e)
        {
            failStatus("Unable to submit data");
        }*/



    }

    @Test
    public void fillCarDetailsWithCarRegistrationNo() throws IOException, InterruptedException {
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
CarDetailsModal carDetailsModal=new CarDetailsModal("no");
carDetails.fillCarDetailsWithRegistrationNo(carDetailsModal);
        carDetails.waitForContinueButtonInvisible();
//carDetails.scrollup();
        carDetails.clickCarDetailsHeading();
        carDetails.clickChangeCarDetails();
        carDetails.visibilitycarRegNo();
System.out.println(carDetails.getselectMakeOfCarJS());
        System.out.println(carDetails.getselectModelofCarJS());
        System.out.println(carDetails.getFuelTypeJS());
        System.out.println(carDetails.getRegistrationJS());
        System.out.println(carDetails.getTransmissionJS());
        System.out.println(carDetails.getSelectVehicleJS());
        String reason=" ";
        boolean error=false;
        if(!(carDetails.getselectMakeOfCarJS().equals(carDetailsModal.getMakeOfCar()))){
            error=true;
            reason="Unable to verify car make";
        }
        if(!(carDetails.getselectModelofCarJS().equals(carDetailsModal.getModelOfCar()))){
            error=true;
            reason="Unable to verify car model";
        }
        if(!(carDetails.getFuelTypeJS().equals(carDetailsModal.getFuelType()))){
            error=true;
            reason="Unable to verify fuel type";
        }
        if(!(carDetails.getRegistrationJS().equals(carDetailsModal.getYearOfRegistration()))){
            error=true;
            reason="Unable to verify year of registration";
        }
        if(!(carDetails.getTransmissionJS().equals(carDetailsModal.getTransmission()))){
            error=true;
            reason="Unable to verify transmission";
        }
        if(!(carDetails.getSelectVehicleJS().equals(carDetailsModal.getVehicle()))){
            error=true;
            reason="Unable to verify vehicle";
        }
        if(!(error)){
            passStatus("Able to verify data");
        }else {
            failStatus("Unable to verify "+ reason);
        }
    }
@Test
public void updatecarRegistrationFromYesToNo() throws IOException, InterruptedException {
    fillScreenOneTwoThreeData();
    CarDetails carDetails = new CarDetails(getDriver());
    CarDetailsModal carDetailsModal1=new CarDetailsModal("yes");
    carDetails.fillCardetailsWithRegistrationYes(carDetailsModal1);
    carDetails.waitForContinueButtonInvisible();
//carDetails.scrollup();
    carDetails.clickCarDetailsHeading();
    carDetails.clickChangeCarDetails();
    carDetails.waitForVisibilityOfFindCar();
    CarDetailsModal carDetailsModal=new CarDetailsModal("no");
    carDetails.fillCarDetailsWithRegistrationNo(carDetailsModal);
    carDetails.waitForContinueButtonInvisible();
//carDetails.scrollup();
    carDetails.clickCarDetailsHeading();
    carDetails.clickChangeCarDetails();
    carDetails.visibilitycarRegNo();
    System.out.println(carDetails.getselectMakeOfCarJS());
    System.out.println(carDetails.getselectModelofCarJS());
    System.out.println(carDetails.getFuelTypeJS());
    System.out.println(carDetails.getRegistrationJS());
    System.out.println(carDetails.getTransmissionJS());
    System.out.println(carDetails.getSelectVehicleJS());
    String reason=" ";
    boolean error=false;
    if(!(carDetails.getselectMakeOfCarJS().equals(carDetailsModal.getMakeOfCar()))){
        error=true;
        reason="Unable to verify car make";
    }
    if(!(carDetails.getselectModelofCarJS().equals(carDetailsModal.getModelOfCar()))){
        error=true;
        reason="Unable to verify car model";
    }
    if(!(carDetails.getFuelTypeJS().equals(carDetailsModal.getFuelType()))){
        error=true;
        reason="Unable to verify fuel type";
    }
    if(!(carDetails.getRegistrationJS().equals(carDetailsModal.getYearOfRegistration()))){
        error=true;
        reason="Unable to verify year of registration";
    }
    if(!(carDetails.getTransmissionJS().equals(carDetailsModal.getTransmission()))){
        error=true;
        reason="Unable to verify transmission";
    }
    if(!(carDetails.getSelectVehicleJS().equals(carDetailsModal.getVehicle()))){
        error=true;
        reason="Unable to verify vehicle";
    }
    if(!(error)){
        passStatus("Able to verify data");
    }else {
        failStatus("Unable to verify "+ reason);
    }

}
    @Test
    public void updateCarDetailsWithCarRegistrationNo() throws IOException, InterruptedException {
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
        CarDetailsModal carDetailsModal1=new CarDetailsModal("no");
        carDetails.fillCarDetailsWithRegistrationNo(carDetailsModal1);
        carDetails.waitForContinueButtonInvisible();
//carDetails.scrollup();
        carDetails.clickCarDetailsHeading();
        carDetails.clickChangeCarDetails();
        carDetails.visibilitycarRegNo();
        System.out.println(carDetails.getselectMakeOfCarJS());
        System.out.println(carDetails.getselectModelofCarJS());
        System.out.println(carDetails.getFuelTypeJS());
        System.out.println(carDetails.getRegistrationJS());
        System.out.println(carDetails.getTransmissionJS());
        System.out.println(carDetails.getSelectVehicleJS());
        CarDetailsModal carDetailsModal=new CarDetailsModal("no1");
        Thread.sleep(5000);
      //  carDetails.fillCarDetailsWithRegistrationNo(carDetailsModal);
        carDetails.selectvehicle("C1 1.0I 68HP VTR (2012-present) 998cc Manual 5dr");
        carDetails.clickContinueButton();
        carDetails.waitForContinueButtonInvisible();
        carDetails.clickCarDetailsHeading();
        carDetails.clickChangeCarDetails();
        carDetails.visibilitycarRegNo();
        System.out.println(carDetails.getselectMakeOfCarJS());
        System.out.println(carDetails.getselectModelofCarJS());
        System.out.println(carDetails.getFuelTypeJS());
        System.out.println(carDetails.getRegistrationJS());
        System.out.println(carDetails.getTransmissionJS());
        System.out.println(carDetails.getSelectVehicleJS());
        String reason=" ";
        boolean error=false;
        if(!(carDetails.getselectMakeOfCarJS().equals(carDetailsModal.getMakeOfCar()))){
            error=true;
            reason="Unable to verify car make";
        }
        if(!(carDetails.getselectModelofCarJS().equals(carDetailsModal.getModelOfCar()))){
            error=true;
            reason="Unable to verify car model";
        }
        if(!(carDetails.getFuelTypeJS().equals(carDetailsModal.getFuelType()))){
            error=true;
            reason="Unable to verify fuel type";
        }
        if(!(carDetails.getRegistrationJS().equals(carDetailsModal.getYearOfRegistration()))){
            error=true;
            reason="Unable to verify year of registration";
        }
        if(!(carDetails.getTransmissionJS().equals(carDetailsModal.getTransmission()))){
            error=true;
            reason="Unable to verify transmission";
        }
        if(!(carDetails.getSelectVehicleJS().equals(carDetailsModal.getVehicle()))){
            error=true;
            reason="Unable to verify vehicle";
        }
        if(!(error)){
            passStatus("Able to verify data");
        }else {
            failStatus("Unable to verify "+ reason);
        }

    }

    @Test
    public void verifyEstimatedCarValueModalInCarDetails() throws IOException {
        fillScreenOneTwoThreeData();
        CarDetails carDetails = new CarDetails(getDriver());
        carDetails.clickcarEstimatedModelToolTip();
        System.out.println(carDetails.getModalText());
        if(carDetails.getModalText().equals("In the event that your vehicle is damaged beyond economic repair we will calculate the value of the vehicle at the time of the loss on the basis of the current market value (for a vehicle of the same make and model). Please Note: We will not pay for loss or damage over the current market value of the vehicle at the time of the loss.")){
            passStatus("Able to verify modal text");
        }else {
            failStatus("Unable to verify modal text");
        }
    }

}


