package org.selenium.pom.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProvider.CustomerOneScreenDataProvider;
import org.selenium.pom.objects.customerScreenOneModal;
import org.selenium.pom.pages.CustomerScreenOne;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.io.IOException;

import static org.selenium.pom.constants.BrowserStackConstants.*;
import static org.selenium.pom.constants.DotSysConstants.DISPLAYNONE;

public class CustomerScreenOnetests extends BaseTest {


    @Test
    public void verifyCarInsuranceAndYourPersonalDetailsHeadingInCustomerScreenOne(){

        CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
        customerScreenOne.load();

        if(customerScreenOne.getcarInsuranceAndYourPersonalDetailsHeading().equals("Car insurance Your personal details")){

         setTestStatus(PASSED,true,"Able to verify Heading");

        }else {
            setTestStatus(FAILED,false,"Unable to verify text");

        }
    }


    @Test
    public void verifyAvivaCarInsuranceHeadingInCustomerScreenOne(){
CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
customerScreenOne.load();
if(customerScreenOne.getAvivaCarInsuranceHeading().equals("Aviva car insurance")){
    setTestStatus(PASSED,true,"Able to verify text");

}else {
    setTestStatus(FAILED,false,"Unable to verify Heading");


}
    }


    @Test
    public void  verifyDataProtectionNoticeInContentInCustomerscreenOne(){
        CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
        customerScreenOne.load();
       if(customerScreenOne.getDataProtectionContent().equals("At Aviva, we take your privacy seriously. Read our Data Protection Notice\n" +
               "Please remember that you are under a duty to answer all questions, which we ask, honestly and with reasonable care.")){
         setTestStatus(PASSED,true,"Content verification Passed");

       }else {
          setTestStatus(FAILED,false,"Data Protection Notice Content Verification failed");
       }
    }

    @Test
    public void verifyDataProtectionNoticeURLInCustomerScreenOne(){
        CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
        customerScreenOne.load();
//System.out.println(customerScreenOne.getreadOurDataProtectionNoticeURl());
        if(customerScreenOne.getreadOurDataProtectionNoticeURl().equals("https://www.aviva.ie/about-and-support/privacy/data-privacy-summary-direct/")){
           setTestStatus(PASSED,true,"Able to verify url");
        }else {
            setTestStatus(FAILED,false,"Unable to verify url");
        }



    }

    @Test
    public void verifyAboutYouHeadingInCustomerScreenOne(){
        CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
        customerScreenOne.load();
        if(customerScreenOne.getAboutYouHeading().equals("About you")){
            setTestStatus(PASSED,true,"Able to verify About You heading");
        }else {
            setTestStatus(FAILED,false,"Unable to verify About You heading");
        }
    }

    @Test
    public void verifyEditIconDisableStateForFirstTimeAccessInCustomerScreenOne() throws InterruptedException {
        CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
        customerScreenOne.load();
        Thread.sleep(6000);
        if(customerScreenOne.getEditIconOneDisabledState().contains("icondisabled")){
            setTestStatus(PASSED,true,"Able to verify edit icon disability status");
        }else {
            setTestStatus(FAILED,false,"Unable to verify edit icon disability status");
        }
    }
    @Test
    public void verifyErrorMessagesIfUserClicksOnContinueWithOutFillingDetailsInCustomerScreenOne(){
        CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
        boolean error=false;
        String reason=" ";
        customerScreenOne.load();
        customerScreenOne.clickContinueButton();
        if(!(customerScreenOne.getyouHaveNotCompletedAllQuestions().equals("You have not completed all questions"))){
            error=true;
            reason=reason+"You have not completed all questions";
        }



       if(!(customerScreenOne.getPleasecheckthedetailsbelowandsubmittheformagain().equals("Please check the details below and submit the form again"))){
            error=true;
            reason=reason+"Please check the details below and submit the form again";
        }
              if(!( customerScreenOne.getpleaseSelectYourTitle().equals("Please select your title"))){
                  error=true;
                  reason=reason+"Please select your title";
        }
                if(!( customerScreenOne.getpleaseEnterYourFirstName().equals("Please enter your first name"))){

                }
                if(!(customerScreenOne.getpleaseEnterYourSurName().equals("Please enter your surname"))) {

                }
                if(!(  customerScreenOne.getpleaseEnterYourEmailAddress().equals("Please enter your email address"))){

                }

                if(!(customerScreenOne.getpleaseEnterYourMobileNumber().equals("Please enter your mobile number"))) {
                    error=true;
                    reason=reason+"Please enter your mobile number";
                }
     if(!(error)){
            setTestStatus(PASSED,true,"Validation messages verification passed");

        }else {
            setTestStatus(FAILED,false,"Validation messages verification failed"+reason);
        }

    }


int getSelectedRadioButtonSize(WebDriver driver) throws InterruptedException {

        int size=0;
    CustomerScreenOne customerScreenOne=new CustomerScreenOne(driver);
    for(WebElement option:customerScreenOne.getRadioElementsGroup()){
        if(option.getAttribute("class").contains("checked")){
            size++;
        }
    }
return size;

}
   @Test(dataProvider = "getTitles",dataProviderClass = CustomerOneScreenDataProvider.class)
   public void verifyTheTitleRadioButtonSelectionInCustomerScreenOne(String title) throws InterruptedException {
       CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
       customerScreenOne.load();
       System.out.println(customerScreenOne.selectTitleradioButtonAndReturnClassAttribute(title));
       if (customerScreenOne.selectTitleradioButtonAndReturnClassAttribute(title).contains("checked")
       && getSelectedRadioButtonSize(getDriver())==1){
           setTestStatus(PASSED,true,"Only One option Can be Checked at a time");
       }else {
           setTestStatus(FAILED,false,"Failed to select One Option at a time");
       }

   }

   @Test(dataProvider ="getvalidFirstNames",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifyFirstNameValidCasesInCustomerScreen(String validname) throws InterruptedException {
       CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
       customerScreenOne.load();
customerScreenOne.EnterFirstNameAndContinue(validname);

if((customerScreenOne.getfirstNameErrorValidationMessageSize().contains(DISPLAYNONE)) &&( customerScreenOne.getpleaseEnterYourFirstNameDisplayNone().contains(DISPLAYNONE))){
    setTestStatus(PASSED,true,"Valid data Criteria passed");
}else {
    setTestStatus(FAILED,false,"Unable to accept valid data");
}



   }

    @Test(dataProvider ="getInvalidFirstNames",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifyFirstNameInvalidCasesInCustomerScreen(String invalidName) throws InterruptedException {
       CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
       customerScreenOne.load();
       customerScreenOne.EnterFirstNameAndContinue(invalidName);
        if(customerScreenOne.getfirstNameErrorValidationMessage().equals("Please enter your complete first name")){
            setTestStatus(PASSED,true,"InValid data Criteria passed");
        }else {
            setTestStatus(FAILED,false,"Unable to verify Please enter your complete first name error message");
        }

   }

    @Test(dataProvider ="getvalidFirstNames",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifySurNameValidCasesInCustomerScreen(String validname) throws InterruptedException {
        CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
        customerScreenOne.load();
        customerScreenOne.EnterSurnameAndContinue(validname);

        if((customerScreenOne.getpleaseEnterYourSurnameDisplayNone().contains(DISPLAYNONE)) &&( customerScreenOne.getpleaseEnterYourSurnameDisplayNone().contains(DISPLAYNONE))){
            setTestStatus(PASSED,true,"Valid data Criteria passed");
        }else {
            setTestStatus(FAILED,false,"Unable to accept valid data");
        }



    }

    @Test(dataProvider ="getInvalidFirstNames",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifySurNameInvalidCasesInCustomerScreen(String invalidName) throws InterruptedException {
        CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
        customerScreenOne.load();
        customerScreenOne.EnterSurnameAndContinue(invalidName);
        System.out.println(customerScreenOne.getpleaseEnterCompleteSurnameMessage());
        if(customerScreenOne.getpleaseEnterCompleteSurnameMessage().equals("Please enter your complete surname")){
            setTestStatus(PASSED,true,"InValid data Criteria passed");
        }else {
            setTestStatus(FAILED,false,"Unable to verify Please enter your complete sur name error message");
        }

    }

    @Test(dataProvider ="getValidEmails",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifyEmailValidCasesInCustomerScreen(String validname) throws InterruptedException {
        CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
        customerScreenOne.load();
        customerScreenOne.EnterEmailAndContinue(validname);
System.out.println(customerScreenOne.getEmailErrorValidationMessageDisplayNone());
System.out.println(customerScreenOne.getpleaseEnterYourEmailDisplayNone().contains(DISPLAYNONE));
        if((customerScreenOne.getEmailErrorValidationMessageDisplayNone().contains(DISPLAYNONE) &&( customerScreenOne.getpleaseEnterYourEmailDisplayNone().contains(DISPLAYNONE)))){
            setTestStatus(PASSED,true,"Valid data Criteria passed");
        }else {
            setTestStatus(FAILED,false,"Unable to accept valid data");
        }



    }

    @Test(dataProvider ="getInValidEmails",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifyEmailInValidCasesInCustomerScreen(String invalidName) throws InterruptedException {
        CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
        customerScreenOne.load();
        customerScreenOne.EnterEmailAndContinue(invalidName);
        System.out.println(customerScreenOne.getEmailErrorValidationMessage());
        if(customerScreenOne.getEmailErrorValidationMessage().contains("Your email does not match the standard format for emails e.g. jsmith@som.ie")&&
                customerScreenOne.getEmailErrorValidationMessage().contains("Please review and amend your email address")){
            setTestStatus(PASSED,true,"InValid data Criteria passed");
        }else {
            setTestStatus(FAILED,false,"Unable to verify Please enter your complete sur name error message");
        }

    }

@Test

    public void verifyEmailHelpModalTextInCustomerScreenOne() throws InterruptedException {
    CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
    customerScreenOne.load();

    if(customerScreenOne.clickEmailHelpIconAndGetHelptext().equals("If you buy an Aviva policy, we'll use this email to contact you. Please enter an email address that you regularly use.")){
        setTestStatus(PASSED,true,"Able to verify mail help content");
    }else {
        setTestStatus(FAILED,false,"Unable to verify mail help content ");
    }

}

@Test
    public void verifyTheEmailHelpModalCloseActionInCustomerScreenOne() throws InterruptedException {
    CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
    customerScreenOne.load();
    customerScreenOne.closeEmailInfoModal();
    System.out.println(customerScreenOne.getCloseEmailModalSize());
    if(customerScreenOne.getCloseEmailModalSize()==0){
        setTestStatus(PASSED,true,"Able to close modal");

    }else {
        setTestStatus(FAILED,false,"Unable to close modal");
    }
}

@Test(dataProvider = "getValidMobileNumber",dataProviderClass = CustomerOneScreenDataProvider.class)
    public void verifyValidMobileNumberInCustomerScreenOne(String number){
    CustomerScreenOne customerScreenOne=new CustomerScreenOne(getDriver());
    customerScreenOne.load();
    customerScreenOne.inputMobileNumber(number);
    customerScreenOne.clickContinueButton();
    if(customerScreenOne.getPleaseEnterYourMobileNumberStyle().contains(DISPLAYNONE)&& customerScreenOne
            .getpleaseEnterValidMobileNumberStyle().contains(DISPLAYNONE)){
        setTestStatus(PASSED,true,"Able to accept valid mobile number");
    }else {
        setTestStatus(FAILED,false,"Unable to accept vallid mobile number");
    }

}



@Test(dataProvider = "getInValidMobileNumber",dataProviderClass = CustomerOneScreenDataProvider.class)
public void verifyInValidMobileNumberInCustomerScreenOne(String number) throws InterruptedException {
    CustomerScreenOne customerScreenOne = new CustomerScreenOne(getDriver());
    customerScreenOne.load();
    customerScreenOne.inputMobileNumber(number);
    customerScreenOne.clickContinueButton();

    System.out.println(customerScreenOne.getpleaseEnterValidMobileNumberMessage());
    if(customerScreenOne.getpleaseEnterValidMobileNumberMessage().equals("Please enter a valid mobile number")){

        setTestStatus(PASSED,true,"Able to display validation message");
    }else {
        setTestStatus(FAILED,false,"Unable to display error validation message");
    }


    }
    String policyDocuments="policy documents";
    @Test
    public void verifyFooterBlockContentVerificationInScreenOne(){
        boolean error=false;
        String reason=" ";
String impDocuments="Important documents";
String impInformation="Important information about your quote can be found in ";

String belowPolicyBlock="Aviva Direct Ireland Limited is regulated by the Central Bank of Ireland. Car insurance and home insurance are underwritten by Aviva Insurance Ireland DAC.";
String coverMarginBotton="Aviva Insurance Ireland Designated Activity Company, trading as Aviva, is regulated by the Central Bank of Ireland. A private company limited by shares. Authorisation number C171485. Registered in Ireland No. 605769. Registered Office: One Park Place, Hatch Street, Dublin 2, Ireland, D02 E651.";
        CustomerScreenOne customerScreenOne = new CustomerScreenOne(getDriver());
        customerScreenOne.load();
System.out.println(customerScreenOne.getImpDocuments(impDocuments));
        System.out.println(customerScreenOne.getimpInformation(impInformation));
        System.out.println(customerScreenOne.getpolicyDocuments(policyDocuments));
        System.out.println(customerScreenOne.getbelowPolicyBlock(belowPolicyBlock));
        System.out.println(customerScreenOne.getCoverMarginText());
        if(!(customerScreenOne.getImpDocuments(impDocuments).equals(impDocuments))){
            error=true;
            reason=reason+ impDocuments;
        }
        if(!(customerScreenOne.getimpInformation(impInformation).contains(impInformation))){
            error=true;
            reason=reason+ impInformation;
        }
        if(!(customerScreenOne.getpolicyDocuments(policyDocuments).contains(policyDocuments))){
            error=true;
            reason=reason+ policyDocuments;
        }
        if(!(customerScreenOne.getbelowPolicyBlock(belowPolicyBlock).equals(belowPolicyBlock))){
            error=true;
            reason=reason+ belowPolicyBlock;
        }

        if(!(customerScreenOne.getCoverMarginText().contains(coverMarginBotton))) {
            error=true;
            reason=reason+ coverMarginBotton;
        }
        if(!(error)){
            setTestStatus(PASSED,true,"Able to verify footer content");
        }else {
            setTestStatus(FAILED,false,"Unable to verify footer content" + reason);
        }

}


@Test
    public void verifyThePolicyDocumentsURlInCustom(){
    CustomerScreenOne customerScreenOne = new CustomerScreenOne(getDriver());
    customerScreenOne.load();
  System.out.println(  customerScreenOne.getpolicyDocumentsAttribute(policyDocuments));
  if( customerScreenOne.getpolicyDocumentsAttribute(policyDocuments).equals("https://www.aviva.ie/about-and-support/document-archive/")){
      setTestStatus(PASSED,true,"Able to verify link");
  }else {
      setTestStatus(FAILED,false,"Unable to verify link");
  }


}


@Test
    public void verifyFooterLinksInCustomerOne(){
        String reason=" ";
        boolean error= true;
        String contactus="Contact us";
        String contactusUrl="https://www.aviva.ie/about-and-support/contact-us/";
        String Accessibility="Accessibility";
        String Accessibilityurl="https://www.aviva.ie/about-and-support/accessibility/";
        String Privacypolicy="Privacy policy";
        String Privacypolicyurl="https://www.aviva.ie/about-and-support/privacy/";
        String Cookiepolicy="Cookie policy";
        String CookiepolicyUrl="https://www.aviva.ie/about-and-support/cookie-policy/";
        String Managecookies="Manage cookies";
        String ManageCookiesUrl="https://www.aviva.ie/about-and-support/cookie-policy/#onetrust-consent-sdk";
        String TermsAndConditions="Terms and conditions";
                String TermsAndConditionsurl="https://www.aviva.ie/about-and-support/terms/";

    CustomerScreenOne customerScreenOne = new CustomerScreenOne(getDriver());
    customerScreenOne.load();
System.out.println(customerScreenOne.getFooterUrl(contactus));
    if(!(customerScreenOne.getFooterUrl(contactus).equals(contactusUrl))){
        error=false;
        reason=reason+" unable to verify contact us url";
    }
    if(!(customerScreenOne.getFooterUrl(Accessibility).equals(Accessibilityurl))){
        error=false;
        reason=reason+" unable to verify accessbility url";
    }
    if(!(customerScreenOne.getFooterUrl(Privacypolicy).equals(Privacypolicyurl))){
        error=false;
        reason=reason+" unable to verify Privacypolicyurl";
    }
    if(!(customerScreenOne.getFooterUrl(Cookiepolicy).equals(CookiepolicyUrl))){
        error=false;
        reason=reason+" unable to verify CookiepolicyUrl";
    }
    if(!(customerScreenOne.getFooterUrl(Managecookies).equals(ManageCookiesUrl))){
        error=false;
        reason=reason+" unable to verify ManageCookiesUrl";
    }
    if(!(customerScreenOne.getFooterUrl(TermsAndConditions).equals(TermsAndConditionsurl))){
        error=false;
        reason=reason+" unable to verify TermsAndConditionsurl";
    }

    if(error){
        setTestStatus(PASSED,true,"Able to verify footer url");
    }else {
        setTestStatus(FAILED,false,"Unable to verify "+reason);


    }

}

void savingdatainScreenOne(int modalid,CustomerScreenOne customerScreenOne) throws InterruptedException, IOException {
    boolean error=false;
    String reason=" ";

    customerScreenOneModal customerScreenOneModal=new customerScreenOneModal(modalid);
    System.out.println(customerScreenOneModal.getEmail());
    System.out.println(customerScreenOneModal.getTitle());
    customerScreenOne.fillCustomerScreenFormAndContinue(customerScreenOneModal);
    customerScreenOne.ClickaboutYouHeadingButton();

    System.out.println(customerScreenOne.selectTitleradioButtonAndReturnClassAttribute(customerScreenOneModal.getTitle()));
    System.out.println(customerScreenOne.getFirstName());
    System.out.println(customerScreenOne.getSurname());
    System.out.println(customerScreenOne.getEmail());
    System.out.println(customerScreenOne.getMobileNumber());
    if (!(customerScreenOne.selectTitleradioButtonAndReturnClassAttribute(customerScreenOneModal.getTitle()).contains("checked")
            && getSelectedRadioButtonSize(getDriver())==1)){
        error=true;
        reason=reason+"Title verification failed";
    }

  /*  if(!(customerScreenOne.getFirstName().equals(customerScreenOneModal.getFirstname()))){
        error=true;
        reason=reason+"first name verification failed";
    }
    if(!(customerScreenOne.getSurname().equals(customerScreenOneModal.getLastname()))){
        error=true;
        reason=reason+"sur name verification failed";
    }
    if(!(customerScreenOne.getEmail().equals(customerScreenOneModal.getEmail()))){
        error=true;
        reason=reason+"Email verification failed";
    }
    if(!(customerScreenOne.getMobileNumber().equals(customerScreenOneModal.getMobile()))){
        error=true;
        reason=reason+"Mobile verification failed";
    }*/
    if(!(error)){
        setTestStatus(PASSED,true,"Able to verify details");
    }else {
        setTestStatus(FAILED,false,"Unable to verify details "+reason);
    }

}

@Test
    public void verifySavingdataInCustomerScreenOne() throws IOException, InterruptedException {
    CustomerScreenOne customerScreenOne = new CustomerScreenOne(getDriver());
    customerScreenOne.load();
    savingdatainScreenOne(1,customerScreenOne);
    customerScreenOneModal customerScreenOneModal=new customerScreenOneModal(1);

System.out.println(customerScreenOne.selectTitleradioButtonAndReturnClassAttributeJS(customerScreenOneModal.getTitle()));
    System.out.println(customerScreenOne.getFirstNameJS());
    System.out.println(customerScreenOne.getLastNameJS());
    System.out.println(customerScreenOne.getEmailJS());
    System.out.println(customerScreenOne.getMobileNumberJS());

    String reason=" ";
    boolean error=false;
    if(!(customerScreenOne.selectTitleradioButtonAndReturnClassAttributeJS(customerScreenOneModal.getTitle()).equals(customerScreenOneModal.getTitle()))){
        error=true;
        reason=reason+"Unable to verify title";


    }
    if(!(customerScreenOne.getFirstNameJS().equals(customerScreenOneModal.getFirstname()))){
        error=true;
        reason=reason+"Unable to verify firstname";


    }
    if(!(customerScreenOne.getLastNameJS().equals(customerScreenOneModal.getLastname()))){
        error=true;
        reason=reason+"Unable to verify surname";


    }
    if(!(customerScreenOne.getEmailJS().equals(customerScreenOneModal.getEmail()))){
        error=true;
        reason=reason+"Unable to verify email";


    }
    if(!(customerScreenOne.getMobileNumberJS().equals(customerScreenOneModal.getMobile()))){
        error=true;
        reason=reason+"Unable to verify mobile number";


    }
    if(!(error)){
        passStatus("Able to verify data");
    }else {
        failStatus("Unable to verify data"+reason);
    }

}

@Test
    public void updatingDataInCustomerScreenOne() throws IOException, InterruptedException {
    CustomerScreenOne customerScreenOne = new CustomerScreenOne(getDriver());
    customerScreenOne.load();
    savingdatainScreenOne(1,customerScreenOne);
    Thread.sleep(1500);
    savingdatainScreenOne(2,customerScreenOne);
    customerScreenOneModal customerScreenOneModal=new customerScreenOneModal(2);
    System.out.println(customerScreenOne.selectTitleradioButtonAndReturnClassAttributeJS(customerScreenOneModal.getTitle()));
    System.out.println(customerScreenOne.getFirstNameJS());
    System.out.println(customerScreenOne.getLastNameJS());
    System.out.println(customerScreenOne.getEmailJS());
    System.out.println(customerScreenOne.getMobileNumberJS());

    String reason=" ";
    boolean error=false;
    if(!(customerScreenOne.selectTitleradioButtonAndReturnClassAttributeJS(customerScreenOneModal.getTitle()).equals(customerScreenOneModal.getTitle()))){
        error=true;
        reason=reason+"Unable to verify title";


    }
    if(!(customerScreenOne.getFirstNameJS().equals(customerScreenOneModal.getFirstname()))){
        error=true;
        reason=reason+"Unable to verify firstname";


    }
    if(!(customerScreenOne.getLastNameJS().equals(customerScreenOneModal.getLastname()))){
        error=true;
        reason=reason+"Unable to verify surname";


    }
    if(!(customerScreenOne.getEmailJS().equals(customerScreenOneModal.getEmail()))){
        error=true;
        reason=reason+"Unable to verify email";


    }
    if(!(customerScreenOne.getMobileNumberJS().equals(customerScreenOneModal.getMobile()))){
        error=true;
        reason=reason+"Unable to verify mobile number";


    }
    if(!(error)){
        passStatus("Able to verify data");
    }else {
        failStatus("Unable to verify data"+reason);
    }
}
@Test(enabled = false)
    public void dummy(){
        getDriver().get("https://google.com");
        passStatus("unable to verify");
}
}
