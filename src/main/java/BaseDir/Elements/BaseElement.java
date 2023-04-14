package BaseDir.Elements;

import BaseDir.WaitUtils;
import BaseDir.WebDriverSingleton;
import org.openqa.selenium.*;

public class BaseElement{
    protected WebDriver driver;
    protected By uniquelocator;


    public BaseElement(By locator) {
        this.driver = WebDriverSingleton.getCurrentDriver();
        this.uniquelocator = locator;
    }

    protected WebElement getElement() {
        return driver.findElement(uniquelocator);
    }

    public void click() {
        getElement().click();
    }

    public void clickButnViaJs(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", getElement());
    }
    public void waitClick(){
        WaitUtils.waitForElementToBeClickable(uniquelocator);
        WaitUtils.waitForElementToBeVisible(uniquelocator);
        getElement().click();
    }


    public String getText() {
        WaitUtils.waitForElementToBeVisible(uniquelocator);
        return getElement().getText();
    }


    public boolean isDisplayed() {
        try {
            WaitUtils.waitForElementToBeVisible(uniquelocator);
            return getElement().isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            return false;
        }
    }

    public WebElement toWebElement() {
        return getElement();
    }
    public By getLocator() {
        return uniquelocator;
    }
}
