package vyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.name("_username")).sendKeys("storemanager85");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Actions action=new Actions(driver);
        WebElement activitiesElement= driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        action.moveToElement(activitiesElement).perform();

        WebElement calendarEventsElement=driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();

        WebElement loaderMask=driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }
    @Test(description = "Verify that page subtitle Options is displayed")
    public void test1(){

        String expectedSubtitle="Options";
        String actualSubtitle=driver.findElement(By.cssSelector("[class='btn btn-link dropdown-toggle']")).getText();
        Assert.assertEquals(expectedSubtitle,actualSubtitle,"Subtitle is wrong!");


    }
    @Test(description = "Verify that page number is 1")
    public void test2(){
        driver.findElement(By.cssSelector("[type='number']"));
        String expectedNumber="1";
        WebElement actualNumber=driver.findElement(By.xpath("//input[@type='number']"));
        actualNumber.getAttribute("value");
        Assert.assertTrue( actualNumber.getAttribute("value").equals("1"));
    }
    @Test(description = "Verify that page number is 25")
    public void test3(){

        WebElement perPageNum=driver.findElement(By.xpath("//button[@class='btn dropdown-toggle ']"));
        System.out.println(perPageNum.getText());
        Assert.assertEquals(perPageNum.getText(), "25");
    }
    @Test(description="Verify that column number equals records number")
    public void test4(){
        List<WebElement> rowsNumber=driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//tr[@class='grid-row row-click-action']"));
       String expectedRow=driver.findElement(By.xpath("//label[contains(text(),'Total')]")).getText();
       String actualRow="Total Of "+rowsNumber.size()+" Records";
        System.out.println(actualRow);
        System.out.println(expectedRow);
        Assert.assertEquals(actualRow,expectedRow);
    }
    @Test(description = "Verify that calendar events are selected")
    public void test5(){
        driver.findElement(By.xpath("//table//thead//tr//th//input[@type='checkbox']")).click();
    }
    @Test(description = "Verify that tester meeting chart is displayed")
    public void Test6(){
        driver.findElement(By.xpath("//table//tr[13]//td[2]")).click();


       List<String> list2=new ArrayList<>(Arrays.asList(

               "Testers Meeting",

               "This is a a weekly testers meeting",

               "Nov 27, 2019, 9:30 PM",

               "Nov 27, 2019, 10:30 PM",

               "No",

               "Stephan Haley",

               "Tom Smith - Required",

               "Weekly every 1 week on Wednesday",

               "No"));
        List<WebElement> list=driver.findElements(By.xpath("//div[@class='controls']"));
        for (int i=0; i<list.size()-1;i++){
          String actualResult= list.get(i).getText();


          Assert.assertEquals(actualResult,list2.get(i));
        }



    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
