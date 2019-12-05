package vyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Tests {
    public static void main(String[] args) {
     WebDriver driver=BrowserFactory.getDriver("chrome");
     driver.get("http://qa2.vytrack.com/user/login");
     WebElement username=driver.findElement(By.name("_username"));
     username.sendKeys("storemanager216");

     WebElement password=driver.findElement(By.name("_password"));
     password.sendKeys("UserUser123");

     WebElement buton=driver.findElement(By.name("_submit"));
     buton.click();
     String expectedTitle="Dashboard";
     String actualTitle=driver.getTitle();
        BrowserUtils.wait(5);
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        driver.close();

    }

}
