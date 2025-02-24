package tests;

import driver.WebDriverRunner;
import model.User;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoginTest extends AbstractTest {
    private LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setupTest() {
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    private void beforeMethodActions() {
        driver.navigate().to("https://butlers.ua/ua/login?returnUrl=%2Fua%2F");
    }

    @AfterMethod(alwaysRun = true)
    private void afterMethodActions(Method method) throws InterruptedException {
        if (method.getName().equalsIgnoreCase("verifyUserIsAbleToLogin")) {
            driver.navigate().back();
        }


        List<User> users = new ArrayList<>();
        users.stream()
                .filter(a -> a.getEmail().equalsIgnoreCase("ano@asd"))
                .map(e->e.getPassword())
                .collect(Collectors.toList());
        users.stream()
                .anyMatch(e->e.getEmail().equalsIgnoreCase("ano@asd"));

    }

    @Test
    public void verifyUserIsAbleToLogin() {
        loginPage.setUserName(user.getEmail());
        loginPage.submit();
        loginPage.login(user.getEmail(), user.getPassword());
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }

}
