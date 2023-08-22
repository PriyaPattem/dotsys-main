package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.customerScreenOneModal;

import java.security.PublicKey;
import java.util.List;
import java.util.Set;

public class CustomerScreenOne extends BasePage {
    public CustomerScreenOne(WebDriver driver) {
        super(driver);
    }
    By createquote= By.cssSelector("a[class*=\"btn-success\"]");
    By avivaCarInsuranceHeading=By.cssSelector("[id=\"ctl00_NavigationTabs_AvivaHeading\"] h1");

    By carInsuranceAndYourPersonalDetailsHeading=By.className("a-progress-bar__step");
    By avivaCarInsuranceHeadingInScreenOne=By.className("m-heading-group__item");
    By dataProtectionContent=By.className("m-card-content");
    By readOurDataProtectionNoticeURl=By.cssSelector(".m-card-content a");

    By aboutYou=By.xpath("//h2[text()=\"About you\"]");
    By editIconOne=By.id("Edit1");

    By youHaveNotCompletedAllQuestions=By.cssSelector("#ctl00_MainContent_Step1ValidationSummary  p:nth-child(1)");
    By Pleasecheckthedetailsbelowandsubmittheformagain=By.cssSelector("#ctl00_MainContent_Step1ValidationSummary  p:nth-child(2)");
By pleaseSelectYourTitle=By.id("CV__ProposerTitle");
By pleaseEnterYourFirstName=By.id("RF__ProposerForename");
By pleaseEnterYourSurName=By.id("RF__ProposerSurname");
By pleaseEnterYourEmailAddress=By.id("RF__ProposerEmail");
By pleaseEnterYourMobileNumber=By.id("RF__ProposerMobile");
By continueButton=By.name("ctl00$MainContent$Continue1");

By radioElementGroup=By.xpath("//input[@name=\"driver-title\"]/parent::label/parent::li");

//By firstName=By.cssSelector("[id=\"divProposerForenameRE\"] input");
    By firstName=By.id("ctl00_MainContent_ProposerForename");
//By surName=By.cssSelector("[id=\"divProposerSurnameRE\"] input");
    By surName=By.id("ctl00_MainContent_ProposerSurname");

By pleaseEnterCompleteSurname=By.id("RE__ProposerSurnameRE");

//By email=By.cssSelector("[id=\"divProposerEmailRE\"] input");
    By email=By.id("ctl00_MainContent_ProposerEmail");


By emailValidationMessage=By.id("RE__ProposerEmailRE");

By emailHelpIcon=By.cssSelector("[aria-labelledby=\"EmailTooltip\"]");
By emailModalText=By.cssSelector("[id=\"modalDescription\"] p");
By emailModalCloseButton=By.className("o-modal__cancel");

By inputMobileNumber=By.id("ctl00_MainContent_ProposerMobile");

By pleaseEnterValidMobileNumber=By.id("RE__ProposerMobileRE");
By coverMarginBottom=By.cssSelector("p[class=\"CoverBottomMargin\"]");
By aboutYouHeadingButton=By.cssSelector("[id=\"accHeading1\"] button");
public void ClickaboutYouHeadingButton(){
    shortwait.until(ExpectedConditions.elementToBeClickable(aboutYouHeadingButton)).click();
}
public String getFirstName(){
    return getText(firstName);
}
public String getSurname(){
    return getText(surName);
}
public String getEmail(){
    return  getText(email);
}
public String getMobileNumber(){
    return  getText(inputMobileNumber);
}

public void fillCustomerScreenFormAndContinue(customerScreenOneModal customerScreenOneModal){
    selectTitleradioButtonAndReturnClassAttribute(customerScreenOneModal.getTitle());
    sendKeys(firstName,customerScreenOneModal.getFirstname());
    sendKeys(surName,customerScreenOneModal.getLastname());
    sendKeys(email,customerScreenOneModal.getEmail());
sendKeys(inputMobileNumber,customerScreenOneModal.getMobile());
clickContinueButton();
//shortwait.until(ExpectedConditions.attributeToBe(aboutYouHeadingButton,"aria-expanded","false"));
}
JavascriptExecutor js=(JavascriptExecutor) driver;
    public String selectTitleradioButtonAndReturnClassAttributeJS(String option){
       return js.executeScript("return document.getElementById('"+option+"').id").toString();
    }
    public String getFirstNameJS(){
     return    js.executeScript("return document.getElementById('ctl00_MainContent_ProposerForename').value").toString();
    }
    public String getLastNameJS(){
        return    js.executeScript("return document.getElementById('ctl00_MainContent_ProposerSurname').value").toString();
    }
    public String getEmailJS(){
        return    js.executeScript("return document.getElementById('ctl00_MainContent_ProposerEmail').value").toString();
    }
    public String getMobileNumberJS(){
        return    js.executeScript("return document.getElementById('ctl00_MainContent_ProposerMobile').value").toString();
    }



public String getCoverMarginText(){
    return getText(coverMarginBottom);
}

public String getpleaseEnterValidMobileNumberMessage(){
    return getText(pleaseEnterValidMobileNumber);
}
public String getImpDocuments(String text){

    return getText(By.xpath("//h2[text()='"+text+"']"));
}

    public String getpolicyDocuments(String text){

        return getText(By.xpath("//a[text()='"+text+"']"));
    }
    public String getpolicyDocumentsAttribute(String text){

        return driver.findElement(By.xpath("//a[text()='"+text+"']")).getAttribute("href");
    }

    public String getbelowPolicyBlock(String text){

        return getText(By.xpath("//p[text()='"+text+"']"));
    }
    public String getimpInformation(String text){

        return getText(By.xpath("//p[text()='"+text+"']"));
    }

    public String getFooterUrl(String text){
        return driver.findElement(By.xpath("//span[text()='"+text+"']/parent::a")).getAttribute("href");

    }
public String getpleaseEnterValidMobileNumberStyle(){
    return  driver.findElement(pleaseEnterValidMobileNumber).getAttribute("style");
}
public void inputMobileNumber(String number){
    sendKeys(inputMobileNumber,number);
}
public String getPleaseEnterYourMobileNumberStyle(){
    return driver.findElement(pleaseEnterYourMobileNumber).getAttribute("style");
}

public String clickEmailHelpIconAndGetHelptext() throws InterruptedException {
    shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(emailHelpIcon))).click();
    //Thread.sleep(1500);
    return getText(emailModalText);

}

public void closeEmailInfoModal() throws InterruptedException {
    clickEmailHelpIconAndGetHelptext();
    performClick(emailModalCloseButton);
    shortwait.until(ExpectedConditions.invisibilityOf(driver.findElement(emailModalCloseButton)));
    try {
        Thread.sleep(1500);
    }catch (Exception e){

    }

}
public int getCloseEmailModalSize(){
   return driver.findElements(emailModalCloseButton).size();
}
public String getEmailErrorValidationMessage(){
    return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(emailValidationMessage))).getText();
}
    public String getEmailErrorValidationMessageDisplayNone(){
        return driver.findElement(emailValidationMessage).getAttribute("style");
    }
public String getpleaseEnterYourEmailDisplayNone(){
    return shortwait.until(ExpectedConditions.presenceOfElementLocated(pleaseEnterYourEmailAddress)).getAttribute("style");
    }
public void EnterEmailAndContinue(String input) throws InterruptedException {
    shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(email))).sendKeys(input);
    clickContinueButton();
    Thread.sleep(1500);
}




public String getpleaseEnterCompleteSurnameMessage(){
    return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(pleaseEnterCompleteSurname))).getText();
}
    public String getpleaseEnterYourSurnameDisplayNone(){
        return driver.findElement(pleaseEnterYourSurName).getAttribute("style");
    }
public String getpleaseEnterCompleteSurnameMessageSize(){
    return driver.findElement(pleaseEnterCompleteSurname).getAttribute("style");
}
    public void EnterSurnameAndContinue(String input) throws InterruptedException {
        shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(surName))).sendKeys(input);
        clickContinueButton();
        Thread.sleep(1500);
    }

public void EnterFirstNameAndContinue(String input) throws InterruptedException {
    shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(firstName))).sendKeys(input);
    clickContinueButton();
    Thread.sleep(1500);

}



By firstNameErrorValidationMessage=By.id("RE__ProposerForenameRE");
public String getfirstNameErrorValidationMessage(){
    return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(firstNameErrorValidationMessage))).getText();

}
public String getfirstNameErrorValidationMessageSize(){
   return driver.findElement(firstNameErrorValidationMessage).getAttribute("style");
}
public String getpleaseEnterYourFirstNameDisplayNone(){
    return driver.findElement(pleaseEnterYourFirstName).getAttribute("style");
}

public List<WebElement> getRadioElementsGroup(){
    return driver.findElements(radioElementGroup);
}
public String selectTitleradioButtonAndReturnClassAttribute(String option){
    shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(option)))).click();
    return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(option)))).getAttribute("class");
}
public void clickContinueButton(){
     performClick(continueButton);
     invisibleLoading();
}

public String getpleaseEnterYourMobileNumber(){
    return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(pleaseEnterYourMobileNumber))).getText();
}

public String getpleaseEnterYourEmailAddress(){
    return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(pleaseEnterYourEmailAddress))).getText();

}

public String getpleaseEnterYourSurName(){
    return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(pleaseEnterYourSurName))).getText();
}

public String getpleaseEnterYourFirstName(){
    return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(pleaseEnterYourFirstName))).getText();
}

public String getpleaseSelectYourTitle(){
    return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(pleaseSelectYourTitle))).getText();

}
public String getPleasecheckthedetailsbelowandsubmittheformagain(){
    return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(Pleasecheckthedetailsbelowandsubmittheformagain))).getText();
}

public String getyouHaveNotCompletedAllQuestions(){
    return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(youHaveNotCompletedAllQuestions))).getText();
}

    public String getEditIconOneDisabledState(){
        return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(editIconOne))).getAttribute("class");
    }

    public String getAboutYouHeading(){
      return   shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(aboutYou))).getText();
    }
    public String getreadOurDataProtectionNoticeURl(){
        return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(readOurDataProtectionNoticeURl))).getAttribute("href");
    }
    public String getDataProtectionContent(){
        return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(dataProtectionContent))).getText();
    }
    public String getAvivaCarInsuranceHeading(){
        return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(avivaCarInsuranceHeadingInScreenOne))).getText();
    }

    public String getcarInsuranceAndYourPersonalDetailsHeading(){
       return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(carInsuranceAndYourPersonalDetailsHeading)))
                .getText();
    }

    public void waitForVisibilityOfAvivaCarInsuranceHeading(){
        mediumwait.until(ExpectedConditions.visibilityOf(driver.findElement(avivaCarInsuranceHeading)));
    }
    public void clickCreateQuoteButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
      //  shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(createquote))).click();
        driver.get("https://testaviva3.dotsys.co.uk/products/motor/CreateNewQuote.aspx?enc=NUic3N57azQgnbRz7sSkmB2yiwSz8k1TVn8SwmhjvnqqGezVsAHUF97jCZCPKJva");
    }

public void load() {
    load("");
    String currentHandle = driver.getWindowHandle();
    clickCreateQuoteButton();
    Set<String> handles = driver.getWindowHandles();
    for (String actual : handles) {
        if (!actual.equalsIgnoreCase(currentHandle)) {
            driver.switchTo().window(actual);
        }
    }
    waitForVisibilityOfAvivaCarInsuranceHeading();
   try {
       Thread.sleep(3500);
   }catch (Exception e){

   }
   new YourQuote(driver).invisibilityOfLoading();
}

}
