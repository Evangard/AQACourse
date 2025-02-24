package tests;

import config.TestConfig;
import driver.WebDriverRunner;
import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public abstract class AbstractTest {
    protected WebDriver driver;
    protected SoftAssert soft;
    protected static User user;

    @BeforeClass(alwaysRun = true)
    public void setupSuite() {
        user = User.newBuilder().withEmail("anton.mikolaenko@gmail.com").withPassword("Tester_123").build();
        soft = new SoftAssert();
        driver = WebDriverRunner.getWebDriver();
        driver.get(TestConfig.CONFIG.baseUrl());
    }

}
