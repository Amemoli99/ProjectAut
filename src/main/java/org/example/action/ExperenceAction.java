package org.example.action;

import org.example.Selector;
import org.example.page.ExperencePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ExperenceAction {
    WebDriver driver;
    ExperencePage page ;
    WebDriverWait wait;
    FooterAction avanti;
    Random rand = new Random();

    public ExperenceAction(WebDriver driver){
        this.page = new ExperencePage(driver);
        this.driver=driver;
        this.avanti = new FooterAction(driver);
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(500));

    }


    public String selectExp() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(Selector.caricamento));
        List<WebElement> exp = driver.findElements(Selector.listEsperienze);
        if(!exp.isEmpty() && exp.size()>1) {
            try {
                   wait.until(ExpectedConditions.elementToBeClickable(exp.get(rand.nextInt(exp.size())))).click();
                   wait.until(ExpectedConditions.elementToBeClickable(Selector.avanti)).click();
                   return page.titleExp();
            } catch (Exception e) {
                          System.out.println("Esperienza non Selezionata");
            }
        }
        avanti.vaiAvanti();
        return page.titleExp();
    }
}
