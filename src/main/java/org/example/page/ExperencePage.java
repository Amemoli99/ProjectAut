package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ExperencePage {
    private final WebDriver driver;


    public ExperencePage(WebDriver driver){
        this.driver=driver;
    }

    public String titleExp(){
        return driver.findElement(By.cssSelector(".title-name")).getText();
    }
}