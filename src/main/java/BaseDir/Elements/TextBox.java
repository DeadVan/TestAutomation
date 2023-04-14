package BaseDir.Elements;

import org.openqa.selenium.By;

public class TextBox extends BaseElement{
    public TextBox(By locator) {
        super(locator);
    }
    public void setText(String text) {
        getElement().clear();
        getElement().sendKeys(text);
    }
}
