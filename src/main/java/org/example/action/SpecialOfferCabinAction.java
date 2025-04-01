package org.example.action;

import org.example.Selector;
import org.example.page.SpecialOfferCabinPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SpecialOfferCabinAction {
    WebDriver driver;
    SpecialOfferCabinPage page;
    JavascriptExecutor js;
    WebDriverWait wait;

    public SpecialOfferCabinAction(WebDriver driver){
        this.driver=driver;
        this.page= new SpecialOfferCabinPage(driver);
        this.wait= new WebDriverWait(driver , Duration.ofMillis(5000));
        this.js = (JavascriptExecutor) driver;
    }

    public void choose(){
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(Selector.caricamento));
            visibilityOf(page.getAvanti());
            elementToBeClickable(page.getAvanti()).apply(driver).click();
            wait.until(visibilityOfElementLocated(Selector.caricamento));
            wait.until(invisibilityOfElementLocated(Selector.caricamento));
        }catch (ElementClickInterceptedException e){
                js.executeScript("arguments[0].click();", page.getAvanti());
               System.out.println("Non sono riuscito ad andare avanti" + e.getMessage());
        }
    }
}
