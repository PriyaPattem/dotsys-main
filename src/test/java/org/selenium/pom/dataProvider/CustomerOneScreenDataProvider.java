package org.selenium.pom.dataProvider;

import org.testng.annotations.DataProvider;

public class CustomerOneScreenDataProvider {

    @DataProvider(name ="getTitles",parallel = false )
    public Object[][] getRadioTitles(){

       return new Object[][]{{"Mr"},{"Mrs"},{"Miss"},{"Ms"}};


    }
    @DataProvider(name ="getvalidFirstNames",parallel = false )
    public Object[][] getvalidFirstNames(){
        return new Object[][]{{"ww"},{"w_"},{"sumanth_',._"},{"samplecharactercounddataa"}};
    }

    @DataProvider(name ="getInvalidFirstNames",parallel = false )
    public Object[][] getInvalidFirstNames(){
        return new Object[][]{{"w"},{"11"},{"sumanth@"},{"sumant1@"},{"samplecharactercoundda##1"}};
    }
   @DataProvider(name="getValidEmails",parallel = false)
    public Object[][] getvalidEmails(){
        return new Object[][]{{"sumanth@gmail.com"},{"1@1.ie"},{"1wwe@1see.co.uk"},{"wW@GT1.com"},{"www@www.co.uk"}
        ,{"WWW@WWW.IE"},{"111@111.ie"}};
    }
    @DataProvider(name="getInValidEmails",parallel = false)
    public Object[][] getInvalidEmails(){
        return new Object[][]{{"11!2@ddd.ddd"},{"111@111.11"},{"WWW@g$.ie"}};
    }

    @DataProvider(name="getValidMobileNumber",parallel = false)
    public Object[][] getvalidMobileNumber(){
        return new Object[][]{{"111111111"},{"111111111111111"},{"223344556678"}};
    }
    @DataProvider(name="getInValidMobileNumber",parallel = false)
    public Object[][] getInvalidMobileNumber(){
        return new Object[][]{{"11"},{"11111"},{"11111111"},{"skks89"},{"111111111&*!"}};
    }


}
