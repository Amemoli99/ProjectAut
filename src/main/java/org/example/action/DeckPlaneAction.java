package org.example.action;

import org.example.Selector;
import org.example.page.DeckPlanPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;


import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class DeckPlaneAction {
    DeckPlanPage page;
    private WebDriverWait wait;
    private WebDriver driver;
    Random rand = new Random();
    JavascriptExecutor js ;

    public DeckPlaneAction(WebDriver driver) {
        this.page = new DeckPlanPage(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        this.js= (JavascriptExecutor) driver;
    }

    public void setDeckPlane() {
        wait.until(invisibilityOfElementLocated(Selector.caricamento));
        try {
            visibilityOf(page.getListNumberCabin().get(0));
            List<WebElement> cabin = page.getListNumberCabin();
            if (!cabin.isEmpty() && cabin.size() > 1) {
                WebElement randomNumberCabin = cabin.get(rand.nextInt(cabin.size()));
                wait.until(refreshed(elementToBeClickable(randomNumberCabin))).click();
                wait.until(elementToBeClickable(page.vaiAvanti())).click();
            } else {
                wait.until(elementToBeClickable(page.vaiAvanti())).click();
            }
        }catch (ElementClickInterceptedException ex)
        {
            js.executeScript("arguments[0].scrollIntoView(true);", page.getTitleCabin());
            setDeckPlane();
        }
    }
}