package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CruiseCardPage {


    private WebDriver driver;

    public CruiseCardPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getSearchResult(){
        return driver.findElement(By.cssSelector(".skeleton-itinerary-card__left"));
    }

    public List<WebElement> openCard(){
            return driver.findElements(By.cssSelector(".button.itinerary-card-price__see-detail"));
    }



    public WebElement selectCard(){
        return driver.findElement(By.cssSelector("[id^=SelectItinerarySummary_]"));
    }
}
