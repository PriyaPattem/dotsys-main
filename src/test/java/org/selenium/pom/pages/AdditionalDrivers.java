package org.selenium.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.AdditionalDriversModal;
import org.selenium.pom.objects.CarDetailsModal;

import java.io.IOException;

public class AdditionalDrivers extends BasePage {
    public AdditionalDrivers(WebDriver driver) {
        super(driver);
    }
By additionalDriversHeading=By.cssSelector("#ctl00_MainContent_UpdatePanel15 p");
    By additionalDriversNo=  By.xpath("//input[@id=\"IsAdditionalDriver-no\"]/parent::label");
    By additionalDriversYes=By.cssSelector("[for=\"IsAdditionalDriver-yes\"]");
    public void clickadditionalDriversYesSingleButton(){
        scrollAndPerformClick(additionalDriversYes);
    }

   By clickContinueButton=By.id("ctl00_MainContent_Continue5");

   By addDriverButton=By.id("SaveDriver");
   By titleValidationMessage=By.id("CV__DriverTitle");
   By firstNameMessage=By.id("RF__DriverForename");
   By surNameMessage=By.id("RF__DriverSurname");
   By dobMessage=By.id("RF__DriverDOB");
   By employeeStatusMessage=By.id("RF__DriverEmploymentStatus");
   By licenceTypeMessage=By.id("RF__DriverLicenceType");
   By yearsHeldMessage=By.id("RF__DriverLicenceYearsHeld");
   By relationShipMessage=By.id("RF__RelationshipToProposer");
   By firstName=By.id("ctl00_MainContent_DriverForename");
   By additionalDriverAttribute=By.id("ctl00_MainContent_hf_IsAdditionalDriver");
   public String getAdditionalDriverAttribute(){
       shortwait.until(ExpectedConditions.presenceOfElementLocated(additionalDriverAttribute));
       return driver.findElement(additionalDriverAttribute).getAttribute("value");
   }
   public void enterFirstName(String data){
       scrollAndSendKeys(firstName,data);
   }


   By editAdditionalDriversHeading=By.id("accHeading5");
   public void clickAdditionalDriversHeading(){
       scrollAndPerformClick(editAdditionalDriversHeading);
   }
    public String getpleaseEnterYourFirstNameDisplayNone(){
        return driver.findElement(firstNameMessage).getAttribute("style");
    }
    public String getfirstNameErrorValidationMessageSize(){
        return driver.findElement(firstNameMessage).getAttribute("style");
    }
    public String getpleaseEnterYourSurnameDisplayNone(){
        return driver.findElement(surNameMessage).getAttribute("style");
    }
    public void EnterFirstNameAndContinue(String input) throws InterruptedException {
       scrollIntoView(firstName);
        shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(firstName))).sendKeys(input);
        clickaddDriverButton();
        Thread.sleep(1500);

    }
    By surName=By.id("ctl00_MainContent_DriverSurname");

    By pleaseEnterCompleteSurname=By.id("RE__DriverSurnameRE");

    public String getpleaseEnterCompleteSurnameMessage(){
        return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(pleaseEnterCompleteSurname))).getText();
    }
    public void EnterSurnameAndContinue(String input) throws InterruptedException {
        shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(surName))).sendKeys(input);
       clickaddDriverButton();
        Thread.sleep(1500);
    }
    public void enterSurname(String data){
        scrollAndSendKeys(surName,data);

    }
    public String getrelationShipMessage(){
        return scrollAndGetText(relationShipMessage);
    }
   public String getyearsHeldMessage(){
        return scrollAndGetText(yearsHeldMessage);
    }
    public String getlicenceTypeMessage(){
        return scrollAndGetText(licenceTypeMessage);
    }
   public String getemployeeStatusMessage(){
        return scrollAndGetText(employeeStatusMessage);
    }

   public String getdobMessage(){
        return scrollAndGetText(dobMessage);
    }

   public String getsurNameMessage(){
        return scrollAndGetText(surNameMessage);
    }

   public String getfirstNameMessage(){
        return scrollAndGetText(firstNameMessage);
    }
    public String getfirstNameErrorValidationMessage(){
        return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("RE__DriverForenameRE")))).getText();

    }
   public String gettitleValidationMessage(){
       return scrollAndGetText(titleValidationMessage);
   }

   public void clickaddDriverButton(){
       //scrollAndPerformClick(addDriverButton);
       shortwait.until(ExpectedConditions.presenceOfElementLocated(addDriverButton));
       try {
           shortwait.until(ExpectedConditions.elementToBeClickable(addDriverButton)).click();
       }catch (StaleElementReferenceException e){
           try {
               Thread.sleep(5000);
           }catch (Exception f){

           }
           shortwait.until(ExpectedConditions.elementToBeClickable(addDriverButton)).click();
       }

   }

   public void invisibiltyAddDriverButton(){
        waitForInvisibility(addDriverButton);
   }
    public void visibilityaddDriverButton(){
        mediumwait.until(ExpectedConditions.visibilityOf(driver.findElement(clickContinueButton)));
    }

   public void clickContinueButton(){
       scrollAndPerformClick(clickContinueButton);
       invisibleLoading();
   }
   public void visibilityContinueButton(){
        scrollAndWaitForVisibility(clickContinueButton);
   }
   public void waitForInvisibilityForClickButton(){
        scrollAndwaitForInvisibility(clickContinueButton);
        //longwait.until(ExpectedConditions.invisibilityOf(driver.findElement(clickContinueButton)));
      // scrollAndwaitForInvisibility(clickContinueButton);
   }

    public String getAdditionalDriversHeading(){
        return scrollAndGetText(additionalDriversHeading);
    }

    public void clickAdditionalDriversNo(){
        scrollAndPerformClick(additionalDriversNo);
    }
    public void clickadditionalDriversYes(){
        shortwait.until(ExpectedConditions.presenceOfElementLocated(additionalDriversYes));
        scrollIntoView(additionalDriversYes);
     try {
         Thread.sleep(3000);
     }catch (Exception e){

     }

        WebElement additionalDriversYes1=driver.findElement(additionalDriversYes);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", additionalDriversYes1);


     /*   try {
            Thread.sleep(1500);
        }catch (Exception e){

        }
      scrollIntoView(additionalDriversYes);
        try {
            performClick(additionalDriversYes);
        }catch (ElementClickInterceptedException e){
           try {
               Thread.sleep(3000);
           }catch (Exception f){

           }
            performClick(additionalDriversYes);
        }

        try {
            Thread.sleep(1500);
        }catch (Exception e){

        }*/
       // shortwait.until(ExpectedConditions.presenceOfElementLocated(additionalDriversYes));
        //shortwait.until(ExpectedConditions.elementToBeClickable(additionalDriversYes));
    }
    public int getadditionalDriversYesCount(){
        return driver.findElements(additionalDriversYes).size();
    }
    public String selectTitleradioButtonAndReturnClassAttribute(String option){
        shortwait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("(//*[@id='"+option+"'])[2]"))));
        try {
            shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[@id='"+option+"'])[2]"))));
            shortwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@id='"+option+"'])[2]")))).click();
        }catch (ElementClickInterceptedException e){
            try {
                Thread.sleep(5000);
            }catch (Exception f){

            }
            shortwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@id='"+option+"'])[2]")))).click();
        }



        return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[@id='"+option+"'])[2]")))).getAttribute("class");
    }
    By employeeStatus=By.id("ctl00_MainContent_DriverEmploymentStatus");
    public void selectEmployeeStatus(String option){
        //shortwait.until(ExpectedConditions.numberOfElementsToBeMoreThan(employeeStatus,2));
        Select select=new Select(driver.findElement(employeeStatus));
        select.selectByVisibleText(option);
    }
    By typeOfDrivingLicence=By.id("ctl00_MainContent_DriverLicenceType");
    public void selecttypeOfDrivingLicence(String option){
        //shortwait.until(ExpectedConditions.numberOfElementsToBeMoreThan(typeOfDrivingLicence,2));
        Select select=new Select(driver.findElement(typeOfDrivingLicence));
        select.selectByVisibleText(option);
        invisibleLoading();
    }
    By yearsHeld=By.id("ctl00_MainContent_DriverLicenceYearsHeld");
    public void selectyearsHeld(String option){
        // shortwait.until(ExpectedConditions.numberOfElementsToBeMoreThan(yearsHeld,2));
        Select select=new Select(driver.findElement(yearsHeld));
        select.selectByVisibleText(option);
    }
    By enterAge=By.id("ctl00_MainContent_DriverDOB");
    public void enterage(String text){
        sendKeys(enterAge, text);
    }
    By relationShipToProposer=By.id("ctl00_MainContent_RelationshipToProposer");
    public void selectrelationShipToProposer(String option){
        selectOptionsByVisibleText(relationShipToProposer,option);
    }
    By removeDriverButton=By.id("ctl00_MainContent_btnRemoveDriver");
    public void clickRemoveDriver(){
        scrollAndPerformClick(removeDriverButton);
        invisibleLoading();
    }
    public void invisibleRemoveDriver(){
        waitForInvisibility(removeDriverButton);
    }
    public void visibleEditDriver(){
        waitForvisibility(editDriverButton);
    }

    public int getEditDriverCount(){
        return driver.findElements(By.xpath("//a[text()=\"Edit driver \"]")).size();
    }
    By removeDriverAfterAdding=By.xpath("//a[text()=\"Remove driver\"]");
    By confirmRemoveDriver=By.id("ctl00_MainContent_DriverRepeater_ctl00_DeleteDriver");
    By licenseObtained=By.id("ctl00_MainContent_DriverCountryLicenceObtained");
    By occupation=By.id("txtDriverOccupation");
    public void enterOccupationData(String data) throws InterruptedException {
        sendKeys(occupation,data);

        driver.findElement(occupation).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(4000);
        driver.findElement(occupation).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(occupation).sendKeys(Keys.ENTER);
    }
    public String getOccupationDataJS(){
        return JSGetText("txtDriverOccupation",driver);
    }
    public void selectLicenseObtained(String option){
        selectOptionsByVisibleText(licenseObtained,option);
    }

    public String getLicenseObtainedJS(){
        return  JSDropDownValue("ctl00_MainContent_DriverCountryLicenceObtained",driver);
    }
    public int getconfirmRemoveDriverCount(){
      return   driver.findElements(removeDriverAfterAdding).size();
    }
   By removeDriverXpath=By.xpath("//a[text()=\"Remove driver\"]");
    public void removeDriverAfterAdding(){
      //  scrollAndPerformClick(removeDriverAfterAdding);

        performClick(removeDriverXpath);
        performClick(confirmRemoveDriver);


    }
By ownCarNo=By.xpath("//input[@id=\"IsSpouseOwnVehicle-no\"]/parent::label");
    public void clickOwnCarNo(){
        scrollAndPerformClick(ownCarNo);
    }
By ownCarYes=By.xpath("//input[@id=\"IsSpouseOwnVehicle-yes\"]/parent::label");
    public void clickOwnCarYes(){
        scrollAndPerformClick(ownCarYes);
    }
    public String getageTooyouToholdDriverLicenceValidationMessage() throws InterruptedException {

        try {
            return scrollAndGetText(By.id("ctl00_MainContent_CV__DriverDOB"));
        }catch (Exception e){
            Thread.sleep(5000);
            return scrollAndGetText(By.id("ctl00_MainContent_CV__DriverDOB"));
        }

    }

    By editDriverButton=By.id("ctl00_MainContent_DriverRepeater_ctl00_EditDriver");
    public void clickEditDriver(){
       try {
            scrollAndPerformClick(editDriverButton);
        }catch (ElementClickInterceptedException e){
           JavascriptExecutor js = (JavascriptExecutor)driver;
           js.executeScript("arguments[0].click()", driver.findElement(editDriverButton));
       }

    }
    JavascriptExecutor js=(JavascriptExecutor) driver;
    public String selectTitleradioButtonAndReturnClassAttributeJS(String option){
        return js.executeScript("return document.getElementById('"+option+"').id").toString();
    }

    public String getFirstNameJS(){
        return JSGetText("ctl00_MainContent_DriverForename",driver);
    }
    public String getSurNameJS(){
        return JSGetText("ctl00_MainContent_DriverSurname",driver);
    }
    public String getDobJS(){
        return JSGetText("ctl00_MainContent_DriverDOB",driver);
    }
    public String getEmployementStatusJS(){
        return JSDropDownValue("ctl00_MainContent_DriverEmploymentStatus",driver);
    }
public String getDrivingLicenseTheyHoldJs(){
        return JSDropDownValue("ctl00_MainContent_DriverLicenceType",driver);
}
public String getyearLicenceHeldJS(){
        return JSDropDownValue("ctl00_MainContent_DriverLicenceYearsHeld",driver);
}
public String getRelationToProposerJS(){
        return  JSDropDownValue("ctl00_MainContent_RelationshipToProposer",driver);
}
public void fillAdditionalDriver(AdditionalDriversModal additionalDriversModal){

    selectTitleradioButtonAndReturnClassAttribute(additionalDriversModal.getTitle());
   enterFirstName(additionalDriversModal.getFirstname());
    enterSurname(additionalDriversModal.getSurname());
    sendKeys(enterAge,additionalDriversModal.getDob());
    selectEmployeeStatus(additionalDriversModal.getEmploymentStatus());
    selecttypeOfDrivingLicence(additionalDriversModal.getDrivingLicense());
    selectyearsHeld(additionalDriversModal.getYearsHeld());
    selectrelationShipToProposer(additionalDriversModal.getRelationship());
   // clickOwnCarNo();
    clickaddDriverButton();
    invisibiltyAddDriverButton();

}
    By ModalText=By.cssSelector("[id=\"modalDescription\"] p");

    public String getModalText(){
        return getText(ModalText);

    }
    By drivingLicenceTooltip=By.cssSelector("[aria-labelledby=\"DriverLicenceTooltip\"]");
    public void clickdrivingLicenceTooltip(){
        scrollAndPerformClick(drivingLicenceTooltip);
    }

    public void fillScreenUpToCarDetails(WebDriver driver) throws IOException {
        new CarDetails(driver).fillScreenOneTwoThreeData(driver);
        CarDetails carDetails = new CarDetails(driver);
        CarDetailsModal carDetailsModal=new CarDetailsModal("yes");
        carDetails.fillCardetailsWithRegistrationYes(carDetailsModal);

    }

}
