package org.example.action;

import org.example.page.PositionCabinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.Random;

public class PositionCabinAction {
    PositionCabinPage page;
     WebDriver driver;
    WebDriverWait wait;
    Random rand = new Random();

    public PositionCabinAction(WebDriver driver){
        this.driver=driver;
        this.page= new PositionCabinPage(driver);
        this.wait= new WebDriverWait( driver , Duration.ofSeconds(500));
    }

    public void positionCabin(){
           wait.until(ExpectedConditions.invisibilityOf(page.getCaricamento()));
           if(!page.getListCabin().isEmpty() && page.getListCabin().size()>1){
                   WebElement seleziona = page.getListCabin().get(rand.nextInt(page.getListCabin().size()));
                   if (seleziona.isSelected()) {
                       seleziona.click();
                       page.getAvanti().click();
                   }

               } else
                      page.getAvanti().click();


    }

}
