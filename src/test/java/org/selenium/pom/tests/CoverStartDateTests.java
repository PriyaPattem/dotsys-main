package org.selenium.pom.tests;

import org.openqa.selenium.WebElement;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.AdditionalDriversModal;
import org.selenium.pom.objects.CarDetailsModal;
import org.selenium.pom.objects.customerScreenOneModal;
import org.selenium.pom.objects.personalDetailsModal;
import org.selenium.pom.pages.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.selenium.pom.tests.InsuranceDetailsTests.NOPREVIOUSEXPERIENCE;

public class CoverStartDateTests extends BaseTest {
    static final String SCROLLVALUE="600";
 /*   public void fillScreenUpToYourPenaltyPoints() throws IOException {
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
        //
        PenaltyPoints penaltyPoints=new PenaltyPoints(getDriver());
        penaltyPoints.clickYesOrNobutton("2");
        penaltyPoints.clickYesOrNobutton("4");
        penaltyPoints.clickContinueButton();
        penaltyPoints.invisibleClickButton();

    }*/
    public void fillScreenUpToYourPenaltyPoints() throws IOException {
        new CoverStartDate(getDriver()).fillScreenUpToYourPenaltyPoints(getDriver());
    }

    @Test
    public void verifyValidationsInCoverStartPage() throws IOException {
        String reason=" ";
        boolean error=false;
        fillScreenUpToYourPenaltyPoints();
        CoverStartDate coverStartDate=new CoverStartDate(getDriver());
        coverStartDate.clickgetMyQuoteButton();
        System.out.println(coverStartDate.getinputDateVaidationMessage());
        if(!(coverStartDate.getinputDateVaidationMessage().equals("Please enter a date"))){
            error=true;
            reason=reason+"Please enter a date validation missing";
        }
        System.out.println(coverStartDate.gethomeInsuranceValidationMessage());
        if(!(coverStartDate.gethomeInsuranceValidationMessage().equals("Please select an option"))){
            error=true;
            reason=reason+"Please select an option validation missing";
        }
        System.out.println(coverStartDate.getcarInsuranceValidationMessage());
        if(!(coverStartDate.getcarInsuranceValidationMessage().equals("Please select an option"))){
            error=true;
            reason=reason+"Please select an option validation missing";
        }
        System.out.println(coverStartDate.getreceiveOffersValidationMessage());
        if(!(coverStartDate.getreceiveOffersValidationMessage().equals("Please select an option"))){
            error=true;
            reason=reason+"Please select an option validation missing";
        }
        System.out.println(coverStartDate.gettermsAndConditionsValidationMessage());
        if(!(coverStartDate.gettermsAndConditionsValidationMessage().equals("Please read the terms and conditions"))){
            error=true;
            reason=reason+"Please read the terms and conditions validation missing";
        }
        if(!(error)){
            passStatus("Able to verify validation messages");
        }else {
            failStatus("Unable to verify "+reason);
        }
    }
    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Test
    public void verifyPastDateValidationInCoverStartPage() throws IOException {
       String date= dateTimeFormatter.format(LocalDate.now().minusDays(1));
        String reason=" ";
        boolean error=false;
        fillScreenUpToYourPenaltyPoints();
        CoverStartDate coverStartDate=new CoverStartDate(getDriver());
        coverStartDate.inputDate(date);
        coverStartDate.clickcarInsurancePolicyYes();
        coverStartDate.clickreceiveSalaryYes();
        coverStartDate.clickhomeInsurancePolicyYes();
        coverStartDate.clicktermsAndConditions();
        coverStartDate.clickgetMyQuoteButton();
System.out.println(coverStartDate.getstartDateEndDateValidationMessage());
if(coverStartDate.getstartDateEndDateValidationMessage().equals("Cover start date cannot occur in the past")){
    passStatus("Able to verify validation");
}else {
    failStatus("Unable to verify Cover start date cannot occur in the past");
}
    }

    @Test
    public void verifyPastFuture45DaysValidationInCoverStartPage() throws IOException {
        String date= dateTimeFormatter.format(LocalDate.now().plusDays(46));
        String reason=" ";
        boolean error=false;
        fillScreenUpToYourPenaltyPoints();
        CoverStartDate coverStartDate=new CoverStartDate(getDriver());
        coverStartDate.inputDate(date);
        coverStartDate.clickcarInsurancePolicyYes();
        coverStartDate.clickreceiveSalaryYes();
        coverStartDate.clickhomeInsurancePolicyYes();
        coverStartDate.clicktermsAndConditions();
        coverStartDate.clickgetMyQuoteButton();
        System.out.println(coverStartDate.getstartDateEndDateValidationMessage());
       if(coverStartDate.getstartDateEndDateValidationMessage().equals("Cover start date cannot occur more than 45 days in the future")){
            passStatus("Able to verify validation");
        }else {
            failStatus("Unable to verify Cover start date cannot occur more than 45 days in the future");
        }

    }
    @Test
    public void  verifyhomeInsuranceModalInCoverStartPage() throws IOException {
        fillScreenUpToYourPenaltyPoints();
        CoverStartDate coverStartDate=new CoverStartDate(getDriver());
        coverStartDate.clickinsurancePolicyModal();
        System.out.println(coverStartDate.getModalText());
        if(coverStartDate.getModalText().equals("If you currently have an Aviva Home insurance policy directly with us (Aviva Direct Ireland Limited) you will be entitled to our Aviva Loyalty Discount. You will be asked to provide your policy number when going on cover.")){
            passStatus("Able to verify modal content");
        }else {
            failStatus("Unable to verify modal content");
        }

    }
    @Test
    public void  verifycarInsuranceModalInCoverStartPage() throws IOException {
        fillScreenUpToYourPenaltyPoints();
        CoverStartDate coverStartDate=new CoverStartDate(getDriver());
        coverStartDate.clickcarInsurancePolicyModal();
        System.out.println(coverStartDate.getModalText());
        if(coverStartDate.getModalText().equals("We offer a multicar discount of 10% on second and subsequent car policies, up to a maximum of five policies, if the new and existing policies are taken out through Aviva Direct Ireland Limited. Vehicles must be owned by members of the same household and registered at the same address. All discounts applied subject to minimum premium.")){
            passStatus("Able to verify modal content");
        }else {
            failStatus("Unable to verify modal content");
        }

    }

    @Test
    public void verifytermsAndConditionsLinksInCoverStartDate() throws IOException {
        String reason=" ";
        boolean error=false;
        ArrayList<String> links=new ArrayList<>();
        links.add("https://www.aviva.ie/insurance/car-insurance/our-assumptions/");
        links.add("https://www.aviva.ie/about-and-support/terms/");
        links.add("https://www.aviva.ie/about-and-support/privacy/data-privacy-summary-direct/");
        links.add("https://www.aviva.ie/content/dam/aviva-public/ie/pdfs/gi-commission-arrangements.pdf");
        fillScreenUpToYourPenaltyPoints();
        CoverStartDate coverStartDate=new CoverStartDate(getDriver());
for(WebElement element:coverStartDate.gettermsAndConditionsLinks()){
    System.out.println(element.getAttribute("href"));
    if(!(links.contains(element.getAttribute("href")))){
        error=true;
        reason=reason+"Unable to verify "+element.getAttribute("href");
    }
}
if(!(error)){
    passStatus("Able to verify links");
}else {
    failStatus("Unable to verify links "+reason);
}
    }

    @Test
    public void navigateToQuoteScreen() throws IOException {
        fillScreenUpToYourPenaltyPoints();
InsuranceDetails insuranceDetails=new InsuranceDetails(getDriver());
insuranceDetails.clickInsuranceDetailsHeading();
insuranceDetails.selectDrivingExperienceOption("I currently have insurance in my own name in Ireland/UK");
insuranceDetails.selectOwnNameInIrelandDropdown("5+");
insuranceDetails.clickContinueButton();
insuranceDetails.waitForInvisibilityOfContinueButton();
CarDetails carDetails=new CarDetails(getDriver());
carDetails.clickChangeCarDetails();
carDetails.selectCarEstimatedValue("Less than €75000");
carDetails.clickCarModifiedNo();
carDetails.clickContinueButton();
carDetails.waitForContinueButtonInvisible();
AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
additionalDrivers.clickContinueButton();
additionalDrivers.waitForInvisibilityForClickButton();
YourClaims yourClaims=new YourClaims(getDriver());
yourClaims.clickselectOptionNoOne();
yourClaims.clickselectOptionNoTwo();
yourClaims.clickContinueButton();
yourClaims.invisibleContinueButton();
yourClaims.clickyourClaimsHeading();
PenaltyPoints penaltyPoints=new PenaltyPoints(getDriver());
penaltyPoints.clickpenaltyPointsHeading();
penaltyPoints.clickContinueButton();
penaltyPoints.invisibleClickButton();
CoverStartDate coverStartDate=new CoverStartDate(getDriver());
coverStartDate.inputDate(  dateTimeFormatter.format(LocalDate.now().plusDays(5)));
coverStartDate.clickhomeInsurancePolicyNo();
coverStartDate.clickgetCarInsurancePolicyNo();
coverStartDate.clickreceiveSalaryNo();
coverStartDate.clicktermsAndConditions();

coverStartDate.clickgetMyQuoteButton();
try {
    new YourQuote(getDriver()).visibilityOfyourQuoteHeading();
    passStatus("Able to getQuote");
}catch (Exception e){
    failStatus("Unable to get quote");
}


    }
}
