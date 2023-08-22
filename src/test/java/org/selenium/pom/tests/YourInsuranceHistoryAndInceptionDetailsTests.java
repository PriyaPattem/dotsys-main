package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.AdditionalDriversModal;
import org.selenium.pom.objects.CarDetailsModal;
import org.selenium.pom.objects.customerScreenOneModal;
import org.selenium.pom.objects.personalDetailsModal;
import org.selenium.pom.pages.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.selenium.pom.tests.InsuranceDetailsTests.NOPREVIOUSEXPERIENCE;

public class YourInsuranceHistoryAndInceptionDetailsTests extends BaseTest {
    String driverNumber="123456789";
    DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("kk:mm");
    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static final String SCROLLVALUE="600";
    void fillUptoAboutTheDriversWithCoveStartDateOptionsNo() throws IOException {

     /*   CustomerScreenOne customerScreenOne = new CustomerScreenOne(getDriver());
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


        insuranceDetails.selectDrivingExperienceOption(NOPREVIOUSEXPERIENCE);
        insuranceDetails.clickContinueButton();

        new CarDetails(getDriver()).waitForVisibilityForCarDetailsHeading();
        insuranceDetails.scrolldown(SCROLLVALUE);
        CarDetails carDetails = new CarDetails(getDriver());
        CarDetailsModal carDetailsModal=new CarDetailsModal("yes");
        carDetails.fillCardetailsWithRegistrationYes(carDetailsModal);


        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();
        AdditionalDriversModal additionalDriversModal=new AdditionalDriversModal(3);
        additionalDrivers.fillAdditionalDriver(additionalDriversModal);
        additionalDrivers.clickAdditionalDriversNo();
        additionalDrivers.clickContinueButton();
        additionalDrivers.waitForInvisibilityForClickButton();
        // additionalDrivers.clickEditDriver();
        // additionalDrivers.visibilityaddDriverButton();
        YourClaims yourClaims=new YourClaims(getDriver());
        yourClaims.fillClaimAndContinue("01/01/2020","Accident","555555555");
        PenaltyPoints penaltyPoints=new PenaltyPoints(getDriver());
        penaltyPoints.clickYesOrNobutton("2");
        penaltyPoints.clickYesOrNobutton("4");
        penaltyPoints.clickContinueButton();
        penaltyPoints.invisibleClickButton();
        InsuranceDetails insuranceDetails1=new InsuranceDetails(getDriver());
        insuranceDetails1.clickInsuranceDetailsHeading();
        insuranceDetails1.selectDrivingExperienceOption("I currently have insurance in my own name in Ireland/UK");
        insuranceDetails1.selectOwnNameInIrelandDropdown("5+");
        insuranceDetails1.clickContinueButton();
        insuranceDetails1.waitForInvisibilityOfContinueButton();
        CarDetails carDetails1=new CarDetails(getDriver());
        carDetails1.clickChangeCarDetails();
        carDetails1.selectCarEstimatedValue("€2001 – €3000");
        carDetails1.clickCarModifiedNo();
        carDetails1.clickContinueButton();
        carDetails1.waitForContinueButtonInvisible();
        AdditionalDrivers additionalDrivers1=new AdditionalDrivers(getDriver());
        additionalDrivers1.clickContinueButton();
        additionalDrivers1.waitForInvisibilityForClickButton();
        YourClaims yourClaims1=new YourClaims(getDriver());
        yourClaims1.clickselectOptionNoOne();
        yourClaims1.clickselectOptionNoTwo();
        yourClaims1.clickContinueButton();
        yourClaims1.invisibleContinueButton();
        yourClaims1.clickyourClaimsHeading();
        PenaltyPoints penaltyPoints1=new PenaltyPoints(getDriver());
        penaltyPoints1.clickpenaltyPointsHeading();
        penaltyPoints1.clickContinueButton();
        penaltyPoints1.invisibleClickButton();
        CoverStartDate coverStartDate=new CoverStartDate(getDriver());
        coverStartDate.inputDate(  dateTimeFormatter.format(LocalDate.now().plusDays(5)));
        coverStartDate.clickhomeInsurancePolicyNo();
        coverStartDate.clickgetCarInsurancePolicyNo();
        coverStartDate.clickreceiveSalaryNo();
        coverStartDate.clicktermsAndConditions();
        coverStartDate.clickgetMyQuoteButton();
        new YourQuote(getDriver()).visibilityOfyourQuoteHeading();
        new YourQuote(getDriver()).clicksinglePaymentBuyNow();
        new YourQuote(getDriver()).invisibilityOfLoading();
        new AboutYourCar(getDriver()).visibilityofaboutYourCar();
        AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
        aboutYourCar.clickcommutingTrue();
        aboutYourCar.clickregisteredTrue();
        aboutYourCar.clickprivateTrue();
        aboutYourCar.clickcontinueButton();
        aboutYourCar.invisiblecontinueButton();*/
        AboutTheDrivers aboutTheDrivers=new AboutTheDrivers(getDriver());
        aboutTheDrivers.fillUptoAboutYourCar(getDriver());
        aboutTheDrivers.selectAllOptionsTrue();
        aboutTheDrivers.inputdriverNumberOne(driverNumber);
        aboutTheDrivers.inputdriverNumberTwo(driverNumber);
        aboutTheDrivers.clickcontinueButton();
        aboutTheDrivers.invisiblecontinueButton();
    }

    void fillUptoAboutTheDriversWithCoveStartDateOptionsYes() throws IOException {

      /*  CustomerScreenOne customerScreenOne = new CustomerScreenOne(getDriver());
        customerScreenOne.load();
        customerScreenOneModal customerScreenOneModal = new customerScreenOneModal(1);
        System.out.println(customerScreenOneModal.getEmail());
        System.out.println(customerScreenOneModal.getTitle());
        customerScreenOne.fillCustomerScreenFormAndContinue(customerScreenOneModal);
        PersonalDetails personalDetails = new PersonalDetails(getDriver());
        personalDetails.waitforVisibiliyofAddressSearchBar();
        personalDetailsModal personalDetailsModal = new personalDetailsModal(1);
        personalDetails.fillPersonalDetailsAndContinue(personalDetailsModal);
        InsuranceDetails insuranceDetails = new InsuranceDetails(getDriver());


        insuranceDetails.selectDrivingExperienceOption(NOPREVIOUSEXPERIENCE);
        insuranceDetails.clickContinueButton();

        new CarDetails(getDriver()).waitForVisibilityForCarDetailsHeading();
        insuranceDetails.scrolldown(SCROLLVALUE);
        CarDetails carDetails = new CarDetails(getDriver());
        CarDetailsModal carDetailsModal=new CarDetailsModal("yes");
        carDetails.fillCardetailsWithRegistrationYes(carDetailsModal);


        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();
        AdditionalDriversModal additionalDriversModal=new AdditionalDriversModal(3);
        additionalDrivers.fillAdditionalDriver(additionalDriversModal);
        additionalDrivers.clickAdditionalDriversNo();
        additionalDrivers.clickContinueButton();
        // additionalDrivers.clickEditDriver();
        // additionalDrivers.visibilityaddDriverButton();
        YourClaims yourClaims=new YourClaims(getDriver());
        yourClaims.fillClaimAndContinue("01/01/2020","Accident","555555555");
        PenaltyPoints penaltyPoints=new PenaltyPoints(getDriver());
        penaltyPoints.clickYesOrNobutton("2");
        penaltyPoints.clickYesOrNobutton("4");
        penaltyPoints.clickContinueButton();
        penaltyPoints.invisibleClickButton();*/
        new CoverStartDate(getDriver()).fillScreenUpToYourPenaltyPoints(getDriver());
        InsuranceDetails insuranceDetails1=new InsuranceDetails(getDriver());
        insuranceDetails1.clickInsuranceDetailsHeading();
        insuranceDetails1.selectDrivingExperienceOption("I currently have insurance in my own name in Ireland/UK");
        insuranceDetails1.invisibleLoading();
       // insuranceDetails1.selectDrivingExperienceOption("I currently have insurance in my own name in Ireland/UK");
        insuranceDetails1.selectOwnNameInIrelandDropdown("5+");

       // insuranceDetails1.selectOwnNameInIrelandDropdown("5+");
        insuranceDetails1.clickContinueButton();
        insuranceDetails1.waitForInvisibilityOfContinueButton();
        CarDetails carDetails1=new CarDetails(getDriver());
        carDetails1.clickChangeCarDetails();
        carDetails1.selectCarEstimatedValue("Less than €75000");
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }
        carDetails1.selectCarEstimatedValue("Less than €75000");
        carDetails1.clickCarModifiedNo();
       // carDetails1.clickCarModifiedNo();
        carDetails1.clickContinueButton();
        carDetails1.waitForContinueButtonInvisible();
        AdditionalDrivers additionalDrivers1=new AdditionalDrivers(getDriver());
        additionalDrivers1.clickContinueButton();
        additionalDrivers1.waitForInvisibilityForClickButton();
        YourClaims yourClaims1=new YourClaims(getDriver());
        yourClaims1.clickselectOptionNoOne();
        yourClaims1.clickselectOptionNoTwo();
        //yourClaims1.clickselectOptionNoOne();
       // yourClaims1.clickselectOptionNoTwo();
        yourClaims1.clickContinueButton();
        yourClaims1.invisibleContinueButton();
        yourClaims1.clickyourClaimsHeading();
        PenaltyPoints penaltyPoints1=new PenaltyPoints(getDriver());
        penaltyPoints1.clickpenaltyPointsHeading();
        penaltyPoints1.clickContinueButton();
        penaltyPoints1.invisibleClickButton();
        CoverStartDate coverStartDate=new CoverStartDate(getDriver());
        coverStartDate.fillAllDetailsYesWithCurrentDate(dateTimeFormatter.format(LocalDate.now()));

        coverStartDate.clicktermsAndConditions();
        coverStartDate.clickgetMyQuoteButton();
        new YourQuote(getDriver()).visibilityOfyourQuoteHeading();
        new YourQuote(getDriver()).clicksinglePaymentBuyNow();
        new YourQuote(getDriver()).invisibilityOfLoading();
        new AboutYourCar(getDriver()).visibilityofaboutYourCar();
        AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
        aboutYourCar.clickcommutingTrue();
        aboutYourCar.clickregisteredTrue();
        aboutYourCar.clickprivateTrue();
        aboutYourCar.clickcommutingTrue();
        aboutYourCar.clickregisteredTrue();
        aboutYourCar.clickprivateTrue();
        aboutYourCar.clickcontinueButton();
        aboutYourCar.invisiblecontinueButton();
        AboutTheDrivers aboutTheDrivers=new AboutTheDrivers(getDriver());
        aboutTheDrivers.selectAllOptionsTrue();
        aboutTheDrivers.inputdriverNumberOne(driverNumber);
        aboutTheDrivers.inputdriverNumberTwo(driverNumber);
        aboutTheDrivers.clickcontinueButton();
        aboutTheDrivers.invisiblecontinueButton();
    }
String validPolicy="123456789";
    @Test
    public void verifyValidationsInYourInsuranceHistoryAndInceptionDetails() throws IOException {
        String reason=" ";
        boolean error=false;

        fillUptoAboutTheDriversWithCoveStartDateOptionsYes();
        YourInsuranceHistoryAndInceptionDetails yourInsuranceHistoryAndInceptionDetails=new YourInsuranceHistoryAndInceptionDetails(getDriver());
        yourInsuranceHistoryAndInceptionDetails.clickcontinueButton();
        System.out.println(yourInsuranceHistoryAndInceptionDetails.getdiscountearnedInIrelandMessage());
        if(!(yourInsuranceHistoryAndInceptionDetails.getdiscountearnedInIrelandMessage().equals("Please select if your no claim discount was earned in Ireland/UK"))){
            error=true;
            reason=reason+"Please select if your no claim discount was earned in Ireland/UK";
        }

        System.out.println(yourInsuranceHistoryAndInceptionDetails.getdiscountOnAnotherPolicyMessage());
        if(!(yourInsuranceHistoryAndInceptionDetails.getdiscountOnAnotherPolicyMessage().equals("Please select if your no claim discount is used on another policy"))){
            error=true;
            reason=reason+"Please select if your no claim discount is used on another policy";
        }
        System.out.println(yourInsuranceHistoryAndInceptionDetails.getcurrentInsuranceValidationMessage());
        if(!(yourInsuranceHistoryAndInceptionDetails.getcurrentInsuranceValidationMessage().equals("Please select if cover date is within 30 days of your current insurance"))){
            error=true;
            reason=reason+"Please select if cover date is within 30 days of your current insurance";
        }
        System.out.println(yourInsuranceHistoryAndInceptionDetails.getcarInsuranceValidationMessage());
        if(!(yourInsuranceHistoryAndInceptionDetails.getcarInsuranceValidationMessage().equals("Please enter a valid policy number"))){
            error=true;
            reason=reason+"Please enter a valid policy number";
        }
        System.out.println(yourInsuranceHistoryAndInceptionDetails.gethomeInsuranceValidationMessage());
        if(!(yourInsuranceHistoryAndInceptionDetails.gethomeInsuranceValidationMessage().equals("Please enter a valid policy number"))){
            error=true;
            reason=reason+"Please enter a valid policy number";
        }
        System.out.println(yourInsuranceHistoryAndInceptionDetails.gettermsAndConditionsMessage());
        if(!(yourInsuranceHistoryAndInceptionDetails.gettermsAndConditionsMessage().equals("Please confirm the details you have provided are correct"))){
            error=true;
            reason=reason+"Please confirm the details you have provided are correct";
        }
        yourInsuranceHistoryAndInceptionDetails.selectAllTrue();
        yourInsuranceHistoryAndInceptionDetails.inputCarPolicy("wewewe");
        yourInsuranceHistoryAndInceptionDetails.inputHomePolicy("ewee1@");
       yourInsuranceHistoryAndInceptionDetails.clicktermsAndConditionsButton();
        yourInsuranceHistoryAndInceptionDetails.clickcontinueButton();
        if(!(yourInsuranceHistoryAndInceptionDetails.getcarInsuranceValidationMessage1().equals("Please enter a valid policy number"))){
            error=true;
            reason=reason+"Please enter a valid policy number";
        }
        if(!(yourInsuranceHistoryAndInceptionDetails.getcarInsuranceValidationMessage2().equals("Please enter a valid policy number"))){
            error=true;
            reason=reason+"Please enter a valid policy number";
        }
        yourInsuranceHistoryAndInceptionDetails.inputCarPolicy(validPolicy);
        yourInsuranceHistoryAndInceptionDetails.inputHomePolicy(validPolicy);
yourInsuranceHistoryAndInceptionDetails.inputCoverTime("8888");
        yourInsuranceHistoryAndInceptionDetails.clicktermsAndConditionsButton();
        yourInsuranceHistoryAndInceptionDetails.clickcontinueButton();
System.out.println(yourInsuranceHistoryAndInceptionDetails.getcoverTimeValidationMessage());
if(!(yourInsuranceHistoryAndInceptionDetails.getcoverTimeValidationMessage().equals("Please enter a valid time"))){
    error=true;
    reason=reason+"Please enter a valid time";

}
        yourInsuranceHistoryAndInceptionDetails.inputCoverTime("0000");
      //  yourInsuranceHistoryAndInceptionDetails.clicktermsAndConditionsButton();
        yourInsuranceHistoryAndInceptionDetails.clickcontinueButton();
        //
        System.out.println(yourInsuranceHistoryAndInceptionDetails.getcoverTimeValidationMessage());
        if(!(yourInsuranceHistoryAndInceptionDetails.getcoverTimeValidationMessage().equals("Start time must not have passed"))){
            error=true;
            reason=reason+"Start time must not have passed";
        }
        if(!(error)){
            passStatus("Able to verify validation messages");
        }else {
            failStatus("Unable to verify "+reason);
        }

    /*    yourInsuranceHistoryAndInceptionDetails.inputCoverTime(timeFormatter.format(LocalTime.now()));
       // yourInsuranceHistoryAndInceptionDetails.clicktermsAndConditionsButton();
yourInsuranceHistoryAndInceptionDetails.clickcontinueButton();
yourInsuranceHistoryAndInceptionDetails.invisiblecontinueButton();
*/

    }

    @Test
    public void verifyCarInsuranceChangePolicyNavigationInYourInsuranceHistoryAndInceptionDetails() throws IOException {
        fillUptoAboutTheDriversWithCoveStartDateOptionsYes();
        YourInsuranceHistoryAndInceptionDetails yourInsuranceHistoryAndInceptionDetails=new YourInsuranceHistoryAndInceptionDetails(getDriver());
        yourInsuranceHistoryAndInceptionDetails.inputCarPolicy(validPolicy);
        yourInsuranceHistoryAndInceptionDetails.clickchangeCarPolicy();
        try {
            new CoverStartDate(getDriver()).visibilitygetMyQuoteButton();
            passStatus("Able to navigate to cover start page");
        }catch (Exception e){
            failStatus("Unable to change policy");
        }

    }
    @Test
    public void verifyHomeInsuranceChangePolicyNavigationInYourInsuranceHistoryAndInceptionDetails() throws IOException {
        fillUptoAboutTheDriversWithCoveStartDateOptionsYes();
        YourInsuranceHistoryAndInceptionDetails yourInsuranceHistoryAndInceptionDetails=new YourInsuranceHistoryAndInceptionDetails(getDriver());
        yourInsuranceHistoryAndInceptionDetails.inputHomePolicy(validPolicy);
        yourInsuranceHistoryAndInceptionDetails.clickchangeHomePolicy();
        try {
            new CoverStartDate(getDriver()).visibilitygetMyQuoteButton();
            passStatus("Able to navigate to cover start page");
        }catch (Exception e){
            failStatus("Unable to change policy");
        }

    }
    @Test
    public void verifyCoverDateValueInYourInsuranceHistoryAndInceptionDetails() throws IOException {
        fillUptoAboutTheDriversWithCoveStartDateOptionsNo();
        YourInsuranceHistoryAndInceptionDetails yourInsuranceHistoryAndInceptionDetails=new YourInsuranceHistoryAndInceptionDetails(getDriver());
        if(yourInsuranceHistoryAndInceptionDetails.getCoverdateValue().equals(dateTimeFormatter.format(LocalDate.now().plusDays(5)))){
passStatus("Able to verify cover date");
        }else {
            failStatus("Unable to verify cover date");
        }
    }

    @Test
    public void verifyModalsContentInYourInsuranceHistoryAndInceptionDetails() throws IOException {
        String reason=" ";
        boolean error=false;
        fillUptoAboutTheDriversWithCoveStartDateOptionsNo();
        YourInsuranceHistoryAndInceptionDetails yourInsuranceHistoryAndInceptionDetails=new YourInsuranceHistoryAndInceptionDetails(getDriver());
        yourInsuranceHistoryAndInceptionDetails.clickisConsentNo();
        yourInsuranceHistoryAndInceptionDetails.clickinsuranceCertificateTooltip();
        System.out.println(yourInsuranceHistoryAndInceptionDetails.getmodalDescription());
        if(!(yourInsuranceHistoryAndInceptionDetails.getmodalDescription().equals("You can print your annual car insurance certificate and disc in colour instantly through MyAviva. Posting it to you may take up to 5 working days."))){
            error=true;
            reason=reason+"You can print your annual car insurance certificate and disc in colour instantly through MyAviva. Posting it to you may take up to 5 working days.";
        }
        yourInsuranceHistoryAndInceptionDetails.clickcloseModal();
        yourInsuranceHistoryAndInceptionDetails.clickpolicyDocumentationTooltip();
        System.out.println(yourInsuranceHistoryAndInceptionDetails.getmodalDescription());
        if(!(yourInsuranceHistoryAndInceptionDetails.getmodalDescription().equals("You can view and download your policy documentation instantly through MyAviva. Posting it to you may take up to 5 working days."))){
            error=true;
            reason=reason+"You can view and download your policy documentation instantly through MyAviva. Posting it to you may take up to 5 working days.";
        }
        yourInsuranceHistoryAndInceptionDetails.clickcloseModal();

if(!(error)){
    passStatus("Able to verify modals");
}else {
    failStatus("Unable to verify "+reason);
}

    }

}
