package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Radio Buttons")).click();
    }
    @Test(description="Verify that blue button is selected")
    public void test1(){
        //<a href="/radio_buttons">Radio Buttons</a>
        //linkText works only with <a> elements
        //        link text only in between >Text<
//        this is step is common for all test cases


        WebElement bluebutton=driver.findElement(By.id("blue"));
        Assert.assertTrue(bluebutton.isSelected());
    }
    @Test(description = "Verify that red button is not selected")
    public void test2(){

        WebElement redbutton=driver.findElement(By.id("red"));
        boolean isSelected=redbutton.isSelected();
        Assert.assertFalse(isSelected);

    }
    @Test(description = "Verify that green button is not clickable")
            public void test3(){
        WebElement greenbutton=driver.findElement(By.id("green"));
        //isEnable() will return true if button is available for interaction
        //that means you can click on it,in this case
        Assert.assertFalse(greenbutton.isEnabled());

            }
            //let's find all radio buttons and click on them one by one
    @Test(description = "Click on all radio buttons")
    public void test4(){
        //how to find all buttons
        List<WebElement> radiobuttons=driver.findElements(By.cssSelector("input[type='radio']"));
        for(WebElement button:radiobuttons){
            if(button.isEnabled()&&!button.isSelected()){
                button.click();
                //in this case ,id attribute represents a name of the color
                System.out.println("Button clicked: "+button.getAttribute("id"));
            } else {
                System.out.println("Button was not clicked: "+button.getAttribute("id"));
            }
            BrowserUtils.wait(2);
        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
