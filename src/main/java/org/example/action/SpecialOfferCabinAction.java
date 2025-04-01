package org.example.action;

import org.example.Selector;
import org.example.page.SpecialOfferCabinPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SpecialOfferCabinAction {
    WebDriver driver;
    SpecialOfferCabinPage page;
    JavascriptExecutor js;
    WebDriverWait wait;

    public SpecialOfferCabinAction(WebDriver driver){
        this.driver=driver;
        this.page= new SpecialOfferCabinPage(driver);
        this.wait= new WebDriverWait(driver , Duration.ofSeconds(500));
        this.js = (JavascriptExecutor) driver;
    }

    public void choose(){
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(Selector.caricamento));
            visibilityOf(page.getAvanti());
            elementToBeClickable(page.getAvanti()).apply(driver).click();
        }catch (ElementClickInterceptedException e){
                js.executeScript("arguments[0].click();", page.getAvanti());
               System.out.println("Non sono riuscito ad andare avanti" + e.getMessage());
        }
    }
}
