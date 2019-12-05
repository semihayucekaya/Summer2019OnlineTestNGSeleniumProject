package tests.day3;

import utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();//to maximize browser window
        driver.get("http://google.com");
        //wait for 3 seconds
        //this is our custom methods
        //since method is static, we use class name to call the method
        //as a parameter,we provide number of seconds
        BrowserUtils.wait(3);
        //how to print title
        System.out.println(driver.getTitle());
        driver.navigate().to("http://amazon.com");
        //navigate back to google
        driver.navigate().back();
        //move forward to the amazon again
        driver.navigate().forward();
        //to refresh  relpoad a webpage website
        driver.navigate().refresh();
        //shutdown browser
        driver.quit();
        //if tab only one,close() will shutdown browser
        //and we cannot use driver any more
        //so we have to recreated an object ofWebDriver
        //what will happened, if i will call driver again
        //aftyer quit
        driver.get("http://google.com");
    }
}
