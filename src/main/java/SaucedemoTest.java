import BaseDir.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static BaseDir.SettingsReader.*;

public class SaucedemoTest extends BaseTest{

    @Test(testName = "standard_user full test",priority = 1)
    public static void standardUserTest(){
        LogUtils.warn("STARTED standardUserTest TESTING");
        mainPage.fillUserName(user1);
        mainPage.fillPassword();
        mainPage.clickLoginBtn();
        Assert.assertTrue(inventoryPage.isFormOpen(),"inventoryPage did not open");
        inventoryPage.clickProduct();
        cartPage.clickCart();
        Assert.assertTrue(cartPage.productIsCorrect(),"product name didn't appear");
        cartPage.clickCheckOut();
        fillInformationPage.fillInformation();
        fillInformationPage.clickContinue();
        Assert.assertTrue(overviewPage.totalPriceIsDisplayed(),"overviewPage did not open");
        overviewPage.clickFinishBtn();
        Assert.assertTrue(succesPage.checkSuccesLabel(),"produt is not bought");
        succesPage.clickbackHomeBtn();
        Assert.assertTrue(inventoryPage.isFormOpen(),"mainPage didn't open");

    }

    @Test(testName = "locked_out_user full test",priority = 2)
    public static void lockedUserTest(){
        LogUtils.warn("STARTED lockedUserTest TESTING");
        mainPage.fillUserName(user2);
        mainPage.fillPassword();
        mainPage.clickLoginBtn();
        Assert.assertTrue(inventoryPage.isFormOpen(),mainPage.getErrorMessage());
    }

    @Test(testName = "problem_user full test",priority = 3)
    public static void problemUserTest(){
        LogUtils.warn("STARTED problemUserTest TESTING");
        mainPage.fillUserName(user3);
        mainPage.fillPassword();
        mainPage.clickLoginBtn();
        Assert.assertTrue(inventoryPage.isFormOpen(),"inventoryPage did not open");
        inventoryPage.clickProduct();
        cartPage.clickCart();
        Assert.assertTrue(cartPage.productIsCorrect(),"product name didn't appear");
        cartPage.clickCheckOut();
        fillInformationPage.fillInformation();
        fillInformationPage.clickContinue();
        Assert.assertTrue(overviewPage.totalPriceIsDisplayed(),fillInformationPage.getError());
        overviewPage.clickFinishBtn();
        Assert.assertTrue(succesPage.checkSuccesLabel(),"produt is not bought");
    }

    @Test(testName = "performance_glitch_user full test",priority = 4)
    public static void glitchUserTest(){
        LogUtils.warn("STARTED glitchUser TESTING");
        mainPage.fillUserName(user4);
        mainPage.fillPassword();
        mainPage.clickLoginBtn();
        Assert.assertTrue(inventoryPage.isFormOpen(),"inventoryPage did not open");
        inventoryPage.clickProduct();
        cartPage.clickCart();
        Assert.assertTrue(cartPage.productIsCorrect(),"product name didn't appear");
        cartPage.clickCheckOut();
        fillInformationPage.fillInformation();
        fillInformationPage.clickContinue();
        Assert.assertTrue(overviewPage.totalPriceIsDisplayed(),"overviewPage did not open");
        overviewPage.clickFinishBtn();
        Assert.assertTrue(succesPage.checkSuccesLabel(),"product is not bought");
    }
}
