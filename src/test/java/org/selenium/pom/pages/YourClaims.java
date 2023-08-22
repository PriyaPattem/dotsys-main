package org.selenium.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.AdditionalDriversModal;

import java.io.IOException;

public class YourClaims extends BasePage {
    public YourClaims(WebDriver driver) {
        super(driver);
    }
    By pleaseSelectAnOption=By.id("ctl00_MainContent_DriverHistoryRepeater_ctl00_RF__IsClaims");
    By pleaseSelectAnOptionOne=By.id("ctl00_MainContent_DriverHistoryRepeater_ctl01_RF__IsClaims");
    By clickContinue=By.id("ctl00_MainContent_Continue6");
    By selectOptionOne=By.xpath("(//span[text()=\"Yes\"])[3]");
    public void clickselectOptionOne(){
        try {
            scrollAndPerformClick(selectOptionOne);
            invisibleLoading();
        }catch (ElementClickInterceptedException e){
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(selectOptionOne));
       invisibleLoading();
        }

    }

    By selectOptionTwo=By.xpath("(//span[text()=\"Yes\"])[4]");
    public void clickselectOptionTwo(){
        scrollAndPerformClick(selectOptionTwo);
        invisibleLoading();
    }
    By selectOptionNoOne=By.xpath("(//span[text()=\"No\"]/parent::span)[3]");
    public void clickselectOptionNoOne(){
        scrollAndPerformClick(selectOptionNoOne);
        invisibleLoading();
    }
    By selectOptionNoTwo=By.xpath("(//span[text()=\"No\"]/parent::span)[4]");
    public void clickselectOptionNoTwo(){
        try {
            scrollAndPerformClick(selectOptionNoTwo);
            invisibleLoading();
        }catch (Exception e){
            try {
                Thread.sleep(10000);
            }catch (Exception f){

            }
            //shortwait.until(ExpectedConditions.stalenessOf(driver.findElement(selectOptionNoTwo)));
            scrollAndPerformClick(selectOptionNoTwo);
            invisibleLoading();
        }

    }
    By addClaimOne=By.id("ctl00_MainContent_DriverHistoryRepeater_ctl00_AddDriverClaimButton");
    public void clickaddClaimOne(){
        scrollAndPerformClick(addClaimOne);
        invisibleLoading();
    }
    public void visibilityOfClaimOneButton(){
        waitForvisibility(addClaimOne);
    }
    By addClaimTwo=By.id("ctl00_MainContent_DriverHistoryRepeater_ctl01_AddDriverClaimButton");
    public void clickaddClaimTwo(){
        scrollAndPerformClick(addClaimTwo);
        invisibleLoading();
    }
    public void visibilityOfClaimtwo(){
        waitForvisibility(addClaimTwo);
    }
    By saveClaim=By.id("SaveClaim");
    public void clicksaveClaim(){
        scrollAndPerformClick(saveClaim);
        invisibleLoading();
    }
    public void visibilityOfSaveClaim(){
       // waitForInvisibility(saveClaim);
        waitForvisibility(saveClaim);
    }
    By claimCancel=By.id("ctl00_MainContent_btnCancelClaim");
    public void clickclaimCancel(){
        try {
            scrollAndPerformClick(claimCancel);
            invisibleLoading();
        }catch (ElementClickInterceptedException e){
            try {
                Thread.sleep(5000);
            }catch (Exception f){

            }
            scrollAndPerformClick(claimCancel);
            invisibleLoading();
        }

    }
    By claimDateValidation=By.id("RF__ClaimDate");
    public String getclaimDateValidation(){
        return getText(claimDateValidation);
    }
    By incidentTypeValidation=By.id("ctl00_MainContent_RF__IncidentType");
    public String getincidentTypeValidation(){
        return getText(incidentTypeValidation);
    }

    By claimFullySelectedValidation=By.id("ctl00_MainContent_RF__IncidentType");
    public String getclaimFullySelectedValidation(){
        return getText(claimFullySelectedValidation);
    }




    public void clickContinueButton(){

        try {
            scrollAndPerformClick(clickContinue);
            invisibleLoading();
        }catch (Exception e){
            scrollAndPerformClick(clickContinue);
            invisibleLoading();
        }


    }
    public void invisibleContinueButton(){
        waitForInvisibility(clickContinue);
    }
    public String getpleaseSelectAnOptionOne(){
        return  getText(pleaseSelectAnOptionOne);
    }
    public String getpleaseSelectAnOption(){
        return getText(pleaseSelectAnOption);
    }
    By claimOneValidation=By.id("ctl00_MainContent_DriverHistoryRepeater_ctl00_ClaimEmpty");

    public String getClaimOneValidationMessage(){
       // scrollIntoView(claimOneValidation);
        return getText(claimOneValidation);
    }
    By claimTwoValidation=By.id("ctl00_MainContent_DriverHistoryRepeater_ctl01_ClaimEmpty");
    public String getclaimTwoValidationMessage(){
        return getText(claimTwoValidation);
    }
    By claimSettledValidation=By.id("ctl00_MainContent_RF__IsClaimSettled");
    public String getclaimSettledValidation(){
        return getText(claimSettledValidation);
    }
    By inputDate=By.id("ctl00_MainContent_ClaimDate");
    public void inputDob(String option){
        try {
            scrollAndSendKeys(inputDate,option);
        }catch (StaleElementReferenceException e){
            try {
                Thread.sleep(5000);
            }catch (Exception f){

            }
            scrollAndSendKeys(inputDate,option);
        }

    }
    By selectIncidentType=By.id("ctl00_MainContent_DDl_IncidentType");
    public void selectIncidentType(String option){
        try {
            selectOptionsByVisibleText(selectIncidentType,option);
            invisibleLoading();
        }catch (Exception e){
            try {
                Thread.sleep(5000);
            }catch (Exception f){

            }
            selectOptionsByVisibleText(selectIncidentType,option);
            invisibleLoading();
        }

    }
    By claimSelectedYes=By.xpath("//input[@id=\"IsClaimSettled-yes\"]/parent::label");
    public void clickclaimSelectedYes(){
        scrollAndPerformClick(claimSelectedYes);
    }
    By claimSelectedNo=By.xpath("//input[@id=\"IsClaimSettled-no\"]/parent::label");
    public void clickclaimSelectedNo(){
        scrollAndPerformClick(claimSelectedNo);
    }
    By datefuturepastMessage=By.id("ctl00_MainContent_CV__ClaimDate");
    public String getdatefuturepastMessage(){
        try {
            return getText(datefuturepastMessage);
        }catch (StaleElementReferenceException e){
            try {
                Thread.sleep(5000);
            }catch (Exception f){

            }
            return getText(datefuturepastMessage);
        }

    }
By accidentFaultErrorMessage=By.id("ctl00_MainContent_RF__IsFault");

    public String getaccidentFaultErrorMessage(){
        return getText(accidentFaultErrorMessage);
    }
    By accidentPersonalInjuryErrorMessage=By.id("ctl00_MainContent_RF__IsPersonalInjury");
    public String getaccidentPersonalInjuryErrorMessage(){
        return getText(accidentPersonalInjuryErrorMessage);
    }
    By settlementCostErrorMessage=By.id("ctl00_MainContent_RF__SettlementCost");
    public String getsettlementCostErrorMessage(){
        return getText(settlementCostErrorMessage);
    }
By faultButtonYes=By.xpath("//input[@id=\"IsFault-yes\"]/parent::label");
    public void clickfaultButtonYes(){
        scrollAndPerformClick(faultButtonYes);
    }
By faultButtonno=By.xpath("//input[@id=\"IsFault-no\"]/parent::label");
    public void clickfaultButtonno(){
        scrollAndPerformClick(faultButtonno);
    }

By personalInjuryClaimYes=By.xpath("//input[@id=\"IsPersonalInjury-yes\"]/parent::label");
    public void clickpersonalInjuryClaimYes(){
        scrollAndPerformClick(personalInjuryClaimYes);
    }
By personalInjuryClaimNo=By.xpath("//input[@id=\"IsPersonalInjury-no\"]/parent::label");
    public void  clickpersonalInjuryClaimNo(){
        scrollAndPerformClick(personalInjuryClaimNo);
    }




public String claimSelectedornotAttribute(){
    By claimSelectedornot= By.id("IsClaimSettled-True");
    shortwait.until(ExpectedConditions.presenceOfElementLocated(claimSelectedornot));
    return driver.findElement(claimSelectedornot).getAttribute("class");
}

    public String faultSelectedornotAttribute(){
        By faultSelectedornot= By.id("IsFault-False");
        shortwait.until(ExpectedConditions.presenceOfElementLocated(faultSelectedornot));
        return driver.findElement(faultSelectedornot).getAttribute("class");
    }

    public String personalInjurySelectedornotAttribute(){
        By personalInjuryfaultSelectedornot= By.id("IsPersonalInjury-True");
        shortwait.until(ExpectedConditions.presenceOfElementLocated(personalInjuryfaultSelectedornot));
        return driver.findElement(personalInjuryfaultSelectedornot).getAttribute("class");
    }
    By inputsettlementCost=By.id("ctl00_MainContent_SettlementCost");
    public void inputSettlementCost(String data){
        scrollAndSendKeys(inputsettlementCost,data);
    }

By invalidsettlementCostErrorMessage=By.id("ctl00_MainContent_RE__SettlementCost");
    public String getinvalidsettlementCostErrorMessage(){
        return  getText(invalidsettlementCostErrorMessage);
    }
    By claimOneEdit=By.id("ctl00_MainContent_DriverHistoryRepeater_ctl00_DriverClaimsRepeater_ctl00_EditClaim");
    public void clickclaimOneEditButton(){
        scrollAndPerformClick(claimOneEdit);
        invisibleLoading();
    }
    By claimTwoEdit=By.id("ctl00_MainContent_DriverHistoryRepeater_ctl01_DriverClaimsRepeater_ctl00_EditClaim");
    public void clickclaimTwoEditButton(){
        scrollAndPerformClick(claimTwoEdit);
        invisibleLoading();
    }
    public void presenceOfTextElement(String text){
        shortwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='"+text+"']")));
    }
    public String getIncidentDateJS(){
       return JSGetText("ctl00_MainContent_ClaimDate",driver);
    }
    public String getIncidentTypeJS(){
        return JSDropDownValue("ctl00_MainContent_DDl_IncidentType",driver);
    }
    public String getClaimAmountJS(){
        return JSGetText("ctl00_MainContent_SettlementCost",driver);
    }
    public void fillclaimData(String incidentType,String date,String amount){
try {
    clickselectOptionTwo();
}catch (ElementClickInterceptedException e){
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click()", driver.findElement(selectOptionTwo));
}

        clickaddClaimTwo();
        inputDob(date);
        selectIncidentType(incidentType);
        clickclaimSelectedYes();
        inputSettlementCost(amount);
        clicksaveClaim();
        presenceOfTextElement(incidentType);
        presenceOfTextElement(date);
        clickclaimTwoEditButton();
        visibilityOfSaveClaim();
    }
    By deleteClaimButton=By.xpath("//a[text()=\"Delete\"]");
    By removeClaimButton=By.xpath("//a[normalize-space(text())=\"Remove claim\"]");
    public void clickDeleteClaimButton(){
        scrollAndPerformClick(deleteClaimButton);
performClick(removeClaimButton);
visibilityOfClaimOneButton();
    }
    public int getDeleteClaimButtonSize(){
        return driver.findElements(deleteClaimButton).size();
    }

    By addAnotherClaim=By.id("ctl00_MainContent_DriverHistoryRepeater_ctl00_AddDriverClaimButton");
    public void clickaddAnotherClaim(){
        scrollAndPerformClick(addAnotherClaim);
    }
    public void visibleaddanotherclaim(){
        try {
            waitForvisibility(addAnotherClaim);
        }catch (StaleElementReferenceException e){
            try {
                Thread.sleep(5000);
            }catch (Exception f){

            }
            waitForvisibility(addAnotherClaim);
        }

    }
  public void  fillClaimAndContinue(String validdate,String incidentType,String amount){
      clickselectOptionOne();
      clickaddClaimOne();
      inputDob(validdate);
      selectIncidentType(incidentType);
      clickclaimSelectedYes();
      clickfaultButtonYes();
      clickpersonalInjuryClaimYes();
      inputSettlementCost(amount);
      clicksaveClaim();
      visibleaddanotherclaim();
      //clickselectOptionNoTwo();

      clickselectOptionTwo();
      clickaddClaimTwo();
      inputDob(validdate);
      String incidentType1="Windscreen";
      selectIncidentType(incidentType1);
      clickclaimSelectedYes();

      clicksaveClaim();
      presenceOfTextElement(incidentType1);
      presenceOfTextElement(validdate);
      clickContinueButton();
     invisibleContinueButton();

    }
    By claimSettledToolTip=By.cssSelector("[aria-labelledby=\"ClaimSettledTooltip\"]");
    public void clickclaimSettledToolTip(){
        scrollAndPerformClick(claimSettledToolTip);
    }
    By faultToolTip=By.cssSelector("[aria-labelledby=\"IsFaultTooltip\"]");
    public void  clickfaultToolTip(){
        scrollAndPerformClick(faultToolTip);
    }
    By personalClaimTooltip=By.cssSelector("[aria-labelledby=\"PersonalInjuryTooltip\"]");
    public void  clickpersonalClaimTooltip(){
        scrollAndPerformClick(personalClaimTooltip);
    }
    By claimSettledTooltip=By.cssSelector("[aria-labelledby=\"SettlementCostTooltip\"]");
    public void clickclaimSettledTooltip(){
        scrollAndPerformClick(claimSettledTooltip);
    }
    By ModalText=By.cssSelector("[id=\"modalDescription\"] p");

    public String getModalText(){
        return getText(ModalText);

    }

    By yourClaimsHeading=By.id("div6");

public void clickyourClaimsHeading(){
    scrollAndPerformClick(yourClaimsHeading);
}

    public void fillScreenUpToAdditionalDrivers(WebDriver driver) throws IOException {
    new AdditionalDrivers(driver).fillScreenUpToCarDetails(driver);
        AdditionalDrivers additionalDrivers=new AdditionalDrivers(driver);
        additionalDrivers.clickadditionalDriversYes();
        AdditionalDriversModal additionalDriversModal=new AdditionalDriversModal(3);
        additionalDrivers.fillAdditionalDriver(additionalDriversModal);
        additionalDrivers.clickAdditionalDriversNo();
        additionalDrivers.clickContinueButton();
        additionalDrivers.waitForInvisibilityForClickButton();

    }

}
