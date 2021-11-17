package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.steps.StepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class DriverUtil {
    public WebDriver getDriver() {
        if (driver == null) {
        	if(StepDefinitions.prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            	WebDriverManager.chromedriver().setup();
    			driver = new ChromeDriver();
        	} else if(StepDefinitions.prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            	WebDriverManager.firefoxdriver().setup();
    			driver = new FirefoxDriver();
        	} else if(StepDefinitions.prop.getProperty("browser").equalsIgnoreCase("edge")) {
        		WebDriverManager.edgedriver().setup();
    			driver = new EdgeDriver();
        	}
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    private WebDriver driver;
}
