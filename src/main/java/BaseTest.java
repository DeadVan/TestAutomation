import BaseDir.LogUtils;
import BaseDir.WebDriverSingleton;
import PageClasses.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static BaseDir.SettingsReader.*;

public class BaseTest {

    static MainPage mainPage;
    static InventoryPage inventoryPage;
    static CartPage cartPage;
    static FillInformationPage fillInformationPage;
    static OverviewPage overviewPage;
    static SuccesPage succesPage;

    @BeforeMethod
    public void setup(){
        WebDriver driver = WebDriverSingleton.getInstance().getDriver(browser);
        driver.get(url);
        mainPage = new MainPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        fillInformationPage = new FillInformationPage(driver);
        overviewPage = new OverviewPage(driver);
        succesPage = new SuccesPage(driver);
        LogUtils.startTestCase(mainPage.getFormLabel());
        LogUtils.info("URL is " + driver.getCurrentUrl());
        LogUtils.info("WaitTime for elements will be max - { " + waitTime + " } ");
        if (mainPage.isFormOpen()) {
            LogUtils.info("Initialized " + browser + " Driver and maximized window");
        } else {
            LogUtils.info("Page didn't open");
        }
    }


    @AfterMethod
    public void closeDriver(){
        WebDriverSingleton.getInstance().closeDriver();
        LogUtils.endTestCase();
    }


}
