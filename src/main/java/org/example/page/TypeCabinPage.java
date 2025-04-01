package org.example.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TypeCabinPage {
    private final WebDriver driver;

    public TypeCabinPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getTitleCabin(){
        return  driver.findElement(By.cssSelector("[class=cabin-type__content__name]"));
    }

    public List<WebElement> getListCabin(){
        return driver.findElements(By.cssSelector("[automation-id^=cabin-type-selection-button]"));
    }

    public WebElement vaiAvanti(){
        return driver.findElements(By.cssSelector("a[automation-id^=nav-action-next]")).get(0);
    }
}

