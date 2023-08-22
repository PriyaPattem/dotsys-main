package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

import java.io.IOException;

public class AboutYourCar extends BasePage {
    public AboutYourCar(WebDriver driver) {
        super(driver);
    }
    By aboutYourCar=By.cssSelector("[id=\"div1\"] h2");
    public void visibilityofaboutYourCar(){
        waitForvisibility(aboutYourCar);
    }
    By backButton=By.id("ctl00_MainContent_Back1");
    public void clickbackButton(){
        scrollAndPerformClick(backButton);
    }
By continueButton=By.id("ctl00_MainContent_btnContinueVehicle");
    public void clickcontinueButton(){
        scrollAndPerformClick(continueButton);
    }
    public void invisiblecontinueButton(){
        scrollAndwaitForInvisibility(continueButton);
    }
    By existingcarRegistration=By.cssSelector("[id=\"ctl00_MainContent_divRegStored\"] h4");
    public   String getexistingcarRegistrationMessage(){
return getText(existingcarRegistration);
    }
    By carOwnerMessage=By.id("ctl00_MainContent_RF_IsOwner");
    public String getcarOwnerMessage(){
        return scrollAndGetText(carOwnerMessage);
    }
    By carTaxMessage=By.id("ctl00_MainContent_RF_IsPrivate");
    public String getcarTaxMessage(){
        return scrollAndGetText(carTaxMessage);
    }
    By carUseMessage=By.id("ctl00_MainContent_RF_IsCommuting");
    public String getcarUseMessage(){
        return scrollAndGetText(carUseMessage);
    }
    By registeredTrue=By.xpath("//input[@id=\"IsOwner-yes\"]/parent::label");

    public void clickregisteredTrue(){
        scrollAndPerformClick(registeredTrue);
    }
    By registeredFalse=By.xpath("//input[@id=\"IsOwner-no\"]/parent::label");
    public void clickregisteredFalse(){
        scrollAndPerformClick(registeredFalse);
    }
By privateTrue=By.xpath("//input[@id=\"IsPrivate-yes\"]/parent::label");
    public void clickprivateTrue(){
        scrollAndPerformClick(privateTrue);
    }
By privateFalse=By.xpath("//input[@id=\"IsPrivate-no\"]/parent::label");
    public void  clickprivateFalse(){
        scrollAndPerformClick(privateFalse);
    }
By commutingTrue=By.xpath("//input[@id=\"IsCommuting-yes\"]/parent::label");
    public void  clickcommutingTrue(){
        scrollAndPerformClick(commutingTrue);
    }
By commutingFalse=By.xpath("//input[@id=\"IsCommuting-no\"]/parent::label");
    public void clickcommutingFalse(){
        scrollAndPerformClick(commutingFalse);
    }
By registeredTooltip=By.cssSelector("[href=\"#OwnerTooltip\"]");
    public void  clickregisteredTooltip(){
        scrollAndPerformClick(registeredTooltip);
    }
By modalDescription=By.cssSelector("[id=\"modalDescription\"] p");
    public String getmodalDescription(){
        return scrollAndGetText(modalDescription);
    }
By registrationNumberNotFound=By.cssSelector("[id=\"ctl00_MainContent_divNotCorrectCar\"] h3");
    public String getregistrationNumberNotFound(){
        return scrollAndGetText(registrationNumberNotFound);
    }
    By registrationNumberNotFoundcar=By.id("ctl00_MainContent_ManualCarSearchResult");
    public String getregistrationNumberNotFoundcar(){
        return scrollAndGetText(registrationNumberNotFoundcar);
    }
public static  final String CHECKEDATTRIBUTE="checked";
public static final String CLASSATTRIBUTE="class";
    By iscarOwnerSelected=By.id("IsOwner-True");
    public boolean iscarOwnerSelected(){
       shortwait.until(ExpectedConditions.presenceOfElementLocated(iscarOwnerSelected));
       if(driver.findElement(iscarOwnerSelected).getAttribute(CLASSATTRIBUTE).contains(CHECKEDATTRIBUTE)){
           return true;
       }
       return false;
    }
   By iscarOwnerNotSelected=By.id("IsOwner-False");
    public boolean iscarOwnerNotSelected(){
        shortwait.until(ExpectedConditions.presenceOfElementLocated(iscarOwnerNotSelected));
        if(driver.findElement(iscarOwnerNotSelected).getAttribute(CLASSATTRIBUTE).contains(CHECKEDATTRIBUTE)){
            return true;
        }
        return false;
    }
    By carTaxSelected=By.id("IsPrivate-True");
    public boolean iscarTaxSelected(){
        shortwait.until(ExpectedConditions.presenceOfElementLocated(carTaxSelected));
        if(driver.findElement(carTaxSelected).getAttribute(CLASSATTRIBUTE).contains(CHECKEDATTRIBUTE)){
            return true;
        }
        return false;
    }
By carTaxNotSelected=By.id("IsPrivate-False");
    public boolean iscarTaxNotSelected(){
        shortwait.until(ExpectedConditions.presenceOfElementLocated(carTaxNotSelected));
        if(driver.findElement(carTaxNotSelected).getAttribute(CLASSATTRIBUTE).contains(CHECKEDATTRIBUTE)){
            return true;
        }
        return false;
    }
    By isCommutingTrue=By.id("IsCommuting-True");
    public boolean isCommutingTrue(){
        shortwait.until(ExpectedConditions.presenceOfElementLocated(isCommutingTrue));
        if(driver.findElement(isCommutingTrue).getAttribute(CLASSATTRIBUTE).contains(CHECKEDATTRIBUTE)){
            return true;
        }
        return false;
    }
    By isCommutingNotTrue=By.id("IsCommuting-False");
    public boolean isCommutingNotTrue(){
        shortwait.until(ExpectedConditions.presenceOfElementLocated(isCommutingNotTrue));
        if(driver.findElement(isCommutingNotTrue).getAttribute(CLASSATTRIBUTE).contains(CHECKEDATTRIBUTE)){
            return true;
        }
        return false;
    }

 //   By enterCarRegistrationValidationMessage=By.id("ctl00_MainContent_CV__VehicleRegistration");
    By enterCarRegistrationValidationMessage=By.id("ctl00_MainContent_RequiredFieldValidator6");
    public String getenterCarRegistrationValidationMessage(){
        try {
            return scrollAndGetText(enterCarRegistrationValidationMessage);
        }catch (StaleElementReferenceException e){
            shortwait.until(ExpectedConditions.stalenessOf(driver.findElement(enterCarRegistrationValidationMessage)));
            return scrollAndGetText(enterCarRegistrationValidationMessage);
        }

    }
    By clickHeading=By.id("accHeading1");
    public void  clickHeading(){
        scrollAndPerformClick(clickHeading);
    }
    By carRegistrationSearchBox=By.cssSelector("[id=\"divVehicleRegistration\"] [id=\"ctl00_MainContent_VehicleRegistration\"]");
      public void inputcarRegistrationSearchBox(String data){
        scrollAndSendKeys(carRegistrationSearchBox,data);
    }
By pleaseSelectCarValidation=By.id("ctl00_MainContent_CV_CompleteCar");
      public String getpleaseSelectCarValidation(){
          return  scrollAndGetText(pleaseSelectCarValidation);
      }
    public   void fillUptoGetQuotePage(WebDriver driver) throws IOException {
          new YourQuote(driver).fillUptoCoverStartPage(driver);
        new YourQuote(driver).clicksinglePaymentBuyNow();
        new YourQuote(driver).invisibilityOfLoading();
        new AboutYourCar(driver).visibilityofaboutYourCar();
    }

    By findcar=By.id("ctl00_MainContent_btnFindCar");

}
