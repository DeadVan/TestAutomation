package PageClasses;

import BaseDir.BaseForm;
import BaseDir.Elements.Button;
import BaseDir.Elements.Label;
import BaseDir.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BaseForm {

    public InventoryPage(WebDriver driver) {
        super(new Label(By.xpath("//span[@class='title'and text()='Products']")), "products", driver);
    }
    Button addCartBtn = new Button(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));


    public void clickProduct(){
        LogUtils.info("add product into cart");
        addCartBtn.waitClick();
    }





}
