package tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestCases {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test(description = "Sign up for mailing address")
    public void test1(){
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Semiha");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("semiha@gmail.com");
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();
        String expectedmessage="Thank you for signing up. Click the button below to return to the home page.";
        String actualmessage=driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actualmessage,expectedmessage);
    }
    @Test(description = "Verify that number of listed examples is equals to 48")
    public void test2(){
      int element=  driver.findElements(By.xpath("//li[@class='list-group-item']")).size();
      Assert.assertEquals(element,48);

    }
    @Test(description = "Verify that message is displayed:Clickes on button one")
    public void test3(){
        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.cssSelector("[onclick='button1()']")).click();
        String expectedResult="Clicked on button one!";
        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(description = "Verify that warning message is displayed")
    public void test4(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("123");
        String expectedmessage="first name can only consist of alphabetical letters";
        String actualmessage=driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        Assert.assertEquals(actualmessage,expectedmessage);
    }
    @Test(description = "Verify that message is displayed for lastname")
    public void test5(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("123");
       String actualmessage= driver.findElement(By.xpath("//small[contains(text(),'The last name can only consist of alphabetical letters and dash')]")).getText();
       String expectedmessage="The last name can only consist of alphabetical letters and dash";
       Assert.assertEquals(actualmessage,expectedmessage);
    }
    @Test(description = "verify that warning message is displayed")
    public void test6(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("user");
        String actualmessage=driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        String expectedmessage="The username must be more than 6 and less than 30 characters long";
        Assert.assertEquals(actualmessage,expectedmessage);
    }
    @Test (description = "Verify that warning message is displayed for email")
    public void test7(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("testers@gmail.com");
        String actualResult=driver.findElement(By.xpath("//small[contains(text(),'Email format is not correct')]")).getText();
        String actualResult2=driver.findElement(By.xpath("//small[contains(text(),'email address is not a valid')]")).getText();
        String expectedResult="Email format is not correct";
        String expectedResult2="email address is not a valid";
        Assert.assertEquals(actualResult2,expectedResult2);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void test8(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("5711234354");
        String actualmessage=driver.findElement(By.xpath("//small[contains(text(),'Phone format is not correct')]")).getText();
        String expectedResult="Phone format is not correct";
        Assert.assertEquals(actualmessage,expectedResult);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}


