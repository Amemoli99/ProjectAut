package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FindYourCruisePage {
    private WebDriver driver;

    public FindYourCruisePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDestinationElement() {
        return driver.findElement(By.cssSelector("div[automation-id='search-destination']"));
    }

    public WebElement getFirstCheckbox() {
        return driver.findElement(By.className("checkbox-label__text"));
    }

    public WebElement getDatePicker() {
        return driver.findElement(By.cssSelector("div[automation-id='search-dates']"));
    }

    public WebElement getDepartureDropdown() {
        return driver.findElement(By.cssSelector("div[automation-id='search-departures']"));
    }

    public WebElement getSpecificDate() {
        return  driver.findElement(By.cssSelector(".cell.month[automation-id='datepicker-month-3-2026']"));
    }

    public WebElement getDepartureOption() {
        return driver.findElement(By.cssSelector("[automation-id^=checklist-item-]"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.cssSelector(".search__button[automation-id='search-button']"));
    }
}
