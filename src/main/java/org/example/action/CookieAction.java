package org.example.action;

import org.example.Selector;
import org.openqa.selenium.WebDriver;
import org.example.page.CookiePage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CookieAction {
    private CookiePage page;
    WebDriver driver;
    WebDriverWait wait;
    public CookieAction(WebDriver driver){
        this.page= new CookiePage(driver);
        this.driver=driver;
        this.wait= new WebDriverWait(driver , Duration.ofSeconds(100));
    }
    public void cookie(){
        wait.until(invisibilityOfElementLocated(Selector.caricamento));

        try {
            visibilityOf(page.rifiuta()).apply(driver).click();
        }catch (Exception e){
            System.out.println("Non è stato possibile accettare i cookie" +e.getMessage());
        }
    }
}
