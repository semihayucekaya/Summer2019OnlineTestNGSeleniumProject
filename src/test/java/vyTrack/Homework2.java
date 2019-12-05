package vyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework2 {
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
    @Test(description = "Verify that “view”, “edit” and “delete” options are available")
    public void test1() {
        Actions action = new Actions(driver);
        WebElement ThreeDot = driver.findElement(By.cssSelector("div[class='dropdown']"));
        action.moveToElement(ThreeDot).perform();
        WebElement view = driver.findElement(By.cssSelector("a[title='View']"));
        Assert.assertTrue(view != null);
        WebElement edit = driver.findElement(By.cssSelector("a[title='Edit']"));
        Assert.assertTrue(edit != null);
        WebElement delete = driver.findElement(By.cssSelector("a[title='Delete']"));
        Assert.assertTrue(delete != null);
    }
    @Test(description = "Verify that title column is displayed")
    public void test2(){
      driver.findElement(By.cssSelector("a[title='Grid Settings']")).click();
      for (int i=1;i<7;i++) {
          List<WebElement>select = driver.findElements(By.xpath("//table//tr//td[@class='visibility-cell']"));
          select.get(i).click();


      }
        driver.findElement(By.xpath("//table//thead//tr//th[2]//span[@class='grid-header-cell__label']")).isDisplayed();
    }
    @Test(description = "verify that save and close save and new save buttons are available")
    public void test3(){
        driver.findElement(By.linkText("Create Calendar Event")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",  driver.findElement(By.xpath("//a[@class='btn-success btn dropdown-toggle']")));

        String actual1= driver.findElement(By.xpath("//button[@class='action-button dropdown-item']")).getText();
        String  expected1="Save And Close";
        Assert.assertEquals(actual1,expected1);

        String actual2=driver.findElement(By.xpath("//*[normalize-space()='Save and New' and @class='main-group action-button dropdown-item']")).getText();
        String expected2="Save And New";
        Assert.assertEquals(actual2,expected2);

        String actual3=driver.findElement(By.xpath("//*[normalize-space()='Save' and @class='main-group action-button dropdown-item']")).getText();
        String expected3="Save";
        Assert.assertEquals(actual3,expected3);



    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
