package tests.day9_review;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;


public class TestNGReview {
    private WebDriver driver;

    //whatever is common among tests,can go into @beforemethod and @aftermethod
    @BeforeMethod
    public void setup() {
        System.out.println("Before method!");
        driver = BrowserFactory.getDriver("chrome");

    }

    @AfterMethod
    public void teardown() {
        System.out.println("After Method!");
        driver.quit();
    }

    @Test(description = "Verify title of google.com", priority = 2)
    public void test1() {
        System.out.println("Test 1!");
        driver.get("http://google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not correct!");
    }

    @Test(description = "Verify title of apple.com", priority = 1)
    //priority will change the order of test execution
    //by default tests are running in alphabet order(a,b,c....from the method name)
    //lower priority -earlier execution
    //lower priority number-higher priority of execution
    //tests will run like this :priority 1-priority2
    //default 0
    public void verifyApplesPageTitle() {
        System.out.println("Test 2");
        driver.get("https://www.apple.com/");
        String expectedTitle = "Apple";
        String actualTitle = driver.getTitle();
        //message will be printed only if assertion failed
        Assert.assertEquals(expectedTitle, actualTitle, "Title is not correct!");
        //if assertion,line below will not be printed
        //if assertion passed,you will see message from line below
        System.out.println("Test passed!");


    }

    //data provider can supply test with a test data. Also, it allows to do Data Driven Testing.
    //What is this?It's when same test runs multiple times with different test data set
    @DataProvider(name = "testData")
    public static Object[][] testData() {
        return new Object[][]{{"http://www.apple.com", "Apple"}, {"http://google.com", "Google"}};
    }
    //data provider must return 2d array of Object
    //1st parameter  = 1 object in the inner array, 2nd parameter = 2 object in the inner array
    // url = https://www.apple.com/, title = Apple
    // url = http://google.com, title = Google
    //we can have as many sets of data as we want

    @Test(dataProvider = "testData")
    public void testWithDataProvider(String url, String title) {
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }
}