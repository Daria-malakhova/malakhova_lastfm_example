package Steps;

import Pages.BrowserAbstractPage;
import Pages.LoginPage;
import Pages.SearchPage;
import Pages.UserPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;


public class Steps {


    private WebDriver driver;
    private final Logger logger = Logger.getLogger(Steps.class);

    public enum Browser {
        FIREFOX,
        CHROME,
        IE,
    };


    public WebDriver initWebDriver(Browser b){

        switch (b) {

            case FIREFOX: driver = new FirefoxDriver();
                break;

            case CHROME: driver = new ChromeDriver();
                break;

            case IE: driver = new InternetExplorerDriver();
                break;

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }

    public void closeDriver()
    {
        driver.quit();
        logger.info("Browser closed\n====================================");
    }


    public void loginLastFm(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public void logoutFromLastFm(){
        UserPage userPage = new UserPage(driver);
        userPage.openPage();
        userPage.logout();
    }

    public String getUserName(){
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.userName();
    }

    public String getTextIcon(){
        UserPage userPage = new UserPage(driver);
        return userPage.loginIcon();
    }

    public boolean isSearchTrackCompleted(String searchQuery){
        SearchPage searchPage = new SearchPage(driver);
        return (searchPage.searchTrack().contains(searchQuery));
    }

    public boolean isSearchAlbumCompleted(String searchQuery){
        SearchPage searchPage = new SearchPage(driver);
        return (searchPage.searchAlbum().contains(searchQuery));
    }

}
