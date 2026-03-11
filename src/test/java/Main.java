import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        /** Google Search
         driver.get("https://www.google.com");

         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

         // Search an element
         WebElement search = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
         search.sendKeys("Mickey");

         // Locate the element
         WebElement suggestion = driver.findElement(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul/li[1]"));

         // Check visibility
         if (suggestion.isDisplayed()) {
         System.out.println("The suggestion is visible on the UI.");
         } else {
         System.out.println("The suggestion is hidden.");
         }


         // Click out of the scope
         WebElement outofscope = driver.findElement(By.xpath("//*[@id=\"LS8OJ\"]"));
         outofscope.click();

         // Re-check visibility
         if (suggestion.isDisplayed()) {
         System.out.println("The suggestion is visible on the UI.");
         } else {
         System.out.println("The suggestion is hidden.");
         }

         //Thread.sleep(3000);
         driver.quit();
         **/


        /** Add/Remove Elements
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Click on the button
        WebElement addbtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        addbtn.click();

        // Locate the element
        WebElement suggestion = driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));

        // Check visibility
        if (suggestion.isDisplayed()) {
            System.out.println("The suggestion is visible on the UI.");
        } else {
            System.out.println("The suggestion is hidden.");
        }

        // Click the suggestion
        suggestion.click();

        // Re-check visibility
        if (suggestion.isDisplayed()) {
            System.out.println("The suggestion is visible on the UI.");
        } else {
            System.out.println("The suggestion is hidden.");
        }

        //Thread.sleep(3000);
        driver.quit();
         **/
    }
}

