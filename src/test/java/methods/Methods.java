package methods;

import base.BaseTest;
import helper.ElementHelper;
import helper.StoreHelper;
import model.ElementInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Methods {

    JsMethods jsMethods;
    ActionMethods actionMethods;
    WebDriver driver;
    WebDriverWait wait;

    public Methods() {
        this.driver = BaseTest.driver;
        this.jsMethods = new JsMethods();
        wait = new WebDriverWait(this.driver, 30);
        this.actionMethods = new ActionMethods(this.driver);
    }

    public By getBy(String key){
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        return  ElementHelper.getElementInfoToBy(elementInfo);
    }

    public WebElement findElement(String key){
        return wait.until(ExpectedConditions.presenceOfElementLocated(getBy(key)));
    }

    public List<WebElement> findElements(String key){
        return driver.findElements(getBy(key));
    }

    public void clickElement(String key){
        findElement(key).click();
    }

    public void sendKeys(String key, String text){
        findElement(key).sendKeys(text);
    }

    public void hoverElement(String key){
        actionMethods.hoverToElement(findElement(key));
    }

    public void hoverElement(WebElement element){
        actionMethods.hoverToElement(element);
    }

    public void assertText(String expect, String actual){
        Assert.assertEquals(getText(expect),actual);
    }

    public String getText(String key){
        return findElement(key).getText();
    }


    public void hoverToMenuItem(String key, String menuName){
        actionMethods.hoverToElement(getListElement(key,menuName));
    }

    public WebElement forListElements(String key,String menu){

        List<WebElement> elements = findElements(key);

        for(WebElement menuItem : elements){

            if (menuItem.getText().contains(menu)){
                return menuItem;
            }
        }

        return null;
    }

    public String getListGetText(String key, String name){
        return  forListElements(key,name).getText();
    }

    public WebElement getListElement(String key, String name){
        return  forListElements(key,name);
    }

    public void clickList(String key, String name){
        getListElement(key,name).click();
    }

    public void sendEnter(String key){
       findElement(key).sendKeys(Keys.RETURN);
    }

    public void expectMenu(String key,String actual){
        assertText(getListGetText(key,actual),actual);
    }

    public void waitSec(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkElementisDisplayed(String key) {
        return findElement(key).isDisplayed();
    }

}