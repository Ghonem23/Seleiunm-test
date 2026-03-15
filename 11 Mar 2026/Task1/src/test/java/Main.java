import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        //driver.get("https://www.bbc.com/arabic");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

        driver.get("https://the-internet.herokuapp.com/login");

        /** User credentials **/
        WebElement username=  driver.findElement(By.cssSelector("input[id=\"username\"]"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.cssSelector("input[id=\"password\"]"));
        password.sendKeys("SuperSecretPassword!");

        /** Login button **/
        WebElement loginbtn = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        loginbtn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /** Logout button **/
        WebElement logoutbtn = driver.findElement(By.linkText("Logout"));
        logoutbtn.click();


        /** Get the page title **/
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.quit();
    }
}