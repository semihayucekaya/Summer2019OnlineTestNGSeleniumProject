package tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class myFirstSeleniumScript {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver=new ChromeDriver();

        driver.get("http://google.com");
        //to read page title,there is method .getTitle();

        //Test 1.Verify that of the page is a "Google"
        String actualResult=driver.getTitle();
        String expectedResult="Google";
        if(actualResult.equals(expectedResult)){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");

        }

        //to close browser


    }
}
