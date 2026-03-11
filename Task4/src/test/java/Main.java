import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://practice-automation.com/form-fields/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Fill Name input
        WebElement name = driver.findElement(By.xpath("//*[@id=\"name-input\"]"));
        name.sendKeys("Admin");

        // Fill Password input
        WebElement password = driver.findElement(By.xpath("//*[@id=\"feedbackForm\"]/label[2]/input"));
        password.sendKeys("admin123");

        // Create a list for element (drinks)
        List<WebElement> drinkCheckboxes = new ArrayList<>();

        // Check all the favourite drink
        for (int i = 1; i <= 5; i++) {
            String XpathLoction = "//*[@id='drink" + i + "']";

            WebElement checkbox = driver.findElement(By.xpath(XpathLoction));
            drinkCheckboxes.add(checkbox);
        }

        // Select each drink
        for (WebElement drink : drinkCheckboxes) {
            if (!drink.isSelected()) {
                drink.click();
            }
        }

        // Select favorite color for the checkpoint
        WebElement colorCheckpoint = driver.findElement(By.xpath("//*[@id=\"feedbackForm\"]/label[13]"));
        colorCheckpoint.click();


        // Opens check menu for answering automation question
        WebElement Automenu = driver.findElement(By.xpath("//*[@id=\"automation\"]"));
        Automenu.click();

        // Select an answer for automation question (Most difficult part)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        Select list=new Select(Automenu);
//        list.selectByIndex(1);

        List<WebElement> selected = driver.findElements(By.cssSelector("option[value]"));
        selected.get(1).click();

        // Fill the email
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("joedien@text.com");

        // Write a message
        WebElement message = driver.findElement(By.cssSelector("#message"));
        message.sendKeys("Hello World");


        // Scroll down
        WebElement scroll = driver.findElement(By.cssSelector("#submit-btn"));
        new Actions(driver)
                .scrollToElement(scroll);
//                .perform();

        scroll.click();

        //Thread.sleep(3000);
        driver.quit();
    }
}

