package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InsurancePage {
    WebDriver driver;

    public InsurancePage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getInsurance(){
        return driver.findElement(By.cssSelector("span[for='op_cab_0_ins1']"));
    }

    public WebElement nextPage(){
        return  driver.findElements(By.cssSelector("[automation-id^=nav-action-next]")).get(1);
    }
}
