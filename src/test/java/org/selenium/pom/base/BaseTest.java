package org.selenium.pom.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.constants.DriverType;
import org.selenium.pom.factory.DriverManagerFactory;
import org.selenium.pom.utils.XLUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static org.selenium.pom.constants.BrowserStackConstants.FAILED;
import static org.selenium.pom.constants.BrowserStackConstants.PASSED;

public class BaseTest {


    public static void markTestStatus(String status, String reason, WebDriver driver) {  // the same WebDriver instance should be passed that is being used to run the test in the calling funtion
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"" + status + "\", \"reason\": \"" + reason + "\"}}");
        } catch (Exception e) {

        }

    }

    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();


    public void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    static ExtentReports extent;
    //  static XLUtils utils;
    static ExtentTest test;

    //   private static final String SHEET="sheet1";
    //  private static final String ExcelFile=System.getProperty("user.dir")+"/reports/sample.xlsx";


    @org.testng.annotations.Parameters("browser")
    @BeforeTest
    public void extent(@Optional String browser, Method name) throws IOException {
        String path1 = System.getProperty("user.dir") + "/reports/" + browser + ".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path1);
        reporter.config().setReportName("Dotsys");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();

        extent.attachReporter(reporter);
        extent.setSystemInfo("user", "Sumanth");
        //   utils=new XLUtils();

    }

    @Parameters({"local", "browser", "USERNAME", "KEY", "browserName", "browserVersion", "os", "osVersion", "seleniumVersion", "build"})
    @BeforeMethod
    public void setup(@Optional("true") boolean local, @Optional String browser, Method name, @Optional String USERNAME, @Optional String KEY, @Optional String browserName, @Optional String browserVersion, @Optional String os, @Optional String osVersion, @Optional String seleniumVersion, @Optional String build) throws MalformedURLException {
        if (local && browser == null) {
            setDriver(DriverManagerFactory.getDriverFactory(DriverType.valueOf("CHROME")).createdriver());
        } else if (local && (browser != null)) {
            System.out.println("true block executed");
            setDriver(DriverManagerFactory.getDriverFactory(DriverType.valueOf(browser)).createdriver());
        } else {

            setBrowserStack(name.getDeclaringClass() + "-" + name.getName(), USERNAME, KEY, browserName, browserVersion, os, osVersion, seleniumVersion, build);
        }


    }


    @Parameters("browser")
    @AfterMethod
    public void teardown(ITestResult result, @Optional String browser, Method methodName) throws IOException {
        if (result.getStatus() == ITestResult.SUCCESS) {


            //     int rowNum= utils.getRowCount(ExcelFile,SHEET)+1;
            //   System.out.println(rowNum);
            try {
                Object[] params = result.getParameters();
                String data = (String) params[0];
                //   utils.setCellData(ExcelFile,SHEET,rowNum,0,methodName.getName()+"with data "+data);
                test = extent.createTest(result.getTestClass().getName() + "-" + result.getMethod().getMethodName() + "with data " + data);
            } catch (Exception e) {
                test = extent.createTest(result.getTestClass().getName() + "-" + result.getMethod().getMethodName());
                // utils.setCellData(ExcelFile,SHEET,rowNum,0,methodName.getName());

            }


            //  utils.setCellData(ExcelFile,SHEET,rowNum,1,"pass");
            //    System.out.println("Method name"+test);
            test.log(Status.PASS, "Test Passed");


            extent.flush();
        } else if (result.getStatus() == ITestResult.FAILURE) {
            //   int rowNum= utils.getRowCount(ExcelFile,SHEET)+1;
            //   System.out.println(rowNum);


            try {
                Object[] params = result.getParameters();
                String data = (String) params[0];
                test = extent.createTest(result.getTestClass().getName() + "-" + result.getMethod().getMethodName() + "with data " + data);
                //   utils.setCellData(ExcelFile,SHEET,rowNum,0,methodName.getName()+"with data "+data);


            } catch (Exception e) {
                test = extent.createTest(result.getTestClass().getName() + "-" + result.getMethod().getMethodName());
                //     utils.setCellData(ExcelFile,SHEET,rowNum,0,methodName.getName());

            }
            //  utils.setCellData(ExcelFile,SHEET,rowNum,1,"Fail ");
            //  utils.setCellData(ExcelFile,SHEET,rowNum,2,result.getThrowable().toString());


            // System.out.println("Method name"+test);
            //Screenshot
            test.log(Status.FAIL, result.getThrowable());

            String testMethodName = result.getTestClass().getName() + "_" + result.getMethod().getMethodName();


            try {
                test.addScreenCaptureFromBase64String(takeScreenShot(testMethodName), result.getTestClass().getName() + "-" + result.getMethod().getMethodName());

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            extent.flush();


        }
        //  if(result.getStatus()==ITestResult.SUCCESS) {
        getDriver().quit();
        //}
    }


    public String takeScreenShot(String testCaseName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);


        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(src, new File(destinationFile));
        File dest = new File(destinationFile);
        byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(dest));
        return new String(encoded, StandardCharsets.US_ASCII);
    }


    public void setBrowserStack(String methodNAme, String USERNAME, String AUTOMATE_KEY, String browserName
            , String browserVersion, String os, String osVersion, String seleniumVersion, String build) throws MalformedURLException {


        final String URL1 = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("os", os);
        browserstackOptions.put("osVersion", osVersion);
        browserstackOptions.put("local", "false");
        browserstackOptions.put("seleniumVersion", seleniumVersion);
        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("build", build);
        capabilities.setCapability("name", methodNAme);
        setDriver(new RemoteWebDriver(new URL(URL1), capabilities));
    }

    public void setTestStatus(String status, boolean Status, String content) {
        markTestStatus(status, content, getDriver());
        Assert.assertTrue(Status, content);
    }

    public void passStatus(String reason) {
        setTestStatus(PASSED, true, reason);
    }

    public void failStatus(String reason) {
        setTestStatus(FAILED, false, reason);
    }


}


