package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

import java.io.IOException;

public class PenaltyPoints extends BasePage {

    public PenaltyPoints(WebDriver driver) {
        super(driver);
    }
By continueButton=By.id("Continue7");
    public void clickContinueButton(){
        scrollAndPerformClick(continueButton);
        invisibleLoading();
    }
    public void invisibleClickButton(){
        scrollAndwaitForInvisibility(continueButton);
    }
By penaltyPointsOneValidationMessage=By.id("ctl00_MainContent_PPDriverRepeater_ctl00_RF__HiddenIsPenaltyPoints");
  public String getpenaltyPointsOneValidationMessage(){
      return  getText(penaltyPointsOneValidationMessage);
  }

    By penaltyPointsTwoValidationMessage=By.id("ctl00_MainContent_PPDriverRepeater_ctl01_RF__HiddenIsPenaltyPoints");
    public String getpenaltyPointsTwoValidationMessage(){
        return  getText(penaltyPointsTwoValidationMessage);
    }
  By activePenaltyPointsTwoValidationMessage=By.id("ctl00_MainContent_PPDriverRepeater_ctl01_RF__DDLPenaltyPoints");
    public String getactivePenaltyPointsTwoValidationMessage(){
        return  getText(activePenaltyPointsTwoValidationMessage);
    }

    By activePenaltyPointsOneValidationMessage=By.id("ctl00_MainContent_PPDriverRepeater_ctl00_RF__DDLPenaltyPoints");


    public String getactivePenaltyPointsOneValidationMessage(){
        return  getText(activePenaltyPointsOneValidationMessage);
    }
    public void clickYesOrNobutton(String buttonId){
      scrollAndPerformClick(By.xpath(" (//div[@id=\"div7\"] //label[@class=\"a-radio\"])["+buttonId+"]"));
      invisibleLoading();
    }
By plenaltyPointsDropdownOne=By.id("ctl00_MainContent_PPDriverRepeater_ctl00_DDLPenaltyPoints");

    public void selectPenaltyPointsOneDropDown(String option){
        scrollAndselectOptionsByVisibleText(plenaltyPointsDropdownOne, option);
        invisibleLoading();
    }

    By penaltyPointsDropDownTwo=By.id("ctl00_MainContent_PPDriverRepeater_ctl01_DDLPenaltyPoints");

    public void selectPenaltyPointsTwoDropDown(String option){
        scrollAndselectOptionsByVisibleText(penaltyPointsDropDownTwo, option);
        invisibleLoading();
    }
    By judgementOneValidationMessage=By.id("ctl00_MainContent_PPDriverRepeater_ctl00_RF__IsCourtofLaw");
    public String getjudgementOneValidationMessage(){
        return  getText(judgementOneValidationMessage);
    }
    By judgementTwoValidationMessage=By.id("ctl00_MainContent_PPDriverRepeater_ctl01_RF__IsCourtofLaw");
    public String getjudgementTwoValidationMessage(){
        return  getText(judgementTwoValidationMessage);
    }
By penaltyPointsHeading=By.id("div7");
    public void clickpenaltyPointsHeading(){
        scrollAndPerformClick(penaltyPointsHeading);
    }

    public String verifyPointsAdded(String id){
        return getText(By.xpath("//h3[normalize-space(text())=\""+id+" penalty points added\"]"));
    }
    public String verifyPointsAddedOne(String id){
        return getText(By.xpath("(//h3[normalize-space(text())=\""+id+" penalty points added\"])[2]"));
    }
    public String verifyJudgementSelection(String id){
        return  getText(By.xpath("//h3[normalize-space(text())=\""+id+" penalty points added\"]/parent::div/h4/span"));
    }

    By penaltyEditOne=By.id("ctl00_MainContent_PPDriverRepeater_ctl00_EditPoints");
    public void  clickpenaltyEditOne(){
        scrollAndPerformClick(penaltyEditOne);
        invisibleLoading();
    }
  public boolean getPenaltyEditOneButtonSize(){
        System.out.println(driver.findElement(penaltyEditOne).isDisplayed());
        return driver.findElement(penaltyEditOne).isDisplayed();
      //  return  driver.findElements(penaltyEditOne).size();
  }
    By penaltyEditTwo=By.id("ctl00_MainContent_PPDriverRepeater_ctl01_EditPoints");
    public void  clickpenaltyEditTwo(){
        scrollAndPerformClick(penaltyEditTwo);
        invisibleLoading();
    }
    public boolean getPenaltyEditTwoButtonSize(){
       System.out.println( driver.findElement(penaltyEditTwo).isDisplayed());
       return driver.findElement(penaltyEditTwo).isDisplayed();
       // return driver.findElements(penaltyEditTwo).size();
    }
public void deletePenaltyOnePoints(){
   /*     shortwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-dd-loc=\"PenaltyPointsAdded\" and @data-dd-link=\"delete\"]")));
        for(WebElement element:driver.findElements(By.xpath("//a[@data-dd-loc=\"PenaltyPointsAdded\" and @data-dd-link=\"delete\"]"))){
            if(element.isDisplayed()){
                scrollAndPerformClick(By.xpath("//a[@data-dd-loc=\"PenaltyPointsAdded\" and @data-dd-link=\"delete\"]"));
                break;
            }*/
            scrollAndPerformClick(By.xpath("//a[@data-dd-loc=\"PenaltyPointsAdded\" and @data-dd-link=\"delete\"]"));
        }

        public void deletePenaltyTwoPoints(){
        scrollAndPerformClick(By.xpath("(//a[@data-dd-loc=\"PenaltyPointsAdded\" and @data-dd-link=\"delete\"])[2]"));
        }



    By confirmDeleteOne=By.id("ctl00_MainContent_PPDriverRepeater_ctl00_DeletePoints");
    public void clickconfirmDeleteOne(){
        scrollAndPerformClick(confirmDeleteOne);
        invisibleLoading();
    }

    By confirmDeleteTwo=By.id("ctl00_MainContent_PPDriverRepeater_ctl01_DeletePoints");
    public void clickconfirmDeleteTwo(){
        scrollAndPerformClick(confirmDeleteTwo);
        invisibleLoading();
    }
    public void fillScreenUpToYourClaims(WebDriver driver) throws IOException {
        new YourClaims(driver).fillScreenUpToAdditionalDrivers(driver);
        YourClaims yourClaims=new YourClaims(driver);
        yourClaims.fillClaimAndContinue("01/01/2020","Accident","555555555");
    }
}
