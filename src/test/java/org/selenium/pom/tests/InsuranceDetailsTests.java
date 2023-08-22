package org.selenium.pom.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProvider.InsuranceDetailsDataProvider;
import org.selenium.pom.objects.customerScreenOneModal;
import org.selenium.pom.objects.personalDetailsModal;
import org.selenium.pom.pages.CarDetails;
import org.selenium.pom.pages.CustomerScreenOne;
import org.selenium.pom.pages.InsuranceDetails;
import org.selenium.pom.pages.PersonalDetails;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.selenium.pom.constants.BrowserStackConstants.FAILED;
import static org.selenium.pom.constants.BrowserStackConstants.PASSED;
import static org.selenium.pom.constants.DotSysConstants.DRIVINGEXPERIENCEMODAL;

public class InsuranceDetailsTests extends BaseTest {
    static final String INSURANCEINIRELAND = "I currently have insurance in my own name in Ireland/UK";
    static final String NAMEDDRIVERINIRELAND = "I have been a named driver in Ireland";
    static final String NOPREVIOUSEXPERIENCE = "No previous experience";

   /* public void fillScreenOneAndTwodata() throws IOException {
        CustomerScreenOne customerScreenOne = new CustomerScreenOne(getDriver());
        customerScreenOne.load();
        customerScreenOneModal customerScreenOneModal = new customerScreenOneModal(1);
        System.out.println(customerScreenOneModal.getEmail());
        System.out.println(customerScreenOneModal.getTitle());
        customerScreenOne.fillCustomerScreenFormAndContinue(customerScreenOneModal);
        //
        PersonalDetails personalDetails = new PersonalDetails(getDriver());
        personalDetails.waitforVisibiliyofAddressSearchBar();
        personalDetailsModal personalDetailsModal = new personalDetailsModal(1);
        personalDetails.fillPersonalDetailsAndContinue(personalDetailsModal);
        personalDetails.invsibilityContinueButton();
        new InsuranceDetails(getDriver()).visibilityOfInsuranceDetails();
    }*/
    public void fillScreenOneAndTwodata() throws IOException {
        new InsuranceDetails(getDriver()).fillScreenOneAndTwodata(getDriver());

    }

    @Test
    public void verifyThePleaseSelectYourDrivingLicenseValidationInInsuranceDetails() throws IOException {
        fillScreenOneAndTwodata();
        InsuranceDetails insuranceDetails = new InsuranceDetails(getDriver());
        insuranceDetails.clickContinueButton();
        System.out.println(insuranceDetails.getpleaseSelectYourDrivingLicenceValidationMessage());
        if (insuranceDetails.getpleaseSelectYourDrivingLicenceValidationMessage().equals("Please select your driving experience")) {
            setTestStatus(PASSED, true, "Able to verify validation message");
        } else {
            setTestStatus(FAILED, false, "Unable to verify validation message");
        }
    }


    @Test
    public void verifyThePleaseselectyournoclaimsdiscountValidationMessageInInsuranceDetails() throws IOException {
        fillScreenOneAndTwodata();
        InsuranceDetails insuranceDetails = new InsuranceDetails(getDriver());
        insuranceDetails.selectDrivingExperienceOption(INSURANCEINIRELAND);
        insuranceDetails.waitForVisibilityOfnoOfClaimsDropdown1();


        insuranceDetails.clickContinueButton();
        System.out.println(insuranceDetails.getselectNoClaimsDiscountValidationMessage1());
        if (insuranceDetails.getselectNoClaimsDiscountValidationMessage1().equals("Please select your no claims discount")) {
            setTestStatus(PASSED, true, "Able to verify validation message");
        } else {
            setTestStatus(FAILED, false, "Unable to verify Please select your no claims discount message ");
        }
    }

    @Test
    public void verifyThePleaseselectyournoclaimsdiscountValidationMessageWithNamedDriverInInsuranceDetails() throws IOException {
        fillScreenOneAndTwodata();
        InsuranceDetails insuranceDetails = new InsuranceDetails(getDriver());
        insuranceDetails.selectDrivingExperienceOption(NAMEDDRIVERINIRELAND);
        insuranceDetails.waitForVisibilityOfnoOfClaimsDropdown();


        insuranceDetails.clickContinueButton();
        System.out.println(insuranceDetails.getselectNoClaimsDiscountValidationMessage());
        if (insuranceDetails.getselectNoClaimsDiscountValidationMessage().equals("Please select your claim free years")) {
            setTestStatus(PASSED, true, "Able to verify validation message");
        } else {
            setTestStatus(FAILED, false, "Unable to verify Please select your claim free years message ");
        }
    }

    void fillInsuranceDetailsWithInsuranceAndNamedDriverInIrelandInInsurancedetails(String option, String years) {
        InsuranceDetails insuranceDetails = new InsuranceDetails(getDriver());


        insuranceDetails.selectDrivingExperienceOption(option);
       // insuranceDetails.waitForVisibilityOfnoOfClaimsDropdown();
        insuranceDetails.selectNoOfClaimsDropdown(years);
        insuranceDetails.clickContinueButton();


    }
    void fillInsuranceDetailsWithInsuranceAndNamedDriverInIrelandInInsurancedetails1(String option, String years) {
        InsuranceDetails insuranceDetails = new InsuranceDetails(getDriver());


        insuranceDetails.selectDrivingExperienceOption(option);
        insuranceDetails.waitForVisibilityOfnoOfClaimsDropdown1();
        insuranceDetails.selectNoOfClaimsDropdown1(years);
        insuranceDetails.clickContinueButton();


    }

    @Test(dataProvider = "getInsuranceOptions", dataProviderClass = InsuranceDetailsDataProvider.class)
    public void fillInsuranceDetailsWithInsuranceAndNamedDriverInIrelandInInsuranceDetails(String option, String years) throws IOException, InterruptedException {
        fillScreenOneAndTwodata();
        fillInsuranceDetailsWithInsuranceAndNamedDriverInIrelandInInsurancedetails1(option, years);
        try {
            new CarDetails(getDriver()).waitForVisibilityForCarDetailsHeading();
            setTestStatus(PASSED, true, "Able to submit data");
        } catch (ElementNotVisibleException e) {
            setTestStatus(FAILED, false, "Unable to submit data");

        }
    }

    void selectNoExperience() {
        InsuranceDetails insuranceDetails = new InsuranceDetails(getDriver());


        insuranceDetails.selectDrivingExperienceOption(NOPREVIOUSEXPERIENCE);
        insuranceDetails.clickContinueButton();
        insuranceDetails.waitForInvisibilityOfContinueButton();
    }

    @Test
    public void fillInsuranceDetailsWithNoPreviousExperienceInInsuranceDetails() throws IOException {
        fillScreenOneAndTwodata();
        selectNoExperience();
        System.out.println(new InsuranceDetails(getDriver()).getExperienceValueJS());
        if (new InsuranceDetails(getDriver()).getExperienceValueJS().equals("No previous experience")) {
            passStatus("Able to submit data");
        } else {
            failStatus("Unable to submit data");
        }
        try {
            new CarDetails(getDriver()).waitForVisibilityForCarDetailsHeading();
            setTestStatus(PASSED, true, "Able to submit data");
        } catch (ElementNotVisibleException e) {
            setTestStatus(FAILED, false, "Unable to submit data");

        }

    }

    @Test
    public void updateDataFromNoExperienceToExperienceInInsuranceDetails() throws InterruptedException, IOException {
        InsuranceDetails insuranceDetails = new InsuranceDetails(getDriver());
        fillScreenOneAndTwodata();
        selectNoExperience();
      //  insuranceDetails.scrollup();
        insuranceDetails.clickInsuranceDetailsHeading();
        fillInsuranceDetailsWithInsuranceAndNamedDriverInIrelandInInsurancedetails(NAMEDDRIVERINIRELAND, "3");
        System.out.println(insuranceDetails.getExperienceValueJS());

        System.out.println(insuranceDetails.getConsecutiveYearsJS());
        if (new InsuranceDetails(getDriver()).getExperienceValueJS().equals(NAMEDDRIVERINIRELAND)
                && insuranceDetails.getConsecutiveYearsJS().equals("3")) {
            passStatus("Able to submit data");
        } else {
            failStatus("Unable to submit data with insurance with ireland and consecutive years");
        }


        try {
            insuranceDetails.waitForInvisibilityOfContinueButton();
            setTestStatus(PASSED, true, "Able to able data");
        } catch (Exception e) {
            setTestStatus(FAILED, false, "Unable to update data");
        }

    }

    @Test
    public void verifyLatestDrivingExperienceModal() throws IOException, InterruptedException {
        String reason = " ";
        boolean error = false;
        InsuranceDetails insuranceDetails = new InsuranceDetails(getDriver());
        fillScreenOneAndTwodata();
        insuranceDetails.clicklatestExperienceTooltip();

//System.out.println(getDriver().findElement(By.cssSelector("[data-origin=\"#DrivingExperienceTooltip\"] p")).getText());
        if (!(insuranceDetails.getDrivingExperienceModalMessage().equals(DRIVINGEXPERIENCEMODAL))) {
            error = true;
            reason = reason + "Unable to verify modal content";
        }
        System.out.println(insuranceDetails.getDrivingExperienceModalAttribute());
        if (!(insuranceDetails.getDrivingExperienceModalAttribute().equals("https://www.aviva.ie/insurance/car-insurance/faqs/"))) {
            error = true;
            reason = reason + "Unable to verify policy url";
        }
        if (!(error)) {
            passStatus("Able to verify modal");
        } else {
            failStatus("Unable to verify modal" + reason);
        }
    }

    @Test
    public void verifyconsecutiveyearsModalInInsuranceDetails() throws IOException {

        InsuranceDetails insuranceDetails = new InsuranceDetails(getDriver());
        fillScreenOneAndTwodata();

        insuranceDetails.selectDrivingExperienceOption(INSURANCEINIRELAND);
        insuranceDetails.clickconsecutiveYearsTooltipButton();
        System.out.println(insuranceDetails.getConsecutiveYearsModalText());
        if (insuranceDetails.getConsecutiveYearsModalText().equals("This is the number of consecutive years you have claims free driving on a policy in your own name. We will require proof of your No Claims Discount, which is available from your current insurer. Your No Claims Discount cannot be used on any other policy and must have been earned in the last two years. It must be earned in Ireland or the UK on a private car policy.")) {
            passStatus("Able to verify modal message");
        } else {
            failStatus("Unable to verify consecutive years message");
        }


    }
    @Test
    public void verifyprivateCarPolicyModalInInsuranceDetails() throws IOException {

        InsuranceDetails insuranceDetails=new InsuranceDetails(getDriver());
        fillScreenOneAndTwodata();

        insuranceDetails.selectDrivingExperienceOption(NAMEDDRIVERINIRELAND);
        insuranceDetails.clickprivateCarPolicyTooltip();
      System.out.println(insuranceDetails.getConsecutiveYearsModalText());
        if(insuranceDetails.getConsecutiveYearsModalText().equals("This is the number of years you have claims free driving as a named driver on someone else's policy. A letter of proof from the insurance company must be supplied if you proceed with cover. Named driving experience must be consecutive (i.e no gaps in cover), current and earned in Ireland. It must not be used on any other policy.")){
            passStatus("Able to verify modal message");
        }else {
            failStatus("Unable to verify car policy modal message");
        }
    }

}