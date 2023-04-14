package PageClasses;

import BaseDir.BaseForm;
import BaseDir.Elements.Button;
import BaseDir.Elements.Label;
import BaseDir.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccesPage extends BaseForm {
    public SuccesPage(WebDriver driver) {
        super(new Label(By.xpath("//span[@class='title' and text()='Checkout: Complete!']")), "Checkout: Complete!", driver);
    }

    Label orderAcepted = new Label(By.xpath("//h2[@class='complete-header']"));

    Button backHomeBtn = new Button(By.xpath("//button[@id='back-to-products']"));

    public boolean checkSuccesLabel(){
        LogUtils.info("check if product was bought succesfully");
        return orderAcepted.isDisplayed();
    }

    public void clickbackHomeBtn(){
        LogUtils.info("click home button to navigate on InventoryPage");
        backHomeBtn.click();
    }

}
