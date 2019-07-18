package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

public class BasePage {

    private WebDriver driver = Driver.getDriver();

    protected void waitForTitle(String title, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.titleContains(title));
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    protected String getText(String id) {
        return driver.findElement(By.id(id)).getText();

    }

    protected void clickLinkById(String id) {
        driver.findElement(By.id(id)).click();
    }

    protected void clickLinkByText(String text) {
        driver.findElement(By.linkText(text)).click();
    }

    protected void clickLinkByClass(String text) {
        driver.findElement(By.className(text)).click();
    }

    protected void sendKeys(String id, final String text) {
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(text);
    }
}

