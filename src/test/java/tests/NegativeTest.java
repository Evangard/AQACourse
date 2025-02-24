package tests;

import driver.WebDriverRunner;
import io.qameta.allure.*;
import listeners.TestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import java.io.File;
import java.lang.reflect.Method;

@Epic("Registration epic")
@Story("Negative scenarios story")
public class NegativeTest extends AbstractTest {
    private LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setupTest() {
        loginPage = new LoginPage(driver);
        driver.navigate().to("https://butlers.ua/ua/login?returnUrl=%2Fua%2F");
    }

    @AfterMethod(alwaysRun = true)
    private void afterMethodActions(Method method) {
        if (method.getName().equalsIgnoreCase("verifyThatErrorMessageIsShownIfEnterWrongLoginData")) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    @Feature("Feature text")
    @Description("Descr text")
    @TmsLink("C123123")
    public void verifyThatErrorMessageIsShownIfEnterWrongLoginData() throws InterruptedException {
        loginPage.login("asd@asd.com", "asd");
        Assert.assertTrue(loginPage.isErrorMessageShown("asdasdВхід не вдалося. Виправте помилки та повторіть спробу."), "Error should be shown.");
    }

//    @AfterClass(alwaysRun = true)
//    public void closeDriver() {
//        WebDriverRunner.closeWebDriver();
//    }

}
