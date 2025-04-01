package org.example.action;

import org.example.Selector;
import org.example.page.InsurancePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class InsuranceAction {
    InsurancePage page;
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    public InsuranceAction(WebDriver driver){
        this.driver=driver;
        this.page= new InsurancePage(driver);
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(500));
    }

    public void selectIncurace(){
        wait.until(invisibilityOfElementLocated(Selector.caricamento));
        try{
            visibilityOf(page.getInsurance()).apply(driver).click();
            elementToBeClickable(page.nextPage()).apply(driver).click();
        }catch(Exception e){
            js.executeScript("arguments[0].click();",page.nextPage());
            System.out.println("Non è stato possibile cliccare sull'assicurazione " + e.getMessage());
        }
    }
}
