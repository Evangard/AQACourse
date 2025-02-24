package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int TIME_OUT = 10;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isFieldErrorShown(String message) {
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='field-validation-error']/span"));
        List<String> list = new ArrayList<>();
        for (WebElement el: elements) {
            list.add(el.getText());
        }
        return list.contains(message);
    }
}
