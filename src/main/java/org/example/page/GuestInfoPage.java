package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GuestInfoPage {
    WebDriver driver;
    public GuestInfoPage(WebDriver driver){
        this.driver= driver;
    }

     public List<WebElement> passenger(){
        return driver.findElements(By.cssSelector("[class*=passenger-wrapper]"));
     }

     public List<WebElement> nome(){
        return driver.findElements(By.cssSelector("[id^=FirstName_]"));
     }
     public List<WebElement> cognome(){
        return driver.findElements(By.cssSelector("[id^=LastName_]"));
     }

     public List<WebElement> dataNascita(){
        return driver.findElements(By.cssSelector("[id^=DateOfBirth_]"));
     }

     public WebElement getEmail(){
        return driver.findElement(By.cssSelector("#Email__1_1"));
     }
     public WebElement getConfirmEmail(){
        return driver.findElement(By.cssSelector("#ConfirmEmail_1_1"));
     }
     public List<WebElement> getGender(){
        return driver.findElements(By.cssSelector("[id^=Gender_]"));
     }

     public List <WebElement> getResidence(){
            return driver.findElements(By.cssSelector("[id^=CountryOfResidence_]"));
     }
    public List <WebElement> getphoneNumber(){
        return driver.findElements(By.cssSelector("[id^=PhoneNumber_]"));
    }


    public WebElement vaiAvanti(){
        return driver.findElements(By.cssSelector("a[automation-id^=nav-action-next]")).get(1);
    }

}
