package org.example.action;

import org.example.Selector;
import org.example.page.TypeCabinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class TypeCabinAction {
    TypeCabinPage page;
    WebDriver driver;
    WebDriverWait wait;
    FooterAction btnNext;
    Random rand = new Random();

    public TypeCabinAction(WebDriver driver){
        this.driver=driver;
        this.page = new TypeCabinPage(driver);
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(500));
        this.btnNext= new FooterAction(driver);


    }

    public String selectCabin() {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(Selector.caricamento));
            List<WebElement> cabin = page.getListCabin();
            if (!cabin.isEmpty() && cabin.size() > 1) {
                     WebElement randomCabin = cabin.get(rand.nextInt(cabin.size()));
                     if(randomCabin.isEnabled()){
                                 wait.until(ExpectedConditions.elementToBeClickable(randomCabin)).click();
                                 wait.until(invisibilityOfElementLocated(Selector.caricamento));
                                  btnNext.vaiAvanti();
                                  //wait.until(elementToBeClickable(page.vaiAvanti())).click();
                                  return page.getTitleCabin().getText();
                     }

            }

           btnNext.vaiAvanti();

            return page.getTitleCabin().getText();

    }
}
