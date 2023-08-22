package org.selenium.pom.tests;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
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

public class AboutYourCarTests extends BaseTest {
    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static final String SCROLLVALUE="600";
  /*public   void fillUptoGetQuotePage() throws IOException {

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
        //
        new YourQuote(getDriver()).clicksinglePaymentBuyNow();
        new YourQuote(getDriver()).invisibilityOfLoading();
        new AboutYourCar(getDriver()).visibilityofaboutYourCar();
    }*/
    public   void fillUptoGetQuotePage() throws IOException {
      new AboutYourCar(getDriver()).fillUptoGetQuotePage(getDriver());
    }
    @Test
    public void verifyExistingCarRegistrationInAboutYourCarPage() throws IOException {
        fillUptoGetQuotePage();
        AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
       // aboutYourCar.clickcontinueButton();
        System.out.println(aboutYourCar.getexistingcarRegistrationMessage());
        if(aboutYourCar.getexistingcarRegistrationMessage().contains("The MERCEDES BENZ registration 12D151 that you wish to insure")){
            passStatus("Able to verify existing car registration");
        }else {
            failStatus("Unable to verify The MERCEDES BENZ registration 12D151 that you wish to insure data");
        }
       // System.out.println(aboutYourCar.getcarOwnerMessage());
       // System.out.println(aboutYourCar.getcarTaxMessage());
      //  System.out.println(aboutYourCar.getcarUseMessage());
    }

    @Test
    public void verifyValidationMessagesInAboutYouCarPage() throws IOException {
        String reason=" ";
        boolean error=false;

        fillUptoGetQuotePage();
        AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
         aboutYourCar.clickcontinueButton();
         System.out.println(aboutYourCar.getcarOwnerMessage());
if(!(aboutYourCar.getcarOwnerMessage().contains("Please select if you are the car owner"))){
    error=true;
    reason=reason+"Please select if you are the car owner";
}
         System.out.println(aboutYourCar.getcarTaxMessage());
if(!(aboutYourCar.getcarTaxMessage().contains("Please select if the car is taxed privately"))){
    error=true;
    reason=reason+"Please select if the car is taxed privately";
}
          System.out.println(aboutYourCar.getcarUseMessage());
if(!(aboutYourCar.getcarUseMessage().contains("Please select the car use"))){
    error=true;
    reason=reason+"Please select the car use";
}
if(!(error)){
    passStatus("Able to verify validation messages");
}else {
    failStatus("Unable to verify following messages "+reason);
}
    }
    @Test
    public void verifyCarRegistrationValidationMessageIfManualCarDetailsProvidedInAboutYourCarPage() throws IOException, InterruptedException {
        String reason=" ";
        boolean error=false;
        fillUptoYourQuoteWithManualCar(getDriver());
        YourQuote yourQuote=new YourQuote(getDriver());
        AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
        CarDetails carDetails=new CarDetails(getDriver());

       /* fillUptoGetQuotePage();
        AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
        aboutYourCar.clickbackButton();
        YourQuote yourQuote=new YourQuote(getDriver());
        yourQuote.clickupdateYourInformation();
        yourQuote.clickeditvehicleDetails();
CarDetails carDetails=new CarDetails(getDriver());
carDetails.clickChangeCarDetails();
carDetails.fillCarDetailsWithRegistrationNoModificationsNo(new CarDetailsModal("ayc"));
carDetails.waitForContinueButtonInvisible();
CoverStartDate coverStartDate=new CoverStartDate(getDriver());
coverStartDate.clickCoverStartDateHeading();
coverStartDate.clicktermsAndConditions();
coverStartDate.clickgetMyQuoteButton();*/
yourQuote.clicksinglePaymentBuyNow();
yourQuote.invisibilityOfLoading();
//aboutYourCar.inputcarRegistrationSearchBox("");
//carDetails.clickFindCar();
        aboutYourCar.clickcontinueButton();
System.out.println(aboutYourCar.getenterCarRegistrationValidationMessage());
if(!(aboutYourCar.getenterCarRegistrationValidationMessage().contains("Please enter a registration"))){
    error=true;
    reason=reason+"Unable to verify Please enter a registration message";
}

        aboutYourCar.inputcarRegistrationSearchBox("1215d1");
        carDetails.clickFindCar();
      System.out.println(  aboutYourCar.getregistrationNumberNotFound());
if(!(aboutYourCar.getregistrationNumberNotFound().contains("Registration number not found"))){
    error=true;
    reason=reason+"Unable to verify Registration number not found message";
}
        System.out.println(  aboutYourCar.getregistrationNumberNotFoundcar());
if(!(aboutYourCar.getregistrationNumberNotFoundcar().contains("(2018) CITROEN 998 Manual 5 DR Petrol"))){
    error=true;
    reason=reason+"Unable to verify (2018) CITROEN 998 Manual 5 DR Petrol";
}

        aboutYourCar.inputcarRegistrationSearchBox("12d151");
        carDetails.clickFindCar();
      System.out.println( carDetails. getSearchResult());
      if(!(carDetails. getSearchResult().equals("(2012) MERCEDES BENZ E 250 AVANTGARDE BLUEEFFICIENCY CDI 2143 Automatic 4 DR DIESEL SALOON SILVER"))){
          error=true;
          reason=reason+"Unable to verify (2012) MERCEDES BENZ E 250 AVANTGARDE BLUEEFFICIENCY CDI 2143 Automatic 4 DR DIESEL SALOON SILVER message";
      }
        carDetails.clickconfirmCarRegistration();
    System.out.println( carDetails.   getcarSuccessfullyAddedMessage());
    if(!(carDetails.   getcarSuccessfullyAddedMessage().contains("Car successfully added"))){
        error=true;
        reason=reason+" Unable to verify Car successfully added message";
    }

if(!(error)){
    passStatus("Able to verify Manual car add functionality");
}else {
    failStatus(reason);
}


    }
void fillUptoYourQuoteWithManualCar(WebDriver driver) throws IOException, InterruptedException {
    CustomerScreenOne customerScreenOne = new CustomerScreenOne(driver);
    customerScreenOne.load();
    customerScreenOneModal customerScreenOneModal=new customerScreenOneModal(1);
    System.out.println(customerScreenOneModal.getEmail());
    System.out.println(customerScreenOneModal.getTitle());
    customerScreenOne.fillCustomerScreenFormAndContinue(customerScreenOneModal);
    new YourQuote(driver).invisibilityOfLoading();
    PersonalDetails personalDetails = new PersonalDetails(driver);
    personalDetails.waitforVisibiliyofAddressSearchBar();
    personalDetailsModal personalDetailsModal = new personalDetailsModal(1);
    personalDetails.fillPersonalDetailsAndContinue(personalDetailsModal);
    personalDetails.invsibilityContinueButton();
    new InsuranceDetails(driver).visibilityOfInsuranceDetails();
    InsuranceDetails insuranceDetails1=new InsuranceDetails(driver);
    insuranceDetails1.selectDrivingExperienceOption("I currently have insurance in my own name in Ireland/UK");
    insuranceDetails1.selectOwnNameInIrelandDropdown("5+");
    insuranceDetails1.clickContinueButton();
    insuranceDetails1.waitForInvisibilityOfContinueButton();
    CarDetails carDetails=new CarDetails(driver);
    carDetails.fillCarDetailsWithRegistrationNoModificationsNo(new CarDetailsModal("ayc"));
    carDetails.selectCarEstimatedValue("Less than €75000");
    carDetails.clickContinueButton();

    AdditionalDrivers additionalDrivers=new AdditionalDrivers(driver);
    additionalDrivers.clickAdditionalDriversNo();
    additionalDrivers.clickContinueButton();
    YourClaims yourClaims1=new YourClaims(driver);
    yourClaims1.clickselectOptionNoOne();
    yourClaims1.clickContinueButton();
    yourClaims1.invisibleContinueButton();
    PenaltyPoints penaltyPoints1=new PenaltyPoints(driver);
    penaltyPoints1.clickpenaltyPointsHeading();
    penaltyPoints1.clickContinueButton();
    CoverStartDate coverStartDate=new CoverStartDate(driver);
    coverStartDate.inputDate(  dateTimeFormatter.format(LocalDate.now().plusDays(5)));
    coverStartDate.inputDate(  dateTimeFormatter.format(LocalDate.now().plusDays(5)));
    coverStartDate.clickhomeInsurancePolicyNo();
    coverStartDate.clickgetCarInsurancePolicyNo();
    coverStartDate.clickreceiveSalaryNo();
    coverStartDate.clickhomeInsurancePolicyNo();
    coverStartDate.clickgetCarInsurancePolicyNo();
    coverStartDate.clickreceiveSalaryNo();
    coverStartDate.clicktermsAndConditions();
    coverStartDate.clickgetMyQuoteButton();
    new YourQuote(driver).visibilityOfyourQuoteHeading();

}
    @Test
    public void verifyPleaseSelectIfThisIsYourCarValidationInAboutYourCarPage() throws IOException, InterruptedException {
        fillUptoYourQuoteWithManualCar(getDriver());
        YourQuote yourQuote=new YourQuote(getDriver());
        AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
        CarDetails carDetails=new CarDetails(getDriver());
       /* fillUptoGetQuotePage();
        AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
        aboutYourCar.clickbackButton();
        YourQuote yourQuote=new YourQuote(getDriver());
        yourQuote.clickupdateYourInformation();
        yourQuote.clickeditvehicleDetails();
        CarDetails carDetails=new CarDetails(getDriver());
        carDetails.clickChangeCarDetails();
        carDetails.fillCarDetailsWithRegistrationNoModificationsNo(new CarDetailsModal("ayc"));
        carDetails.waitForContinueButtonInvisible();
        CoverStartDate coverStartDate=new CoverStartDate(getDriver());
        coverStartDate.clickCoverStartDateHeading();

        coverStartDate.clicktermsAndConditions();
        coverStartDate.clickgetMyQuoteButton();
*/

        yourQuote.clicksinglePaymentBuyNow();
        yourQuote.invisibilityOfLoading();
        aboutYourCar.inputcarRegistrationSearchBox("12d151");
        carDetails.clickFindCar();
        aboutYourCar.clickcommutingTrue();
        aboutYourCar.clickregisteredTrue();
        aboutYourCar.clickprivateTrue();
        aboutYourCar.clickcontinueButton();
        System.out.println(aboutYourCar.getpleaseSelectCarValidation());
        if(aboutYourCar.getpleaseSelectCarValidation().equals("Please select if this is your car")){
            passStatus("Able to verify validation message");
        }else {
            failStatus("Unable to verify validation message");
        }


    }

    @Test
    public void verifyGetQuoteInAboutYourCarPageWithAllTrueOptions() throws IOException {
        String reason=" ";
        boolean error=false;
        fillUptoGetQuotePage();
        AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
aboutYourCar.clickcommutingTrue();
aboutYourCar.clickregisteredTrue();
aboutYourCar.clickprivateTrue();
aboutYourCar.clickcontinueButton();
aboutYourCar.invisiblecontinueButton();
aboutYourCar.clickHeading();
System.out.println(aboutYourCar.iscarOwnerSelected());
if(!(aboutYourCar.iscarOwnerSelected())){
    error=true;
    reason=reason+"Unable to verify car owner selected true";
}
        System.out.println(aboutYourCar.iscarTaxSelected());
if(!(aboutYourCar.iscarTaxSelected())){
    error=true;
    reason=reason+"Unable to verify tax selected true";
}
        System.out.println(aboutYourCar.isCommutingTrue());
if(!(aboutYourCar.isCommutingTrue())){
    error=true;
    reason=reason+"Unable to verify social, domestic purpose true";
}
if(!(error)){
    passStatus("Able to verify selections");
}else {
    failStatus("Unable to verify "+reason);
}
    }
@Test
    public void verifyGetQuoteInAboutYourCarPageWithUpdateAllFalseOptions() throws IOException {
        String reason=" ";
        boolean error=false;
    fillUptoGetQuotePage();
    AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
    aboutYourCar.clickcommutingTrue();
    aboutYourCar.clickregisteredTrue();
    aboutYourCar.clickprivateTrue();
    aboutYourCar.clickcontinueButton();
    aboutYourCar.invisiblecontinueButton();
    aboutYourCar.clickHeading();
    System.out.println(aboutYourCar.iscarOwnerSelected());
    System.out.println(aboutYourCar.iscarTaxSelected());
    System.out.println(aboutYourCar.isCommutingTrue());
    aboutYourCar.clickcommutingFalse();
    aboutYourCar.clickprivateFalse();
    aboutYourCar.clickregisteredFalse();
    aboutYourCar.clickcontinueButton();
    aboutYourCar.invisiblecontinueButton();
    aboutYourCar.clickHeading();
    System.out.println(aboutYourCar.iscarOwnerNotSelected());
    if(!(aboutYourCar.iscarOwnerNotSelected())){
        error=true;
        reason=reason+"Unable to verify car owner selected false";
    }
    System.out.println(aboutYourCar.iscarTaxNotSelected());
    if(!(aboutYourCar.iscarTaxNotSelected())){
        error=true;
        reason=reason+"Unable to verify tax selected false";
    }
    System.out.println(aboutYourCar.isCommutingNotTrue());
   if(!(aboutYourCar.isCommutingNotTrue())){
       error=true;
       reason=reason+"Unable to verify social, domestic purpose false";
   }
    if(!(error)){
        passStatus("Able to verify selections");
    }else {
        failStatus("Unable to verify "+reason);
    }
}

@Test
    public void verifyRegisteredTooltipInAboutYourCarPage() throws IOException {
    fillUptoGetQuotePage();
    AboutYourCar aboutYourCar=new AboutYourCar(getDriver());
    aboutYourCar.clickregisteredTooltip();
    System.out.println(aboutYourCar.getmodalDescription());
    if(aboutYourCar.getmodalDescription().equals("Your partner or husband or wife, living at the same address as you and sharing financial responsibilities with you. This does not include any business partner or associate.")){
        passStatus("Able to verify modal description");
    }else {
        failStatus("Unable to verify modal description");
    }
}


}
