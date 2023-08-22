package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.AboutTheDriversModal;

import java.io.IOException;

public class AboutTheDrivers extends BasePage {
    public AboutTheDrivers(WebDriver driver) {
        super(driver);
    }

    By continueButton=By.id("ctl00_MainContent_btnContinueDrivers");
    public void clickcontinueButton(){
        scrollAndPerformClick(continueButton);
    }
    public void visibilitycontinueButton(){
        scrollAndWaitForVisibility(continueButton);
    }
    public void invisiblecontinueButton(){
        scrollAndwaitForInvisibility(continueButton);
    }
    By permanentResidentValidationMessage=By.id("ctl00_MainContent_RF_IsResident");
    public String getpermanentResidentValidationMessage(){
        return  scrollAndGetText(permanentResidentValidationMessage);
    }
    By mainDriverValidationMessage=By.id("ctl00_MainContent_RF_IsMainDriver");
    public String getmainDriverValidationMessage(){
        return scrollAndGetText(mainDriverValidationMessage);
    }
    By mainDriverOfAnotherCarValidationMessage=By.id("ctl00_MainContent_RF_IsNotOtherCar");
    public String getmainDriverOfAnotherCarValidationMessage(){
        return  scrollAndGetText(mainDriverOfAnotherCarValidationMessage);
    }
    By insuredOnOtherCarValidationMessage=By.id("ctl00_MainContent_RF_IsNotOtherInsurance");
    public String getinsuredOnOtherCarValidationMessage(){
        return scrollAndGetText(insuredOnOtherCarValidationMessage);
    }
    By driversHaveConvictionsValidationMessage=By.id("ctl00_MainContent_RF_IsNoConvictions");
    public String getdriversHaveConvictionsValidationMessage(){
        return  scrollAndGetText(driversHaveConvictionsValidationMessage);
    }
    By driversHaveDisqualificationsValidationMessage=By.id("ctl00_MainContent_RF_IsNoDisqualifications");
    public String getdriversHaveDisqualificationsValidationMessage(){
        return scrollAndGetText(driversHaveDisqualificationsValidationMessage);
    }
    By driversHaveRefusedInsuranceValidationMessage=By.id("ctl00_MainContent_RF_IsNoRefusal");
    public String getdriversHaveRefusedInsuranceValidationMessage(){
        return scrollAndGetText(driversHaveRefusedInsuranceValidationMessage);
    }
    By driversHaveIncreasedExcessValidationMessage=By.id("ctl00_MainContent_RF_IsNoIncrease");
    public String getdriversHaveIncreasedExcessValidationMessage(){
        return scrollAndGetText(driversHaveIncreasedExcessValidationMessage);
    }
    By driversHaveMedicalInsuranceValidationMessage=By.id("ctl00_MainContent_RF_IsNoMedical");
    public String getdriversHaveMedicalInsuranceValidationMessage(){
        return scrollAndGetText(driversHaveMedicalInsuranceValidationMessage);
    }
    By permanentResidentYes=By.xpath("//input[@id=\"IsResident-yes\"]/parent::label");
    By permanentResidentNo=By.xpath("//input[@id=\"IsResident-no\"]/parent::label");
    By mainDriverYes=By.xpath("//input[@id=\"IsMainDriver-yes\"]/parent::label");
    By mainDriverNo=By.xpath("//input[@id=\"IsMainDriver-no\"]/parent::label");
By mainDriverOfAnotherCarYes=By.xpath("//input[@id=\"IsNotOtherCar-yes\"]/parent::label");


    By mainDriverOfAnotherCarNo=By.xpath("//input[@id=\"IsNotOtherCar-no\"]/parent::label");
    By insuranceInOwnNameYes=By.xpath("//input[@id=\"IsNotOtherInsurance-yes\"]/parent::label");
    By insuranceInOwnNameNo=By.xpath("//input[@id=\"IsNotOtherInsurance-no\"]/parent::label");
    By driverConvictionsYes=By.xpath("//input[@id=\"IsNoConvictions-yes\"]/parent::label");
    By driverConvictionsNo=By.xpath("//input[@id=\"IsNoConvictions-no\"]/parent::label");
    By driverDisqualificationsYes=By.xpath("//input[@id=\"IsNoDisqualifications-yes\"]/parent::label");
    By driverDisqualificationsNo=By.xpath("//input[@id=\"IsNoDisqualifications-no\"]/parent::label");
    By refusedInsuranceYes=By.xpath("//input[@id=\"IsNoRefusal-yes\"]/parent::label");
    By refusedInsuranceNo=By.xpath("//input[@id=\"IsNoRefusal-no\"]/parent::label");
    By increasedExcessYes=By.xpath("//input[@id=\"IsNoIncrease-yes\"]/parent::label");
    By increasedExcessNo=By.xpath("//input[@id=\"IsNoIncrease-no\"]/parent::label");
    By medicalConditionYes=By.xpath("//input[@id=\"IsNoMedical-yes\"]/parent::label");
    By medicalConditionNo=By.xpath("//input[@id=\"IsNoMedical-no\"]/parent::label");
public void selectAllOptionsFalse(){
    scrollAndPerformClick(permanentResidentNo);
    scrollAndPerformClick(mainDriverNo);
    scrollAndPerformClick(mainDriverOfAnotherCarNo);
    scrollAndPerformClick(insuranceInOwnNameNo);
    scrollAndPerformClick(driverConvictionsNo);
    scrollAndPerformClick(driverDisqualificationsNo);
    scrollAndPerformClick(refusedInsuranceNo);
    scrollAndPerformClick(increasedExcessNo);
    scrollAndPerformClick(medicalConditionNo);
}
public void clickmedicalConditionNo(){
    scrollAndPerformClick(medicalConditionNo);
}
public void clickDriverConvictionsNo(){
    scrollAndPerformClick(driverConvictionsNo);
}
public void clickdriverDisqualificationsNo(){
    scrollAndPerformClick(driverDisqualificationsNo);
}
public void clickrefusedInsuranceNo(){
    scrollAndPerformClick(refusedInsuranceNo);
}
public void clickincreasedExcessNo(){
    scrollAndPerformClick(increasedExcessNo);
}
public void selectAllOptionsTrue(){
    scrollAndPerformClick(permanentResidentYes);
    scrollAndPerformClick(mainDriverYes);
    scrollAndPerformClick(mainDriverOfAnotherCarYes);
    scrollAndPerformClick(insuranceInOwnNameYes);
    scrollAndPerformClick(driverConvictionsYes);
    scrollAndPerformClick(driverDisqualificationsYes);
    scrollAndPerformClick(refusedInsuranceYes);
    scrollAndPerformClick(increasedExcessYes);
    scrollAndPerformClick(medicalConditionYes);

}
static final String CLASSATTRIBUTE="class";
static final String CHECKEDATTRIBUTE="checked";

By isPermanentResidentTrue=By.id("IsResident-True");
public boolean isPermanentResidentTrue(){
    return shortwait.until(ExpectedConditions.presenceOfElementLocated(isPermanentResidentTrue)).getAttribute(CLASSATTRIBUTE)
             .contains(CHECKEDATTRIBUTE);
}
By isPermanentResidentFalse=By.id("IsResident-False");
    public boolean isPermanentResidentFalse(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isPermanentResidentFalse)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isMainDriverTrue=By.id("IsMainDriver-True");
    public boolean isMainDriverTrue(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isMainDriverTrue)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isMainDriverFalse=By.id("IsMainDriver-False");
    public boolean isMainDriverFalse(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isMainDriverFalse)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isMainDriverOfAnotherCarTrue=By.id("IsNotOtherCar-True");
    public boolean isMainDriverOfAnotherCarTrue(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isMainDriverOfAnotherCarTrue)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isMainDriverOfAnotherCarFalse=By.id("IsNotOtherCar-False");
    public boolean isMainDriverOfAnotherCarFalse(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isMainDriverOfAnotherCarFalse)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isInsuredOnOtherCarTrue=By.id("IsNotOtherInsurance-True");
    public boolean isInsuredOnOtherCarTrue(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isInsuredOnOtherCarTrue)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isInsuredOnOtherCarFalse=By.id("IsNotOtherInsurance-False");
    public boolean isInsuredOnOtherCarFalse(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isInsuredOnOtherCarFalse)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isConvictionsTrue=By.id("IsNoConvictions-True");
    public boolean isConvictionsTrue(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isConvictionsTrue)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
    By isConvictionsFalse=By.id("IsNoConvictions-False");
    public boolean isConvictionsFalse(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isConvictionsFalse)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isDrivingDisqualiFicationsTrue=By.id("IsNoDisqualifications-True");
    public boolean isDrivingDisqualiFicationsTrue(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isDrivingDisqualiFicationsTrue)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isDrivingDisqualificationsFalse=By.id("IsNoDisqualifications-False");
    public boolean isDrivingDisqualificationsFalse(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isDrivingDisqualificationsFalse)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isRefusalTrue=By.id("IsNoRefusal-True");
    public boolean isRefusalTrue(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isRefusalTrue)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isRefusalFalse=By.id("IsNoRefusal-False");
    public boolean isRefusalFalse(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isRefusalFalse)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isExcessedIncreaseTrue=By.id("IsNoIncrease-True");
    public boolean isExcessedIncreaseTrue(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isExcessedIncreaseTrue)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isExcessedIncreasedFalse=By.id("IsNoIncrease-False");
    public boolean isExcessedIncreasedFalse(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isExcessedIncreasedFalse)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isMedicalConditionsTrue=By.id("IsNoMedical-True");
    public boolean isMedicalConditionsTrue(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isMedicalConditionsTrue)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }
By isMedicalConditionsFalse=By.id("IsNoMedical-False");
    public boolean isMedicalConditionsFalse(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isMedicalConditionsFalse)).getAttribute(CLASSATTRIBUTE)
                .contains(CHECKEDATTRIBUTE);
    }

    By aboutYourDriversHeading=By.id("accHeading2");
    public void clickaboutYourDriversHeading(){
        scrollAndPerformClick(aboutYourDriversHeading);
    }

    By addConviction=By.id("btnAddConviction");
    public void clickaddConviction(){
        scrollAndPerformClick(addConviction);
    }

    public void visibilityaddConviction(){
        scrollAndWaitForVisibility(addConviction);
    }
    By saveConviction=By.id("SaveConviction");
    public void clicksaveConviction(){
        scrollAndPerformClick(saveConviction);
    }
    By selectDriverValidationMessage=By.id("ctl00_MainContent_RF__ddlDriversConvictions");
    public String getselectDriverValidationMessage(){
        return scrollAndGetText(selectDriverValidationMessage);
    }
    By enterDatevalidationMessage=By.id("ctl00_MainContent_RF__ConvictionDate");
    public String getenterDatevalidationMessage(){
        return scrollAndGetText(enterDatevalidationMessage);
    }
    By selectConvictionValidationMessage=By.id("ctl00_MainContent_RF_ddlConvictionType");
    public String getselectConvictionValidationMessage(){
        return scrollAndGetText(selectConvictionValidationMessage);
    }
    By cancelConvictions=By.id("ctl00_MainContent_btnHideConvictions");
    public void clickcancelConvictions(){
        scrollAndPerformClick(cancelConvictions);
    }
    public void invisibilitycancelConvictions(){
        scrollAndwaitForInvisibility(cancelConvictions);
    }
    public void visibilitycancelConvictions(){
        scrollAndWaitForVisibility(cancelConvictions);
    }

By validDriverValidationMessage=By.id("ctl00_MainContent_DriverRepeater_ctl00_RF__DriverNum");

By convictionsDate=By.id("ctl00_MainContent_ConvictionDate");
public void inputconvictionsDate(String date){
    scrollAndSendKeys(convictionsDate,date);
}
public String getinputconvictionsDateJS(){
   return JSGetText("ctl00_MainContent_ConvictionDate",driver);
}
By convictionsDateValidationMessage=By.id("ctl00_MainContent_CV__ConvictionDate");
public  String getconvictionsDateValidationMessage() {
    try {
        return scrollAndGetText(convictionsDateValidationMessage);
    } catch (StaleElementReferenceException e) {
       // shortwait.until(ExpectedConditions.stalenessOf(driver.findElement(convictionsDateValidationMessage)));
       try {
           Thread.sleep(5000);
       }catch (Exception f){

       }
        return scrollAndGetText(convictionsDateValidationMessage);
    }
}
    By convictionSelectDriver=By.id("ctl00_MainContent_ddlDriversConvictions");
public void convictionSelectDriver(String option){
    scrollAndselectOptionsByVisibleText(convictionSelectDriver,option);
}
    public String getconvictionSelectDriverJS(){
    return JSDropDownValue("ctl00_MainContent_ddlDriversConvictions",driver);
    }
By convictionType=By.id("ctl00_MainContent_ddlConvictionType");
public void  selectconvictionType(String option){
    scrollAndselectOptionsByVisibleText(convictionType,option);
}
    public String getselectconvictionTypeJS(){
        return JSDropDownValue("ctl00_MainContent_ddlConvictionType",driver);
    }
public void addConviction(AboutTheDriversModal aboutTheDriversModal){
    convictionSelectDriver(aboutTheDriversModal.getName());
    inputconvictionsDate(aboutTheDriversModal.getDate());
            selectconvictionType(aboutTheDriversModal.getType());
            clicksaveConviction();
}
By editConviction=By.id("ctl00_MainContent_ConvictionsRepeater_ctl00_EditConviction");
public void clickeditConviction(){
    scrollAndPerformClick(editConviction);
}
By convictionAddedMessage=By.cssSelector("#divConvictionsRepeater span");
public String getconvictionAddedMessage(){
    return scrollAndGetText(convictionAddedMessage);
}
By deleteButton=By.cssSelector("[data-dd-link=\"delete\"]");
public void clickdeleteConviction(){
    scrollAndPerformClick(deleteButton);
}
By removeConviction=By.id("ctl00_MainContent_ConvictionsRepeater_ctl00_DeleteThisConviction");
public void clickremoveConviction(){
    scrollAndPerformClick(removeConviction);
}

By addDrivingDisqualification= By.id("btnAddDisqualification");
public void clickaddDrivingDisqualification(){
    scrollAndPerformClick(addDrivingDisqualification);
}
public void visibilityaddDrivingDisqualification(){
    scrollAndWaitForVisibility(addDrivingDisqualification);
}
By saveDrivingDisqualification=By.id("SaveDisqualification");
public void clicksaveDrivingDisqualification(){
    scrollAndPerformClick(saveDrivingDisqualification);
}
By cancelDisqualification=By.id("ctl00_MainContent_btnHideDisqualifications");
public void clickcancelDisqualification(){
    scrollAndPerformClick(cancelDisqualification);
}
public void visibilitycancelDisqualification(){
    scrollAndWaitForVisibility(cancelDisqualification);
}
By disqualificationselectDriver=By.id("ctl00_MainContent_RF__ddlDriversDisqualification");
public String getdisqualificationselectDriver(){
    return scrollAndGetText(disqualificationselectDriver);
}
By disqualificationEnterDate=By.id("ctl00_MainContent_RF_DisqualificationDate");
public String getdisqualificationEnterDate(){
    return scrollAndGetText(disqualificationEnterDate);
}
By disqualificationReason=By.id("ctl00_MainContent_RF_ddlDisqualificationReason");
public String getdisqualificationReason(){
    return scrollAndGetText(disqualificationReason);
}

By disqualificationDateValidation=By.id("ctl00_MainContent_CV__DisqualificationDate");
public String getdisqualificationDateValidation(){
    return scrollAndGetText(disqualificationDateValidation);
}
By selectDisqualificationDriver=By.id("ctl00_MainContent_ddlDriversDisqualifications");
public void selectDisqualificationDriver(String option){
    selectOptionsByVisibleText(selectDisqualificationDriver,option);
}
By inputDisqualificationDate=By.id("ctl00_MainContent_DisqualificationDate");
public void inputDisqualificationDate(String date){
    scrollAndSendKeys(inputDisqualificationDate,date);
}
By selectDisqualificationReason=By.id("ctl00_MainContent_ddlDisqualificationReason");
public void selectDisqualificationReason(String option){
    selectOptionsByVisibleText(selectDisqualificationReason,option);
}
public void addDrivingDisqualification(AboutTheDriversModal aboutTheDriversModal){
    selectDisqualificationDriver(aboutTheDriversModal.getName());
            inputDisqualificationDate(aboutTheDriversModal.getDate());
    selectDisqualificationReason(aboutTheDriversModal.getType());
            clicksaveDrivingDisqualification();
}
By disqualificationAddedMessage=By.cssSelector("#divDisqualificationRepeater span");
public String getdisqualificationAddedMessage(){
    return scrollAndGetText(disqualificationAddedMessage);
}
By editDisqualification=By.id("ctl00_MainContent_DisqualificationRepeater_ctl00_EditDisqualification");
public void clickeditDisqualification(){
    scrollAndPerformClick(editDisqualification);
}
public String getselectedDisqualificationDriverJS(){
    return JSDropDownValue("ctl00_MainContent_ddlDriversDisqualifications",driver);
}
public String getDisqualifiedDateJS(){
    return JSGetText("ctl00_MainContent_DisqualificationDate",driver);
}
public String getDisqualifiedTypeJS(){
    return JSDropDownValue("ctl00_MainContent_ddlDisqualificationReason",driver);
}
By deleteDriverDisqualification=By.xpath("//a[text()=\"Delete\"]");
public void clickdeleteDriverDisqualification(){
    scrollAndPerformClick(deleteDriverDisqualification);
}
By removeDisqualification=By.id("ctl00_MainContent_DisqualificationRepeater_ctl00_DeleteThisDisqualification");
public void clickremoveDisqualification(){
    scrollAndPerformClick(removeDisqualification);
}
By addRefusal=By.id("btnAddRefusal");
public void clickaddRefusal(){
    scrollAndPerformClick(addRefusal);
}
public void visibilityaddRefusal(){
    scrollAndWaitForVisibility(addRefusal);
}
By saveRefusal=By.id("SaveRefusal");
public void clicksaveRefusal(){
    scrollAndPerformClick(saveRefusal);
}
public void visibilitysaveRefusal(){
    scrollAndWaitForVisibility(saveRefusal);
}
By cancelRefusal=By.id("ctl00_MainContent_btnHideRefusals");
public void clickcancelRefusal(){
    scrollAndPerformClick(cancelRefusal);
}
By selectRefusalDriver=By.id("ctl00_MainContent_ddlDriversRefusals");
public void selectRefusalDriver(String option){
    selectOptionsByVisibleText(selectRefusalDriver,option);
}
By inputRefusalDate=By.id("ctl00_MainContent_RefusalDate");
public void inputRefusalDate(String date){
    scrollAndSendKeys(inputRefusalDate,date);
}
By inputRefusalCancellationReason=By.id("ctl00_MainContent_txtRefusalReason");
public void inputRefusalCancellationReason(String option){
    scrollAndSendKeys(inputRefusalCancellationReason,option);
}
By selectDriverRefusalMessage=By.id("ctl00_MainContent_RF__ddlDriversRefusals");
public String getselectDriverRefusalMessage(){
   return scrollAndGetText(selectDriverRefusalMessage);
}
By enterDateRefusalMessage=By.id("ctl00_MainContent_RF__RefusalDate");
public String getenterDateRefusalMessage(){
    return scrollAndGetText(enterDateRefusalMessage);
}
By refusalCancellationMessage=By.id("ctl00_MainContent_RF_txtRefusalReason");
public String getrefusalCancellationMessage(){
    return scrollAndGetText(refusalCancellationMessage);
}
By refusalpastFutureMessage=By.id("ctl00_MainContent_CV__RefusalDate");
public String getrefusalpastFutureMessage(){
    return scrollAndGetText(refusalpastFutureMessage);
}
public void fillAddRefusal(AboutTheDriversModal aboutTheDriversModal){
    selectRefusalDriver(aboutTheDriversModal.getName());
            inputRefusalDate(aboutTheDriversModal.getDate());
    inputRefusalCancellationReason(aboutTheDriversModal.getType());
    clicksaveRefusal();
}
By editRefusal=By.id("ctl00_MainContent_RefusalRepeater_ctl00_EditRefusal");
public void clickeditRefusal(){
    scrollAndPerformClick(editRefusal);
}
public String  getRefusalDriverJS(){
    return JSDropDownValue("ctl00_MainContent_ddlDriversRefusals",driver);
}
public String getRefusalDateJS(){
    return JSGetText("ctl00_MainContent_RefusalDate",driver);
}
public String getrefusalReasonJS(){
    return JSGetText("ctl00_MainContent_txtRefusalReason",driver);
}

By removeRefusal=By.id("ctl00_MainContent_RefusalRepeater_ctl00_DeleteThisRefusal");
public void clickremoveRefusal(){
    scrollAndPerformClick(removeRefusal);
}

By addSpecialTerms=By.id("btnAddIncrease");
public void clickaddSpecialTerms(){
    scrollAndPerformClick(addSpecialTerms);
}
public void visibilityaddSpecialTerms(){
    scrollAndWaitForVisibility(addSpecialTerms);
}

By selectspecialTermsRelate=By.id("ctl00_MainContent_ddlDriversIncreases");
public void selectspecialTermsRelate(String option){
    selectOptionsByVisibleText(selectspecialTermsRelate,option);
}
By inputSpecialTermsDate=By.id("ctl00_MainContent_IncreaseDate");
public void inputSpecialTermsDate(String date){
    scrollAndSendKeys(inputSpecialTermsDate,date);
}
By specialTermsReason=By.id("ctl00_MainContent_txtIncreaseReason");
public void inputspecialTermsReason(String data){
    scrollAndSendKeys(specialTermsReason,data);
}
By saveSpecialTerms=By.id("SaveIncrease");
public void clicksaveSpecialTerms(){
    scrollAndPerformClick(saveSpecialTerms);
}
public void  visibilitysaveSpecialTerms(){
    scrollAndWaitForVisibility(saveSpecialTerms);
}
By cancelSpecialTerms=By.id("ctl00_MainContent_btnHideIncreases");
public  void clickcancelSpecialTerms(){
    scrollAndPerformClick(cancelSpecialTerms);
}
By selectDriverSpecialTerms=By.id("ctl00_MainContent_RF__ddlDriversIncreases");
public String getselectDriverSpecialTerms(){
    return scrollAndGetText(selectDriverSpecialTerms);
}
By enterDateSpecialTerms=By.id("ctl00_MainContent_RF__IncreaseDate");
public String getenterDateSpecialTerms(){
    return scrollAndGetText(enterDateSpecialTerms);
}
By enterSpecialTermsReason=By.id("ctl00_MainContent_RF_txtIncreaseReason");
public String getenterSpecialTermsReason(){
    return scrollAndGetText(enterSpecialTermsReason);
}
By specialTermspastFutureDateMessage=By.id("ctl00_MainContent_CV__IncreaseDate");
public String getspecialTermspastFutureDateMessage(){
    try {
        return scrollAndGetText(specialTermspastFutureDateMessage);
    }catch (StaleElementReferenceException e){
        shortwait.until(ExpectedConditions.stalenessOf(driver.findElement(specialTermspastFutureDateMessage)));
        return scrollAndGetText(specialTermspastFutureDateMessage);
    }

}
public void fillSpecialTerms(AboutTheDriversModal aboutTheDriversModal){
    selectspecialTermsRelate(aboutTheDriversModal.getName());
            inputSpecialTermsDate(aboutTheDriversModal.getDate());
    inputspecialTermsReason(aboutTheDriversModal.getType());
    clicksaveSpecialTerms();
}
By editSpecialTerms=By.id("ctl00_MainContent_IncreaseRepeater_ctl00_EditIncrease");
public void clickeditSpecialTerms(){
    scrollAndPerformClick(editSpecialTerms);
}
public String getSpecialTermsNameJS(){
    return JSDropDownValue("ctl00_MainContent_ddlDriversIncreases",driver);
}
public String getSpecialTermsDateJS(){
    return JSGetText("ctl00_MainContent_IncreaseDate",driver);
}
public String getSpecialTermsReasonJS(){
    return JSGetText("ctl00_MainContent_txtIncreaseReason",driver);
}
By removeSpecialTerms=By.id("ctl00_MainContent_IncreaseRepeater_ctl00_DeleteThisIncrease");
public void clickremoveSpecialTerms(){
    scrollAndPerformClick(removeSpecialTerms);
}
By addMedicalCondition=By.id("btnAddMedicalCondition");
public void clickaddMedicalConditionButton(){
    scrollAndPerformClick(addMedicalCondition);
}
public void visibilityaddMedicalConditionButton(){
    scrollAndWaitForVisibility(addMedicalCondition);
}
By medicalConditionSelectADriverMessage=By.id("ctl00_MainContent_RF__ddlDriversMedicalConditions");
public String getmedicalConditionSelectADriverMessage(){
    return scrollAndGetText(medicalConditionSelectADriverMessage);
}
By medicalConditionSelectAMedicalCondition=By.id("ctl00_MainContent_RF_ddlMedicalConditions");
public String getmedicalConditionSelectAMedicalCondition(){
    return scrollAndGetText(medicalConditionSelectAMedicalCondition);
}
By medicalConditionAppropriateDrivingAuthority=By.id("ctl00_MainContent_RequiredFieldValidator7");
public String getmedicalConditionAppropriateDrivingAuthority(){
    return scrollAndGetText(medicalConditionAppropriateDrivingAuthority);
}
By saveMedicalConditionButton=By.id("SaveMedicalCondition");
public void clicksaveMedicalConditionButton(){
     scrollAndPerformClick(saveMedicalConditionButton);
}
public void visibilityMedicalConditionButton(){
    scrollAndWaitForVisibility(saveMedicalConditionButton);
}
By cancelMedicalCondition=By.id("ctl00_MainContent_btnHideMedicalConditions");
public void clickcancelMedicalCondition(){
    scrollAndPerformClick(cancelMedicalCondition);
}
By medicalMessage=By.cssSelector("[id=\"divMedicalMessage\"] p");
public String getmedicalMessage(){
    return scrollAndGetText(medicalMessage);
}
By appropriateAuthorityNo=By.xpath("//input[@id=\"IsInformed-no\"]/parent::label");
public void clickappropriateAuthorityNo(){
    scrollAndPerformClick(appropriateAuthorityNo);
}
By appropriateAuthorityYes=By.xpath("//input[@id=\"IsInformed-yes\"]/parent::label");
public void clickappropriateAuthorityYes(){
    scrollAndPerformClick(appropriateAuthorityYes);
}
    By isAppropriateDrivingAuthorityYes=By.id("IsInformed-True");
    By isAppropriateDrivingAuthorityNo=By.id("IsInformed-False");
    public boolean isAppropriateDrivingAuthorityYes(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isAppropriateDrivingAuthorityYes))
                .getAttribute(CLASSATTRIBUTE).contains(CHECKEDATTRIBUTE);

    }
    public boolean isAppropriateDrivingAuthorityNo(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(isAppropriateDrivingAuthorityNo))
                .getAttribute(CLASSATTRIBUTE).contains(CHECKEDATTRIBUTE);
    }
    By selectMedicalDriver=By.id("ctl00_MainContent_ddlDriversMedicalConditions");
    By selectMedicalCondition=By.id("ctl00_MainContent_ddlMedicalConditions");

public void fillMedicalDetails(AboutTheDriversModal aboutTheDriversModal){
    selectOptionsByVisibleText(selectMedicalDriver,aboutTheDriversModal.getName());
    selectOptionsByVisibleText(selectMedicalCondition,aboutTheDriversModal.getType());

}
By editMedicalCondition=By.id("ctl00_MainContent_MedicalRepeater_ctl00_EditThisCondition");
public void clickeditMedicalCondition(){
    scrollAndPerformClick(editMedicalCondition);
}
public String getMedicalDriverJS(){
    return JSDropDownValue("ctl00_MainContent_ddlDriversMedicalConditions",driver);
}
public String getMedicalConditionJS(){
    return JSDropDownValue("ctl00_MainContent_ddlMedicalConditions",driver);
}
By removeMedicalCondition=By.id("ctl00_MainContent_MedicalRepeater_ctl00_DeleteThisCondition");
public void clickremoveMedicalCondition(){
    scrollAndPerformClick(removeMedicalCondition);
}
By findYourDriverNumber=By.cssSelector("[href=\"#drivingNumberModal\"]");
public void clickfindYourDriverNumber(){
    scrollAndPerformClick(findYourDriverNumber);
}

public void visibilityfindYourDriverNumber(){
    scrollAndWaitForVisibility(findYourDriverNumber);
}
By closeModal=By.className("o-modal__cancel");
public void clickcloseModal(){
    scrollAndPerformClick(closeModal);
}
By modalDescription=By.id("modalDescription");
public String getmodalDescription(){
    return scrollAndGetText(modalDescription);
}
By mainDriverCarToolTip=By.cssSelector("[href=\"#MainDriverTooltip\"]");
public void clickmainDriverCarToolTip(){
    scrollAndPerformClick(mainDriverCarToolTip);
}

By mainDriverOtherCarToolTip=By.cssSelector("[href=\"#OtherCarTooltip\"]");
public void clickmainDriverOtherCarToolTip(){
    scrollAndPerformClick(mainDriverOtherCarToolTip);
}
By medicalDriverToolTip=By.cssSelector("[href=\"#MedicalTooltip\"]");
public void clickmedicalDriverToolTip(){
    scrollAndPerformClick(medicalDriverToolTip);
}
By driverNumberOne=By.id("ctl00_MainContent_DriverRepeater_ctl00_DriverNum");
public void inputdriverNumberOne(String data){
    scrollAndSendKeys(driverNumberOne,data);
}
By driverNumberTwo=By.id("ctl00_MainContent_DriverRepeater_ctl01_DriverNum");
public void inputdriverNumberTwo(String data){
    scrollAndSendKeys(driverNumberTwo,data);
}
    public void fillUptoAboutYourCar(WebDriver driver) throws IOException {
    new AboutYourCar(driver).fillUptoGetQuotePage(driver);
        AboutYourCar aboutYourCar=new AboutYourCar(driver);
        aboutYourCar.clickcommutingTrue();
        aboutYourCar.clickregisteredTrue();
        aboutYourCar.clickprivateTrue();
        aboutYourCar.clickcommutingTrue();
        aboutYourCar.clickregisteredTrue();
        aboutYourCar.clickprivateTrue();
        aboutYourCar.clickcontinueButton();
        aboutYourCar.invisiblecontinueButton();

    }

}
