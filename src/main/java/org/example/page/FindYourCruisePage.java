package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;


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
        return driver.findElement(By.cssSelector("[automation-id=search-dates]"));
    }

    public WebElement getDepartureDropdown() {
        return driver.findElement(By.cssSelector("div[automation-id='search-departures']"));
    }

    public List<WebElement> getSpecificDate() {
        return  driver.findElements(By.cssSelector("span[class='cell month']"));
    }

    public List<WebElement> getDepartureOption() {
        return driver.findElements(By.cssSelector("div[automation-id^=checklist-item]"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.cssSelector(".search__button[automation-id='search-button']"));
    }
}
