package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        //how to find all links
        //every link as a tag name <a>
        // //a[.='Home']  or //a[text()='Home']-find link with text name Home
        List<WebElement> links=driver.findElements(By.xpath("//a"));
        System.out.println("Number of links: "+links.size());
        //loop through the collection of links
        for(WebElement webElement: links) {
            //print text of every link
            if (!webElement.getText().isEmpty()) {
                System.out.println(webElement.getText());
            }
        }
        driver.quit();
    }

}
