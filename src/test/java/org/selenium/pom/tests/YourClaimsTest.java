package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProvider.YourClaimsDataProvider;
import org.selenium.pom.objects.AdditionalDriversModal;
import org.selenium.pom.objects.CarDetailsModal;
import org.selenium.pom.objects.customerScreenOneModal;
import org.selenium.pom.objects.personalDetailsModal;
import org.selenium.pom.pages.*;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.selenium.pom.tests.InsuranceDetailsTests.NOPREVIOUSEXPERIENCE;

public class YourClaimsTest extends BaseTest {
    static final String SCROLLVALUE="600";
   /* public void fillScreenUpToAdditionalDrivers() throws IOException {
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
        //

        AdditionalDrivers additionalDrivers=new AdditionalDrivers(getDriver());
        additionalDrivers.clickadditionalDriversYes();
        AdditionalDriversModal additionalDriversModal=new AdditionalDriversModal(3);
        additionalDrivers.fillAdditionalDriver(additionalDriversModal);
        additionalDrivers.clickAdditionalDriversNo();
        additionalDrivers.clickContinueButton();
        additionalDrivers.waitForInvisibilityForClickButton();
       // additionalDrivers.clickEditDriver();
       // additionalDrivers.visibilityaddDriverButton();


    }*/
    public void fillScreenUpToAdditionalDrivers() throws IOException {
        new YourClaims(getDriver()).fillScreenUpToAdditionalDrivers(getDriver());
    }
    @Test
    public void fieldsValidationInYourClaims() throws IOException {
        String reason=" ";
        boolean error=false;
        fillScreenUpToAdditionalDrivers();
        YourClaims yourClaims=new YourClaims(getDriver());
        yourClaims.clickContinueButton();
        System.out.println(yourClaims.getpleaseSelectAnOption());
        System.out.println(yourClaims.getpleaseSelectAnOptionOne());
        if(!(yourClaims.getpleaseSelectAnOption().equals("Please select an option"))){
            error=true;
            reason=reason+ "Please select an option for claim one missing";
        }
        if(!(yourClaims.getpleaseSelectAnOptionOne().equals("Please select an option"))){
            error=true;
            reason=reason+ "Please select an option for claim two missing";
        }
        yourClaims.clickselectOptionOne();
        yourClaims.clickselectOptionTwo();
        yourClaims.clickContinueButton();
System.out.println(yourClaims.getClaimOneValidationMessage());
        System.out.println(yourClaims.getclaimTwoValidationMessage());
        if(!(yourClaims.getClaimOneValidationMessage().equals("You have not added any claims."))){
            error=true;
            reason=reason+ "You have not added any claims for claim one missing";
        }
        if(!(yourClaims.getclaimTwoValidationMessage().equals("You have not added any claims."))){
            error=true;
            reason=reason+ "You have not added any claims for claim two missing";
        }
        yourClaims.clickaddClaimOne();
        yourClaims.clicksaveClaim();
        System.out.println(yourClaims.getclaimDateValidation());
        if(!(yourClaims.getclaimDateValidation().equals("Please enter the date of your claim"))){
            error=true;
            reason=reason+ "Please enter the date of your claim missing";
        }
        System.out.println(yourClaims.getincidentTypeValidation());
        if(!(yourClaims.getincidentTypeValidation().equals("Please select the incident"))){
            error=true;
            reason=reason+ "Please select the incident missing";
        }
        System.out.println(yourClaims.getclaimSettledValidation());
        if(!(yourClaims.getclaimSettledValidation().equals("Please select an option"))){
            error=true;
            reason=reason+ "Please select an option missing in add claim";
        }
        yourClaims.clickclaimCancel();
yourClaims.visibilityOfClaimtwo();
if(!(error)){
    passStatus("Able to verify validation messages");
}else {
    failStatus("Unable to verify validation messages "+reason);
}

    }

    @Test
    public void verifyFutureValidationMessagesInAddClaim() throws IOException {
        String reason=" ";
        boolean error=false;
        String futuredate="01/01/2030";
        String pastdate="01/01/2000";
        String incidentType="Windscreen";
        fillScreenUpToAdditionalDrivers();
        YourClaims yourClaims=new YourClaims(getDriver());
        yourClaims.clickselectOptionOne();
        yourClaims.clickaddClaimOne();
        yourClaims.inputDob(futuredate);
        yourClaims.selectIncidentType(incidentType);
        yourClaims.clickclaimSelectedYes();
        yourClaims.clicksaveClaim();
        System.out.println(yourClaims.getdatefuturepastMessage());
        if(!(yourClaims.getdatefuturepastMessage().equals("Date can not be in future"))){
            error=true;
            reason=reason+"Date can not be in future validation failed";
        }

        yourClaims.inputDob(pastdate);
        yourClaims.clicksaveClaim();
        System.out.println(yourClaims.getdatefuturepastMessage());
        if(!(yourClaims.getdatefuturepastMessage().equals("Date not in last 3 years"))){
            error=true;
            reason=reason+"Date not in last 3 years validation failed";
        }




    }
    String validdate="01/01/2022";
    @Test
    public void verifyAccidentIncidentClaimErrorMessages() throws IOException {
        String reason=" ";
        boolean error=false;
        String incidentType="Accident";
        String date="01/01/2021";
        fillScreenUpToAdditionalDrivers();
        YourClaims yourClaims=new YourClaims(getDriver());
        yourClaims.clickselectOptionOne();
        yourClaims.clickaddClaimOne();
        yourClaims.inputDob(date);
        yourClaims.selectIncidentType(incidentType);

        yourClaims.clickclaimSelectedYes();
        yourClaims.clicksaveClaim();

        System.out.println(yourClaims.getaccidentFaultErrorMessage());
        System.out.println(yourClaims.getaccidentPersonalInjuryErrorMessage());
        System.out.println(yourClaims.getsettlementCostErrorMessage());
        if(!((yourClaims.getaccidentFaultErrorMessage().equals("Please select an option")))){
            error=true;
            reason=reason+"Unable to verify accident fault error message";
        }
        if(!((yourClaims.getaccidentPersonalInjuryErrorMessage().equals("Please select an option")))){
            error=true;
            reason=reason+"Unable to verify personal injury error message";
        }
        if(!((yourClaims.getsettlementCostErrorMessage().equals("Please enter your settlement cost")))){
            error=true;
            reason=reason+"Unable to verify Please enter your settlement cost error message";
        }
yourClaims.inputSettlementCost("fdgdgdggd");
        yourClaims.clicksaveClaim();
        System.out.println(yourClaims.getinvalidsettlementCostErrorMessage());
        if(!((yourClaims.getinvalidsettlementCostErrorMessage().equals("Please enter the cost of your settlement")))){
            error=true;
            reason=reason+"Unable to verify Please enter the cost of your settlement error message";
        }
    }

    void addAccidentClaim(String incidentType,String validdate,String amount){
        YourClaims yourClaims=new YourClaims(getDriver());
        yourClaims.clickselectOptionOne();
        yourClaims.clickaddClaimOne();
        yourClaims.inputDob(validdate);
        yourClaims.selectIncidentType(incidentType);
        yourClaims.clickclaimSelectedYes();
        yourClaims.clickfaultButtonYes();
        yourClaims.clickpersonalInjuryClaimYes();
        yourClaims.inputSettlementCost(amount);
        yourClaims.clicksaveClaim();
        //Claim type: Accident
        yourClaims.presenceOfTextElement(incidentType);
        yourClaims.presenceOfTextElement(validdate);
        yourClaims.clickclaimOneEditButton();
        yourClaims.visibilityOfSaveClaim();
    }
@Test
    public void addAccidentClaimInYourClaims() throws IOException {
        String amount="555555555";
        String reason=" ";
        boolean error=false;
    String incidentType="Accident";
    fillScreenUpToAdditionalDrivers();
    YourClaims yourClaims=new YourClaims(getDriver());
    addAccidentClaim(incidentType,validdate,amount);
System.out.println(yourClaims.getIncidentDateJS());
    if(!(yourClaims.getIncidentDateJS().contains(validdate))){
        error=true;
        reason=reason+"Unable to verify date";
    }
    System.out.println(yourClaims.getIncidentTypeJS());
    if(!(yourClaims.getIncidentTypeJS().contains(incidentType))){
        error=true;
        reason=reason+"Unable to verify incident type";
    }
    System.out.println(yourClaims.getClaimAmountJS());
    if(!(yourClaims.getClaimAmountJS().contains(amount))){
        error=true;
        reason=reason+"Unable to verify claim amount";
    }
    System.out.println(yourClaims.claimSelectedornotAttribute());

    System.out.println(yourClaims.faultSelectedornotAttribute());
    System.out.println(yourClaims.personalInjurySelectedornotAttribute());
    if(!(yourClaims.claimSelectedornotAttribute().contains("checked"))){
        error=true;
        reason=reason+"Unable to verify claim selected attribute";
    }
    if(!(yourClaims.personalInjurySelectedornotAttribute().contains("checked"))){
        error=true;
        reason=reason+"Unable to verify personal injury selected attribute";
    }
    if((yourClaims.faultSelectedornotAttribute().contains("checked"))){
        error=true;
        reason=reason+"Unable to verify fault  selected attribute";
    }
if(!(error)){
    passStatus("Able to verify accident claim");
}else {
    failStatus(reason);
}
}

@Test
    public void updateAccidentClaimInYourClaims() throws IOException {
    String amount="66666";
    String reason=" ";
    String date="02/02/2022";
    boolean error=false;
    String incidentType="Accident";
    fillScreenUpToAdditionalDrivers();
    YourClaims yourClaims=new YourClaims(getDriver());
    addAccidentClaim(incidentType,validdate,"55555555");
    yourClaims.inputDob(date);
    yourClaims.clickfaultButtonno();
    yourClaims.clickpersonalInjuryClaimNo();
    yourClaims.inputSettlementCost(amount);
    yourClaims.clicksaveClaim();
    //Claim type: Accident
    yourClaims.presenceOfTextElement(incidentType);
    yourClaims.presenceOfTextElement(date);
    yourClaims.clickclaimOneEditButton();
    yourClaims.visibilityOfSaveClaim();
    System.out.println(yourClaims.getIncidentDateJS());
    if(!(yourClaims.getIncidentDateJS().contains(date))){
        error=true;
        reason=reason+"Unable to verify date";
    }
    System.out.println(yourClaims.getIncidentTypeJS());
    if(!(yourClaims.getIncidentTypeJS().contains(incidentType))){
        error=true;
        reason=reason+"Unable to verify incident type";
    }
    System.out.println(yourClaims.getClaimAmountJS());
    if(!(yourClaims.getClaimAmountJS().contains(amount))){
        error=true;
        reason=reason+"Unable to verify claim amount";
    }
    System.out.println(yourClaims.claimSelectedornotAttribute());

    System.out.println(yourClaims.faultSelectedornotAttribute());
    System.out.println(yourClaims.personalInjurySelectedornotAttribute());
    if(!(yourClaims.claimSelectedornotAttribute().contains("checked"))){
        error=true;
        reason=reason+"Unable to verify claim selected attribute";
    }
    if((yourClaims.personalInjurySelectedornotAttribute().contains("checked"))){
        error=true;
        reason=reason+"Unable to verify personal injury selected attribute";
    }
    if(!(yourClaims.faultSelectedornotAttribute().contains("checked"))){
        error=true;
        reason=reason+"Unable to verify fault  selected attribute";
    }
    if(!(error)){
        passStatus("Able to verify accident claim");
    }else {
        failStatus(reason);
    }
}

@Test(dataProvider = "addclaims",dataProviderClass = YourClaimsDataProvider.class)
public void verifyAddClaimForFireTheftVandalism(String incidentType,String date,String amount) throws IOException {
    String reason=" ";
    boolean error=false;
    fillScreenUpToAdditionalDrivers();
    YourClaims yourClaims=new YourClaims(getDriver());
    yourClaims.fillclaimData(incidentType,date,amount);
    System.out.println(yourClaims.getIncidentDateJS());
    if(!(yourClaims.getIncidentDateJS().contains(validdate))){
        error=true;
        reason=reason+"Unable to verify date";
    }
    System.out.println(yourClaims.getIncidentTypeJS());
    if(!(yourClaims.getIncidentTypeJS().contains(incidentType))){
        error=true;
        reason=reason+"Unable to verify incident type";
    }
    System.out.println(yourClaims.getClaimAmountJS());
    if(!(yourClaims.getClaimAmountJS().contains(amount))){
        error=true;
        reason=reason+"Unable to verify claim amount";
    }
    System.out.println(yourClaims.claimSelectedornotAttribute());
    if(!(yourClaims.claimSelectedornotAttribute().contains("checked"))){
        error=true;
        reason=reason+"Unable to verify claim selected attribute";
    }
    if(!(error)){
        passStatus("Able to verify accident claim");
    }else {
        failStatus(reason);
    }

}

@Test(dataProvider = "updateclaims",dataProviderClass = YourClaimsDataProvider.class)
public void verifyUpdateClaimForFireTheftVandalism(String incidentType,String date,String amount,String updateDate,String updateAmount) throws IOException {
    String reason=" ";
    boolean error=false;
    fillScreenUpToAdditionalDrivers();
    YourClaims yourClaims=new YourClaims(getDriver());
    yourClaims.fillclaimData(incidentType,date,amount);

  yourClaims. inputDob(updateDate);

    yourClaims.   inputSettlementCost(updateAmount);
    yourClaims.  clicksaveClaim();
    yourClaims.  presenceOfTextElement(incidentType);
    yourClaims. presenceOfTextElement(updateDate);
    yourClaims. clickclaimTwoEditButton();
    yourClaims. visibilityOfSaveClaim();


    if(!(yourClaims.getIncidentDateJS().contains(updateDate))){
        error=true;
        reason=reason+"Unable to verify date";
    }
    System.out.println(yourClaims.getIncidentTypeJS());
    if(!(yourClaims.getIncidentTypeJS().contains(incidentType))){
        error=true;
        reason=reason+"Unable to verify incident type";
    }
    System.out.println(yourClaims.getClaimAmountJS());
    if(!(yourClaims.getClaimAmountJS().contains(updateAmount))){
        error=true;
        reason=reason+"Unable to verify claim amount";
    }
    if(!(yourClaims.claimSelectedornotAttribute().contains("checked"))){
        error=true;
        reason=reason+"Unable to verify claim selected attribute";
    }
    if(!(error)){
        passStatus("Able to verify  claim");
    }else {
        failStatus(reason);
    }

}
void addMultipleClaims(String incidentType,String amount){
    YourClaims yourClaims=new YourClaims(getDriver());

    yourClaims.clickselectOptionOne();
    yourClaims.clickaddClaimOne();
    yourClaims.inputDob(validdate);
    yourClaims.selectIncidentType(incidentType);
    yourClaims.clickclaimSelectedYes();
    yourClaims.clickfaultButtonYes();
    yourClaims.clickpersonalInjuryClaimYes();
    yourClaims.inputSettlementCost(amount);
    yourClaims.clicksaveClaim();
    //Claim type: Accident
    yourClaims.presenceOfTextElement(incidentType);
    yourClaims.presenceOfTextElement(validdate);
}
@Test
    public void addClaimsAndDeleteInYourClaims() throws IOException {
    String amount="555555555";
    String reason=" ";
    boolean error=false;
    String incidentType="Accident";
    fillScreenUpToAdditionalDrivers();
    YourClaims yourClaims=new YourClaims(getDriver());
    addAccidentClaim(incidentType,validdate,amount);
    yourClaims.clickclaimCancel();

   // yourClaims.clickDeleteClaimButton();
    yourClaims.clickDeleteClaimButton();
    System.out.println(yourClaims.getDeleteClaimButtonSize());
yourClaims.visibleaddanotherclaim();
yourClaims.clickContinueButton();
try {
    Thread.sleep(5000);
}catch (Exception e){

}
    if(!(yourClaims.getClaimOneValidationMessage().contains("You have not added any claims."))){
       failStatus("Unable to delete claims");
    }else {
        passStatus("Able to delete claim");
    }

}

@Test
public void verifyClaimFullySettledModalInYourClaims() throws IOException {
    fillScreenUpToAdditionalDrivers();
    YourClaims yourClaims=new YourClaims(getDriver());
    yourClaims.clickselectOptionOne();
    yourClaims.clickaddClaimOne();
    yourClaims.selectIncidentType("Accident");
    yourClaims.clickclaimSelectedYes();
    yourClaims.clickclaimSettledToolTip();
    System.out.println(yourClaims.getModalText());
    if(yourClaims.getModalText().equals("For a claim to be fully settled, all payments due for any damage and third party injury must have been settled in full and a final settlement letter must have been received by you from the insurer settling the claim. If this is not the case the claim may still be outstanding and you should select 'No' to this question.")){
        passStatus("Able to verify modal content");
    }else {
        failStatus("Unable to verify modal content");
    }
}
    @Test
    public void verifyClaimFaultModalInYourClaims() throws IOException {
        fillScreenUpToAdditionalDrivers();
        YourClaims yourClaims=new YourClaims(getDriver());
        yourClaims.clickselectOptionOne();
        yourClaims.clickaddClaimOne();
        yourClaims.selectIncidentType("Accident");
        yourClaims.clickclaimSelectedYes();
        yourClaims.clickfaultToolTip();
        System.out.println(yourClaims.getModalText());
        if(yourClaims.getModalText().equals("If you had to make a claim that was your fault then you should answer 'Yes' to this question. Examples include: You rear ended another party on the road or you damaged your car with no other party involved. In any of the above examples the claim may have impacted your no claims bonus and your settlement may have been subject to an excess.")){
            passStatus("Able to verify modal content");
        }else {
            failStatus("Unable to verify modal content");
        }
    }
    @Test
    public void verifyClaimPersonalInjuryModalInYourClaims() throws IOException {
        fillScreenUpToAdditionalDrivers();
        YourClaims yourClaims=new YourClaims(getDriver());
        yourClaims.clickselectOptionOne();
        yourClaims.clickaddClaimOne();
        yourClaims.selectIncidentType("Accident");
        yourClaims.clickclaimSelectedYes();
        yourClaims.clickpersonalClaimTooltip();
        System.out.println(yourClaims.getModalText());
        if(yourClaims.getModalText().equals("You must answer 'Yes' here if a Personal injury Claim has been made against you as a result of an accident.")){
            passStatus("Able to verify modal content");
        }else {
            failStatus("Unable to verify modal content");
        }
    }
    @Test
    public void verifyClaimSettledModalInYourClaims() throws IOException {
        fillScreenUpToAdditionalDrivers();
        YourClaims yourClaims=new YourClaims(getDriver());
        yourClaims.clickselectOptionOne();
        yourClaims.clickaddClaimOne();
        yourClaims.selectIncidentType("Accident");
        yourClaims.clickclaimSelectedYes();
        yourClaims.clickclaimSettledTooltip();
        System.out.println(yourClaims.getModalText());
        if(yourClaims.getModalText().equals("Please advise the total claim costs involved here. These may be for repairs to the third party car and for injuries to the other driver or passengers that had to be paid to compensate and close the claim. If you do not know the total amount, this information can be obtained from your insurer at the time that handled the accident/claim.")){
            passStatus("Able to verify modal content");
        }else {
            failStatus("Unable to verify modal content");
        }
    }


@Test(enabled = false)
    public void frward() throws IOException {

    fillScreenUpToAdditionalDrivers();
    YourClaims yourClaims=new YourClaims(getDriver());
    yourClaims.fillClaimAndContinue("01/01/2020","Accident","555555555");
}


}
