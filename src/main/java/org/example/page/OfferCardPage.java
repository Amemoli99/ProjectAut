package org.example.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;


public class OfferCardPage {
    private WebDriver driver;


    public OfferCardPage(WebDriver driver){
           this.driver = driver;
    }

    public List<WebElement> getOffer(){
        return driver.findElements(By.cssSelector("[automation-id^=price-type-selection-button]"));
    }

    public WebElement getAvanti(){
        return driver.findElements(By.cssSelector("[automation-id=nav-action-next]")).get(0);
    }
}
