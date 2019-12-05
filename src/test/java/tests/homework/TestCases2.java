package tests.homework;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class TestCases2 {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Verify that The date of birth is not valid")
    public void test1(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        String actualmessage=driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]")).getText();
        String expectedmessage="The date of birth is not valid";
        Assert.assertEquals(actualmessage,expectedmessage);


    }
    @Test(description = "Verify that programming language is displayed")
    public void test2(){
        driver.findElement(By.linkText("Registration Form")).click();
        List<WebElement> checkboxes=driver.findElements(By.id("checkbox"));
        for(WebElement checkbox:checkboxes){
            if(checkbox.isEnabled()){
                System.out.println("pass");
            } else {
                System.out.println("fail");
            }
        }

    }
    @Test(description = "verify that message is displayed :first name must be more than 2 and less than 64 characters long")
     public void test3(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("firstname")).sendKeys("a");
        String actualmessage=driver.findElement(By.xpath("//small[contains(text(),'first name must be more than 2 and less than 64 characters long')]")).getText();
        String expectedmessage="first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualmessage,expectedmessage);
    }
    @Test(description = "Verify that message is displaye:The last name must be more than 2 and less than 64 characters long")
    public void test4(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("lastname")).sendKeys("a");
        String actualmessage=driver.findElement(By.xpath("//small[contains(text(),'The last name must be more than 2 and less than 64 characters long')]")).getText();
        String expectedmessage="The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualmessage,expectedmessage);
    }
    @Test(description="Verify that filling registration form")
    public void test5(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("firstname")).sendKeys("Semiha");
        driver.findElement(By.name("lastname")).sendKeys("aksa");
        driver.findElement(By.name("username")).sendKeys("semiha22");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("semiha@gmail.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("semiha123");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("954-918-8495");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("5/4/1984");

        Select select= new Select(driver.findElement(By.name("department"))) ;
        select.selectByValue("AO");

        Select jobTitle=new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByVisibleText("SDET");
        driver.findElement(By.cssSelector("label[for='inlineCheckbox2']")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        String expectedmessage="You've successfully completed registration!";
        String actualmessage=driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(expectedmessage,actualmessage);

    }
    @Test(description = "Verify that subscribing e-mail address")
    public void test6(){
        driver.navigate().to("https://www.tempmailaddress.com/");
        driver.findElement(By.cssSelector("[class='cetc']")).click();
        String copymail=driver.findElement(By.id("email")).getText();
        driver.navigate().to("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("hidayet");
        driver.findElement(By.name("email")).sendKeys(copymail);
        driver.findElement(By.name("wooden_spoon")).click();
        String actualmessage=driver.findElement(By.tagName("h3")).getText();
        String expectedmessage="Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actualmessage,expectedmessage);
        driver.navigate().to("https://www.tempmailaddress.com/");

       driver.findElement(By.xpath("//tbody[@id='schranka']/tr[1]")).click();
       String lastmessage=driver.findElement(By.id("predmet")).getText();
       String last2="Thanks for subscribing to practice.cybertekschool.com!";
       Assert.assertEquals(last2,lastmessage);


    }
    @Test(description = "Verify that upload folder")
    public void Test7(){
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:/Users/mustafa/Desktop/homework.txt");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(3);
        String expectedSubtitle="File Uploaded!";
        String actualSubtitle=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualSubtitle,expectedSubtitle);

        String expecteduploadedfile="homework.txt";
        String actualUploadedfile=driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(expecteduploadedfile,actualUploadedfile);
    }
    @Test(description = "Verify that following message is displayed:you selected usa ")
    public void Test8(){
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States Of America");
        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
        BrowserUtils.wait(2);
        String expectedResult="You selected: United States Of America";
        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expectedResult,actualResult);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
