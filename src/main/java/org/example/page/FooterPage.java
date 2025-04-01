package org.example.page;

import org.example.Selector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class FooterPage {

    WebDriver driver;

    public FooterPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement load(){
        return driver.findElement(Selector.caricamento);
    }

    public List<WebElement> buttonAvanti(){
        return driver.findElements(By.cssSelector("[automation-id^=nav-action-next]"));
    }

}
