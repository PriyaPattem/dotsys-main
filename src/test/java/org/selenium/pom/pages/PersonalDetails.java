package org.selenium.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.customerScreenOneModal;
import org.selenium.pom.objects.personalDetailsCustomAddressModal;
import org.selenium.pom.objects.personalDetailsModal;

import java.io.IOException;

import static org.selenium.pom.constants.DotSysConstants.DRIVINGLICENCEMODAL;

public class PersonalDetails extends BasePage {
    public PersonalDetails(WebDriver driver) {
        super(driver);
    }
    By cannotFindAddress=By.id("ctl00_MainContent_btnManualAddress");
        By continueButton=By.id("ctl00_MainContent_Continue2");
    By pleaseEnterAddress=By.id("CV__AutoAddressValidate");
    By pleaseEnterDateOfBirth=By.id("RF__ProposerDOB");
    By pleaseEnterEmployeeStatus=By.id("RF__EmploymentStatus");
    By pleaseSelectLicenseType=By.id("RF__LicenceType");
    By pleaseSelectyearsLicenseHeld=By.id("RF__LicenceYearsHeld");
    By personalDetailsHeading=By.id("div2");
    By changeAddress=By.id("ctl00_MainContent_btnEditAddress");
    public void clickChangeAddress(){
        performClick(changeAddress);
        new YourQuote(driver).invisibilityOfLoading();
    }
    public void clickPersonalDetailsHeading(){
        try {
            performClick(personalDetailsHeading);
        }catch (ElementClickInterceptedException e){
            try{
                Thread.sleep(3000);
            }catch (Exception f){

            }
            performClick(personalDetailsHeading);
        }
    }

    public void clickContinueButton(){
        performClick(continueButton);
    }
    public void visibilityContinueButton(){
        scrollAndWaitForVisibility(continueButton);
    }
    public void invsibilityContinueButton(){
        scrollAndwaitForInvisibility(continueButton);
        //mediumwait.until(ExpectedConditions.invisibilityOf(driver.findElement(continueButton)));
    }
    public String getpleaseSelectyearsLicenseHeld(){
        return getText(pleaseSelectyearsLicenseHeld);
    }

   public String getpleaseSelectLicenseType(){
       return getText(pleaseSelectLicenseType);
   }
    public String getpleaseEnterEmployeeStatus(){
        return getText(pleaseEnterEmployeeStatus);
    }

    public void clickCannotFindAddress(){
        performClick(cannotFindAddress);
        new YourQuote(driver).invisibilityOfLoading();
    }
    public String getpleaseEnterAddressValidationMessage(){
        return getText(pleaseEnterAddress);
    }
    public String getpleaseEnterDateOfBirthValidationMessage(){
        return getText(pleaseEnterDateOfBirth);
    }

    //cannot find address
    By pleaseenterfirestlineofAddress=By.id("RF__Address1");
    By pleaseentersecondlineofAddress=By.id("RF__Address2");
    By pleaseselectYourCountry=By.id("RF__ddlCounty");
    By pleaseselectYourSubarea=By.id("RF__CheckSubArea");

    By confirmAddress=By.id("ctl00_MainContent_btnConfirmManualAddress");

    public String getpleaseselectYourSubarea(){
        return  getText(pleaseselectYourSubarea);
    }
public String getpleaseenterfirestlineofAddress(){
    return getText(pleaseenterfirestlineofAddress);
}
public String getpleaseentersecondlineofAddress(){
    return getText(pleaseentersecondlineofAddress);
}
public String getpleaseselectYourCountry(){
    return getText(pleaseselectYourCountry);
}
public void clickConfirmAddress(){
    performClick(confirmAddress);
    invisibleLoading();
}
By address1=By.id("ctl00_MainContent_Address1");
By address2=By.id("ctl00_MainContent_Address2");
By selectCounty=By.id("ctl00_MainContent_ddlCounty");
By address3=By.id("ctl00_MainContent_Address3");

public void enterCustomAddressDetails(personalDetailsCustomAddressModal personalDetailsCustomAddressModal){
    enteraddress1(personalDetailsCustomAddressModal.getAddress1());
    enteraddress2(personalDetailsCustomAddressModal.getAddress2());
    enteraddress3(personalDetailsCustomAddressModal.getAddress3());
    selectCountry(personalDetailsCustomAddressModal.getCounty());
    try {
        Thread.sleep(3000);
    }catch (Exception e){

    }
   // selectSubArea(personalDetailsCustomAddressModal.getSubcounty());
    clickConfirmAddress();

}
    public void enteraddress3(String address){
        sendKeys(address3,address);
    }
public void enteraddress1(String address){
    sendKeys(address1,address);
}
    public void enteraddress2(String address){
        sendKeys(address2,address);
    }
    public void selectCountry(String option){
        Select select=new Select(driver.findElement(selectCounty));
        select.selectByVisibleText(option);
    }
    By selectSubArea=By.id("ctl00_MainContent_ddlSubArea");
public void selectSubArea(String option){
    Select select=new Select(driver.findElement(selectSubArea));
    select.selectByVisibleText(option);

}
By confirmAddressButton=By.id("ctl00_MainContent_btnConfirmManualAddress");
public void  clickconfirmAddressButton(){
    performClick(confirmAddressButton);
}
By returnButton=By.id("ctl00_MainContent_BtnReturnToAutoAddress");
    public void  clickReturnButton(){
        performClick(returnButton);
    }
public int getReturnButtonSize(){
        return driver.findElements(returnButton).size();
}
public boolean waitForInvisbilityForReturnButton(){
        return waitForInvisibility(returnButton);
}
    public boolean waitForInvisbilityForNoButton(){
        return waitForInvisibility(correctAddressNoButton);
    }
By addressSearch=By.cssSelector("[id=\"divAddressSearch\"] input");
    public void waitforVisibiliyofAddressSearchBar(){
        waitForvisibility(addressSearch);
    }
public void inputSearchText(String data){
        sendKeys(addressSearch,data);
}
    By autoSuggestionClass=By.className("autoaddress-suggestion");
    public void selectSuggestedCountry(String country){
       shortwait.until(ExpectedConditions.numberOfElementsToBeMoreThan(autoSuggestionClass,2));

            // driver.findElement(autoSuggestionClass).click();
        performClick(autoSuggestionClass);


    }
    By previewAddress=By.id("ctl00_MainContent_searchResult");
    public String getPreviewAddress(){
        return getText(previewAddress);
    }
    By correctAddressYesButton=By.id("ctl00_MainContent_btnConfirmAddress");
    public void clickcorrectAddressYesButton(){
        performClick(correctAddressYesButton);
        try {
            new YourQuote(driver).invisibilityOfLoading();
        }catch (TimeoutException e){

        }

    }
    By correctAddressNoButton=By.id("ctl00_MainContent_btnNotAddress");
    public void  clickCorrectAddressNoButton(){
        performClick(correctAddressNoButton);
        new YourQuote(driver).invisibilityOfLoading();
    }
    By addressResult=By.id("ctl00_MainContent_searchResult1");
    public String getaddressResult(){
        return getText(addressResult);
    }
By ageTooyouToholdDriverLicence=By.id("CV_ProposerDOB");
public String getageTooyouToholdDriverLicenceValidationMessage(){
    return getText(ageTooyouToholdDriverLicence);
}
By pleaseEnterAnOccupation=By.id("RF__txtOccupation");
public String getPleaseEnterAnOccupationValidationMessage(){
    return getText(pleaseEnterAnOccupation);
}
By occupation=By.id("txtOccupation");
public void enterAndSelectOccupation(String data) throws InterruptedException {
    sendKeys(occupation,data);

   driver.findElement(occupation).sendKeys(Keys.BACK_SPACE);
    Thread.sleep(4000);
    driver.findElement(occupation).sendKeys(Keys.ARROW_DOWN);
    driver.findElement(occupation).sendKeys(Keys.ENTER);


}
By pleaseSelectCountryWhereLicenceObtained=By.id("RF__CountryLicenceObtained");
By countryWhereLicenceApplied=By.cssSelector("#ctl00_MainContent_CountryLicenceObtained option");
By selectCountry=By.id("ctl00_MainContent_CountryLicenceObtained");
public void obtainedlicensecountry(String option){
    Select select=new Select(driver.findElement(selectCountry));
    select.selectByVisibleText(option);


}
public void waitforCountrywherelicenceappliedvisbility(){
    waitForvisibility(countryWhereLicenceApplied);
    shortwait.until(ExpectedConditions.numberOfElementsToBeMoreThan(countryWhereLicenceApplied,2));
}
public String getpleaseSelectCountryWhereLicenceObtained(){

    return getText(pleaseSelectCountryWhereLicenceObtained);
}
By employeeStatus=By.id("ctl00_MainContent_EmploymentStatus");
By typeOfDrivingLicence=By.id("ctl00_MainContent_LicenceType");
By yearsHeld=By.id("ctl00_MainContent_LicenceYearsHeld");
public void selectEmployeeStatus(String option){
   //shortwait.until(ExpectedConditions.numberOfElementsToBeMoreThan(employeeStatus,2));
    Select select=new Select(driver.findElement(employeeStatus));
    select.selectByVisibleText(option);
}
public void selecttypeOfDrivingLicence(String option){
   //shortwait.until(ExpectedConditions.numberOfElementsToBeMoreThan(typeOfDrivingLicence,2));
    Select select=new Select(driver.findElement(typeOfDrivingLicence));
    select.selectByVisibleText(option);
    new YourQuote(driver).invisibilityOfLoading();
}
    public void selectyearsHeld(String option){
     // shortwait.until(ExpectedConditions.numberOfElementsToBeMoreThan(yearsHeld,2));
        Select select=new Select(driver.findElement(yearsHeld));
        select.selectByVisibleText(option);
    }
By enterAge=By.id("ctl00_MainContent_ProposerDOB");
public void enterAge(String data){
    sendKeys(enterAge, data);
}
public void fillPersonalDetailsAndContinue(personalDetailsModal personalDetailsModal){
    inputSearchText(personalDetailsModal.getCountry());
    selectSuggestedCountry(personalDetailsModal.getCountry());
    clickcorrectAddressYesButton();

    sendKeys(enterAge,personalDetailsModal.getDob());
    selectEmployeeStatus(personalDetailsModal.getEmployeeStatus());
    selecttypeOfDrivingLicence(personalDetailsModal.getDrivingLicense());
    new YourQuote(driver).invisibilityOfLoading();
    selectyearsHeld(personalDetailsModal.getYearsHeld());
    clickContinueButton();


    //invsibilityContinueButton();
   // insibilityContinueButton();
}
public void fillPersonalDetailsAndContinueWithSubOptions(personalDetailsModal personalDetailsModal) throws InterruptedException {
    fillPersonalDetailsAndContinue( personalDetailsModal);
    waitforCountrywherelicenceappliedvisbility();
    enterAndSelectOccupation(personalDetailsModal.getOccupation());
    obtainedlicensecountry(personalDetailsModal.getCountryLicense());
    clickContinueButton();
}
JavascriptExecutor js=(JavascriptExecutor) driver;
public String getAddressJS(){
    return    js.executeScript("return document.getElementById('ctl00_MainContent_searchResult1').innerText").toString();
}

public String getdobJS(){
    return    js.executeScript("return document.getElementById('ctl00_MainContent_ProposerDOB').value").toString();
}

public String getEmployeeStatusJS(){
  return   js.executeScript("return document.getElementById(\"ctl00_MainContent_EmploymentStatus\").options[document.getElementById(\"ctl00_MainContent_EmploymentStatus\").selectedIndex].text").toString();
}

public String getDrivingLicenseJS(){
    return js.executeScript("return document.getElementById(\"ctl00_MainContent_LicenceType\").options[document.getElementById(\"ctl00_MainContent_LicenceType\").selectedIndex].text").toString();
}
    public String getYearsHeldJS(){
        return js.executeScript("return document.getElementById(\"ctl00_MainContent_LicenceYearsHeld\").options[document.getElementById(\"ctl00_MainContent_LicenceYearsHeld\").selectedIndex].text").toString();
    }

    public String getOccupationJs(){
        return js.executeScript("return document.getElementById('txtOccupation').value").toString();
    }
    public String getLicenceObtained(){
        return js.executeScript("return document.getElementById(\"ctl00_MainContent_CountryLicenceObtained\").options[document.getElementById(\"ctl00_MainContent_CountryLicenceObtained\").selectedIndex].text").toString();
    }
public String getDrivingLicenceYouHoldModalMessage(){
    return getText(By.xpath("//p[text()='"+ DRIVINGLICENCEMODAL+"']"));
}
By clickDrivingLicenceModal=By.cssSelector("[aria-describedby=\"LicenceTooltip\"]");
public void clickDrivingLicenceModal(){
    performClick(clickDrivingLicenceModal);
}
By modalCancelButton=By.className("o-modal__cancel");
public void visibilityOfmodalText(){

waitForvisibility(By.xpath("//p[text()='"+DRIVINGLICENCEMODAL+"']"));
}
    public void fillScreenOnedata(WebDriver driver) throws IOException {
        CustomerScreenOne customerScreenOne = new CustomerScreenOne(driver);
        customerScreenOne.load();
        customerScreenOneModal customerScreenOneModal=new customerScreenOneModal(1);
        System.out.println(customerScreenOneModal.getEmail());
        System.out.println(customerScreenOneModal.getTitle());
        customerScreenOne.fillCustomerScreenFormAndContinue(customerScreenOneModal);
        new YourQuote(driver).invisibilityOfLoading();
    }
}
