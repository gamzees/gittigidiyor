package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import read.ReadFile;

import java.util.ResourceBundle;

public class BaseTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    public static ResourceBundle configProp = ReadFile.readProp("Configuration");

    public static WebDriver driver;

    @Before
    public void beforePlan(){

        logger.info("======================================");
        logger.info("    Test Başlatıldı    ");
        logger.info("======================================");
    }

    @BeforeScenario
    public void beforeScenario() {

        String browserName = configProp.getString("browserName");
        if (browserName.equals("chrome")){
            logger.info("chrome");
            driver = BrowserExec.getChromeDriver(browserName);
            logger.info("chrome");
        }else {
            logger.info("chrome yok");
            driver = BrowserExec.getFirefox(browserName);
        }
        driver.get(configProp.getString("baseURL"));
        driver.manage().window().maximize();
    }

    @After
    public void after(){
        logger.info("======================================");
        logger.info("    Test Bitti    ");
        logger.info("======================================");
    }

    @AfterScenario
    public void afterScenario() {
        driver.quit();
    }
}