package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before // JUnit Annotation which will run before every method

    public void setUp() { // calling openBrowser method using baseUrl value
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();// Find and click on Sign in link
        String expectedText = "Welcome Back!"; // Expected text from requirements
        String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]")).getText(); // Find the text element and get the text
        Assert.assertEquals("User was not Navigated to Login page.", expectedText, actualText);// Validating actual and expected text
    }

    @Test
    public void verifyTheErrorMessage() {

        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();// Find and click on Sign in link
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("invalid@invalid.com");// Find Email field and enter invalid email
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("Test123456");// Find password field and enter invalid password
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();// Find and click on Sign in
        String expectedMessage = "Invalid email or password."; // Expected message from requirements
        String actualMessage = driver.findElement(By.xpath("//div[@id='notice']")).getText();// Find the text element and get the text
        Assert.assertEquals("Error Message was not displayed.", expectedMessage, actualMessage);// Validating actual and expected text
    }

    @After // JUnit Annotation which will run after every method
    public void tearDown() {
        closeBrowser();
    }
}
