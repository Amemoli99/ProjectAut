package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.model.Frame;

public class CheckOutPage {

    WebDriver driver;

    public CheckOutPage(WebDriver driver){
        this.driver=driver;
    }

     public WebElement getCardNumber(){
        return driver.findElement(By.cssSelector("[id=cardNumber]"));
     }
     public WebElement getExpireDate(){
        return driver.findElement(By.cssSelector("#expiry"));
     }

     public WebElement getCvv(){
        return driver.findElement(By.cssSelector("#cvv"));
     }

     public WebElement btnPay(){
        return driver.findElement(By.cssSelector("#payLabel"));
     }
}
