package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;
    //you cannot do like this, if constructor is private Driver obj=new Driver()
    private Driver(){

    }
    public static WebDriver get(){
        //if webdriver object was not created yet
        if(driver==null){
            String browser=ConfigurationReader.getProperty("browser");
             switch (browser){
                 case "chrome":
                     WebDriverManager.chromedriver().setup();
                     ChromeOptions chromeOptions = new ChromeOptions();
                     chromeOptions.setHeadless(true);
                     driver = new ChromeDriver(chromeOptions);

                     break;
                 case "firefox":
                     WebDriverManager.firefoxdriver().setup();
                     driver=new FirefoxDriver();
                     break;
                 default:
                     //if browser type is wrong, stop tests and throw exception, no browser will be opened
                     throw new RuntimeException("Wrong browser type!");
             }
        }
        return driver;
    }
    public static void close(){
        //if driver still exist
        if(driver != null){
            //close all browsers
            driver.quit();
            //destroy driver object, ready for gc
            driver=null;

        }
    }
}
