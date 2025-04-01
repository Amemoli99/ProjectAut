package org.example.action;

import org.example.Selector;
import org.example.page.OfferCardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class OfferCardAction {
       private OfferCardPage page;
       WebDriverWait wait;
       WebDriver driver;
       FooterAction avanti;
       Random rand = new Random();


       public OfferCardAction(WebDriver driver){
           this.page = new OfferCardPage(driver);
           this.driver= driver;
           this.wait= new WebDriverWait(driver, Duration.ofSeconds(500));
           this.avanti = new FooterAction(driver);
       }

       public void selezionaOffer(){
           wait.until(visibilityOfElementLocated(Selector.caricamento));
           wait.until(invisibilityOfElementLocated(Selector.caricamento));
           try{
               List<WebElement> offer = page.getOffer();
               if(!offer.isEmpty() && offer.size()>1){
                   //offer.get(rand.nextInt(offer.size()));
                    wait.until(ExpectedConditions.elementToBeClickable(offer.get(rand.nextInt(offer.size())))).click();
                   //elementToBeClickable(page.getAvanti()).apply(driver).click();
                   avanti.vaiAvanti();
               }else {
                   elementToBeClickable(offer.get(0)).apply(driver).click();
                   elementToBeClickable(page.getAvanti()).apply(driver).click();
               }
           }catch (Exception e){
                     System.out.println("Card non selezionata " + e.getMessage());
           }
       }

}