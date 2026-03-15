import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        /** Swag Labs Website **/
        driver.get("https://www.saucedemo.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        /** Fill the username **/
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");

        /** Fill the password **/
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");


        /** Click on login button (With Error handling) **/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginbtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("#login-button"))
        );
        loginbtn.click();

        /** Open the filter menu **/

        //List<WebElement> optionList = select.getOptions();


        /** Select an item **/
        WebElement selectedItem = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));
        selectedItem.click();


        // Do some checks on the item



        /** Click on checkout **/
        WebElement checkout = driver.findElement(By.cssSelector("#checkout"));
        checkout.click();

            // Fill the firstname
            WebElement firstname = driver.findElement(By.cssSelector("#first-name"));
            firstname.sendKeys("Joe");

            // Fill the lastname
            WebElement lastname = driver.findElement(By.cssSelector("#last-name"));
            lastname.sendKeys("Biden");

            // Fill the postal code
            WebElement postalCode = driver.findElement(By.cssSelector("#postal-code"));
            postalCode.sendKeys("20500");

            /** Click on continue **/
            WebElement continuebtn = driver.findElement(By.cssSelector("#continue"));
            continuebtn.click();

        /** Click on finish **/
        WebElement finishbtn = driver.findElement(By.id("finish"));
        finishbtn.click();


        //Thread.sleep(3000);
        driver.quit();
    }
}

/****************************
        /** Select two items to add in the cart **/
//        WebElement item1 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
//        item1.click();
//        WebElement item2 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket"));
//        item2.click();
//
//        /** Checkout the cart **/
//        WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
//        cart.click();
//
//        // Click on checkout
//        WebElement checkout = driver.findElement(By.cssSelector("#checkout"));
//        checkout.click();
//
//        // Fill the firstname
//        WebElement firstname = driver.findElement(By.cssSelector("#first-name"));
//        firstname.sendKeys("Joe");
//
//        // Fill the lastname
//        WebElement lastname = driver.findElement(By.cssSelector("#last-name"));
//        lastname.sendKeys("Biden");
//
//        // Fill the postal code
//        WebElement postalCode = driver.findElement(By.cssSelector("#postal-code"));
//        postalCode.sendKeys("20500");
//
//        // Click on continue
//        WebElement continuebtn = driver.findElement(By.cssSelector("#continue"));
//        continuebtn.click();
//
//        // Display the price extraction
//        WebElement price = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]"));
//        String priceText = price.getText();
//        //System.out.println(priceText);
//        Pattern priceplain = Pattern.compile("\\d+\\.\\d{2}");
//        Matcher p = priceplain.matcher(priceText);
//        if (p.find()) {
//            System.out.println("Price: " + p.group());
//        } else {
//            System.out.println("Price extraction is not working!");
//        }
//
//        Thread.sleep(3000);
//        driver.quit();
//    }
//}
