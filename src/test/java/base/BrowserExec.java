package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserExec {

    private static  WebDriver driver;


    public static WebDriver getChromeDriver(String browserName){

        DesiredCapabilities desiredCapabilities =  DesiredCapabilities.chrome();
        desiredCapabilities.setJavascriptEnabled(true);
        desiredCapabilities.setBrowserName(browserName);
        try {
        System.setProperty(BaseTest.configProp.getString("chromePath"), BaseTest.configProp.getString("chromeDriverPath"));
        } catch (Exception e) {
            System.setProperty(BaseTest.configProp.getString("chromePath"), BaseTest.configProp.getString("chromeDriverPathMac"));
        }

        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver getFirefox(String browserName){

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities.setJavascriptEnabled(true);
        desiredCapabilities.setBrowserName(browserName);
        System.setProperty(BaseTest.configProp.getString("chromePath"), BaseTest.configProp.getString("chromeDriverPath"));
        driver = new FirefoxDriver();
        return  driver;
    }
}