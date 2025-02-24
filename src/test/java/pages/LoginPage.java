package pages;

import io.qameta.allure.Step;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends AbstractPage{
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='inputs']/input[@type='email']")
    WebElement usernameField;

    @FindBy(xpath = "//div[@class='inputs']/input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//div[@class='inputs']/input[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//*[@class='item-grid']//div[@class='details']//input[@value='В кошик']")
    List<WebElement> asd;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Step("Login to the portal with '{0}' email and '{1}' password.")
    public void login(String name, String password) {
        setUserName(name);
        setPassword(password);
        submit();
    }

    public void addItemToTheBasket(int index) {

    }

    @Step
    public void setUserName(String name) {
        WebElement sectionElement = driver.findElement(By.xpath("//form[@action='/ua/login?returnurl=%2Fua%2F']"));
//        WebElement usernameField = sectionElement.findElement(By.xpath(".//div[@class='inputs']/input[@type='email']"));
//        WebElement usernameField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inputs']/input[@type='email']"))));
        usernameField.clear();
        usernameField.sendKeys(name);
    }

    @Step
    public void setPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    @Step
    public void submit() {
        WebElement submitButton = driver.findElement(By.xpath("//div[@class='buttons']/input[@type='submit']"));
        submitButton.click();
    }

    public boolean isErrorMessageShown(String message) {
        WebElement el = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        return el.getText().contains(message);
    }

}
