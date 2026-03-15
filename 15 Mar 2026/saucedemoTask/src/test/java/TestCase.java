import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class TestCase {
    WebDriver driver;
    String temPrice;
    boolean found;
    //public SoftAssert softAssert;


    @BeforeClass
    public void setUp() {
        // Initialization logic
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.saucedemo.com");
        //softAssert = new SoftAssert();
    }

    @Test
    public void testItemDetials() {
        // 1. Interaction
        /** Fill the username **/
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");

        /** Fill the password **/
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");

        /** Click on login button (With Error handling) **/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginbtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("#login-button"))
        );
        loginbtn.click();

        /** Open the filter menu and the apply second filter **/
        WebElement selectElement = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
        Select select = new Select(selectElement);
        select.selectByIndex(1);

        /** Select an item **/
        WebElement selectedItem = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));
        selectedItem.click();

        /** Checkout the cart **/
        WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        cart.click();
        WebElement itemName = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div"));

        // 2. Assertion (Expected vs. Actual)
        Assert.assertTrue(itemName.getText().contains("Sauce Labs"), "Error: item mismatch!");

        // 3. Price Assertion (Expected vs. Actual)
        WebElement actualPriceElement = driver.findElement(By.cssSelector(".inventory_item_price"));
        String actualPriceText = actualPriceElement.getText();
        Assert.assertEquals(actualPriceText, "$7.99", "Price mismatch!");

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

        //driver.quit();
    }
}

