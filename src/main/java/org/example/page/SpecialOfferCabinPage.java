package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SpecialOfferCabinPage {
    WebDriver driver;

    public SpecialOfferCabinPage(WebDriver driver){
        this.driver=driver;
    }


    public WebElement getAvanti(){
        return  driver.findElements(By.cssSelector("[automation-id^=nav-action-next]")).get(1);
    }


}
