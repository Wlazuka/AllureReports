package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    private final WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilCondition(ExpectedCondition<?> condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public void forPageToLoad() {
        ExpectedCondition<Object> condition = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
        String timeoutMessage = "#### Page did not load completely after 5 seconds";
        waitUntilCondition(condition, timeoutMessage, 5);
    }

    public void forElementToLoad(WebElement element) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(element);
        String timeoutMessage = "#### Element did not load to DOM after 5 seconds";
        waitUntilCondition(condition, timeoutMessage, 5);
    }
}