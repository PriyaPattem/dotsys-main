package org.selenium.pom.dataProvider;

import org.testng.annotations.DataProvider;

public class InsuranceDetailsDataProvider {
    @DataProvider(name="getInsuranceOptions",parallel = false)
    public Object[][] getInsuranceOptions(){
        return new Object[][]{{"I currently have insurance in my own name in Ireland/UK","1"},
                {"I currently have insurance in my own name in Ireland/UK","5+"}};
    }
}
