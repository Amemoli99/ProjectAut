package org.example.action;


import org.example.Selector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.example.page.FindYourCruisePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class FindYourCruiseAction {
    private FindYourCruisePage page;
    private WebDriver driver;
    private WebDriverWait wait;
    Random rand = new Random();

    public FindYourCruiseAction(WebDriver driver) {
        this.page = new FindYourCruisePage(driver);
        this.driver= driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(500));
    }

    public void searchCruise() {
        try {
            wait.until(invisibilityOfElementLocated(Selector.caricamento));
            page.getDestinationElement().click();
            wait.until(visibilityOf(page.getFirstCheckbox()));
            wait.until(elementToBeClickable(page.getFirstCheckbox())).click();

            selectDate();
            selectDeparture();

            wait.until(elementToBeClickable(page.getSearchButton())).click();
                visibilityOfElementLocated(Selector.caricamento);
                invisibilityOfElementLocated(Selector.caricamento);

        } catch (Exception e) {
            System.out.println("Non è stato possibile completare la ricerca" + e.getMessage());
        }
    }

    private void selectDate() {
        wait.until(elementToBeClickable(page.getDatePicker()));
        page.getDatePicker().click();
        wait.until(visibilityOf(driver.findElement(By.cssSelector(".vdp-datepicker__calendar--row"))));
        List<WebElement> monthEnebled = page.getSpecificDate().stream().filter(WebElement::isEnabled).collect(Collectors.toList());
        if(!monthEnebled.isEmpty()) {
            var indexMonth = monthEnebled.get(rand.nextInt(monthEnebled.size()));
            wait.until(elementToBeClickable(indexMonth));
            indexMonth.click();
        }
    }

    private void selectDeparture() throws InterruptedException {
        Thread.sleep(1000);
        elementToBeClickable(page.getDepartureDropdown()).apply(driver).click();
        wait.until(visibilityOf(driver.findElement(By.cssSelector(".dropdown__container"))));
        List<WebElement>departureEnabled = page.getDepartureOption().stream().filter(x->x.isEnabled()).collect(Collectors.toList());
        if(!departureEnabled.isEmpty()){
            var indexDeparture = departureEnabled.get(rand.nextInt(departureEnabled.size()));
            wait.until(elementToBeClickable(indexDeparture)).click();
        }
    }
}
