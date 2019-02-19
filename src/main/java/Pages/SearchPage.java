package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BrowserAbstractPage {

    private final Logger logger = Logger.getLogger(SearchPage.class);
    private final String BASE_URL = "https://www.last.fm/search";
    private final String TRACK_SEARCH = "https://www.last.fm/search/tracks";
    private final String ALBUM_SEARCH = "https://www.last.fm/search/albums";
    private final String query = "TesseracT";

    @FindBy(id = "site-search")
    private WebElement inputSearchQuery;

    @FindBy(className = "search-submit")
    private WebElement searchSubmitButton;

    @FindBy(className = "content-top-header")
    private WebElement searchResultText;


    public SearchPage(WebDriver driver)
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

    public String searchTrack()
    {
        driver.navigate().to(TRACK_SEARCH);
        inputSearchQuery.sendKeys(query);
        searchSubmitButton.click();
        return searchResultText.getText();
    }


    public String searchAlbum()
    {
        driver.navigate().to(ALBUM_SEARCH);
        inputSearchQuery.sendKeys(query);
        searchSubmitButton.click();
        return searchResultText.getText();
    }



}

