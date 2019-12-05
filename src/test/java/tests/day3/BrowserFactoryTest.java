package tests.day3;

import utils.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class BrowserFactoryTest {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //how we can print a source code of the page?
        //getDriver() method will return webdriver object
        //and we can use reference variable to work with that object
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        System.out.println(driver.getPageSource());
        //TO FINISH TEST EXECUTION
        driver.quit();
    }
}
