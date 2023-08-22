package org.selenium.pom.dataProvider;

import org.testng.annotations.DataProvider;

public class YourClaimsDataProvider {
    @DataProvider(name="addclaims",parallel = false)
    public Object[][] getaddclaims(){
        return new Object[][]{{"Fire","01/01/2022","55555"},
                {"Theft","01/01/2022","66666"},
                {"Vandalism","01/01/2022","55"}};
    }
    @DataProvider(name="updateclaims",parallel = false)
    public Object[][] getupdateclaims(){
        return new Object[][]{{"Fire","01/01/2022","55555","02/02/2022","8888"},
                {"Theft","01/01/2022","66666","02/02/2022","999"},
                {"Vandalism","01/01/2022","55","02/02/2022","222"}};
    }
}
