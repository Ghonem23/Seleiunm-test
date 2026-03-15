import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.time.Duration;

public class loggerTask {
    WebDriver driver;
    String text;
    boolean found;
    public SoftAssert softAssert;


    @BeforeMethod
    public void setUp() {
        // Initialization logic
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://the-internet.herokuapp.com/login");
        softAssert = new SoftAssert();
    }

    /**
     * Negative Scenarios
     **/


    @Test
    public void testValidateContent() {
        // 1. Interaction
        driver.findElement(By.cssSelector("#username")).sendKeys("tom$mith");
        driver.findElement(By.id("password")).sendKeys("Password123!");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginbtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("#login > button"))
        );
        loginbtn.click();

        // 2. Assertion (Expected vs. Actual)
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://the-internet.herokuapp.com/secure";

        softAssert.assertEquals(actualUrl, expectedUrl, "Login failed: URL mismatch!");
        softAssert.assertAll();
    }


    /**
     * Happy Scenarios
     **/

    @Test
    public void testValidLogin() {
        // 1. Interaction
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginbtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("#login > button"))
        );
        loginbtn.click();

        // 2. Assertion (Expected vs. Actual)
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        softAssert.assertEquals(actualUrl, expectedUrl, "Login failed: URL mismatch!");

        // 1. Interaction
        text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4")).getText();

        //System.out.println(text);

        // 2. Assertion (Expected vs. Actual)
        String expectedContent = "Welcome to the Secure Area. When you are done click logout below.\n";

        Assert.assertTrue(text.contains("Secure Area"), "Content mismatch!");

        // 1. Interaction
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
            // Check visibility
            if (logout.isDisplayed()) {
                found = true;
            }

        // 2. Assertion (Expected vs. Actual)
        Assert.assertTrue(found, "Logout button is not displayed");

    }

}
