import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        driver.manage().window().maximize();

        /** Example1 selection
        WebElement example1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        example1.click();

        WebElement startbtn = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        startbtn.click();

        WebElement text = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> text.isDisplayed());
         **/


        /** Example2 selection

        WebElement example2 = driver.findElement(By.linkText("Example 2: Element rendered after the fact"));
        example2.click();

        WebElement startbtn = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        startbtn.click();

        WebElement text = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> text.isDisplayed());
         **/







/**
 try {
 Thread.sleep(1000);
 } catch (InterruptedException e) {
 throw new RuntimeException(e);
 }
 **/


        driver.quit();
    }
}