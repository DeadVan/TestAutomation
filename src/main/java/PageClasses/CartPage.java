package PageClasses;

import BaseDir.BaseForm;
import BaseDir.Elements.Button;
import BaseDir.Elements.Label;
import BaseDir.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BaseForm {
    public CartPage(WebDriver driver) {
        super(new Label(By.xpath("//span[@class='title' and text()='Your Cart']")), "Your Cart", driver);
    }

    Button cartBtn = new Button(By.xpath("//a[@class='shopping_cart_link']"));
    Label productName = new Label(By.xpath("//div[@class='inventory_item_name']"));
    Button checkOut = new Button(By.xpath("//button[@id='checkout']"));

    public void clickCart(){
        LogUtils.info("click on cart to show items");
        cartBtn.click();
    }

    public boolean productIsCorrect(){
        LogUtils.info("check if product on cart matches actrual added product");
        return productName.isDisplayed();
    }

    public void clickCheckOut(){
        LogUtils.info("click checkout button");
        checkOut.click();
    }

}
