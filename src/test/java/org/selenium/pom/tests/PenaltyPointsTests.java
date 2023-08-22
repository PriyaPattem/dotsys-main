package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.AdditionalDriversModal;
import org.selenium.pom.objects.CarDetailsModal;
import org.selenium.pom.objects.customerScreenOneModal;
import org.selenium.pom.objects.personalDetailsModal;
import org.selenium.pom.pages.*;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.selenium.pom.tests.InsuranceDetailsTests.NOPREVIOUSEXPERIENCE;

public class PenaltyPointsTests extends BaseTest {
    static final String SCROLLVALUE="600";
    /*public void fillScreenUpToYourClaims() throws IOException {
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
        //
        YourClaims yourClaims=new YourClaims(getDriver());
        yourClaims.fillClaimAndContinue("01/01/2020","Accident","555555555");


    }*/
    public void fillScreenUpToYourClaims() throws IOException {
        new PenaltyPoints(getDriver()).fillScreenUpToYourClaims(getDriver());
    }
    @Test
    public void verifyValidationMessagesInPenaltyPointsScreen() throws IOException {
        String validationMessage="Please select an option";
        String reason=" ";
        boolean error=false;
        fillScreenUpToYourClaims();
        PenaltyPoints penaltyPoints=new PenaltyPoints(getDriver());
        penaltyPoints.clickContinueButton();
        System.out.println("penaltyPointsOneValidationMessage "+penaltyPoints.getpenaltyPointsOneValidationMessage());
        if(!(penaltyPoints.getpenaltyPointsOneValidationMessage().equals(validationMessage))){
            error=true;
            reason=reason+"unable to verify penaltyPointsOneValidationMessage";
        }

        System.out.println("penaltyPointsTwoValidationMessage "+penaltyPoints.getpenaltyPointsTwoValidationMessage());
        if(!(penaltyPoints.getpenaltyPointsTwoValidationMessage().equals(validationMessage))){
            error=true;
            reason=reason+"unable to verify penaltyPointsTwoValidationMessage";
        }
        penaltyPoints.clickYesOrNobutton("1");
        penaltyPoints.clickYesOrNobutton("3");
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }
        penaltyPoints.clickContinueButton();
        System.out.println("getactivePenaltyPointsOneValidationMessage "+penaltyPoints.getactivePenaltyPointsOneValidationMessage());
        if(!(penaltyPoints.getactivePenaltyPointsOneValidationMessage().equals(validationMessage))){
            error=true;
            reason=reason+"unable to verify getactivePenaltyPointsOneValidationMessage";
        }
        System.out.println("getactivePenaltyPointsTwoValidationMessage "+penaltyPoints.getactivePenaltyPointsTwoValidationMessage());
        if(!(penaltyPoints.getactivePenaltyPointsTwoValidationMessage().equals(validationMessage))){
            error=true;
            reason=reason+"unable to verify getactivePenaltyPointsTwoValidationMessage";
        }
        penaltyPoints.selectPenaltyPointsOneDropDown("3");
        penaltyPoints.selectPenaltyPointsTwoDropDown("4");
        penaltyPoints.clickContinueButton();
        try {
            Thread.sleep(3000);
        }catch (Exception e){

        }
        System.out.println("getjudgementOneValidationMessage "+penaltyPoints.getjudgementOneValidationMessage());
        if(!(penaltyPoints.getjudgementOneValidationMessage().equals(validationMessage))){
            error=true;
            reason=reason+"unable to verify getjudgementOneValidationMessage";
        }
        System.out.println("getjudgementTwoValidationMessage "+penaltyPoints.getjudgementTwoValidationMessage());
        if(!(penaltyPoints.getjudgementTwoValidationMessage().equals(validationMessage))){
            error=true;
            reason=reason+"unable to verify getjudgementTwoValidationMessage";
        }
if(!(error)){
    passStatus("Able to verify validation messages");
}else {
    failStatus("Unable to verify validation messages "+reason);
}
    }
void addPenality(){
    PenaltyPoints penaltyPoints=new PenaltyPoints(getDriver());
    penaltyPoints.clickYesOrNobutton("1");
    penaltyPoints.clickYesOrNobutton("3");
    penaltyPoints.selectPenaltyPointsOneDropDown("3");
    try {
        penaltyPoints.selectPenaltyPointsTwoDropDown("4");
    }catch (Exception e){
        try {
            Thread.sleep(3000);
        }catch (Exception f){

        }
        penaltyPoints.selectPenaltyPointsTwoDropDown("4");
    }

    penaltyPoints.clickYesOrNobutton("3");
    penaltyPoints.clickYesOrNobutton("8");
    penaltyPoints.clickContinueButton();
    penaltyPoints.invisibleClickButton();
    penaltyPoints.clickpenaltyPointsHeading();
}
@Test
    public void verifyAddingPenaltyPointsInPenaltyPointsScreen() throws IOException {
        String reason=" ";
        boolean error=false;
    fillScreenUpToYourClaims();
    addPenality();
    PenaltyPoints penaltyPoints=new PenaltyPoints(getDriver());

 System.out.println(penaltyPoints.verifyPointsAdded("3"));
 if(!(penaltyPoints.verifyPointsAdded("3").equals("3 penalty points added"))){
     error=true;
     reason=reason+"Unable to verify 3 penalty points added";
 }

    System.out.println(penaltyPoints.verifyPointsAdded("4"));
    if(!(penaltyPoints.verifyPointsAdded("4").equals("4 penalty points added"))){
        error=true;
        reason=reason+"Unable to verify 4 penalty points added for brother claim";
    }
    System.out.println(penaltyPoints.verifyJudgementSelection("3"));
    if(!(penaltyPoints.verifyJudgementSelection("3").equals("Yes"))){
        error=true;
        reason=reason+"Unable to verify Judgement selection yes ";
    }
    System.out.println(penaltyPoints.verifyJudgementSelection("4"));
    if(!(penaltyPoints.verifyJudgementSelection("4").equals("No"))){
        error=true;
        reason=reason+"Unable to verify Judgement selection No for brother ";
    }
    if(!(error)){
        passStatus("Able to verify penalty points");
    }else {
        failStatus("Unable to verify penalty points "+reason);
    }
}
@Test
    public void verifyUpdatePenalityPoints() throws IOException {
    String reason=" ";
    boolean error=false;
    fillScreenUpToYourClaims();
    addPenality();

    PenaltyPoints penaltyPoints=new PenaltyPoints(getDriver());
    penaltyPoints.clickpenaltyEditOne();

    penaltyPoints.selectPenaltyPointsOneDropDown("12");
    penaltyPoints.clickpenaltyEditTwo();
    penaltyPoints.selectPenaltyPointsTwoDropDown("3");
    penaltyPoints.clickYesOrNobutton("4");
    penaltyPoints.clickYesOrNobutton("7");
    penaltyPoints.clickContinueButton();
    penaltyPoints.invisibleClickButton();
    penaltyPoints.clickpenaltyPointsHeading();

    System.out.println(penaltyPoints.verifyPointsAdded("12"));
    if(!(penaltyPoints.verifyPointsAdded("12").equals("12 penalty points added"))){
        error=true;
        reason=reason+"Unable to verify 12 penalty points added";
    }

    System.out.println(penaltyPoints.verifyPointsAdded("3"));
    if(!(penaltyPoints.verifyPointsAdded("3").equals("3 penalty points added"))){
        error=true;
        reason=reason+"Unable to verify 3 penalty points added for brother claim";
    }
    System.out.println(penaltyPoints.verifyJudgementSelection("12"));
    if(!(penaltyPoints.verifyJudgementSelection("12").equals("No"))){
        error=true;
        reason=reason+"Unable to verify Judgement selection No ";
    }
    System.out.println(penaltyPoints.verifyJudgementSelection("3"));
    if(!(penaltyPoints.verifyJudgementSelection("3").equals("Yes"))){
        error=true;
        reason=reason+"Unable to verify Judgement selection Yes for brother ";
    }
    if(!(error)){
        passStatus("Able to verify penalty points");
    }else {
        failStatus("Unable to verify penalty points "+reason);
    }

}
@Test
    public void verifyDeletePenaltyPoints() throws IOException {
    String reason=" ";
    boolean error=false;
    fillScreenUpToYourClaims();
    addPenality();

    PenaltyPoints penaltyPoints=new PenaltyPoints(getDriver());
    penaltyPoints.deletePenaltyOnePoints();
    penaltyPoints.clickconfirmDeleteOne();

    penaltyPoints.clickpenaltyPointsHeading();
    penaltyPoints.deletePenaltyTwoPoints();
    penaltyPoints.clickconfirmDeleteTwo();
    penaltyPoints.clickpenaltyPointsHeading();
    System.out.println(penaltyPoints.getPenaltyEditOneButtonSize());

    if(penaltyPoints.getPenaltyEditOneButtonSize()){
        error=true;
        reason=reason+"Unable to delete penality points";
    }
    System.out.println(penaltyPoints.getPenaltyEditTwoButtonSize());
if(penaltyPoints.getPenaltyEditTwoButtonSize()){
    error=true;
    reason=reason+"Unable to delete penality points for brother";
}
if(!(error)){
    passStatus("Able to delete penalty points");
}else {
    failStatus("Unable to delete penalty points "+reason);
}
}

@Test
    public void verifyAddingPenaltyPointsOneValueConditionInPenaltyPointsScreen() throws IOException {
    String reason=" ";
    boolean error=false;
    fillScreenUpToYourClaims();
        PenaltyPoints penaltyPoints=new PenaltyPoints(getDriver());
    penaltyPoints.clickYesOrNobutton("1");
    penaltyPoints.clickYesOrNobutton("3");
    penaltyPoints.selectPenaltyPointsOneDropDown("1");
    penaltyPoints.selectPenaltyPointsTwoDropDown("2");
    penaltyPoints.clickContinueButton();
    penaltyPoints.invisibleClickButton();
    penaltyPoints.clickpenaltyPointsHeading();

    System.out.println(penaltyPoints.verifyPointsAddedOne("1"));
    if(!(penaltyPoints.verifyPointsAddedOne("1").equals("1 penalty points added"))){
        error=true;
        reason=reason+"Unable to verify 3 penalty points added";
    }

    System.out.println(penaltyPoints.verifyPointsAddedOne("2"));
    if(!(penaltyPoints.verifyPointsAddedOne("2").equals("2 penalty points added"))){
        error=true;
        reason=reason+"Unable to verify 4 penalty points added for brother claim";
    }


    if(!(error)){
        passStatus("Able to verify penalty points");
    }else {
        failStatus("Unable to verify penalty points "+reason);
    }
}
@Test
    public void verifyUserCanAbleToNavigateToCoverStartPageBySelectingPenaltyPointsNo() throws IOException {
    fillScreenUpToYourClaims();
    PenaltyPoints penaltyPoints=new PenaltyPoints(getDriver());
    penaltyPoints.clickYesOrNobutton("2");
    penaltyPoints.clickYesOrNobutton("4");
    penaltyPoints.clickContinueButton();
    penaltyPoints.invisibleClickButton();
    try {
        new CoverStartDate(getDriver()).visibilityCoverStartDateHeading();
        passStatus("Able to continue to cover start page by clicking option no");
    }catch (Exception e){
        failStatus("Unable to continue to cover start page by clicking option no");
    }
}
}
