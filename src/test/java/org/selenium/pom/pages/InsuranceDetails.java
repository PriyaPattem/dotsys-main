package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.personalDetailsModal;

import java.io.IOException;

public class InsuranceDetails extends BasePage {
    public InsuranceDetails(WebDriver driver) {
        super(driver);
    }
    By insurancedetails=By.id("accHeading3");
    By pleaseSelectYourDrivingLicence=By.id("RF__DrivingExperience");
    By continueButton=By.id("ctl00_MainContent_Continue3");
    By drivingExperienceDropdown=By.id("ctl00_MainContent_ddlDrivingExperience");
By selectNoClaimsDiscountValidationMessage1=By.id("RF__YearsNCB");
By selectNoClaimsDiscountValidationMessage=By.id("RF__YearsNamed");
By noOfClaimsDropdown1=By.id("ctl00_MainContent_ddlYearsNCB");
By noOfClaimsDropdown=By.id("ctl00_MainContent_ddlYearsNamed");
By insuranceDetailDiv=By.id("div3");
public void clickinsuranceDetailDiv(){
    performClick(insuranceDetailDiv);
}
public void selectNoOfClaimsDropdown(String option){
    scrollAndselectOptionsByVisibleText(noOfClaimsDropdown,option);
}
    public void selectNoOfClaimsDropdown1(String option){
        selectOptionsByVisibleText(noOfClaimsDropdown1,option);
    }
public void selectOwnNameInIrelandDropdown(String option){
    selectOptionsByVisibleText(By.id("ctl00_MainContent_ddlYearsNCB"),option);
}
public void waitForVisibilityOfnoOfClaimsDropdown(){
    waitForvisibility(noOfClaimsDropdown);
}
    public void waitForVisibilityOfnoOfClaimsDropdown1(){
        waitForvisibility(noOfClaimsDropdown1);
    }


public String getselectNoClaimsDiscountValidationMessage(){
    return getText(selectNoClaimsDiscountValidationMessage);
}
    public String getselectNoClaimsDiscountValidationMessage1(){
        return getText(selectNoClaimsDiscountValidationMessage1);
    }

    public void selectDrivingExperienceOption(String option){
        scrollAndselectOptionsByVisibleText(drivingExperienceDropdown,option);
        invisibleLoading();
    }



    public void clickContinueButton(){
        scrollAndPerformClick(continueButton);
        invisibleLoading();
    }
    public void visibilityContinueButton(){
    scrollAndWaitForVisibility(continueButton);
    }

    public void waitForInvisibilityOfContinueButton(){
   mediumwait.until(ExpectedConditions.invisibilityOf(driver.findElement(continueButton)));
    }
    public String getpleaseSelectYourDrivingLicenceValidationMessage(){
        return getText(pleaseSelectYourDrivingLicence);
    }

    public void visibilityOfInsuranceDetails(){
        waitForvisibility(insurancedetails);
    }

    public void clickInsuranceDetailsHeading(){
    performClick(By.id("div3"));
    }
JavascriptExecutor js=(JavascriptExecutor) driver;
    public String getExperienceValueJS(){
        return    js.executeScript("return document.getElementById(\"ctl00_MainContent_ddlDrivingExperience\").options[document.getElementById(\"ctl00_MainContent_ddlDrivingExperience\").selectedIndex].text").toString();
    }
    public String getConsecutiveYearsJS(){
        return    js.executeScript("return document.getElementById(\"ctl00_MainContent_ddlYearsNamed\").options[document.getElementById(\"ctl00_MainContent_ddlYearsNamed\").selectedIndex].text").toString();
    }
By latestExperienceTooltip=By.cssSelector("[aria-labelledby=\"DrivingExperienceTooltip\"]");
    public void clicklatestExperienceTooltip(){
        scrollAndPerformClick(latestExperienceTooltip);
    }

    public String getDrivingExperienceModalMessage(){
        return getText(By.cssSelector("[data-origin=\"#DrivingExperienceTooltip\"] p"));
    }
    public String getDrivingExperienceModalAttribute(){
        return driver.findElement(By.cssSelector("[data-origin=\"#DrivingExperienceTooltip\"] p a")).getAttribute("href");
    }
    By consecutiveYearsTooltip=By.cssSelector("[aria-labelledby=\"NCDTooltip\"]");

    public void clickconsecutiveYearsTooltipButton(){
        scrollAndPerformClick(consecutiveYearsTooltip);
    }
By ConsecutiveYearsModalText=By.cssSelector("[id=\"modalDescription\"] p");

public String getConsecutiveYearsModalText(){
    return getText(ConsecutiveYearsModalText);

}
By privateCarPolicyTooltip=By.cssSelector("[aria-labelledby=\"YearsNamedTooltip\"]");
    public void clickprivateCarPolicyTooltip(){
        scrollAndPerformClick(privateCarPolicyTooltip);
    }

    public void fillScreenOneAndTwodata(WebDriver driver) throws IOException {
        new PersonalDetails(driver).fillScreenOnedata(driver);
        PersonalDetails personalDetails = new PersonalDetails(driver);
        personalDetails.waitforVisibiliyofAddressSearchBar();
        personalDetailsModal personalDetailsModal = new personalDetailsModal(1);
        personalDetails.fillPersonalDetailsAndContinue(personalDetailsModal);
        personalDetails.invsibilityContinueButton();
        new InsuranceDetails(driver).visibilityOfInsuranceDetails();

    }
}
