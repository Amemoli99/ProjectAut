package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CookiePage {
    private WebDriver driver;

    public CookiePage(WebDriver driver){
           this.driver = driver;

    }

    public WebElement rifiuta(){
            return driver.findElement(By.cssSelector("#didomi-notice-disagree-button"));
    }
}
