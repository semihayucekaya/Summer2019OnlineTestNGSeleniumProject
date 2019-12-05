package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test(description = "Verify that title is practice")
    public void test1(){
        driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice","Title is wrong");
    }
    @Test(description="verify that user is able to see new window")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();
        String oldWindow=driver.getWindowHandle();
        //after 3 seconds, another website will be opened, in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(5);
        //in the selenium every window has an id.That id calls window handle to read window handle we use get.WindowHandle()
        //after new window was opened,we can get list of all window id's/window handles
        //also, you cannot easily access anything from there
        //there is no .get() method
        //that's why,we need to loop through the set, to read a data from there
        //set can store only unique values
        Set<String> windowHandles=driver.getWindowHandles();
        for(String windowHandle:windowHandles){
            //if it's not an old window
            if(!windowHandle.equals(oldWindow)){
                //switch to that window
                driver.switchTo().window(windowHandle);
            }
        }
        //let's verify that title of new window is a Fresh tab
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Fresh tab","Title is wrong");
        //come back to original page
        //we can build a function,that will jump, in between windows
        //based on page title
        String pageTitle="Practice";
        //keep jumping from window to window
        for(String windowHandle:windowHandles){
            //once we found page title, of the window that we need
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals(pageTitle)){
                //just exit
                //stop jumping
                break;
            }
        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
