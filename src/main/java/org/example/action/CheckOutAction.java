package org.example.action;

import org.example.Selector;
import org.example.page.CheckOutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CheckOutAction {

    WebDriver driver;
    CheckOutPage page;
    FooterAction btnPay;
    WebDriverWait wait;
    JavascriptExecutor js ;
    public CheckOutAction(WebDriver driver){
        this.driver=driver;
        this.page = new CheckOutPage(driver);
        this.btnPay= new FooterAction(driver);
        this.wait= new WebDriverWait(driver , Duration.ofMillis(5000));
        this.js = (JavascriptExecutor) driver;
    }

    public void payCruise() throws InterruptedException{
        try{
             wait.until(visibilityOfElementLocated(Selector.caricamento));
             wait.until(invisibilityOfElementLocated(Selector.caricamento));
             btnPay.vaiAvanti();
             wait.until(visibilityOfElementLocated(Selector.caricamento));
             wait.until(invisibilityOfElementLocated(Selector.caricamento));
             Thread.sleep(5000);
             driver.switchTo().frame(driver.findElement(By.cssSelector("#datatransPaymentFrame")));
             visibilityOf(driver.findElement(By.cssSelector("[data-method=ECA]"))).apply(driver).click();
             Thread.sleep(2000);
             cartMC();
             //wait.until(elementToBeClickable(page.btnPay())).click();
        }catch (ElementClickInterceptedException ex){
                  System.out.println("Pagina non trovata");
        }
    }

    protected void cartMC(){
            wait.until(elementToBeClickable(page.getCardNumber())).click();
            js.executeScript("arguments[0].value = arguments[1];", page.getCardNumber(), "5200000000000007");
            wait.until(elementToBeClickable(page.getExpireDate())).click();
            js.executeScript("arguments[0].value = arguments[1];", page.getExpireDate(), "06/28");
            wait.until(elementToBeClickable(page.getCvv())).click();
            js.executeScript("arguments[0].value = arguments[1];", page.getCvv(), "123");
    }

}
