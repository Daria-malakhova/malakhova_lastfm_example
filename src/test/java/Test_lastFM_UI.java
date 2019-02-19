import Steps.Steps;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

    public class Test_lastFM_UI {


        private final String login = "daria_malakhova";
        private final String password = "test!2";
        private Steps steps;
        private final Logger logger = Logger.getLogger(Test_lastFM_UI.class);
        private final String query = "TesseracT";
        public static WebDriver driver;

        @Before
        public void setUp(){
            this.steps = new Steps();
            this.steps.initWebDriver(Steps.Browser.CHROME);
        }

        @Test
        public void loginLastFM(){
            this.steps.loginLastFm(login, password);
            Assert.assertEquals(steps.getUserName(), login);
        }

        @Test
        public void logoutLastFM(){
            this.steps.loginLastFm(login, password);
            this.steps.logoutFromLastFm();
            Assert.assertEquals(steps.getTextIcon(),"Login");
        }

        @Test
        public void trackSearchLastFM(){
            this.steps.loginLastFm(login, password);
            Assert.assertTrue(steps.isSearchTrackCompleted(query));

        }

        @Test
        public void albumSearchLastFM(){
            this.steps.loginLastFm(login, password);
            Assert.assertTrue(steps.isSearchAlbumCompleted(query));
        }

        @After
        public void tearDown(){
            this.steps.closeDriver();
        }

    }
