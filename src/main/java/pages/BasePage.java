package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;
    JavascriptExecutor je;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);
        je = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    protected void waitVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void waitClickability(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected String getText(By locator){
        return findElement(locator).getText();
    }

    protected void click(By locator){
        waitClickability(locator);
        findElement(locator).click();
    }

    protected void scrollBy300(){
        je.executeScript("window.scrollBy(0,300)", "");
    }

    protected void moveToElement(By locator){
        action.moveToElement(findElement(locator));
    }
}
