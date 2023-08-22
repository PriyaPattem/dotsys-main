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
import java.time.format.DateTimeFormatter;

import static org.selenium.pom.tests.InsuranceDetailsTests.NOPREVIOUSEXPERIENCE;


public class YourQuoteTests extends BaseTest {
    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static final String HOWWECALCULATEPREMIUM="How we calculate your premium";
    static final String SCROLLVALUE="600";
 /* public  void fillUptoCoverStartPage() throws IOException {
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
        //

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
    }*/
    public  void fillUptoCoverStartPage() throws IOException {
      new YourQuote(getDriver()).fillUptoCoverStartPage(getDriver());
    }

    @Test
    public void verifyViewPremiumModalsForSinglePaymentAnd9MonthlyPaymentsinComprehensiveInYourQuotePage() throws IOException {
      String reason=" ";
      boolean error=false;
        fillUptoCoverStartPage();
        YourQuote yourQuote=new YourQuote(getDriver());
        yourQuote.clickSinglepremium();
        System.out.println(yourQuote.getcalculatePremiumHeading());
        if(!(yourQuote.getcalculatePremiumHeading().equals(HOWWECALCULATEPREMIUM))){
            error=true;
            reason=reason+"Unable to verify single premium modal in comprehensive";
        }
        yourQuote.clickclosePremiumModal();
        yourQuote.clickMultiPremium();
        System.out.println(yourQuote.getcalculateMultiPremiumHeading());
        if(!(yourQuote.getcalculateMultiPremiumHeading().equals(HOWWECALCULATEPREMIUM))){
            error=true;
            reason=reason+"Unable to verify 9 monthly premium modal in comprehensive";
        }
        yourQuote.clickclosePremiumModal();
        yourQuote.clickthirdPartyFireAndTheftButton();
        yourQuote.invisibilityOfLoading();
        yourQuote.clickSinglepremium();
        System.out.println(yourQuote.getcalculatePremiumHeading());
        if(!(yourQuote.getcalculatePremiumHeading().equals(HOWWECALCULATEPREMIUM))){
            error=true;
            reason=reason+"Unable to verify single premium modal in third party,fire and theft";
        }
        yourQuote.clickclosePremiumModal();
        yourQuote.clickMultiPremium();
        System.out.println(yourQuote.getcalculateMultiPremiumHeading());
        if(!(yourQuote.getcalculateMultiPremiumHeading().equals(HOWWECALCULATEPREMIUM))){
            error=true;
            reason=reason+"Unable to verify 9 monthly premium modal in third party,fire and theft";
        }
        yourQuote.clickclosePremiumModal();
        if(!(error)){
            passStatus("Able to verify premium modal");
        }else {
            failStatus("Unable to verify premium modal "+reason);
        }
    }
    @Test
    public void verifyBuyNowAndPayMonthlyButtonNavigationsInComprehensiveAndThirdPartyFireAndTheftInYourQuoteTests() throws IOException {
      String reason=" ";
      boolean error=false;
       AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
        fillUptoCoverStartPage();
        YourQuote yourQuote=new YourQuote(getDriver());
        yourQuote.clicksinglePaymentBuyNow();
        yourQuote.invisibilityOfLoading();
        try {
            aboutYourCar.visibilityofaboutYourCar();
        }catch (Exception e){
            error=true;
            reason=reason+"Unable to navigate to about your car screen when user clicks on buy now from comprehensive";
        }

        aboutYourCar.clickbackButton();
        yourQuote.clickmultiPaymentBuyNow();
        yourQuote.invisibilityOfLoading();
        try {
            aboutYourCar.visibilityofaboutYourCar();
        }catch (Exception e){
            error=true;
            reason=reason+"Unable to navigate to about your car screen when user clicks on pay monthly from comprehensive";
        }

        aboutYourCar.clickbackButton();
        yourQuote.clickthirdPartyFireAndTheftButton();
        yourQuote.invisibilityOfLoading();
        yourQuote.clicksinglePaymentBuyNow();
        yourQuote.invisibilityOfLoading();
        try {
            aboutYourCar.visibilityofaboutYourCar();
        }catch (Exception e){
            error=true;
            reason=reason+"Unable to navigate to about your car screen when user clicks on buy now from third party theft and fire";
        }

        aboutYourCar.clickbackButton();
        yourQuote.clickmultiPaymentBuyNow();
        yourQuote.invisibilityOfLoading();
        try {
            aboutYourCar.visibilityofaboutYourCar();
        }catch (Exception e){
            error=true;
            reason=reason+"Unable to navigate to about your car screen when user clicks on pay monthly from third party theft and fire";
        }

        aboutYourCar.clickbackButton();
        try {
            aboutYourCar.visibilityofaboutYourCar();
        }catch (Exception e){
            error=true;
            reason=reason+"Unable to navigate back to quote page from about your car page";
        }
        if(!(error)){
            passStatus("Able to continue to next step after clicking buy button");
        }else {
            failStatus("Unable to navigate to next step after clicking buy button "+reason);
        }



    }

    @Test
    public void verifyManageYourExcessSelectionsInYourQuotePage() throws IOException {
        String reason=" ";
        boolean error=false;
        fillUptoCoverStartPage();
        YourQuote yourQuote=new YourQuote(getDriver());
        //System.out.println(yourQuote.getMidAccountCheckStatusByAttribute());
        System.out.println(yourQuote.getexcessIncreasedTextSize());
        if(!(yourQuote.getexcessIncreasedTextSize()==0)){
            error=true;
            reason=reason+"able to display excess increased text for 300";
        }
        yourQuote.clickexcessAmount125();
        System.out.println(yourQuote.getMinAccountCheckStatusByAttribute());
        if(!(yourQuote.getMinAccountCheckStatusByAttribute()).contains("checked")){
            error=true;
            reason=reason+"able to display excess increased text for 125";
        }
        yourQuote.clickselectExcessButton();
        yourQuote.invisibilityOfLoading();
        System.out.println(yourQuote.getexcessIncreasedText());
        if(!(yourQuote.getexcessIncreasedText().contains("Excess reduced to €125: € 178.07"))){
            error=true;
            reason=reason+"Unable to verify Excess reduced to €125: € 178.07";
        }
        yourQuote.clickexcessAmount600();

        System.out.println(yourQuote.getMaxAccountCheckStatusByAttribute());
        if(!(yourQuote.getMaxAccountCheckStatusByAttribute()).contains("checked")){
            error=true;
            reason=reason+"able to display excess increased text for 600";
        }
        yourQuote.clickselectExcessButton();
        yourQuote.invisibilityOfLoading();
        System.out.println(yourQuote.getexcessIncreasedText());

        if(!(yourQuote.getexcessIncreasedText().contains("Excess increased to €600: € -178.07"))){
            error=true;
            reason=reason+"Unable to verify Excess increased to €600: € -178.07";
        }
        if(!(error)){
            passStatus("Unable to verify manage your excess values");
        }else {
            failStatus("Unable to verify "+reason);
        }

    }
@Test
    public void verifyAddJourneyWiseAccidentCoverInYourQuotePage() throws IOException {
        String reason=" ";
        boolean error=false;
    fillUptoCoverStartPage();
    YourQuote yourQuote=new YourQuote(getDriver());
    yourQuote.clickaddJourneyWiseButton();
    yourQuote.invisibilityOfLoading();
    System.out.println(yourQuote.getjourneyWiseText());
    if(!(yourQuote.getjourneyWiseText().contains("JourneyWise accident cover added: € 12.00"))){
        error=true;
        reason=reason+"JourneyWise accident cover added: € 12.00";
    }
    yourQuote.clickremoveJourneyWiseButton();
    yourQuote.invisibilityOfLoading();
    System.out.println(yourQuote.getjourneyWiseTextSize());
    if(!(yourQuote.getjourneyWiseTextSize()==0)){
        error=true;
        reason=reason+"Able to see JourneyWise accident cover after removing journeywise accident cover";
    }
if(!(error)){
    passStatus("Able to verify journey wise accident cover");
}else {
    failStatus("Unable to verify "+reason);
}
}

@Test
    public void verifyProtectYourNoClaimsDiscountInYourQuotePage() throws IOException {
        String reason=" ";
        boolean error=false;
    fillUptoCoverStartPage();
    YourQuote yourQuote=new YourQuote(getDriver());
    yourQuote.clickstepBack();
    yourQuote.clickaddThisCover();
yourQuote.invisibilityOfLoading();
    System.out.println(yourQuote.getnodiscountClaimsMessage());
    if(!(yourQuote.getnodiscountClaimsMessage().contains("Step-back No Claims discount added: € 178.07"))){
        error=true;
        reason=reason+"Unable to verify Step-back No Claims discount added: € 178.07";
    }
    yourQuote.clickremoveThisCover();
    yourQuote.invisibilityOfLoading();
    yourQuote.clickprotectedClaims();
    yourQuote.clickaddThisCover();
    yourQuote.invisibilityOfLoading();
    System.out.println(yourQuote.getnodiscountClaimsMessage());
    if(!(yourQuote.getnodiscountClaimsMessage().contains("Protected No Claims discount added: € 356.14"))){
        error=true;
        reason=reason+"Unable to verify Protected No Claims discount added: € 356.14";
    }
    yourQuote.clickremoveThisCover();
    yourQuote.invisibilityOfLoading();
    yourQuote.clickprotectedStepback();
    yourQuote.clickaddThisCover();
    yourQuote.invisibilityOfLoading();
    System.out.println(yourQuote.getnodiscountClaimsMessage());
    if(!(yourQuote.getnodiscountClaimsMessage().contains("Protected No Claims Discount with Stepback added: € 552.01"))){
        error=true;
        reason=reason+"Unable to verify Protected No Claims Discount with Stepback added: € 552.01";
    }
if(!(error)){
    passStatus("Able to verify no claims discount module");
}else {
    failStatus("Unable to verify "+reason);
}

}
@Test
    public void AddWindScreenCoverInThirdPartyFireAndTheftInYourQuote() throws IOException {
        String reason=" ";
        boolean error=false;
    fillUptoCoverStartPage();
    YourQuote yourQuote=new YourQuote(getDriver());
    yourQuote.clickthirdPartyFireAndTheftButton();
    yourQuote.invisibilityOfLoading();
    yourQuote.clickaddWindScreenCover();
    yourQuote.invisibilityOfLoading();
    System.out.println(yourQuote.getwindScreenCoverText());
    if(!(yourQuote.getwindScreenCoverText().contains("Windscreen cover added: € 96.16"))){
        error=true;
        reason=reason+"Unable to verify Windscreen cover added: € 96.16";
    }
    yourQuote.clickremoveWindScreenCover();
    yourQuote.invisibilityOfLoading();
    System.out.println(yourQuote.getwindScreenCoverTextsize());
    if(!(yourQuote.getwindScreenCoverTextsize()==0)){
        error=true;
        reason=reason+"Able to see windscreen cover added after removing windscreen";
    }
    if(!(error)){
        passStatus("Able to verify windscreen");
    }else {
        failStatus("Unable to verify "+reason);
    }
}
@Test
    public void verifyvehicleDetailsNavigationInYourQuote() throws IOException {
    fillUptoCoverStartPage();
    YourQuote yourQuote=new YourQuote(getDriver());
    yourQuote.clickupdateYourInformation();
    yourQuote.clickeditvehicleDetails();
    try {
        new CarDetails(getDriver()).visibilityContinueButton();
        new CarDetails(getDriver()).clickContinueButton();
        passStatus("Able to verify navigation");
    }catch (Exception e){
        failStatus("Unable to verify navigation");
    }



}

    @Test
    public void verifyInsuranceHistoryNavigationInYourQuote() throws IOException {
        fillUptoCoverStartPage();
        YourQuote yourQuote=new YourQuote(getDriver());
        yourQuote.clickupdateYourInformation();
        yourQuote.clickeditInsuranceDetails();
        try {
            new InsuranceDetails(getDriver()).visibilityContinueButton();
            new InsuranceDetails(getDriver()).clickContinueButton();
            passStatus("Able to verify navigation");
        }catch (Exception e){
            failStatus("Unable to verify navigation");
        }



    }

    @Test
    public void verifyPersonalDetailsNavigationInYourQuote() throws IOException {
        fillUptoCoverStartPage();
        YourQuote yourQuote=new YourQuote(getDriver());
        yourQuote.clickupdateYourInformation();
        yourQuote.clickeditPersonalDtails();
        try {
            new PersonalDetails(getDriver()).visibilityContinueButton();
            new PersonalDetails(getDriver()).clickContinueButton();
            passStatus("Able to verify navigation");
        }catch (Exception e){
            failStatus("Unable to verify navigation");
        }



    }

    @Test
    public void verifyDrivingExperienceNavigationInYourQuote() throws IOException {
        fillUptoCoverStartPage();
        YourQuote yourQuote=new YourQuote(getDriver());
        yourQuote.clickupdateYourInformation();
        yourQuote.clickeditDrivingExperience();
        try {
            new InsuranceDetails(getDriver()).visibilityContinueButton();
            new InsuranceDetails(getDriver()).clickContinueButton();
            passStatus("Able to verify navigation");
        }catch (Exception e){
            failStatus("Unable to verify navigation");
        }



    }

    @Test
    public void verifyAdditionalDriversNavigationInYourQuote() throws IOException {
        fillUptoCoverStartPage();
        YourQuote yourQuote=new YourQuote(getDriver());
        yourQuote.clickupdateYourInformation();
        yourQuote.clickeditAdditionalDrivers();
        try {
            new AdditionalDrivers(getDriver()).visibilityContinueButton();
            new AdditionalDrivers(getDriver()).clickContinueButton();
            passStatus("Able to verify navigation");
        }catch (Exception e){
            failStatus("Unable to verify navigation");
        }



    }

    @Test
    public void verifyUpdateYourInformationModalsinYourQuote() throws IOException, InterruptedException {
        String reason=" ";
        boolean error=false;
        fillUptoCoverStartPage();
        YourQuote yourQuote=new YourQuote(getDriver());
        yourQuote.clickupdateYourInformation();
        yourQuote.clickvehicleDetailsTooltip();
        System.out.println(yourQuote.getModalDescription());
        if(!(yourQuote.getModalDescription().equals("Update your make and model, vehicle value, NCT and annual mileage"))){
            error=true;
            reason=reason+"Update your make and model, vehicle value, NCT and annual mileage modal";

        }
        yourQuote.clickcloseModal();
        yourQuote.clickinsuranceDetailsTooltip();
        System.out.println(yourQuote.getModalDescription());
        if(!(yourQuote.getModalDescription().equals("Update your insurance history, years no claims, discount/named driver experience and cover start date"))){
            error=true;
            reason=reason+"Update your insurance history, years no claims, discount/named driver experience and cover start date modal";
        }
        yourQuote.clickcloseModal();
        yourQuote.clickpersonalDetailstooltip();
        System.out.println(yourQuote.getModalDescription());
        if(!(yourQuote.getModalDescription().equals("Update your name/contact details, date of birth, occupation details, and overnight parking"))){
            error=true;
            reason=reason+"Update your name/contact details, date of birth, occupation details, and overnight parking modal";
        }
        yourQuote.clickcloseModal();
        yourQuote.clickdrivingExperienceTooltip();
        System.out.println(yourQuote.getModalDescription());
        if(!(yourQuote.getModalDescription().equals("Update your licence details, claims/accidents and penalty points/convictions"))){
            error=true;
            reason=reason+"Update your licence details, claims/accidents and penalty points/convictions modal";
        }
        yourQuote.clickcloseModal();
        yourQuote.clickadditionalDriverTooltip();
        System.out.println(yourQuote.getModalDescription());
        if(!(yourQuote.getModalDescription().equals("Update details about your additional driver(s)"))){
            error=true;
            reason=reason+"Update details about your additional driver(s) modal";
        }
        yourQuote.clickcloseModal();
if(!(error)){
    passStatus("Able to verify modals");
}else {
    failStatus("Unable to verify "+reason);
}
    }
}
