package org.example.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;


public class DeckPlanPage {
          WebDriver driver;

        public DeckPlanPage(WebDriver driver){
                this.driver=driver;
        }

        public WebElement vaiAvanti(){
            return driver.findElements(By.cssSelector("a[automation-id^=nav-action-next]")).get(0);
        }

        public WebElement getTitleCabin(){
            return  driver.findElement(By.cssSelector(".location--subtitle"));
        }

        public List<WebElement> getListNumberCabin(){
            return  driver.findElements(By.cssSelector("[class*=cabins-carousel__]"));


        }

}
