package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;

import org.selenium.pom.dataProvider.CustomerOneScreenDataProvider;
import org.selenium.pom.objects.AdditionalDriversModal;
import org.selenium.pom.objects.CarDetailsModal;
import org.selenium.pom.objects.customerScreenOneModal;
import org.selenium.pom.objects.personalDetailsModal;
import org.selenium.pom.pages.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.selenium.pom.constants.BrowserStackConstants.FAILED;
import static org.selenium.pom.constants.BrowserStackConstants.PASSED;
import static org.selenium.pom.constants.DotSysConstants.DISPLAYNONE;
import static org.selenium.pom.tests.InsuranceDetailsTests.NOPREVIOUSEXPERIENCE;

public class AdditionalDriversTests extends BaseTest {
    static final String SCROLLVALUE="600";
   /* public void fillScreenUpToCarDetails() throws IOException {
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
        //
        CarDetails carDetails = new CarDetails(getDriver());
        CarDetailsModal carDetailsModal=new CarDetailsModal("yes");
        carDetails.fillCardetailsWithRegistrationYes(carDetailsModal);


    }*/
    public void fillScreenUpToCarDetails() throws IOException {
        new AdditionalDrivers(getDriver()).fillScreenUpToCarDetails(getDriver());
    }


@Test
    public void verifyAdditionalDriversWithNoOption() throws IOException {
    fillScreenUpToCarDetails();
    AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
    additionalDrivers.clickAdditionalDriversNo();
    additionalDrivers.clickContinueButton();
    try {
        additionalDrivers.waitForInvisibilityForClickButton();
        passStatus("Able to continue without drivers");
    }catch (Exception e){
        failStatus("Unable to continue without adding drivers");
    }

}

    @Test
    public void verifyValidationMessagesInDriverDetails() throws IOException {
        boolean error=false;
        String reason=" ";
        fillScreenUpToCarDetails();
        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();
        additionalDrivers.clickaddDriverButton();
        System.out.println(additionalDrivers.gettitleValidationMessage());
        System.out.println(additionalDrivers.getfirstNameMessage());
        System.out.println(additionalDrivers.getsurNameMessage());
        System.out.println(additionalDrivers.getdobMessage());
        System.out.println(additionalDrivers.getemployeeStatusMessage());
        System.out.println(additionalDrivers.getlicenceTypeMessage());
        System.out.println(additionalDrivers.getyearsHeldMessage());
        System.out.println(additionalDrivers.getrelationShipMessage());

        if(!(additionalDrivers.gettitleValidationMessage().equals("Please select your title"))){
            error=true;
            reason=reason+"Please select your title";
        }
        if(!(additionalDrivers.getfirstNameMessage().equals("Please enter your first name"))){
            error=true;
            reason=reason+"Please enter your first name";
        }
        if(!(additionalDrivers.getsurNameMessage().equals("Please enter your surname"))){
            error=true;
            reason=reason+"Please enter their surname";
        }
        if(!(additionalDrivers.getdobMessage().equals("Please enter your date of birth"))){
            error=true;
            reason=reason+"Please enter your date of birth";
        }
        if(!(additionalDrivers.getemployeeStatusMessage().equals("Please select your employment status"))){
            error=true;
            reason=reason+"Please select your employment status";
        }
        if(!(additionalDrivers.getlicenceTypeMessage().equals("Please select your licence type"))){
            error=true;
            reason=reason+"Please select your licence type";
        }
        if(!(additionalDrivers.getyearsHeldMessage().equals("Please select years licence held"))){
            error=true;
            reason=reason+"Please select years licence held";
        }
        if(!(additionalDrivers.getrelationShipMessage().equals("Please select their relationship to you"))){
            error=true;
            reason=reason+"Please select their relationship to you";
        }

        if(!(error)){
            passStatus("Able to verify validation messages");
        }else {
            failStatus("Unable to verify "+reason);
        }

    }
    @Test(dataProvider = "getTitles",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifyTheTitleRadioButtonSelectionInAdditionalDrivers(String title) throws InterruptedException, IOException {

        fillScreenUpToCarDetails();
        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();
        System.out.println(additionalDrivers.selectTitleradioButtonAndReturnClassAttribute(title));
        if (additionalDrivers.selectTitleradioButtonAndReturnClassAttribute(title).contains("checked")
                && new CustomerScreenOnetests().getSelectedRadioButtonSize(getDriver())==1){
            setTestStatus(PASSED,true,"Only One option Can be Checked at a time");
        }else {
            setTestStatus(FAILED,false,"Failed to select One Option at a time");
        }

    }

    @Test(dataProvider ="getvalidFirstNames",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifyFirstNameValidCasesInDriverDetails(String validname) throws InterruptedException, IOException {
        fillScreenUpToCarDetails();
        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();
        additionalDrivers.EnterFirstNameAndContinue(validname);

        if((additionalDrivers.getfirstNameErrorValidationMessageSize().contains(DISPLAYNONE)) &&( additionalDrivers.getpleaseEnterYourFirstNameDisplayNone().contains(DISPLAYNONE))){
            setTestStatus(PASSED,true,"Valid data Criteria passed");
        }else {
            setTestStatus(FAILED,false,"Unable to accept valid data");
        }



    }


    @Test(dataProvider ="getInvalidFirstNames",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifyFirstNameInvalidCasesInDriverScreen(String invalidName) throws InterruptedException, IOException {
        fillScreenUpToCarDetails();
        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();
        additionalDrivers.EnterFirstNameAndContinue(invalidName);
        if(additionalDrivers.getfirstNameErrorValidationMessage().equals("Please enter your first name")){
            setTestStatus(PASSED,true,"InValid data Criteria passed");
        }else {
            setTestStatus(FAILED,false,"Unable to verify Please enter your first name error message");
        }

    }
    @Test(dataProvider ="getvalidFirstNames",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifySurNameValidCasesInAdditionalDriversScreen(String validname) throws InterruptedException, IOException {
        fillScreenUpToCarDetails();
        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();
        additionalDrivers.EnterSurnameAndContinue(validname);

        if((additionalDrivers.getpleaseEnterYourSurnameDisplayNone().contains(DISPLAYNONE)) &&( additionalDrivers.getpleaseEnterYourSurnameDisplayNone().contains(DISPLAYNONE))){
            setTestStatus(PASSED,true,"Valid data Criteria passed");
        }else {
            setTestStatus(FAILED,false,"Unable to accept valid data");
        }



    }
    @Test(dataProvider ="getInvalidFirstNames",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifySurNameInvalidCasesInAdditionalriversScreen(String invalidName) throws InterruptedException, IOException, ParseException {
       fillScreenUpToCarDetails();

        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();
        additionalDrivers.EnterSurnameAndContinue(invalidName);
        System.out.println(additionalDrivers.getpleaseEnterCompleteSurnameMessage());
        if(additionalDrivers.getpleaseEnterCompleteSurnameMessage().equals("Please enter your complete surname")){
            setTestStatus(PASSED,true,"InValid data Criteria passed");
        }else {
            setTestStatus(FAILED,false,"Unable to verify Please enter your complete surname error message");
        }

    }
    @Test
    public void verifyAgeCriteriaToHoldLicence2020YearInDriverDetails() throws IOException, InterruptedException {

        fillScreenUpToCarDetails();


        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();

        AdditionalDriversModal additionalDriversModal=new AdditionalDriversModal(1);
        additionalDrivers.fillAdditionalDriver(additionalDriversModal);
        System.out.println(additionalDrivers.getageTooyouToholdDriverLicenceValidationMessage());
        if(additionalDrivers.getageTooyouToholdDriverLicenceValidationMessage().equals("Age too young to hold a driver's licence")){
            setTestStatus(PASSED,true,"Able to display error message");
        }else {
            setTestStatus(FAILED,false,"Unable to display Age too young to hold a driver's licence");
        }
    }
    @Test
    public void verifyAgeCriteriaToHoldLicence2005YearWith5YearDrivingLicenceInDriverDetails() throws IOException, InterruptedException {

        fillScreenUpToCarDetails();


        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();

        AdditionalDriversModal additionalDriversModal=new AdditionalDriversModal(2);
        additionalDrivers.fillAdditionalDriver(additionalDriversModal);
        System.out.println(additionalDrivers.getageTooyouToholdDriverLicenceValidationMessage());
        if(additionalDrivers.getageTooyouToholdDriverLicenceValidationMessage().equals("Age too low to have held a licence for 5 years")){
            setTestStatus(PASSED,true,"Able to display error message");
        }else {
            setTestStatus(FAILED,false,"Unable to display Age too low to have held a licence for 5 years");
        }
    }
    void addDriver(int id) throws IOException, InterruptedException {
        fillScreenUpToCarDetails();


        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();
        AdditionalDriversModal additionalDriversModal=new AdditionalDriversModal(id);
        additionalDrivers.fillAdditionalDriver(additionalDriversModal);
additionalDrivers.clickEditDriver();
additionalDrivers.visibilityaddDriverButton();
Thread.sleep(10000);
String reason=" ";
boolean error=false;
System.out.println(additionalDrivers.selectTitleradioButtonAndReturnClassAttributeJS(additionalDriversModal.getTitle()));

if(!(additionalDrivers.selectTitleradioButtonAndReturnClassAttributeJS(additionalDriversModal.getTitle()).equals(additionalDriversModal.getTitle()))){
    error=true;
    reason=reason+"Unable to verify title "+additionalDriversModal.getTitle();
}
System.out.println(additionalDrivers.getFirstNameJS());

if(!(additionalDrivers.getFirstNameJS().equals(additionalDriversModal.getFirstname()))){
    error=true;
    reason=reason+"Unable to verify  "+additionalDriversModal.getFirstname();
}
        System.out.println(additionalDriversModal.getFirstname());
        if(!(additionalDrivers.getSurNameJS().equals(additionalDriversModal.getSurname()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getFirstname();
        }
        System.out.println(additionalDrivers.getDobJS());
        if(!(additionalDrivers.getDobJS().equals(additionalDriversModal.getDob()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getDob();
        }

        System.out.println(additionalDrivers.getEmployementStatusJS());
        if(!(additionalDrivers.getEmployementStatusJS().equals(additionalDriversModal.getEmploymentStatus()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getEmploymentStatus();
        }
        System.out.println(additionalDrivers.getDrivingLicenseTheyHoldJs());
        if(!(additionalDrivers.getDrivingLicenseTheyHoldJs().equals(additionalDriversModal.getDrivingLicense()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getDrivingLicense();
        }
        System.out.println(additionalDrivers.getyearLicenceHeldJS());
        if(!(additionalDrivers.getyearLicenceHeldJS().equals(additionalDriversModal.getYearsHeld()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getYearsHeld();
        }
        System.out.println(additionalDrivers.getRelationToProposerJS());
        if(!(additionalDrivers.getRelationToProposerJS().equals(additionalDriversModal.getRelationship()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getRelationship();
        }
        if(!(error)){
            passStatus("Able to add driver");
        }else {
            failStatus("Unable to verify data "+reason);
        }
    }
    @Test
    public void fillDriverDetailsInDriverPage() throws IOException, InterruptedException {
        addDriver(3);
    }
    @Test
    public void removeDriverInDriverPage() throws IOException, InterruptedException {
        addDriver(3);
        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
      additionalDrivers.  clickaddDriverButton();
        additionalDrivers.removeDriverAfterAdding();
       additionalDrivers.invisibleLoading();
        try {
            additionalDrivers.invisibleRemoveDriver();
            passStatus("Able to remove driver");
        }catch (Exception e){
            failStatus("Unable to remove driver");
        }
        getDriver().navigate().refresh();
        if(additionalDrivers.getconfirmRemoveDriverCount()>0){
            failStatus("Unable to remove driver");
        }

    }

    @Test
    public void updateDriverDataInDriverDetails() throws IOException, InterruptedException {
        String reason=" ";
        boolean error=false;
        addDriver(3);
        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        AdditionalDriversModal additionalDriversModal=new AdditionalDriversModal(4);

        additionalDrivers.   selectTitleradioButtonAndReturnClassAttribute(additionalDriversModal.getTitle());
        additionalDrivers.   enterFirstName(additionalDriversModal.getFirstname());
        additionalDrivers.   enterSurname(additionalDriversModal.getSurname());
        additionalDrivers.  enterage(additionalDriversModal.getDob());
        additionalDrivers.   selectEmployeeStatus(additionalDriversModal.getEmploymentStatus());
        additionalDrivers.enterOccupationData(additionalDriversModal.getOccupation());
        additionalDrivers.   selecttypeOfDrivingLicence(additionalDriversModal.getDrivingLicense());
        additionalDrivers.selectLicenseObtained(additionalDriversModal.getCountry());
        additionalDrivers.   selectyearsHeld(additionalDriversModal.getYearsHeld());
        additionalDrivers.   selectrelationShipToProposer(additionalDriversModal.getRelationship());
        additionalDrivers.clickOwnCarYes();
        additionalDrivers.  clickaddDriverButton();
        additionalDrivers.clickEditDriver();
        additionalDrivers.visibilityaddDriverButton();
        Thread.sleep(5000);
        System.out.println(additionalDrivers.selectTitleradioButtonAndReturnClassAttributeJS(additionalDriversModal.getTitle()));

        if(!(additionalDrivers.selectTitleradioButtonAndReturnClassAttributeJS(additionalDriversModal.getTitle()).equals(additionalDriversModal.getTitle()))){
            error=true;
            reason=reason+"Unable to verify title "+additionalDriversModal.getTitle();
        }
        System.out.println(additionalDrivers.getFirstNameJS());

        if(!(additionalDrivers.getFirstNameJS().equals(additionalDriversModal.getFirstname()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getFirstname();
        }
        System.out.println(additionalDriversModal.getFirstname());
        if(!(additionalDrivers.getSurNameJS().equals(additionalDriversModal.getSurname()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getFirstname();
        }
        System.out.println(additionalDrivers.getDobJS());
        if(!(additionalDrivers.getDobJS().equals(additionalDriversModal.getDob()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getDob();
        }

        System.out.println(additionalDrivers.getEmployementStatusJS());
        if(!(additionalDrivers.getEmployementStatusJS().equals(additionalDriversModal.getEmploymentStatus()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getEmploymentStatus();
        }
        System.out.println(additionalDrivers.getDrivingLicenseTheyHoldJs());
        if(!(additionalDrivers.getDrivingLicenseTheyHoldJs().equals(additionalDriversModal.getDrivingLicense()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getDrivingLicense();
        }
        System.out.println(additionalDrivers.getyearLicenceHeldJS());
        if(!(additionalDrivers.getyearLicenceHeldJS().equals(additionalDriversModal.getYearsHeld()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getYearsHeld();
        }
        System.out.println(additionalDrivers.getRelationToProposerJS());
        if(!(additionalDrivers.getRelationToProposerJS().equals(additionalDriversModal.getRelationship()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getRelationship();
        }
        System.out.println(additionalDrivers.getOccupationDataJS());
        if(!(additionalDrivers.getOccupationDataJS().toLowerCase().contains(additionalDriversModal.getOccupation()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getOccupation();
        }
        System.out.println(additionalDrivers.getLicenseObtainedJS());
        if(!(additionalDrivers.getLicenseObtainedJS().equals(additionalDriversModal.getCountry()))){
            error=true;
            reason=reason+"Unable to verify  "+additionalDriversModal.getCountry();
        }
        if(!(error)){
            passStatus("Able to add driver");
        }else {
            failStatus("Unable to verify data "+reason);
        }


    }

    @Test
    public void addTwoDriversInDriverDetailsPage() throws IOException, InterruptedException {
        fillScreenUpToCarDetails();


        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();
        AdditionalDriversModal additionalDriversModal=new AdditionalDriversModal(3);
        additionalDrivers.fillAdditionalDriver(additionalDriversModal);
        additionalDrivers.clickadditionalDriversYes();

        AdditionalDriversModal additionalDriversModal1=new AdditionalDriversModal(3);
        additionalDrivers.fillAdditionalDriver(additionalDriversModal1);
Thread.sleep(3000);
        additionalDrivers.clickAdditionalDriversNo();
        additionalDrivers.clickContinueButton();
        int count=additionalDrivers.getEditDriverCount();
        additionalDrivers.waitForInvisibilityForClickButton();
        if(count==2){
            passStatus("Unable to add more than one driver and  continue");
        }else {
            failStatus("Unable to add more than one driver" + count);
        }

    }
    void addSevenDrivers() throws IOException, InterruptedException {



        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());

        AdditionalDriversModal additionalDriversModal=new AdditionalDriversModal(3);
        additionalDrivers.fillAdditionalDriver(additionalDriversModal);

    }
    @Test
    public void verifyAddingSixDriversInDriverDetailsPage() throws IOException, InterruptedException {
        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        fillScreenUpToCarDetails();

        int clickCount=0;
       for(int i=0;i<6;i++){

           additionalDrivers.clickadditionalDriversYes();
           addSevenDrivers();

           clickCount++;
           if(clickCount==6){
             break;
           }

           //additionalDrivers.clickadditionalDriversYes();
        }

        Thread.sleep(3000);
       if(!(additionalDrivers.getAdditionalDriverAttribute().equals("No"))){
           failStatus("Able to add more than six drivers");
       }else {
           passStatus("Able to add six drivers");
       }
    }
@Test
    public void verifyDrivingLicenceModalMessageInAdditionalDrivers() throws IOException {
    fillScreenUpToCarDetails();


    AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
    additionalDrivers.clickadditionalDriversYesSingleButton();
    additionalDrivers.clickdrivingLicenceTooltip();
    System.out.println(additionalDrivers.getModalText());
    if(additionalDrivers.getModalText().equals("Please select the type of Driving licence you hold. If your licence type is not listed here, we may not be able to insure you. Please note as a learner permit or provisional licenceholder you must adhere to your obligations under the Road Traffic Act.")){
        passStatus("Able to verify modal");
    }else {
        failStatus("Unable to verify modal");
    }
}
}
