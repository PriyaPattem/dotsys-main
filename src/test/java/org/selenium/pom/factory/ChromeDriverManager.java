package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeDriverManager implements DriverManager{

    @Override
    public WebDriver createdriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
          options.addArguments("--headless");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}