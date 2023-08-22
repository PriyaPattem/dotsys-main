package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YourQuote extends BasePage {


    public YourQuote(WebDriver driver) {
        super(driver);
    }
    By yourQuoteHeading=By.xpath("//h2[text()=\"Your quote\"]");
    By Singlepremium=By.cssSelector("[href=\"#SinglePaymentBreakdown\"]");
    public void clickSinglepremium(){
        scrollAndPerformClick(Singlepremium);
    }
    By multiPremium=By.cssSelector("[href=\"#MultiPaymentBreakdown\"");
    public void clickMultiPremium(){
        scrollAndPerformClick(multiPremium);
    }
By closePremiumModal=By.className("o-modal__cancel");
    public void clickclosePremiumModal(){
        scrollAndPerformClick(closePremiumModal);
    }
By thirdPartyFireAndTheft=By.xpath("//input[@id=\"QuoteType-no\"]/parent::label");
    public void clickthirdPartyFireAndTheftButton(){
        scrollAndPerformClick(thirdPartyFireAndTheft);
    }
By singlePaymentBuyNow=By.cssSelector("[id=\"ctl00_MainContent_btnBuyNow\"]");
    public void clicksinglePaymentBuyNow(){
        scrollAndPerformClick(singlePaymentBuyNow);
    }
By  multiPaymentBuyNow=By.cssSelector("[id=\"ctl00_MainContent_btnPayMonthly\"]");
    public void clickmultiPaymentBuyNow(){
        scrollAndPerformClick(multiPaymentBuyNow);
    }
    By loadingInvisible=By.className("a-loading-indicator-container");
    public void invisibilityOfLoading(){

        longwaitForInvisibility(loadingInvisible);
    }
    public void visibilityOfyourQuoteHeading(){
        waitForvisibility(yourQuoteHeading);
    }
    By calculatePremiumHeading=By.id("singleModalTitle");
    By calculateMultiPremiumHeading=By.id("multiModalTitle");
    public String getcalculateMultiPremiumHeading(){
        return getText(calculateMultiPremiumHeading);
    }
    public String getcalculatePremiumHeading(){
      return   getText(calculatePremiumHeading);
    }
    By excessAmount125=By.xpath("//input[@id=\"ExcessAmount-125\"]/parent::label");
    public void  clickexcessAmount125(){
        scrollAndPerformClick(excessAmount125);
    }
    By excessAmount600=By.xpath("//input[@id=\"ExcessAmount-600\"]/parent::label");
    public void clickexcessAmount600(){
        scrollAndPerformClick(excessAmount600);
    }

    By selectExcess=By.id("btnSelectExcess");
    public void clickselectExcessButton(){
        scrollAndPerformClick(selectExcess);
    }
    By excessIncreasedText=By.cssSelector("[id=\"ctl00_MainContent_ExcessChanged\"] h4");
    public String getexcessIncreasedText(){
        return getText(excessIncreasedText);
    }
    public int getexcessIncreasedTextSize(){
        return driver.findElements(excessIncreasedText).size();
    }

    public String getMidAccountCheckStatusByAttribute(){
        return  shortwait.until(ExpectedConditions.presenceOfElementLocated(By.id("ExcessAmount-mid"))).getAttribute("class");
    }
    public String getMinAccountCheckStatusByAttribute(){
        return  shortwait.until(ExpectedConditions.presenceOfElementLocated(By.id("ExcessAmount-min"))).getAttribute("class");
    }
    public String getMaxAccountCheckStatusByAttribute(){
        return  shortwait.until(ExpectedConditions.presenceOfElementLocated(By.id("ExcessAmount-max"))).getAttribute("class");
    }
    By addJourneyWise=By.id("ctl00_MainContent_btnAddJourneyWise");
    public void clickaddJourneyWiseButton(){
        scrollAndPerformClick(addJourneyWise);
    }
    By journeyWiseText=By.cssSelector("[id=\"ctl00_MainContent_JourneyWiseAdded\"] h4");
    public String getjourneyWiseText(){
        return scrollAndGetText(journeyWiseText);
    }
    public int getjourneyWiseTextSize(){
        return driver.findElements(journeyWiseText).size();
    }
    By removeJourneyWise=By.id("ctl00_MainContent_btnRemoveJourneyWise");
    public void clickremoveJourneyWiseButton(){
        scrollAndPerformClick(removeJourneyWise);
    }
    By stepBack=By.cssSelector("[id=\"ctl00_MainContent_OptionalStepBack\"] label");
    public void clickstepBack(){
        scrollAndPerformClick(stepBack);
    }
    By protectedClaims=By.cssSelector("[id=\"ctl00_MainContent_OptionalProtectedNCB\"] label");
    public void clickprotectedClaims(){
        scrollAndPerformClick(protectedClaims);
    }
    By protectedStepback=By.cssSelector("[id=\"ctl00_MainContent_OptionalProtectedStepBack\"] label");
    public void clickprotectedStepback(){
        scrollAndPerformClick(protectedStepback);
    }
    By addThisCover=By.id("btnAddThisCover");
    public void  clickaddThisCover(){
        scrollAndPerformClick(addThisCover);
    }
    By removeThisCover=By.id("ctl00_MainContent_btnRemoveThisCover");
    public void clickremoveThisCover(){
        scrollAndPerformClick(removeThisCover);
    }
    By nodiscountClaimsMessage=By.cssSelector("[id=\"ctl00_MainContent_ClaimsCoverAdded\"] h4");
    public String getnodiscountClaimsMessage(){
return scrollAndGetText(nodiscountClaimsMessage);
    }
    By addWindScreenCover=By.id("ctl00_MainContent_btnAddWindscreen");
    public void clickaddWindScreenCover(){
        scrollAndPerformClick(addWindScreenCover);
    }
    By windScreenCoverText=By.cssSelector("[id=\"ctl00_MainContent_WindscreenAdded\"]   h4");
    public String getwindScreenCoverText(){
        return scrollAndGetText(windScreenCoverText);
    }
    public int getwindScreenCoverTextsize(){
        return driver.findElements(windScreenCoverText).size();
    }
    By removeWindScreenCover=By.id("ctl00_MainContent_btnRemoveWindscreen");
    public void clickremoveWindScreenCover(){
        scrollAndPerformClick(removeWindScreenCover);
    }
By updateYourInformation=By.xpath("//button[text()=\"Update your information\"]");
    public void clickupdateYourInformation(){
        scrollAndPerformClick(updateYourInformation);
    }
    By editvehicleDetails=By.id("ctl00_MainContent_EditCarDetails");
    public void clickeditvehicleDetails(){
        scrollAndPerformClick(editvehicleDetails);
    }
    By editInsuranceDetails=By.id("ctl00_MainContent_EditInsuranceDetails");
    public void  clickeditInsuranceDetails(){
        scrollAndPerformClick(editInsuranceDetails);
    }
    By editPersonalDtails=By.id("ctl00_MainContent_EditPersonalDetails");
    public void clickeditPersonalDtails(){
        scrollAndPerformClick(editPersonalDtails);
    }
    By editDrivingExperience=By.id("ctl00_MainContent_EditDrivingExperience");
    public void clickeditDrivingExperience(){
        scrollAndPerformClick(editDrivingExperience);
    }
    By editAdditionalDrivers=By.id("ctl00_MainContent_EditAdditionalDriver");
    public void clickeditAdditionalDrivers(){
        scrollAndPerformClick(editAdditionalDrivers);
    }
    By vehicleDetailsTooltip=By.cssSelector("[href=\"#VehicleDetailsToolTip\"]");
    public void clickvehicleDetailsTooltip(){
        scrollAndPerformClick(vehicleDetailsTooltip);
    }
    By insuranceDetailsTooltip=By.cssSelector("[href=\"#InsuranceDetailsTooltip\"]");
    public void clickinsuranceDetailsTooltip(){
        scrollAndPerformClick(insuranceDetailsTooltip);
    }
    By personalDetailstooltip=By.cssSelector("[href=\"#PersonalDetailsTooltip\"]");
    public void clickpersonalDetailstooltip(){
        scrollAndPerformClick(personalDetailstooltip);
    }
    By drivingExperienceTooltip=By.cssSelector("[href=\"#DrivingExperienceTooltip\"]");
    public void clickdrivingExperienceTooltip(){
        scrollAndPerformClick(drivingExperienceTooltip);
    }
    By additionalDriverTooltip=By.cssSelector("[href=\"#AdditionalDriverTooltip\"]");
    public void clickadditionalDriverTooltip(){
        scrollAndPerformClick(additionalDriverTooltip);
    }
            By closeModal=By.className("o-modal__cancel");
    public void clickcloseModal() throws InterruptedException {
        scrollAndPerformClick(closeModal);
        Thread.sleep(1200);
    }
    public String getModalDescription(){
        return getText(By.cssSelector("[id=\"modalDescription\"] p"));
    }
    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public  void fillUptoCoverStartPage(WebDriver driver) throws IOException {
        new CoverStartDate(driver).fillScreenUpToYourPenaltyPoints(driver);

        InsuranceDetails insuranceDetails1=new InsuranceDetails(driver);
        insuranceDetails1.clickInsuranceDetailsHeading();
        insuranceDetails1.selectDrivingExperienceOption("I currently have insurance in my own name in Ireland/UK");
        insuranceDetails1.selectOwnNameInIrelandDropdown("5+");
        insuranceDetails1.selectDrivingExperienceOption("I currently have insurance in my own name in Ireland/UK");
        insuranceDetails1.selectOwnNameInIrelandDropdown("5+");
        insuranceDetails1.clickContinueButton();
        insuranceDetails1.waitForInvisibilityOfContinueButton();
        CarDetails carDetails1=new CarDetails(driver);
        carDetails1.clickChangeCarDetails();
        try {
            carDetails1.selectCarEstimatedValue("Less than €75000");
        }catch (Exception e){
            try {
                Thread.sleep(5000);
            }catch (Exception f){

            }
            carDetails1.selectCarEstimatedValue("Less than €75000");
        }
        carDetails1.selectCarEstimatedValue("Less than €75000");
        carDetails1.clickCarModifiedNo();
        carDetails1.clickCarModifiedNo();
        carDetails1.clickContinueButton();
        carDetails1.waitForContinueButtonInvisible();
        AdditionalDrivers additionalDrivers1=new AdditionalDrivers(driver);
        additionalDrivers1.clickContinueButton();
        additionalDrivers1.waitForInvisibilityForClickButton();
        YourClaims yourClaims1=new YourClaims(driver);
        yourClaims1.clickselectOptionNoOne();
        yourClaims1.clickselectOptionNoTwo();
       // yourClaims1.clickselectOptionNoOne();
       // yourClaims1.clickselectOptionNoTwo();
        yourClaims1.clickContinueButton();
        yourClaims1.invisibleContinueButton();
        yourClaims1.clickyourClaimsHeading();
        PenaltyPoints penaltyPoints1=new PenaltyPoints(driver);
        penaltyPoints1.clickpenaltyPointsHeading();
        penaltyPoints1.clickContinueButton();
        penaltyPoints1.invisibleClickButton();
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
}
