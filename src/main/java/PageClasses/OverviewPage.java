package PageClasses;

import BaseDir.BaseForm;
import BaseDir.Elements.Button;
import BaseDir.Elements.Label;
import BaseDir.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BaseForm {
    public OverviewPage(WebDriver driver) {
        super(new Label(By.xpath("//span[@class='title' and text()='Checkout: Overview']")), "Checkout: Overview", driver);
    }
    Label totalPrice = new Label(By.xpath("//div[@class='summary_info_label summary_total_label']"));
    Button finishBtn = new Button(By.xpath("//button[@id='finish']"));

    public boolean totalPriceIsDisplayed(){
        LogUtils.info("check if  totalprice displayed");
        return totalPrice.isDisplayed();
    }
    public void clickFinishBtn(){
        LogUtils.info("click finish button");
        finishBtn.click();
    }


}
