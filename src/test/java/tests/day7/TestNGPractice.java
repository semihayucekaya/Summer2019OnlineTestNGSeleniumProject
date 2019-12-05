package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {
    @Test
    public void test() {
        //to verify that expected and actual result is the same
        //if no -it will throw exception and atop the program
        //also,you will see in the console what was expected
        //and what was actually
        Assert.assertEquals("appl", "apple");
        //  if(str.equals(str1)){
        //      System.out.println("passed");
        // } else {
        //      System.out.println("test failed");
        //  }
    }


    @Test(description="Verifying title of the practice website")
    public void verifyTitle() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/");
         String expectedTitle="Practice";
         String actualTitle=driver.getTitle();
         Assert.assertEquals(actualTitle,expectedTitle,"Title is wrong");
         driver.quit();
    }
    @Test (description="Verify that heading is displayed")
    public void verifyHeadingIsDisplayed(){
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        WebElement heading=driver.findElement(By.xpath("//span['text()='Test Automation Practice']"));
        Assert.assertTrue(heading.isDisplayed(),"Element is not visible");
        driver.quit();

    }
}