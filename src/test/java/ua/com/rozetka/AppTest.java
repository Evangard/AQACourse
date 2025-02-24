package ua.com.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    public static String EXPECTED_TEXT = "Персональний кабінет";
    private WebDriver driver;
    private SoftAssert soft;

    @BeforeClass(alwaysRun = true)
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/amykolaienko/Downloads/chromedriver");
        soft = new SoftAssert();
        driver = new ChromeDriver();
        driver.get("https://butlers.ua/ua/");
    }

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Вхід']"));
        loginButton.click();
        Thread.sleep(5000);

        WebElement usernameField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='password']"));
        WebElement submitButton = driver.findElement(By.xpath("//div[@class='buttons']/input[@type='submit']"));

        usernameField.clear();
        usernameField.sendKeys("anton.mikolaenko@gmail.com");
        passwordField.click();
        passwordField.sendKeys("Tester_123");
        submitButton.click();

        Thread.sleep(5000);

//        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Персональний кабінет']")).getText(), EXPECTED_TEXT,
//                String.format("'%s' text should be displayed.", EXPECTED_TEXT));
        soft.assertEquals(driver.findElement(By.xpath("//a[text()='Персональний кабінет']")).getText(), EXPECTED_TEXT,
                String.format("'%s' text should be displayed.", EXPECTED_TEXT));
        soft.assertEquals(driver.findElement(By.xpath("//a[text()='Персональний кабінет']")).getText(), "asdasd",
                String.format("'%s' text should be displayed.", EXPECTED_TEXT));
        soft.assertTrue(driver.findElement(By.xpath("//a[text()='Персональний кабінет']")).getText().equals(EXPECTED_TEXT),
                String.format("SOFT TRUE: '%s' text should be displayed.", EXPECTED_TEXT));
        soft.assertFalse(driver.findElement(By.xpath("//a[text()='Персональний кабінет']")).getText().equals(EXPECTED_TEXT),
                String.format("SOFT FALSE: '%s' text should be displayed.", EXPECTED_TEXT));
        soft.assertAll();
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.close();
    }

//    @Test
//    public void shouldAnswerWithTrue2()
//    {
//        System.out.println("Hello 2");
//    }
}
