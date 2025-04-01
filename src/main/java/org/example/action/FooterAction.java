package org.example.action;

import net.bytebuddy.implementation.bytecode.Throw;
import org.example.Selector;
import org.example.page.FooterPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.UndeclaredThrowableException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class FooterAction{

    WebDriver driver;
    FooterPage page;
    WebDriverWait wait;
    JavascriptExecutor js;

    public FooterAction(WebDriver driver)
    {
        this.driver=driver;
        this.page = new FooterPage(driver);
        this.wait= new WebDriverWait(driver , Duration.ofMillis(2000));
    }

   /* public void vaiAvanti(){
        try{
               wait.until(visibilityOfElementLocated(Selector.caricamento));
               wait.until(invisibilityOfElementLocated(Selector.caricamento));
               goAvanti();
           }catch(NoSuchElementException ex){
                 goAvanti();
        }
    }*/

    public void vaiAvanti() {

        List<WebElement> getAvanti;
        try
        {

            getAvanti = page.buttonAvanti();
            if (!getAvanti.isEmpty())
            {
                getAvanti.stream()
                        .filter(x -> x.isDisplayed())
                        .collect(Collectors.toList())
                        .get(0)
                        .click();
            }
        }
        catch (IndexOutOfBoundsException | NoSuchElementException ex)
        {
              js.executeScript("arguments[0].click();", page.buttonAvanti().stream().filter(x -> x.isDisplayed()).collect(Collectors.toList()).get(0));
        }

    }
}
