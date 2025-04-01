package org.example.action;

import org.example.Selector;
import org.example.page.CruiseCardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CruiseCardAction {

    private CruiseCardPage page;
    Random rand = new Random();
    WebDriverWait wait ;
    WebDriver driver;
    JavascriptExecutor js;
    public CruiseCardAction(WebDriver driver){
     this.page = new CruiseCardPage(driver);
     this.driver=driver;
     this.wait = new WebDriverWait (driver , Duration.ofMillis(200));
     this.js = (JavascriptExecutor) driver;
}


  public void openCardAction(){
       try
       {
            invisibilityOfElementLocated(Selector.caricamento);
            elementToBeClickable(page.openCard().get(0));
            WebElement indexRandom = page.openCard().get(rand.nextInt(page.openCard().size()));
            int index = page.openCard().indexOf(indexRandom);
            indexRandom.click();
            String idSelectCard = ("SelectItinerarySummary_"+index);
            WebElement clickCard = driver.findElement(By.cssSelector("#"+idSelectCard));
            visibilityOf(clickCard).apply(driver).click();

       }
       catch (NoSuchElementException | IndexOutOfBoundsException e )
       {
           wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
           openCardAction();
       }
  }

}
