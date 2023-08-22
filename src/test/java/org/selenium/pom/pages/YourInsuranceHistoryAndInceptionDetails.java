package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class YourInsuranceHistoryAndInceptionDetails extends BasePage {
    public YourInsuranceHistoryAndInceptionDetails(WebDriver driver) {
        super(driver);
    }
    By backButton= By.id("ctl00_MainContent_Back3");
    public void clickbackButton(){
        scrollAndPerformClick(backButton);
    }
    By discountearnedInIrelandMessage=By.id("ctl00_MainContent_RF_IsNCDROI");
    public String getdiscountearnedInIrelandMessage(){
        return scrollAndGetText(discountearnedInIrelandMessage);
    }
    By discountOnAnotherPolicyMessage=By.id("ctl00_MainContent_RF_IsNotOtherNCD");
    public String getdiscountOnAnotherPolicyMessage(){
        return scrollAndGetText(discountOnAnotherPolicyMessage);
    }
    By currentInsuranceValidationMessage=By.id("ctl00_MainContent_RF_IsWithinExpiry");
    public String getcurrentInsuranceValidationMessage(){
        return scrollAndGetText(currentInsuranceValidationMessage);
    }
    By carInsuranceValidationMessage=By.id("ctl00_MainContent_RequiredFieldValidator5");
    public String getcarInsuranceValidationMessage(){
        return scrollAndGetText(carInsuranceValidationMessage);
    }
    public String getcarInsuranceValidationMessage1(){
        return scrollAndGetText(By.id("ctl00_MainContent_RE__OtherCarPolicyNo"));

    }
    public String getcarInsuranceValidationMessage2(){
        return scrollAndGetText(By.id("ctl00_MainContent_RegularExpressionValidator1"));

    }
    By homeInsuranceValidationMessage=By.id("ctl00_MainContent_RequiredFieldValidator4");
    public String gethomeInsuranceValidationMessage(){
        return scrollAndGetText(homeInsuranceValidationMessage);
    }
    By termsAndConditionsMessage=By.id("CV__TermsConditionsBox");
    public String gettermsAndConditionsMessage(){
        return scrollAndGetText(termsAndConditionsMessage);
    }
    By continueButton=By.id("ctl00_MainContent_btnContinueToPayment");
    public void clickcontinueButton(){
        scrollAndPerformClick(continueButton);
    }
public void invisiblecontinueButton(){
        scrollAndPerformClick(continueButton);
}

By isEarnedIrelandTrue=By.xpath("//input[@id=\"IsNCDROI-yes\"]/parent::label");
    public void clickisEarnedIrelandTrue(){
        scrollAndPerformClick(isEarnedIrelandTrue);
    }

    By isEarnedIrelandFalse=By.xpath("//input[@id=\"IsNCDROI-no\"]/parent::label");
    public void clickisEarnedIrelandFalse(){
        scrollAndPerformClick(isEarnedIrelandFalse);
    }
    By isActiveOtherPolicyTrue=By.xpath("//input[@id=\"IsNotOtherNCD-yes\"]/parent::label");
    public void clickisActiveOtherPolicyTrue(){
        scrollAndPerformClick(isActiveOtherPolicyTrue);
    }
        By isActiveOtherPolicyFalse=By.xpath("//input[@id=\"IsNotOtherNCD-no\"]/parent::label");
    public void clickisActiveOtherPolicyFalse(){
        scrollAndPerformClick(isActiveOtherPolicyFalse);
    }
        By isCurrentInsuranceTrue=By.xpath("//input[@id=\"IsWithinExpiry-yes\"]/parent::label");
    public void clickisCurrentInsuranceTrue(){
        scrollAndPerformClick(isCurrentInsuranceTrue);
    }
        By isCurrentInsuranceFalse=By.xpath("//input[@id=\"IsWithinExpiry-no\"]/parent::label");
    public void clickisCurrentInsuranceFalse(){
        scrollAndPerformClick(isCurrentInsuranceFalse);
    }
        By inputCarPolicy=By.id("ctl00_MainContent_OtherCarPolicyNo");
    public void inputCarPolicy(String data){
        scrollAndSendKeys(inputCarPolicy,data);
    }
        By inputHomePolicy=By.id("ctl00_MainContent_HomePolicyNo");
    public void  inputHomePolicy(String data){
        scrollAndSendKeys(inputHomePolicy,data);
    }
        By isConsentYes=By.xpath("//input[@id=\"IsMyAviva-yes\"]/parent::label");
    public void clickisConsentYes(){
        scrollAndPerformClick(isConsentYes);
    }
        By isConsentNo=By.xpath("//input[@id=\"IsMyAviva-no\"]/parent::label");
    public void clickisConsentNo(){
        scrollAndPerformClick(isConsentNo);
    }
        By isCarInsuranceCertificateYes=By.xpath("//input[@id=\"IsPostCert-yes\"]/parent::label");
    public void clickisCarInsuranceCertificateYes(){
        scrollAndPerformClick(isCarInsuranceCertificateYes);
    }
        By isCarInsuranceCertificateNo=By.xpath("//input[@id=\"IsPostCert-no\"]/parent::label");
    public void clickisCarInsuranceCertificateNo(){
        scrollAndPerformClick(isCarInsuranceCertificateNo);
    }
        By isPolicyDocumentationYes=By.xpath("//input[@id=\"IsPostDocs-yes\"]/parent::label");
    public void clickisPolicyDocumentationYes(){
        scrollAndPerformClick(isPolicyDocumentationYes);
    }
        By isPolicyDocumentationNo=By.xpath("//input[@id=\"IsPostDocs-no\"]/parent::label");
    public void clickisPolicyDocumentationNo(){
        scrollAndPerformClick(isPolicyDocumentationNo);
    }
        By termsAndConditionsButton=By.xpath("//input[@id=\"chkTandCs\"] /parent::label");
    public void clicktermsAndConditionsButton(){
        scrollAndPerformClick(termsAndConditionsButton);
    }
    public void selectAllTrue(){
        clickisEarnedIrelandTrue();
        clickisActiveOtherPolicyTrue();
        clickisCurrentInsuranceTrue();
    }
    By coverTime=By.id("ctl00_MainContent_CoverTime");
    public void inputCoverTime(String date){
        scrollAndSendKeys(coverTime,date);
    }
    By coverTimeValidationMessage=By.id("ctl00_MainContent_CV_CoverTime");
    public String getcoverTimeValidationMessage(){
        return scrollAndGetText(coverTimeValidationMessage);
    }
    By changeCarPolicy=By.id("btnEditPolicies");
    public void clickchangeCarPolicy(){
        scrollAndPerformClick(changeCarPolicy);
    }
    By changeHomePolicy=By.id("btnEditPolicies2");
    public void clickchangeHomePolicy(){
        scrollAndPerformClick(changeHomePolicy);
    }
    By getCoverdate=By.id("ctl00_MainContent_CoverDate");
    public String getCoverdateValue(){
        return shortwait.until(ExpectedConditions.presenceOfElementLocated(getCoverdate)).getAttribute("value");
    }
    By insuranceCertificateTooltip=By.cssSelector("[href=\"#PostCertTooltip\"]");
    public void clickinsuranceCertificateTooltip(){
        scrollAndPerformClick(insuranceCertificateTooltip);
    }
    By policyDocumentationTooltip=By.cssSelector("[href=\"#PostDocsTooltip\"]");
    public void clickpolicyDocumentationTooltip(){
        scrollAndPerformClick(policyDocumentationTooltip);
    }
    By modalDescription=By.id("modalDescription");
    public String getmodalDescription(){
        return scrollAndGetText(modalDescription);
    }
    By closeModal=By.className("o-modal__cancel");
    public void clickcloseModal(){
        scrollAndPerformClick(closeModal);
    }
}
