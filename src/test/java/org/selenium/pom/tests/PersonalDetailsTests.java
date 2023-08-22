package org.selenium.pom.tests;

import org.openqa.selenium.StaleElementReferenceException;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.customerScreenOneModal;
import org.selenium.pom.objects.personalDetailsCustomAddressModal;
import org.selenium.pom.objects.personalDetailsModal;
import org.selenium.pom.pages.CustomerScreenOne;
import org.selenium.pom.pages.InsuranceDetails;
import org.selenium.pom.pages.PersonalDetails;
import org.selenium.pom.pages.YourQuote;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.selenium.pom.constants.BrowserStackConstants.FAILED;
import static org.selenium.pom.constants.BrowserStackConstants.PASSED;
import static org.selenium.pom.constants.DotSysConstants.DRIVINGLICENCEMODAL;

public class PersonalDetailsTests extends BaseTest {
/*public void fillScreenOnedata() throws IOException {
    CustomerScreenOne customerScreenOne = new CustomerScreenOne(getDriver());
    customerScreenOne.load();
    customerScreenOneModal customerScreenOneModal=new customerScreenOneModal(1);
    System.out.println(customerScreenOneModal.getEmail());
    System.out.println(customerScreenOneModal.getTitle());
    customerScreenOne.fillCustomerScreenFormAndContinue(customerScreenOneModal);
}*/
    public void fillScreenOnedata() throws IOException {

    new PersonalDetails(getDriver()).fillScreenOnedata(getDriver());
    }
    @Test
    public void verifyValidationsWhenUserDoesNotprovidesAnyDataInPersonalDetails() throws IOException {
       fillScreenOnedata();

        PersonalDetails personalDetails=new PersonalDetails(getDriver());
        personalDetails.clickContinueButton();
String reason=" ";
boolean error=false;

        System.out.println(personalDetails.getpleaseEnterAddressValidationMessage());
        System.out.println(personalDetails.getpleaseEnterDateOfBirthValidationMessage());
        System.out.println(personalDetails.getpleaseEnterEmployeeStatus());
        System.out.println(personalDetails.getpleaseSelectLicenseType());
        System.out.println(personalDetails.getpleaseSelectyearsLicenseHeld());
if(!(personalDetails.getpleaseEnterAddressValidationMessage().equals("Please enter an address or eircode"))){
    error=true;
    reason=reason+"Please enter an address or eircode";

}
        if(!(personalDetails.getpleaseEnterDateOfBirthValidationMessage().equals("Please enter your date of birth"))){
            error=true;
            reason=reason+"Please enter your date of birth";

        }
        if(!(personalDetails.getpleaseEnterEmployeeStatus().equals("Please select your employment status"))){
            error=true;
            reason=reason+"Please select your employment status";

        }
        if(!(personalDetails.getpleaseSelectLicenseType().equals("Please select your licence type"))){
            error=true;
            reason=reason+"Please select your licence type";

        }
        if(!(personalDetails.getpleaseSelectyearsLicenseHeld().equals("Please select years licence held"))){
            error=true;
            reason=reason+"Please select years licence held";

        }

        if(!(error)){
            setTestStatus(PASSED,true,"Able to verify validation messages");
        }else {
            setTestStatus(FAILED,false,"Unable to verify validation messages"+ reason);
        }
    }


    @Test
    public void verifyTheValidationMessagesInCannotFindAddressFieldsInPersonalDetailsPage() throws IOException, InterruptedException {
        fillScreenOnedata();
        PersonalDetails personalDetails=new PersonalDetails(getDriver());
        personalDetails.clickContinueButton();
        String reason=" ";
        boolean error=false;
        personalDetails.clickCannotFindAddress();
        personalDetails.clickConfirmAddress();
        System.out.println(personalDetails.getpleaseenterfirestlineofAddress());
        System.out.println(personalDetails.getpleaseentersecondlineofAddress());


        if(!(personalDetails.getpleaseenterfirestlineofAddress().equals("Please enter the first line of your address"))){
            error=true;
            reason=reason+ "Please enter the first line of your address";
        }
        if(!(personalDetails.getpleaseentersecondlineofAddress().equals("Please enter the second line of your address"))){
            error=true;
            reason=reason+ "Please enter the second line of your address";
        }
        personalDetails.enteraddress1("@");
        personalDetails.enteraddress2("#");
        Thread.sleep(1500);
        personalDetails.clickConfirmAddress();
        try {
            System.out.println(personalDetails.getpleaseselectYourCountry());
        }catch (StaleElementReferenceException e){
            Thread.sleep(3000);
            System.out.println(personalDetails.getpleaseselectYourCountry());
        }

        if(!(personalDetails.getpleaseselectYourCountry().equals("Please select your county"))){
            error=true;
            reason=reason+ "Please select your county";
        }


        personalDetails.selectCountry("Dublin 7");
        personalDetails.clickConfirmAddress();
        System.out.println(personalDetails.getpleaseselectYourSubarea());
        if(!(personalDetails.getpleaseselectYourSubarea().equals("Please select your SubArea"))){
            error=true;
            reason=reason+ "Please select your SubArea";
        }

        if(!(error)){
            setTestStatus(PASSED,true,"Able to verify validation messages");
        }else {
            setTestStatus(FAILED,false,"Unable to verify validation messages "+reason);
        }


    }


    @Test
    public void verifyCustomAddressFunctionalityInPersonalDetailsPage() throws IOException {
        String reason=" ";
        boolean error=false;
        fillScreenOnedata();
        PersonalDetails personalDetails=new PersonalDetails(getDriver());

        personalDetails.clickCannotFindAddress();

        personalDetailsCustomAddressModal personalDetailsCustomAddressModal=new personalDetailsCustomAddressModal(1);
        System.out.println(personalDetailsCustomAddressModal.getAddress1());
        System.out.println(personalDetailsCustomAddressModal.getAddress2());
        System.out.println(personalDetailsCustomAddressModal.getAddress3());
        System.out.println(personalDetailsCustomAddressModal.getCounty());
        System.out.println(personalDetailsCustomAddressModal.getSubcounty());
        personalDetails.enterCustomAddressDetails(personalDetailsCustomAddressModal);


        System.out.println(personalDetails.getPreviewAddress());
if(!(personalDetails.getPreviewAddress().contains(personalDetailsCustomAddressModal.getAddress1())
&& personalDetails.getPreviewAddress().contains(personalDetailsCustomAddressModal.getAddress2())
&& personalDetails.getPreviewAddress().contains(personalDetailsCustomAddressModal.getCounty()))){
    error=true;
    reason=reason+"Error verifying address in preview block";

}

        personalDetails.clickcorrectAddressYesButton();
        System.out.println(personalDetails.getaddressResult());
        if(!(personalDetails.getaddressResult().contains(personalDetailsCustomAddressModal.getAddress1())
                && personalDetails.getaddressResult().contains(personalDetailsCustomAddressModal.getAddress2())
                && personalDetails.getaddressResult().contains(personalDetailsCustomAddressModal.getCounty()))){
            error=true;
            reason=reason+"Error verifying address in address result block";

        }

        if(!(error)){
            setTestStatus(PASSED,true,"Able to verify address");
        }else {
            setTestStatus(FAILED,false,"Unable to verify address"+reason);
        }


    }

    @Test
    public void verifyReturnButtonFunctionalityInCustomAddressInPersonlDetailsPage() throws IOException {
        fillScreenOnedata();
        PersonalDetails personalDetails=new PersonalDetails(getDriver());

        personalDetails.clickCannotFindAddress();
        personalDetails.clickReturnButton();
        if(personalDetails.waitForInvisbilityForReturnButton()){
            setTestStatus(PASSED,true,"pass");
        }else {
            setTestStatus(FAILED,false,"Unable to close custom address block");
        }
    }
@Test
    public  void verifyCustomAddressFunctionalityWithNoButtonActionInPersonalDetailsPage() throws IOException {

    fillScreenOnedata();
    PersonalDetails personalDetails=new PersonalDetails(getDriver());

    personalDetails.clickCannotFindAddress();

    personalDetailsCustomAddressModal personalDetailsCustomAddressModal=new personalDetailsCustomAddressModal(1);

    personalDetails.enterCustomAddressDetails(personalDetailsCustomAddressModal);


    System.out.println(personalDetails.getPreviewAddress());


    personalDetails.clickCorrectAddressNoButton();
    personalDetails.waitForInvisbilityForNoButton();
    try {
        personalDetails.waitforVisibiliyofAddressSearchBar();
        setTestStatus(PASSED,true,"Pass");
    }catch (Exception e){
        setTestStatus(FAILED,false,"Unable to close custom address after selecting no in confirm address");
    }


}

@Test
    public void verifyAutoSuggestionsSearchFunctionalityInPersonalDetailsScreen() throws IOException {
    boolean error=false;
    String reason=" ";
    String country="new york";
    fillScreenOnedata();
    PersonalDetails personalDetails=new PersonalDetails(getDriver());
    personalDetails.waitforVisibiliyofAddressSearchBar();
    personalDetails.inputSearchText(country);
    personalDetails.selectSuggestedCountry(country);
    System.out.println(personalDetails.getPreviewAddress());
    if(!(personalDetails.getPreviewAddress().toLowerCase().contains(country))){
        error=true;
        reason=reason+"Error verifying address in preview block";

    }

    personalDetails.clickcorrectAddressYesButton();
    System.out.println(personalDetails.getaddressResult());
    if(!(personalDetails.getaddressResult().toLowerCase().contains(country))){
        error=true;
        reason=reason+"Error verifying address in address result block";

    }

    if(!(error)){
        setTestStatus(PASSED,true,"Able to verify address");
    }else {
        setTestStatus(FAILED,false,"Unable to verify address"+reason);
    }
}

@Test
    public void verifyAgeCriteriaToHoldLicence2020YearInPersonalDetails() throws IOException {

    fillScreenOnedata();
    PersonalDetails personalDetails=new PersonalDetails(getDriver());
    personalDetails.waitforVisibiliyofAddressSearchBar();
    personalDetailsModal personalDetailsModal=new personalDetailsModal(2);
    personalDetails.fillPersonalDetailsAndContinue(personalDetailsModal);
System.out.println(personalDetails.getageTooyouToholdDriverLicenceValidationMessage());
if(personalDetails.getageTooyouToholdDriverLicenceValidationMessage().equals("Age too young to hold a driver's licence")){
    setTestStatus(PASSED,true,"Able to display error message");
}else {
    setTestStatus(FAILED,false,"Unable to display Age too young to hold a driver's licence");
}
}
    @Test
    public void verifyAgeCriteriaToHoldLicence2005YearWith5YearDrivingLicenceInPersonalDetails() throws IOException {

        fillScreenOnedata();
        PersonalDetails personalDetails=new PersonalDetails(getDriver());
        personalDetails.waitforVisibiliyofAddressSearchBar();
        personalDetailsModal personalDetailsModal=new personalDetailsModal(3);
        personalDetails.fillPersonalDetailsAndContinue(personalDetailsModal);
        System.out.println(personalDetails.getageTooyouToholdDriverLicenceValidationMessage());
        if(personalDetails.getageTooyouToholdDriverLicenceValidationMessage().equals("Age too low to have held a licence for 5 years")){
            setTestStatus(PASSED,true,"Able to display error message");
        }else {
            setTestStatus(FAILED,false,"Age too low to have held a licence for 5 years");
        }
    }

 @Test
 public void verify130YearsAgeValidationInPersonalDeails() throws IOException {
     fillScreenOnedata();
     PersonalDetails personalDetails=new PersonalDetails(getDriver());
     personalDetails.waitforVisibiliyofAddressSearchBar();
     personalDetailsModal personalDetailsModal=new personalDetailsModal(4);
     personalDetails.fillPersonalDetailsAndContinue(personalDetailsModal);
     System.out.println(personalDetails.getageTooyouToholdDriverLicenceValidationMessage());
     if(personalDetails.getageTooyouToholdDriverLicenceValidationMessage().equals("Age must be lower than 130")){
         setTestStatus(PASSED,true,"Able to display error message");
     }else {
         setTestStatus(FAILED,false,"Unable to display Age must be lower than 130");
     }
 }

    @Test
    public void  validateOccupationInEmployeeStatusInPersonalDetails() throws IOException {
        fillScreenOnedata();
        PersonalDetails personalDetails=new PersonalDetails(getDriver());
        personalDetails.selectEmployeeStatus("Employed");
        personalDetails.clickContinueButton();
System.out.println(personalDetails.getPleaseEnterAnOccupationValidationMessage());
if(personalDetails.getPleaseEnterAnOccupationValidationMessage().equals("Please enter an occupation")){
    setTestStatus(PASSED,true,"Able to display validation message");
}else {
    setTestStatus(FAILED,false,"Unable to display Please enter an occupation");
}

    }

    @Test
    public void VerifyDataInOcupationInEmployeeStatusInPersonalDetails() throws IOException, InterruptedException {
    String employeeType="Self Employed";
        fillScreenOnedata();
        PersonalDetails personalDetails=new PersonalDetails(getDriver());
        personalDetails.selectEmployeeStatus(employeeType);
      personalDetails.enterAndSelectOccupation("engineer");


    }

    @Test
    public void verifyCountryWhereLicenseObtainedValidationMessage() throws IOException {
        String country="new york";
        fillScreenOnedata();
        PersonalDetails personalDetails=new PersonalDetails(getDriver());
        personalDetails.waitforVisibiliyofAddressSearchBar();
        personalDetails.inputSearchText(country);
        personalDetails.selectSuggestedCountry(country);
personalDetails.selectEmployeeStatus("Retired");
        personalDetails.clickcorrectAddressYesButton();
        personalDetails.enterAge("01/01/1990");
        personalDetails.selecttypeOfDrivingLicence("Non EU");

        personalDetails.selectyearsHeld("2");
        personalDetails.waitforCountrywherelicenceappliedvisbility();
        personalDetails.clickContinueButton();

        System.out.println(personalDetails.getpleaseSelectCountryWhereLicenceObtained());


        if(personalDetails.getpleaseSelectCountryWhereLicenceObtained().equals("Please select country where licence obtained")){
            setTestStatus(PASSED,true,"Able to verify validation message");
        }else {
            setTestStatus(FAILED,false,"Unable to verify Please select country where licence obtained");
        }

    }


@Test
    public void fillPersonalDetailsPageWithValidDataInnerOptions() throws IOException, InterruptedException {
    fillScreenOnedata();
    PersonalDetails personalDetails=new PersonalDetails(getDriver());
    personalDetails.waitforVisibiliyofAddressSearchBar();
    personalDetailsModal personalDetailsModal=new personalDetailsModal(5);
    System.out.println(personalDetailsModal.getOccupation());
    System.out.println(personalDetailsModal.getCountryLicense());
    personalDetails.fillPersonalDetailsAndContinueWithSubOptions(personalDetailsModal);
    System.out.println(personalDetails.getOccupationJs());
    System.out.println(personalDetails.getLicenceObtained());
    System.out.println(personalDetails.getYearsHeldJS());
    System.out.println(personalDetails.getDrivingLicenseJS());
    System.out.println(personalDetails.getAddressJS());
    System.out.println(personalDetails.getdobJS());
    System.out.println(personalDetails.getEmployeeStatusJS());
    String reason=" ";
    boolean error=false;
    if(!(personalDetails.getLicenceObtained().equals(personalDetailsModal.getCountryLicense()))){
        error=true;
        reason=reason+"Unable to verify country licence data";
    }
    if(!(personalDetails.getOccupationJs().equals("Acoustic Engineer"))){
        error=true;
        reason=reason+"Unable to verify occupation data";
    }
    if(!(personalDetails.getYearsHeldJS().equals(personalDetailsModal.getYearsHeld()))){
        error=true;
        reason=reason+"Unable to verify years held";
    }
    if(!(personalDetails.getDrivingLicenseJS().equals(personalDetailsModal.getDrivingLicense()))){
        error=true;
        reason=reason+"Unable to verify driving licence";
    }
    if(!(personalDetails.getDrivingLicenseJS().equals(personalDetailsModal.getDrivingLicense()))){
        error=true;
        reason=reason+"Unable to verify driving licence";
    }

    if(!(error)){
        passStatus("Able to submit data");
    }else {
        failStatus("Unable to sublit data"+reason);
    }


    /*try {
        new InsuranceDetails(getDriver()).visibilityOfInsuranceDetails();
        setTestStatus(PASSED,true,"Able to submit successfully");
    }catch (Exception e){
        setTestStatus(FAILED,false,"unable to submit data successfully ");
    }*/


}

void fillDataInpersonalDetails(int id) throws IOException {

    PersonalDetails personalDetails = new PersonalDetails(getDriver());
    personalDetails.waitforVisibiliyofAddressSearchBar();
    personalDetailsModal personalDetailsModal = new personalDetailsModal(id);
    personalDetails.fillPersonalDetailsAndContinue(personalDetailsModal);


}
    @Test
    public void fillPersonalDetailsPageWithValidData() throws IOException, InterruptedException {
        fillScreenOnedata();
        fillDataInpersonalDetails(1);
        PersonalDetails personalDetails = new PersonalDetails(getDriver());
        personalDetails.clickPersonalDetailsHeading();
        personalDetailsModal personalDetailsModal = new personalDetailsModal(1);
        System.out.println(personalDetails.getYearsHeldJS());
        System.out.println(personalDetails.getDrivingLicenseJS());
        System.out.println(personalDetails.getAddressJS());
        System.out.println(personalDetails.getdobJS());
        System.out.println(personalDetails.getEmployeeStatusJS());
        String reason=" ";
        boolean error=false;
        if(!(personalDetails.getAddressJS().toLowerCase().contains(personalDetailsModal.getCountry()))){
            error=true;
            reason=reason+"Unable to verify address";
        }
        if(!(personalDetails.getYearsHeldJS().equals(personalDetailsModal.getYearsHeld()))){
            error=true;
            reason=reason+"Unable to verify years held";
        }
        if(!(personalDetails.getDrivingLicenseJS().equals(personalDetailsModal.getDrivingLicense()))){
            error=true;
            reason=reason+"Unable to verify driving licence";
        }
        if(!(personalDetails.getdobJS().equals(personalDetailsModal.getDob()))){
            error=true;
            reason=reason+"Unable to verify dob";
        }
        if(!(personalDetails.getEmployeeStatusJS().equals(personalDetailsModal.getEmployeeStatus()))){
            error=true;
            reason=reason+"Unable to verify employee status";
        }

        if(!(error)){
            passStatus("Able to submit data");
        }else {
            failStatus("Unable to submit data"+reason);
        }


      /*  try {
            new InsuranceDetails(getDriver()).visibilityOfInsuranceDetails();
            setTestStatus(PASSED,true,"Able to submit successfully");
        }catch (Exception e){
            setTestStatus(FAILED,false,"unable to submit data successfully ");
        }*/


    }
@Test
    public void updateDataInPersonalDetails() throws IOException, InterruptedException {
    fillScreenOnedata();
    fillDataInpersonalDetails(1);
   PersonalDetails personalDetails=new PersonalDetails(getDriver());
    personalDetailsModal personalDetailsModal = new personalDetailsModal(6);
   personalDetails.scrollup();
    Thread.sleep(3000);
   personalDetails.clickPersonalDetailsHeading();
   personalDetails.clickChangeAddress();
    fillDataInpersonalDetails(6);
    System.out.println(personalDetails.getYearsHeldJS());
    System.out.println(personalDetails.getDrivingLicenseJS());
    System.out.println(personalDetails.getAddressJS());
    System.out.println(personalDetails.getdobJS());
    System.out.println(personalDetails.getEmployeeStatusJS());
    String reason=" ";
    boolean error=false;
    if(!(personalDetails.getAddressJS().toLowerCase().contains(personalDetailsModal.getYearsHeld()))){
        error=true;
        reason=reason+"Unable to verify address";
    }
    if(!(personalDetails.getYearsHeldJS().equals(personalDetailsModal.getYearsHeld()))){
        error=true;
        reason=reason+"Unable to verify years held";
    }
    if(!(personalDetails.getDrivingLicenseJS().equals(personalDetailsModal.getDrivingLicense()))){
        error=true;
        reason=reason+"Unable to verify driving licence";
    }
    if(!(personalDetails.getDrivingLicenseJS().equals(personalDetailsModal.getDrivingLicense()))){
        error=true;
        reason=reason+"Unable to verify driving licence";
    }

    if(!(error)){
        passStatus("Able to submit data");
    }else {
        failStatus("Unable to sublit data"+reason);
    }

   /* try {
        personalDetails.insibilityContinueButton();
        //new InsuranceDetails(getDriver()).visibilityOfInsuranceDetails();
        setTestStatus(PASSED,true,"Able to submit successfully");
    }catch (Exception e){
        setTestStatus(FAILED,false,"unable to set status successfully ");
    }*/
}

@Test
    public void verifyDrivingLicenceYouHoldModalInPersonalDetails() throws IOException {
    String reason=" ";
    boolean error=false;
    fillScreenOnedata();
    PersonalDetails personalDetails=new PersonalDetails(getDriver());
    personalDetails.clickDrivingLicenceModal();
  // System.out.println(personalDetails.getDrivingLicenceYouHoldModalMessage());
    try {
        personalDetails.visibilityOfmodalText();
        passStatus("Able to verify modal");
    }catch (Exception e){
        failStatus("Unable to verify modal content");
    }



}

}
