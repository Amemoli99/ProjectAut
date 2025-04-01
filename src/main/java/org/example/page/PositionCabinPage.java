package org.example.page;

import org.example.Selector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class PositionCabinPage {
    private WebDriver driver;

    public PositionCabinPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getCaricamento(){
        return driver.findElement(Selector.caricamento);
    }

    public List<WebElement> getListCabin(){
           return    driver.findElements(By.cssSelector("[id^=responsive-cabins-slider]"));
    }

    public WebElement getAvanti(){
        return    driver.findElement(By.cssSelector("a[automation-id^=nav-action-next]"));
    }
}
