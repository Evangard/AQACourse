package listeners;

import driver.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static driver.WebDriverRunner.getWebDriver;

public class TestListener extends AllureTestNg {
    @Override
    public void onTestFailure(ITestResult result) {
        File screenShot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Allure.addAttachment(screenShot.getName(), new FileInputStream(screenShot));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        super.onTestFailure(result);
    }
}
