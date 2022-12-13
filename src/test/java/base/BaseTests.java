package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {

    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        //finding elements
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement inputLink = driver.findElement(By.linkText("Angie"));
        inputLink.click();


        driver.findElement(By.id("first-name")).sendKeys("Nonhlanhla");
        //or
        driver.findElement(By.id("continue")).click();

        //manage the window display
        driver.manage().window().maximize();;
        driver.manage().window().fullscreen();
        driver.manage().window().setSize(new Dimension(375, 812));

        System.out.println(driver.getTitle());
        driver.quit();
    }
    public static void main(String args[]){
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
