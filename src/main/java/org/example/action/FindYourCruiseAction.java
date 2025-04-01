package org.example.action;


import org.example.Selector;
import org.openqa.selenium.WebDriver;
import org.example.page.FindYourCruisePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class FindYourCruiseAction {
    private FindYourCruisePage page;
    private WebDriver driver;
    public FindYourCruiseAction(WebDriver driver) {
        this.page = new FindYourCruisePage(driver);
        this.driver=driver;
    }

    public void searchCruise() {
        try {
            invisibilityOfElementLocated(Selector.caricamento);
            page.getDestinationElement().click();
            elementToBeClickable(page.getFirstCheckbox()).apply(driver).click();
            elementToBeClickable(page.getDatePicker()).apply(driver).click();
            visibilityOf(page.getSpecificDate()).apply(driver).click();

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
