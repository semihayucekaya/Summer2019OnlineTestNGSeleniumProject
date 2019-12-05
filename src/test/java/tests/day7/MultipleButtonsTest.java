package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class MultipleButtonsTest {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }
    @Test
    public void verifyButton1(){
        String expectedResult="Clicked on button one!";
        driver.findElement(By.xpath("//*[text()='Button 1']"));
        String actualResult=driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Result is wrong");
    }
    @AfterMethod
    public void teardown(){
       driver.quit();
    }
}
