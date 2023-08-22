package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

import java.io.IOException;
import java.util.List;

public class CoverStartDate extends BasePage {
    public CoverStartDate(WebDriver driver) {
        super(driver);
    }
    By CoverStartDateHeading= By.id("div8");
    public void visibilityCoverStartDateHeading(){
       scrollAndWaitForVisibility(CoverStartDateHeading);
    }
    public void clickCoverStartDateHeading(){
        scrollAndPerformClick(CoverStartDateHeading);
        System.out.println("cover start heading clicked");
    }
    By inputDate=By.id("ctl00_MainContent_StartDate");
    public void inputDate(String date){
        scrollAndSendKeys(inputDate,date);
    }
    By inputDateVaidationMessage=By.id("ctl00_MainContent_RF__StartDate");
    public String getinputDateVaidationMessage(){
        return  getText(inputDateVaidationMessage);
    }
    By homeInsurancePolicyYes=By.xpath("//input[@id=\"IsHome-yes\"]/parent::label");
    public void clickhomeInsurancePolicyYes(){
        scrollAndPerformClick(homeInsurancePolicyYes);
    }
    By homeInsurancePolicyNo=By.xpath("//input[@id=\"IsHome-no\"]/parent::label");
    public void clickhomeInsurancePolicyNo(){
        scrollAndPerformClick(homeInsurancePolicyNo);
    }
    By carInsurancePolicyYes=By.xpath("//input[@id=\"IsHouseholdCar-yes\"]/parent::label");
    public void clickcarInsurancePolicyYes(){
        scrollAndPerformClick(carInsurancePolicyYes);
    }
    By getCarInsurancePolicyNo=By.xpath("//input[@id=\"IsHouseholdCar-no\"]/parent::label");
    public void clickgetCarInsurancePolicyNo(){
        scrollAndPerformClick(getCarInsurancePolicyNo);
    }
    By receiveSalaryYes=By.xpath("//input[@id=\"RecieveOffers-yes\"]/parent::label");
    public void clickreceiveSalaryYes(){
        scrollAndPerformClick(receiveSalaryYes);
    }
    By receiveSalaryNo=By.xpath("//input[@id=\"RecieveOffers-no\"]/parent::label");
    public void  clickreceiveSalaryNo(){
        scrollAndPerformClick(receiveSalaryNo);
    }
    By termsAndConditions=By.cssSelector("[data-dd-loc=\"TermsAndConditions\"]");
    public void clicktermsAndConditions(){
        scrollAndPerformClick(termsAndConditions);
        System.out.println("clicked terms and conditions");
        invisibleLoading();
    }
    By getMyQuoteButton=By.id("ctl00_MainContent_Continue8");
    public CoverStartDate clickgetMyQuoteButton(){
        scrollAndPerformClick(getMyQuoteButton);
        invisibleLoading();
        System.out.println("get my quote clicked");
        return this;
    }
    public void visibilitygetMyQuoteButton(){
        scrollAndWaitForVisibility(getMyQuoteButton);
    }

    public void waitForInvisibilityForGetQuoteButton(){
        scrollAndwaitForInvisibility(getMyQuoteButton);
    }
public void fillAllDetailsYesWithCurrentDate(String date){
        clickcarInsurancePolicyYes();
        clickhomeInsurancePolicyYes();
        clickreceiveSalaryYes();
        inputDate(date);
    clickcarInsurancePolicyYes();
    clickhomeInsurancePolicyYes();
    clickreceiveSalaryYes();
    inputDate(date);

}
By homeInsuranceValidationMessage=By.id("CV__IsHome");
    public String gethomeInsuranceValidationMessage(){
        return scrollAndGetText(homeInsuranceValidationMessage);
    }
    By carInsuranceValidationMessage=By.id("CV__IsHouseHoldCar");
    public String getcarInsuranceValidationMessage(){
        return scrollAndGetText(carInsuranceValidationMessage);
    }
    By receiveOffersValidationMessage=By.id("CV__RecieveOffers");
    public String getreceiveOffersValidationMessage(){
        return scrollAndGetText(receiveOffersValidationMessage);
    }
By termsAndConditionsValidationMessage=By.id("CV__TermsConditionsBox");
    public String gettermsAndConditionsValidationMessage(){
        return scrollAndGetText(termsAndConditionsValidationMessage);
    }
By startDateEndDateValidationMessage=By.id("ctl00_MainContent_CV__StartDate");
    public String getstartDateEndDateValidationMessage(){
        try {
            return scrollAndGetText(startDateEndDateValidationMessage);
        }catch (Exception e){
            return scrollAndGetText(startDateEndDateValidationMessage);
        }

    }
    By insurancePolicyModal=By.cssSelector("[aria-labelledby=\"HomeTooltip\"]");
    public void clickinsurancePolicyModal(){
        scrollAndPerformClick(insurancePolicyModal);
    }
    By carInsurancePolicyModal=By.cssSelector("[aria-labelledby=\"HouseholdCar\"]");
    public void clickcarInsurancePolicyModal(){
        scrollAndPerformClick(carInsurancePolicyModal);
    }
    By ModalText=By.cssSelector("[id=\"modalDescription\"] p");

    public String getModalText(){
        return getText(ModalText);

    }
    By termsAndConditionsLinks=By.cssSelector("[id=\"ctl00_MainContent_divTerms\"] p a");
    public List<WebElement> gettermsAndConditionsLinks(){
        shortwait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(termsAndConditionsLinks)));
        return driver.findElements(termsAndConditionsLinks);
    }

    public void fillScreenUpToYourPenaltyPoints(WebDriver driver) throws IOException {
        new PenaltyPoints(driver).fillScreenUpToYourClaims(driver);
        PenaltyPoints penaltyPoints=new PenaltyPoints(driver);
        penaltyPoints.clickYesOrNobutton("2");
        penaltyPoints.clickYesOrNobutton("4");
        penaltyPoints.clickContinueButton();
        penaltyPoints.invisibleClickButton();
    }
}
