package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage extends BrowserAbstractPage{

    private final Logger logger = Logger.getLogger(UserPage.class);
    private final String UserName = "daria_malakhova";
    private final String BASE_URL = "http://last.fm/user/"+UserName;

    @FindBy(className = "auth-avatar-desktop")
    private WebElement hoverDropdown;
    @FindBy(linkText = "Logout")
    private WebElement logoutButton;


    @FindBy(css="a[class='auth-link auth-login-link']")
    private WebElement loginlink;


    public UserPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("User page opened");
    }


    public void logout(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Actions action = new Actions(driver);
        action.moveToElement(hoverDropdown).perform();
     //   WebElement userIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("auth-avatar-desktop")));
     //   userIcon.click();
     //   WebElement exitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("auth-dropdown-menu-item                     js-logout-button")));
     //   exitButton.click();
        logoutButton.click();
    }

    public  String loginIcon() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement logIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Login")));
        String output = logIcon.getText();
        return output;
    }



}