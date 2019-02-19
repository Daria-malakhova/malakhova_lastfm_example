package Pages;

import org.openqa.selenium.WebDriver;

public abstract class BrowserAbstractPage {

    protected WebDriver driver;

    public BrowserAbstractPage(WebDriver driver){

        this.driver = driver;
    }

    public abstract void openPage();

}
