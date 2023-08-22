package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.*;
import org.selenium.pom.pages.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.selenium.pom.tests.InsuranceDetailsTests.NOPREVIOUSEXPERIENCE;

public class AboutTheDriversTests extends BaseTest {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static final String SCROLLVALUE = "600";

    /* public void fillUptoAboutYourCar() throws IOException {

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
          //
          AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
          aboutYourCar.clickcommutingTrue();
          aboutYourCar.clickregisteredTrue();
          aboutYourCar.clickprivateTrue();
          aboutYourCar.clickcontinueButton();
          aboutYourCar.invisiblecontinueButton();
      }*/
    public void fillUptoAboutYourCar() throws IOException {
        new AboutTheDrivers(getDriver()).fillUptoAboutYourCar(getDriver());
    }

    @Test
    public void verifyValidationMessagesInAboutTheDriversPage() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickcontinueButton();
        System.out.println(aboutTheDrivers.getpermanentResidentValidationMessage());
        if (!(aboutTheDrivers.getpermanentResidentValidationMessage().equals("Please select if you are a permanent resident"))) {
            error = true;
            reason = reason + "Please select if you are a permanent resident";
        }

        System.out.println(aboutTheDrivers.getmainDriverValidationMessage());
        if (!(aboutTheDrivers.getmainDriverValidationMessage().equals("Please select the main driver"))) {
            error = true;
            reason = reason + "Please select the main driver";
        }
        System.out.println(aboutTheDrivers.getmainDriverOfAnotherCarValidationMessage());
        if (!(aboutTheDrivers.getmainDriverOfAnotherCarValidationMessage().equals("Please select if you are the main driver of another car"))) {
            error = true;
            reason = reason + "Please select if you are the main driver of another car";
        }
        System.out.println(aboutTheDrivers.getinsuredOnOtherCarValidationMessage());
        if (!(aboutTheDrivers.getinsuredOnOtherCarValidationMessage().equals("Please select if you are insured on another car"))) {
            error = true;
            reason = reason + "Please select if you are insured on another car";
        }
        System.out.println(aboutTheDrivers.getdriversHaveConvictionsValidationMessage());
        if (!(aboutTheDrivers.getdriversHaveConvictionsValidationMessage().equals("Please select if any drivers have convictions"))) {
            error = true;
            reason = reason + "Please select if any drivers have convictions";
        }
        System.out.println(aboutTheDrivers.getdriversHaveDisqualificationsValidationMessage());
        if (!(aboutTheDrivers.getdriversHaveDisqualificationsValidationMessage().equals("Please select if any drivers have disqualifications"))) {
            error = true;
            reason = reason + "Please select if any drivers have disqualifications";
        }
        System.out.println(aboutTheDrivers.getdriversHaveRefusedInsuranceValidationMessage());
        if (!(aboutTheDrivers.getdriversHaveRefusedInsuranceValidationMessage().equals("Please select if any drivers have been refused insurance"))) {
            error = true;
            reason = reason + "Please select if any drivers have been refused insurance";
        }
        System.out.println(aboutTheDrivers.getdriversHaveIncreasedExcessValidationMessage());
        if (!(aboutTheDrivers.getdriversHaveIncreasedExcessValidationMessage().equals("Please select if any drivers have had an increased excess"))) {
            error = true;
            reason = reason + "Please select if any drivers have had an increased excess";


        }
        System.out.println(aboutTheDrivers.getdriversHaveMedicalInsuranceValidationMessage());
        if (!(aboutTheDrivers.getdriversHaveMedicalInsuranceValidationMessage().equals("Please select if any drivers have a medical condition"))) {
            error = true;
            reason = reason + "Please select if any drivers have a medical condition";
        }
        if (!(error)) {
            passStatus("Able to verify validation messages");
        } else {
            failStatus("Unable to verify" + reason);
        }
    }

    String driverNumber = "123456789";

    @Test
    public void verifyAllTrueOptionsSelectionsInAboutYourCarPage() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.selectAllOptionsTrue();
        aboutTheDrivers.inputdriverNumberOne(driverNumber);
        aboutTheDrivers.inputdriverNumberTwo(driverNumber);
        aboutTheDrivers.clickcontinueButton();
        aboutTheDrivers.invisiblecontinueButton();
        aboutTheDrivers.clickaboutYourDriversHeading();
        aboutTheDrivers.visibilitycontinueButton();

        System.out.println("isPermanentResidentTrue" + aboutTheDrivers.isPermanentResidentTrue());
        if (!(aboutTheDrivers.isPermanentResidentTrue())) {
            error = true;
            reason = reason + "Unable to verify isPermanentResidentTrue";
        }
        System.out.println("isMainDriverTrue" + aboutTheDrivers.isMainDriverTrue());
        if (!(aboutTheDrivers.isMainDriverTrue())) {
            error = true;
            reason = reason + "Unable to verify isMainDriverTrue";
        }
        System.out.println("isMainDriverOfAnotherCarTrue" + aboutTheDrivers.isMainDriverOfAnotherCarTrue());
        if (!(aboutTheDrivers.isMainDriverOfAnotherCarTrue())) {
            error = true;
            reason = reason + "Unable to verify isMainDriverOfAnotherCarTrue";
        }
        System.out.println("isInsuredOnOtherCarTrue" + aboutTheDrivers.isInsuredOnOtherCarTrue());
        if (!(aboutTheDrivers.isInsuredOnOtherCarTrue())) {
            error = true;
            reason = reason + "Unable to verify isInsuredOnOtherCarTrue";
        }
        System.out.println("isConvictionsTrue" + aboutTheDrivers.isConvictionsTrue());
        if (!(aboutTheDrivers.isConvictionsTrue())) {
            error = true;
            reason = reason + "Unable to verify isConvictionsTrue";
        }
        System.out.println("isDrivingDisqualiFicationsTrue" + aboutTheDrivers.isDrivingDisqualiFicationsTrue());

        if (!(aboutTheDrivers.isDrivingDisqualiFicationsTrue())) {
            error = true;
            reason = reason + "Unable to verify isDrivingDisqualiFicationsTrue";
        }
        System.out.println("isRefusalTrue" + aboutTheDrivers.isRefusalTrue());
        if (!(aboutTheDrivers.isRefusalTrue())) {
            error = true;
            reason = reason + "Unable to verify isRefusalTrue";
        }
        System.out.println("isExcessedIncreaseTrue" + aboutTheDrivers.isExcessedIncreaseTrue());
        if (!(aboutTheDrivers.isExcessedIncreaseTrue())) {
            error = true;
            reason = reason + "Unable to verify isExcessedIncreaseTrue";
        }
        System.out.println("isMedicalConditionsTrue" + aboutTheDrivers.isMedicalConditionsTrue());
        if (!(aboutTheDrivers.isMedicalConditionsTrue())) {
            error = true;
            reason = reason + "Unable to verify isMedicalConditionsTrue";
        }
        if (!(error)) {
            passStatus("Able to verify selections");
        } else {
            failStatus("Unable to verify selections due to following " + reason);
        }
    }

    @Test
    public void verifyAllFalseOptionsSelectionsInAboutYourCarPage() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.selectAllOptionsFalse();
        aboutTheDrivers.inputdriverNumberOne(driverNumber);
        aboutTheDrivers.inputdriverNumberTwo(driverNumber);
        aboutTheDrivers.clickcontinueButton();
        aboutTheDrivers.invisiblecontinueButton();
        //aboutTheDrivers.clickaboutYourDriversHeading();
        new YourInsuranceHistoryAndInceptionDetails(getDriver()).clickbackButton();
        aboutTheDrivers.visibilitycontinueButton();
        System.out.println(aboutTheDrivers.isPermanentResidentFalse());
        if (!(aboutTheDrivers.isPermanentResidentFalse())) {
            error = true;
            reason = reason + "isPermanentResidentFalse";
        }
        System.out.println(aboutTheDrivers.isMainDriverFalse());
        if (!(aboutTheDrivers.isMainDriverFalse())) {
            error = true;
            reason = reason + "isMainDriverFalse";
        }
        System.out.println(aboutTheDrivers.isMainDriverOfAnotherCarFalse());
        if (!(aboutTheDrivers.isMainDriverOfAnotherCarFalse())) {
            error = true;
            reason = reason + "isMainDriverOfAnotherCarFalse";
        }
        System.out.println(aboutTheDrivers.isInsuredOnOtherCarFalse());
        if (!(aboutTheDrivers.isInsuredOnOtherCarFalse())) {
            error = true;
            reason = reason + "isInsuredOnOtherCarFalse";
        }
        System.out.println(aboutTheDrivers.isConvictionsFalse());
        if (!(aboutTheDrivers.isConvictionsFalse())) {
            error = true;
            reason = reason + "isConvictionsFalse";
        }
        System.out.println(aboutTheDrivers.isDrivingDisqualificationsFalse());
        if (!(aboutTheDrivers.isDrivingDisqualificationsFalse())) {
            error = true;
            reason = reason + "isDrivingDisqualificationsFalse";
        }
        System.out.println(aboutTheDrivers.isRefusalFalse());
        if (!(aboutTheDrivers.isRefusalFalse())) {
            error = true;
            reason = reason + "isRefusalFalse";
        }
        System.out.println(aboutTheDrivers.isExcessedIncreasedFalse());
        if (!(aboutTheDrivers.isExcessedIncreasedFalse())) {
            error = true;
            reason = reason + "isExcessedIncreasedFalse";
        }
        System.out.println(aboutTheDrivers.isMedicalConditionsFalse());
        if (!(aboutTheDrivers.isMedicalConditionsFalse())) {
            error = true;
            reason = reason + "isMedicalConditionsFalse";
        }
        if (!(error)) {
            passStatus("Able to verify false selections");
        } else {
            failStatus("Unable to verify " + reason);
        }
    }

    String driver = "sumanth vuppu";
    String convictionType = "Dangerous Driving";

    @Test
    public void verifyAddOffenceConvictionValidationsInAboutTheDriversPage() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickDriverConvictionsNo();
        aboutTheDrivers.clickaddConviction();
        aboutTheDrivers.clicksaveConviction();
        System.out.println(aboutTheDrivers.getselectDriverValidationMessage());
        if (!(aboutTheDrivers.getselectDriverValidationMessage().equals("Please select a driver"))) {
            error = true;
            reason = reason + "Please select a driver";
        }
        System.out.println(aboutTheDrivers.getenterDatevalidationMessage());
        if (!(aboutTheDrivers.getenterDatevalidationMessage().equals("Please enter a date"))) {
            error = true;
            reason = reason + "Please enter a date";
        }
        System.out.println(aboutTheDrivers.getselectConvictionValidationMessage());
        if (!(aboutTheDrivers.getselectConvictionValidationMessage().equals("Please select a convition or offence"))) {
            error = true;
            reason = reason + "Please select a convition or offence";
        }
        aboutTheDrivers.convictionSelectDriver(driver);
        aboutTheDrivers.selectconvictionType(convictionType);
        aboutTheDrivers.inputconvictionsDate(dateTimeFormatter.format(LocalDate.now().plusDays(20)));
        aboutTheDrivers.clicksaveConviction();
        System.out.println(aboutTheDrivers.getconvictionsDateValidationMessage());
        if (!(aboutTheDrivers.getconvictionsDateValidationMessage().equals("Invalid date, must be in the past"))) {
            error = true;
            reason = reason + "Invalid date, must be in the past";
        }
        aboutTheDrivers.inputconvictionsDate("01/01/1800");
        aboutTheDrivers.clicksaveConviction();
        System.out.println(aboutTheDrivers.getconvictionsDateValidationMessage());
        if (!(aboutTheDrivers.getconvictionsDateValidationMessage().equals("Date must be after 1900"))) {
            error = true;
            reason = reason + "Date must be after 1900";
        }
        aboutTheDrivers.clickcancelConvictions();
        aboutTheDrivers.clickaddConviction();
        if (!(error)) {
            passStatus("Able to verify validation messages");
        } else {
            failStatus("Unable to verify " + reason);
        }

    }

    @Test
    public void verifyAddOffenceConvictionInAboutTheDrivers() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickDriverConvictionsNo();
        aboutTheDrivers.clickaddConviction();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("conviction");
        aboutTheDrivers.addConviction(aboutTheDriversModal);
        aboutTheDrivers.getconvictionAddedMessage();
        if (!(aboutTheDrivers.getconvictionAddedMessage().equals("Offence/conviction added"))) {
            error = true;
            reason = reason + "Offence/conviction added missing";
        }
        aboutTheDrivers.clickeditConviction();
        aboutTheDrivers.visibilitycancelConvictions();
        System.out.println(aboutTheDrivers.getconvictionSelectDriverJS());
        if (!(aboutTheDrivers.getconvictionSelectDriverJS().equals(aboutTheDriversModal.getName()))) {
            error = true;
            reason = reason + " Unable to verify driver name";
        }
        System.out.println(aboutTheDrivers.getinputconvictionsDateJS());
        if (!(aboutTheDrivers.getinputconvictionsDateJS().equals(aboutTheDriversModal.getDate()))) {
            error = true;
            reason = " Unable to verify date";
        }
        System.out.println(aboutTheDrivers.getselectconvictionTypeJS());
        if (!(aboutTheDrivers.getselectconvictionTypeJS().equals(aboutTheDriversModal.getType()))) {
            error = true;
            reason = " Unable to verify type";
        }
        if (!(error)) {
            passStatus("Able to add Office Conviction");
        } else {
            failStatus("Unable to add Office Conviction due to following " + reason);
        }
    }

    @Test
    public void verifyUpdateOffenceConvictionInAboutTheDrivers() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickDriverConvictionsNo();
        aboutTheDrivers.clickaddConviction();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("conviction");
        aboutTheDrivers.addConviction(aboutTheDriversModal);
        aboutTheDrivers.getconvictionAddedMessage();
        aboutTheDrivers.clickeditConviction();
        aboutTheDrivers.visibilitycancelConvictions();
        System.out.println(aboutTheDrivers.getconvictionSelectDriverJS());
        System.out.println(aboutTheDrivers.getinputconvictionsDateJS());
        System.out.println(aboutTheDrivers.getselectconvictionTypeJS());
        //
        AboutTheDriversModal aboutTheDriversModal1 = new AboutTheDriversModal("convictionUpdate");
        aboutTheDrivers.addConviction(aboutTheDriversModal1);
        aboutTheDrivers.getconvictionAddedMessage();
        if (!(aboutTheDrivers.getconvictionAddedMessage().equals("Offence/conviction added"))) {

        }
        aboutTheDrivers.clickeditConviction();
        aboutTheDrivers.visibilitycancelConvictions();
        System.out.println(aboutTheDrivers.getconvictionSelectDriverJS());
        if (!(aboutTheDrivers.getconvictionSelectDriverJS().equals(aboutTheDriversModal1.getName()))) {
            error = true;
            reason = reason + " Unable to verify driver name";
        }
        System.out.println(aboutTheDrivers.getinputconvictionsDateJS());
        if (!(aboutTheDrivers.getinputconvictionsDateJS().equals(aboutTheDriversModal1.getDate()))) {
            error = true;
            reason = " Unable to verify date";
        }
        System.out.println(aboutTheDrivers.getselectconvictionTypeJS());
        if (!(aboutTheDrivers.getselectconvictionTypeJS().equals(aboutTheDriversModal1.getType()))) {
            error = true;
            reason = " Unable to verify type";
        }
        if (!(error)) {
            passStatus("Able to add Office Conviction");
        } else {
            failStatus("Unable to add Office Conviction due to following " + reason);
        }

    }

    @Test
    public void verifyDeleteConvictionInAboutTheDrivers() throws IOException {

        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickDriverConvictionsNo();
        aboutTheDrivers.clickaddConviction();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("conviction");
        aboutTheDrivers.addConviction(aboutTheDriversModal);
        aboutTheDrivers.getconvictionAddedMessage();
        aboutTheDrivers.clickdeleteConviction();
        aboutTheDrivers.clickremoveConviction();
        try {
            aboutTheDrivers.visibilityaddConviction();
            passStatus("Able to delete conviction");
        } catch (Exception e) {
            failStatus("Unable to delete conviction");
        }
    }

    @Test
    public void verifyAddDrivingDisqualificationValidationsInAboutTheDrivers() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickdriverDisqualificationsNo();
        aboutTheDrivers.clickaddDrivingDisqualification();
        aboutTheDrivers.clicksaveDrivingDisqualification();
        System.out.println(aboutTheDrivers.getdisqualificationselectDriver());
        if (!(aboutTheDrivers.getdisqualificationselectDriver().equals("Please select a driver"))) {
            error = true;
            reason = reason + " Please select a driver";
        }
        System.out.println(aboutTheDrivers.getdisqualificationEnterDate());
        if (!(aboutTheDrivers.getdisqualificationEnterDate().equals("Please enter a date"))) {
            error = true;
            reason = reason + " Please enter a date";
        }
        System.out.println(aboutTheDrivers.getdisqualificationReason());
        if (!(aboutTheDrivers.getdisqualificationReason().equals("Please select a disqualification reason"))) {
            error = true;
            reason = reason + " Please select a disqualification reason";
        }
        aboutTheDrivers.selectDisqualificationDriver("sumanth vuppu");
        aboutTheDrivers.selectDisqualificationReason("Accident not reported by the Insured");
        aboutTheDrivers.inputDisqualificationDate("01/01/1800");
        aboutTheDrivers.clicksaveDrivingDisqualification();
        System.out.println(aboutTheDrivers.getdisqualificationDateValidation());
        if (!(aboutTheDrivers.getdisqualificationDateValidation().equals("Date must be after 1900"))) {
            error = true;
            reason = reason + " Date must be after 1900";
        }
        aboutTheDrivers.inputDisqualificationDate(dateTimeFormatter.format(LocalDate.now().plusDays(20)));
        aboutTheDrivers.clicksaveDrivingDisqualification();
        System.out.println(aboutTheDrivers.getdisqualificationDateValidation());
        if (!(aboutTheDrivers.getdisqualificationDateValidation().equals("Invalid date, must be in the past"))) {
            error = true;
            reason = reason + "Invalid date, must be in the past";
        }
        aboutTheDrivers.clickcancelDisqualification();

        aboutTheDrivers.clickaddDrivingDisqualification();
        if (!(error)) {
            passStatus("Able to verify add driving disqualification validation messages");
        } else {
            failStatus("Unable to verify the following " + reason);
        }
    }

    @Test
    public void verifyAddDriverDisqualificationInAboutTheDrivers() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickdriverDisqualificationsNo();
        aboutTheDrivers.clickaddDrivingDisqualification();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("disqualification");
        aboutTheDrivers.addDrivingDisqualification(aboutTheDriversModal);
        System.out.println(aboutTheDrivers.getdisqualificationAddedMessage());
        aboutTheDrivers.clickeditDisqualification();
        aboutTheDrivers.visibilitycancelDisqualification();
        System.out.println(aboutTheDrivers.getselectedDisqualificationDriverJS());
        if (!(aboutTheDrivers.getselectedDisqualificationDriverJS().equals(aboutTheDriversModal.getName()))) {
            error = true;
            reason = reason + "Unable to verify driver name";
        }
        System.out.println(aboutTheDrivers.getDisqualifiedDateJS());
        if (!(aboutTheDrivers.getDisqualifiedDateJS().equals(aboutTheDriversModal.getDate()))) {
            error = true;
            reason = reason + "Unable to verify date";
        }
        System.out.println(aboutTheDrivers.getDisqualifiedTypeJS());
        if (!(aboutTheDrivers.getDisqualifiedTypeJS().equals(aboutTheDriversModal.getType()))) {
            error = true;
            reason = reason + "Unable to verify reason for disqualification";
        }
        if (!(error)) {
            passStatus("Able to verify Add driver disqualification");
        } else {
            failStatus("Unable to verify due to following conditions" + reason);
        }
    }

    @Test
    public void verifyUpdateDriverDisqualificationInAboutTheDriver() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickdriverDisqualificationsNo();
        aboutTheDrivers.clickaddDrivingDisqualification();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("disqualification");
        aboutTheDrivers.addDrivingDisqualification(aboutTheDriversModal);
        System.out.println(aboutTheDrivers.getdisqualificationAddedMessage());
        aboutTheDrivers.clickeditDisqualification();
        aboutTheDrivers.visibilitycancelDisqualification();
        AboutTheDriversModal aboutTheDriversModal1 = new AboutTheDriversModal("disqualificationUpdate");
        aboutTheDrivers.addDrivingDisqualification(aboutTheDriversModal1);
        aboutTheDrivers.clickeditDisqualification();
        aboutTheDrivers.visibilitycancelDisqualification();
        System.out.println(aboutTheDrivers.getselectedDisqualificationDriverJS());
        if (!(aboutTheDrivers.getselectedDisqualificationDriverJS().equals(aboutTheDriversModal1.getName()))) {
            error = true;
            reason = reason + "Unable to verify driver name";
        }
        System.out.println(aboutTheDrivers.getDisqualifiedDateJS());
        if (!(aboutTheDrivers.getDisqualifiedDateJS().equals(aboutTheDriversModal1.getDate()))) {
            error = true;
            reason = reason + "Unable to verify date";
        }
        System.out.println(aboutTheDrivers.getDisqualifiedTypeJS());
        if (!(aboutTheDrivers.getDisqualifiedTypeJS().equals(aboutTheDriversModal1.getType()))) {
            error = true;
            reason = reason + "Unable to verify reason for disqualification";
        }
        if (!(error)) {
            passStatus("Able to verify Add driver disqualification");
        } else {
            failStatus("Unable to verify due to following conditions" + reason);
        }
    }

    @Test
    public void verifyDeleteDriverDisqualificationInAboutTheDriver() throws IOException {
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickdriverDisqualificationsNo();
        aboutTheDrivers.clickaddDrivingDisqualification();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("disqualification");
        aboutTheDrivers.addDrivingDisqualification(aboutTheDriversModal);
        System.out.println(aboutTheDrivers.getdisqualificationAddedMessage());
        aboutTheDrivers.clickdeleteDriverDisqualification();
        aboutTheDrivers.clickremoveDisqualification();
        try {
            aboutTheDrivers.visibilityaddDrivingDisqualification();
            passStatus("Able to delete driver disqualification");
        } catch (Exception e) {
            failStatus("Unable to delete driver disqualification");
        }

    }

    @Test
    public void verifyRefusalCancellationValidationsInAboutTheDriver() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickrefusedInsuranceNo();
        aboutTheDrivers.clickaddRefusal();
        aboutTheDrivers.clicksaveRefusal();
        System.out.println(aboutTheDrivers.getenterDateRefusalMessage());
        if (!(aboutTheDrivers.getenterDateRefusalMessage().equals("Please enter a date"))) {
            error = true;
            reason = reason + "Please enter a date";
        }
        System.out.println(aboutTheDrivers.getrefusalCancellationMessage());
        if (!(aboutTheDrivers.getrefusalCancellationMessage().equals("Please select a refusal/cancellation reason"))) {
            error = true;
            reason = reason + "Please select a refusal/cancellation reason";
        }
        System.out.println(aboutTheDrivers.getselectDriverRefusalMessage());
        if (!(aboutTheDrivers.getselectDriverRefusalMessage().equals("Please select a driver"))) {
            error = true;
            reason = reason + "Please select a driver";
        }
        aboutTheDrivers.selectRefusalDriver("sumanth vuppu");
        aboutTheDrivers.inputRefusalCancellationReason("sample");
        aboutTheDrivers.inputRefusalDate("01/01/2050");
        aboutTheDrivers.clicksaveRefusal();
        System.out.println(aboutTheDrivers.getrefusalpastFutureMessage());
        if (!(aboutTheDrivers.getrefusalpastFutureMessage().contains("Invalid date, must be in the past"))) {
            error = true;
            reason = reason + "Invalid date, must be in the past";
        }
        aboutTheDrivers.inputRefusalDate(dateTimeFormatter.format(LocalDate.now().minusYears(7)));
        aboutTheDrivers.clicksaveRefusal();
        System.out.println(aboutTheDrivers.getrefusalpastFutureMessage());
        if (!(aboutTheDrivers.getrefusalpastFutureMessage().equals("Date must be within last 7 years"))) {
            error = true;
            reason = reason + "Date must be within last 7 years";
        }
        aboutTheDrivers.clickcancelRefusal();
        aboutTheDrivers.visibilityaddRefusal();
        if (!(error)) {
            passStatus("Able to verify Validations");
        } else {
            failStatus("Unable to verify " + reason);
        }
    }

    @Test
    public void verifyAddRefusalInAboutTheDriver() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickrefusedInsuranceNo();
        aboutTheDrivers.clickaddRefusal();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("refusal");
        aboutTheDrivers.fillAddRefusal(aboutTheDriversModal);
        aboutTheDrivers.clickeditRefusal();
        aboutTheDrivers.visibilitysaveRefusal();
        System.out.println(aboutTheDrivers.getRefusalDriverJS());
        if (!(aboutTheDrivers.getRefusalDriverJS().equals(aboutTheDriversModal.getName()))) {
            error = true;
            reason = reason + "Unable to verify driver name";
        }
        System.out.println(aboutTheDrivers.getRefusalDateJS());
        if (!(aboutTheDrivers.getRefusalDateJS().equals(aboutTheDriversModal.getDate()))) {
            error = true;
            reason = reason + "Unable to verify date";
        }
        System.out.println(aboutTheDrivers.getrefusalReasonJS());
        if (!(aboutTheDrivers.getrefusalReasonJS().equals(aboutTheDriversModal.getType()))) {
            error = true;
            reason = reason + " Unable to verify reason";
        }

        if (!(error)) {
            passStatus("Able to Add refusal");
        } else {
            failStatus("Unable to verify " + reason);
        }


    }

    @Test
    public void verifyUpdateRefusalInAboutTheDriver() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickrefusedInsuranceNo();
        aboutTheDrivers.clickaddRefusal();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("refusal");
        aboutTheDrivers.fillAddRefusal(aboutTheDriversModal);
        aboutTheDrivers.clickeditRefusal();
        aboutTheDrivers.visibilitysaveRefusal();
        AboutTheDriversModal aboutTheDriversModal1 = new AboutTheDriversModal("refusalUpdate");
        aboutTheDrivers.fillAddRefusal(aboutTheDriversModal1);
        aboutTheDrivers.clickeditRefusal();
        aboutTheDrivers.visibilitysaveRefusal();
        System.out.println(aboutTheDrivers.getRefusalDriverJS());
        if (!(aboutTheDrivers.getRefusalDriverJS().equals(aboutTheDriversModal1.getName()))) {
            error = true;
            reason = reason + "Unable to verify driver name";
        }
        System.out.println(aboutTheDrivers.getRefusalDateJS());
        if (!(aboutTheDrivers.getRefusalDateJS().equals(aboutTheDriversModal1.getDate()))) {
            error = true;
            reason = reason + "Unable to verify date";
        }
        System.out.println(aboutTheDrivers.getrefusalReasonJS());
        if (!(aboutTheDrivers.getrefusalReasonJS().equals(aboutTheDriversModal1.getType()))) {
            error = true;
            reason = reason + " Unable to verify reason";
        }

        if (!(error)) {
            passStatus("Able to Add refusal");
        } else {
            failStatus("Unable to verify " + reason);
        }
    }

    @Test
    public void verifyDeleteRefusalInAboutTheDrivers() throws IOException {

        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickrefusedInsuranceNo();
        aboutTheDrivers.clickaddRefusal();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("refusal");
        aboutTheDrivers.fillAddRefusal(aboutTheDriversModal);
        aboutTheDrivers.clickdeleteDriverDisqualification();
        aboutTheDrivers.clickremoveRefusal();
        try {
            aboutTheDrivers.visibilityaddRefusal();
            passStatus("Able to delete refusal");
        } catch (Exception e) {
            failStatus("Unable to delete refusal");
        }


    }

    @Test
    public void verifyAddMedicalConditionValidationsInAboutTheDriver() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());

        aboutTheDrivers.clickmedicalConditionNo();
        aboutTheDrivers.clickaddMedicalConditionButton();
        aboutTheDrivers.clicksaveMedicalConditionButton();
        System.out.println(aboutTheDrivers.getmedicalConditionSelectADriverMessage());
        if (!(aboutTheDrivers.getmedicalConditionSelectADriverMessage().equals("Please select a driver"))) {
            error = true;
            reason = reason + "Please select a driver";
        }

        System.out.println(aboutTheDrivers.getmedicalConditionSelectAMedicalCondition());
        if (!(aboutTheDrivers.getmedicalConditionSelectAMedicalCondition().equals("Please select a medical condition"))) {
            error = true;
            reason = reason + "Please select a medical condition";
        }
        System.out.println(aboutTheDrivers.getmedicalConditionAppropriateDrivingAuthority());
        if (!(aboutTheDrivers.getmedicalConditionAppropriateDrivingAuthority().equals("Please select if you informed the appropriate driving authority"))) {
            error = true;
            reason = reason + "Please select if you informed the appropriate driving authority";
        }
        aboutTheDrivers.clickappropriateAuthorityNo();
        System.out.println(aboutTheDrivers.getmedicalMessage());
        if (!(aboutTheDrivers.getmedicalMessage().equals("We will need a medical report form to be completed by your doctor. We will provide you with the form and what to do next once you're on cover"))) {
            error = true;
            reason = reason + "We will need a medical report form to be completed by your doctor. We will provide you with the form and what to do next once you're on cover by selecting appropriate driving authority no";
        }
        aboutTheDrivers.clickcancelMedicalCondition();
        aboutTheDrivers.visibilityaddMedicalConditionButton();
        if (!(error)) {
            passStatus("Able to verify validation messages");
        } else {
            failStatus("Unable to verify " + reason);
        }
    }

    @Test
    public void addMedicalConditionInAboutTheDriver() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());

        aboutTheDrivers.clickmedicalConditionNo();
        aboutTheDrivers.clickaddMedicalConditionButton();
        //
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("medical");
        aboutTheDrivers.fillMedicalDetails(aboutTheDriversModal);
        aboutTheDrivers.clickappropriateAuthorityYes();
        aboutTheDrivers.clicksaveMedicalConditionButton();
        aboutTheDrivers.clickeditMedicalCondition();
        aboutTheDrivers.visibilityMedicalConditionButton();
        System.out.println(aboutTheDrivers.getMedicalDriverJS());
        if (!(aboutTheDrivers.getMedicalDriverJS().equals(aboutTheDriversModal.getName()))) {
            error = true;
            reason = reason + "Unable to verify name";
        }
        System.out.println(aboutTheDrivers.getMedicalConditionJS());
        if (!(aboutTheDrivers.getMedicalConditionJS().equals(aboutTheDriversModal.getType()))) {
            error = true;
            reason = reason + "Unable to verify medical condition";
        }
        System.out.println(aboutTheDrivers.isAppropriateDrivingAuthorityYes());
        if (!(aboutTheDrivers.isAppropriateDrivingAuthorityYes())) {
            error = true;
            reason = reason + "Unable to verify medical authority with option yes";
        }

        if (!(error)) {
            passStatus("Able to add medical condition");
        } else {
            failStatus("Unable to add medical condition due to following " + reason);
        }
        // aboutTheDrivers.clicksaveMedicalConditionButton();
    }

    @Test
    public void updateMedicalConditionInAboutTheDriver() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());

        aboutTheDrivers.clickmedicalConditionNo();
        aboutTheDrivers.clickaddMedicalConditionButton();
        //
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("medical");
        aboutTheDrivers.fillMedicalDetails(aboutTheDriversModal);
        aboutTheDrivers.clickappropriateAuthorityYes();
        aboutTheDrivers.clicksaveMedicalConditionButton();
        aboutTheDrivers.clickeditMedicalCondition();
        aboutTheDrivers.visibilityMedicalConditionButton();
        AboutTheDriversModal aboutTheDriversModal1 = new AboutTheDriversModal("medicalUpdate");
        aboutTheDrivers.fillMedicalDetails(aboutTheDriversModal1);
        aboutTheDrivers.clickappropriateAuthorityNo();
        aboutTheDrivers.clicksaveMedicalConditionButton();
        aboutTheDrivers.clickeditMedicalCondition();
        aboutTheDrivers.visibilityMedicalConditionButton();
        System.out.println(aboutTheDrivers.getMedicalDriverJS());
        if (!(aboutTheDrivers.getMedicalDriverJS().equals(aboutTheDriversModal.getName()))) {
            error = true;
            reason = reason + "Unable to verify name";
        }
        System.out.println(aboutTheDrivers.getMedicalConditionJS());
        if (!(aboutTheDrivers.getMedicalConditionJS().equals(aboutTheDriversModal.getType()))) {
            error = true;
            reason = reason + "Unable to verify medical condition";
        }
        System.out.println(aboutTheDrivers.isAppropriateDrivingAuthorityNo());
        if (!(aboutTheDrivers.isAppropriateDrivingAuthorityNo())) {
            error = true;
            reason = reason + "Unable to verify medical authority with option no";
        }
        if (!(error)) {
            passStatus("Able to add medical condition");
        } else {
            failStatus("Unable to add medical condition due to following " + reason);
        }
    }

    @Test
    public void verifyDeleteMedicalConditionAboutTheDriver() throws IOException {
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());

        aboutTheDrivers.clickmedicalConditionNo();
        aboutTheDrivers.clickaddMedicalConditionButton();
        //
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("medical");
        aboutTheDrivers.fillMedicalDetails(aboutTheDriversModal);
        aboutTheDrivers.clickappropriateAuthorityYes();
        aboutTheDrivers.clicksaveMedicalConditionButton();
        aboutTheDrivers.clickdeleteDriverDisqualification();
        aboutTheDrivers.clickremoveMedicalCondition();
        try {
            aboutTheDrivers.visibilityaddMedicalConditionButton();
            passStatus("Able to delete medical condition");
        } catch (Exception e) {
            failStatus("Unable to delete medical condition");
        }
    }

    @Test
    public void verifyAddSpecialTermsValidationsInAboutTheDriver() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickincreasedExcessNo();
        aboutTheDrivers.clickaddSpecialTerms();
        aboutTheDrivers.clicksaveSpecialTerms();
        System.out.println(aboutTheDrivers.getselectDriverSpecialTerms());
        if (!(aboutTheDrivers.getselectDriverSpecialTerms().equals("Please select a driver"))) {
            error = true;
            reason = reason + "Please select a driver";
        }
        System.out.println(aboutTheDrivers.getenterDateSpecialTerms());
        if (!(aboutTheDrivers.getenterDateSpecialTerms().equals("Please enter a date"))) {
            error = true;
            reason = reason + "Please enter a date";
        }
        System.out.println(aboutTheDrivers.getenterSpecialTermsReason());
        if (!(aboutTheDrivers.getenterSpecialTermsReason().equals("Please select a special terms reason"))) {
            error = true;
            reason = reason + "Please select a special terms reason";
        }
        //
        aboutTheDrivers.selectspecialTermsRelate("sumanth vuppu");
        aboutTheDrivers.inputspecialTermsReason("sample");
        aboutTheDrivers.inputSpecialTermsDate("01/01/2050");
        aboutTheDrivers.clicksaveSpecialTerms();
        System.out.println(aboutTheDrivers.getspecialTermspastFutureDateMessage());
        if (!(aboutTheDrivers.getspecialTermspastFutureDateMessage().equals("Invalid date, must be in the past"))) {
            error = true;
            reason = reason + "Invalid date, must be in the past";
        }
        aboutTheDrivers.inputSpecialTermsDate(dateTimeFormatter.format(LocalDate.now().minusYears(7)));
        aboutTheDrivers.clicksaveSpecialTerms();
        System.out.println(aboutTheDrivers.getspecialTermspastFutureDateMessage());
        if (!(aboutTheDrivers.getspecialTermspastFutureDateMessage().equals("Date must be within last 7 years"))) {
            error = true;
            reason = reason + "Date must be within last 7 years";
        }
        aboutTheDrivers.clickcancelSpecialTerms();
        aboutTheDrivers.visibilityaddSpecialTerms();
        if (!(error)) {
            passStatus("Able to verify validation messages");
        } else {
            failStatus("Unable to verify " + reason);
        }

    }

    @Test
    public void verifyAddSpecialTermsInAboutTheDriver() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickincreasedExcessNo();
        aboutTheDrivers.clickaddSpecialTerms();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("refusal");
        aboutTheDrivers.fillSpecialTerms(aboutTheDriversModal);
        aboutTheDrivers.clickeditSpecialTerms();
        aboutTheDrivers.visibilitysaveSpecialTerms();
        System.out.println(aboutTheDrivers.getSpecialTermsNameJS());
        if (!(aboutTheDrivers.getSpecialTermsNameJS().equals(aboutTheDriversModal.getName()))) {
            error = true;
            reason = reason + "Unable to verify driver type";
        }
        System.out.println(aboutTheDrivers.getSpecialTermsDateJS());
        if (!(aboutTheDrivers.getSpecialTermsDateJS().equals(aboutTheDriversModal.getDate()))) {
            error = true;
            reason = reason + "Unable to verify date";
        }
        System.out.println(aboutTheDrivers.getSpecialTermsReasonJS());
        if (!(aboutTheDrivers.getSpecialTermsReasonJS().equals(aboutTheDriversModal.getType()))) {
            error = true;
            reason = reason + "Unable to verify reason";
        }
        if (!(error)) {
            passStatus("Able to add special terms");
        } else {
            failStatus("Unable to add special terms");
        }

    }

    @Test
    public void verifyUpdateSpecialTermsInAboutTheDriverPage() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickincreasedExcessNo();
        aboutTheDrivers.clickaddSpecialTerms();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("refusal");
        aboutTheDrivers.fillSpecialTerms(aboutTheDriversModal);
        aboutTheDrivers.clickeditSpecialTerms();
        aboutTheDrivers.visibilitysaveSpecialTerms();
        AboutTheDriversModal aboutTheDriversModal1 = new AboutTheDriversModal("refusalUpdate");
        aboutTheDrivers.fillSpecialTerms(aboutTheDriversModal1);
        aboutTheDrivers.clickeditSpecialTerms();
        aboutTheDrivers.visibilitysaveSpecialTerms();
        System.out.println(aboutTheDrivers.getSpecialTermsNameJS());
        if (!(aboutTheDrivers.getSpecialTermsNameJS().equals(aboutTheDriversModal1.getName()))) {
            error = true;
            reason = reason + "Unable to verify driver type";
        }
        System.out.println(aboutTheDrivers.getSpecialTermsDateJS());
        if (!(aboutTheDrivers.getSpecialTermsDateJS().equals(aboutTheDriversModal1.getDate()))) {
            error = true;
            reason = reason + "Unable to verify date";
        }
        System.out.println(aboutTheDrivers.getSpecialTermsReasonJS());
        if (!(aboutTheDrivers.getSpecialTermsReasonJS().equals(aboutTheDriversModal1.getType()))) {
            error = true;
            reason = reason + "Unable to verify reason";
        }
        if (!(error)) {
            passStatus("Able to update special terms");
        } else {
            failStatus("Unable to update special terms");
        }


    }

    @Test
    public void verifyDeleteSpecialTermsInAboutTheDriver() throws IOException {
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickincreasedExcessNo();
        aboutTheDrivers.clickaddSpecialTerms();
        AboutTheDriversModal aboutTheDriversModal = new AboutTheDriversModal("refusal");
        aboutTheDrivers.fillSpecialTerms(aboutTheDriversModal);
        aboutTheDrivers.clickdeleteDriverDisqualification();
        aboutTheDrivers.clickremoveSpecialTerms();
        try {
            aboutTheDrivers.visibilityaddSpecialTerms();
            passStatus("Able to delete special terms");
        } catch (Exception e) {
            failStatus("Unable to delete special terms");
        }

    }

    @Test
    public void verifyFindYourDrivingNumberModal() throws IOException {
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickfindYourDriverNumber();
        String data = aboutTheDrivers.getmodalDescription();
        if (data.contains("Finding your driver number") &&
                data.contains("Please note: We may validate the licence & penalty points details provided by you with the National Vehicle & Driver File.")
                && data.contains("Plastic licence")
                && data.contains("Paper licence")) {
            passStatus("Able to verify modal description");
        } else {
            failStatus("Unable to verify Find Your Driver Number modal description");
        }
        aboutTheDrivers.clickcloseModal();
        aboutTheDrivers.visibilityfindYourDriverNumber();

    }

    @Test
    public void verifyDriverCarAndDriverOTherCarAndMedicalDriverToolTip() throws IOException {
        String reason = " ";
        boolean error = false;
        fillUptoAboutYourCar();
        AboutTheDrivers aboutTheDrivers = new AboutTheDrivers(getDriver());
        aboutTheDrivers.clickmainDriverCarToolTip();
        System.out.println(aboutTheDrivers.getmodalDescription());
        if (!(aboutTheDrivers.getmodalDescription().equals("Your partner or husband or wife, living at the same address as you and sharing financial responsibilities with you. This does not include any business partner or associate."))) {
            error = true;
            reason = reason + "Your partner or husband or wife, living at the same address as you and sharing financial responsibilities with you. This does not include any business partner or associate.";
        }
        aboutTheDrivers.clickcloseModal();
        aboutTheDrivers.clickmainDriverOtherCarToolTip();
        System.out.println(aboutTheDrivers.getmodalDescription());
        if (!(aboutTheDrivers.getmodalDescription().equals("This includes any other company car/van."))) {
            error = true;
            reason = reason + "This includes any other company car/van.";
        }
        aboutTheDrivers.clickcloseModal();
        aboutTheDrivers.clickmedicalDriverToolTip();
        System.out.println(aboutTheDrivers.getmodalDescription());
        if (!(aboutTheDrivers.getmodalDescription().equals("As outlined by the Road Safety Authority in their Medical Fitness to Drive Guidelines"))) {
            error = true;
            reason = reason + "As outlined by the Road Safety Authority in their Medical Fitness to Drive Guidelines";
        }

        if (!(error)) {
            passStatus("Able to verify modal content");
        } else {
            failStatus("Unable to verify " + reason);
        }
    }


}
