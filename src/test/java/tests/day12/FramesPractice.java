package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FramesPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
    }
    @Test(description = "iFrame example")
    public void test1(){
        driver.findElement(By.linkText("iFrame")).click();
        //since element inside a frame,element is not visible for selenium
        //without switching to the frame
        //we can switch to frame based on id, name ,index(starting from0), web element
        driver.switchTo().frame("mce_0_ifr");
        //without switching, we cannot see inner html document
        //which one tou use? id,name,index,webelement
        //1.id or name <iframe id ="mce_0_ifr" name ="some_frame">

        WebElement inputArea=driver.findElement(By.id("tinymce"));
        String expectedText="Your content goes here.";
        String actualText=inputArea.getText();
        Assert.assertEquals(actualText,expectedText);
        //exit to frame
        BrowserUtils.wait(2);
        inputArea.clear();//clear to delete
        inputArea.sendKeys("Java is fun!");
        driver.switchTo().defaultContent();
    }

    //in case of nested frames
    //we must switch to frame--->then again to another frame, that is inside

    @Test(description="nested frame example")
    public void test2(){
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
        WebElement content=driver.findElement(By.tagName("body"));
        System.out.println(content.getText());

        driver.switchTo().defaultContent();//exit all frame
        driver.switchTo().frame("frame-top");//second floor
        driver.switchTo().frame("frame-left");//third floor
        System.out.println(driver.findElement(By.tagName("body")).getText());//print text



    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
