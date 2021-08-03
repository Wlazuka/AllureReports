package allureReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    public void login(String username, String password) {
        WebElement emailBox = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        emailBox.clear();
        emailBox.sendKeys(username);

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        passwordBox.clear();
        passwordBox.sendKeys(password);

        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
    }


    @Test
    public void logoPresence() {

        boolean logovisible = driver.findElement(By.xpath("//div[@id='divLogo']//img")).isDisplayed();
        Assert.assertTrue(logovisible);

    }

    @Test
    public void successLoginTest() {

        login("Admin", "admin123");

        WebElement dashboard_text = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]"));
        wait.forElementToLoad(dashboard_text);

        Assert.assertTrue(dashboard_text.isDisplayed());
    }

    @Test
    public void unhappyLoginTestPass() {
        login("Admin", "admin");

        WebElement spanMessage = driver.findElement(By.xpath("//span[@id='spanMessage']"));

        Assert.assertTrue(spanMessage.isDisplayed());
        Assert.assertEquals(spanMessage.getText(), "Invalid credentials");
    }


    @Test
    public void unhappyLoginTestFail() {
        login("Admin", "admin");

        WebElement spanMessage = driver.findElement(By.xpath("//span[@id='spanMessage']"));

        Assert.assertTrue(spanMessage.isDisplayed());
        Assert.assertEquals(spanMessage.getText(), "Invalid text");
    }

    @Test
    public void registrationTest() {
        throw new SkipException("Skipping this Test");
    }

}
