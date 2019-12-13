package tests.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Test2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://qa2.vytrack.com/user/login");
        WebElement username=driver.findElement(By.name("_username"));
        username.sendKeys("storemanager200");

        WebElement password=driver.findElement(By.name("_password"));
        password.sendKeys("user123");
        WebElement button=driver.findElement(By.name("_submit"));
        button.click();
        WebElement errs=driver.findElement(By.xpath("//div[@class='alert alert-error']"));
        System.out.println(errs.getText());
        String actualResult=errs.getText();
        if(actualResult.equals("Invalid user name or password.")){
            System.out.println("Pass");
        } else {
            System.out.println("fail");
        }

    }
}
