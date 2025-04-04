package org.example.action;


import org.example.Selector;
import org.openqa.selenium.WebDriver;
import org.example.page.FindYourCruisePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class FindYourCruiseAction {
    private FindYourCruisePage page;
    private WebDriver driver;
    WebDriverWait wait;
    public FindYourCruiseAction(WebDriver driver) {
        this.page = new FindYourCruisePage(driver);
        this.driver= driver;
        this.wait= new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    public void searchCruise() {
        try {
            invisibilityOfElementLocated(Selector.caricamento);
            page.getDestinationElement().click();
            wait.until(elementToBeClickable(page.getFirstCheckbox())).click();

            wait.until(elementToBeClickable(page.getDatePicker())).click();
            Random rand = new Random();
            List<WebElement> monthEnebled = page.getSpecificDate();
            wait.until(elementToBeClickable(monthEnebled.get(rand.nextInt(page.getSpecificDate().size())))).click();
            page.getDepartureDropdown().click();

            try {
                page.getDepartureOption().click();
                page.getSearchButton().click();
                visibilityOfElementLocated(Selector.caricamento);
                invisibilityOfElementLocated(Selector.caricamento);
            } catch (NullPointerException e) {
                System.out.println("Elemento non trovato: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Non è stato possibile completare la ricerca" + e.getMessage());
        }
    }
}
