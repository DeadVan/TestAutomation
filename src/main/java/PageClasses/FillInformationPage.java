package PageClasses;

import BaseDir.BaseForm;
import BaseDir.Elements.Button;
import BaseDir.Elements.Label;
import BaseDir.Elements.TextBox;
import BaseDir.LogUtils;
import BaseDir.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FillInformationPage extends BaseForm {
    public FillInformationPage(WebDriver driver) {
        super(new Label(By.xpath("//span[@class='title'and text()='Checkout: Your Information']")), "Checkout: Your Information", driver);
    }

    TextBox firstName = new TextBox(By.xpath("//input[@id='first-name']"));
    TextBox lastName = new TextBox(By.xpath("//input[@id='last-name']"));
    TextBox zipCode = new TextBox(By.xpath("//input[@id='postal-code']"));

    Label error = new Label(By.xpath("//div[@class='error-message-container error']"));
    Button continueBtn = new Button(By.xpath("//input[@id='continue']"));

    public void fillInformation(){
        LogUtils.info("fill information to continue buying");
        firstName.setText(RandomUtils.getDefaultString(6));
        lastName.setText(RandomUtils.getDefaultString(6));
        zipCode.setText(RandomUtils.getNums(4));
    }
    public String getError(){
        return error.getText();
    }
    public void clickContinue(){
        LogUtils.info("click continue button");
        continueBtn.click();
    }

}
