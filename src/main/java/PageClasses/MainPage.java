package PageClasses;

import BaseDir.BaseForm;

import BaseDir.Elements.Button;
import BaseDir.Elements.Label;
import BaseDir.Elements.TextBox;
import BaseDir.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import static BaseDir.SettingsReader.passwordFromProp;

public class MainPage extends BaseForm {

    public MainPage(WebDriver driver) {
        super(new Label(By.xpath("//div[@class='login_logo']")), "Swag Labs Logo", driver);
    }

    TextBox userName = new TextBox(By.xpath("//input[@id='user-name']"));
    TextBox password = new TextBox(By.xpath("//input[@id='password']"));
    Button login = new Button(By.xpath("//input[@id='login-button']"));
    Label error = new Label(By.xpath("//h3[contains(@data-test,'error')]"));



    public void fillUserName(String usernames){
        LogUtils.info("fill username");
        userName.setText(usernames);
    }

    public void fillPassword(){
        LogUtils.info("fill password");
            password.setText(passwordFromProp);
    }

    public void clickLoginBtn(){
        LogUtils.info("click login button");
        login.waitClick();
    }

    public boolean errormessage(){
        return error.isDisplayed();
    }

    public String getErrorMessage(){
        return error.getText();
    }

}
