package org.example;

import org.openqa.selenium.By;


public class Selector {

          public static final By avanti = By.cssSelector("a[automation-id^=nav-action-next]");
          public static final By avantiForm = By.cssSelector("div[class='priceDetailContainer'] a[class='button btn btn-next text-center']");
          public static final By caricamento = By.cssSelector("[class=loader],.generic-loader");
          public static final By cookieButton = By.cssSelector("#didomi-notice-disagree-button");
          public static final By buttonDestinazioni = By.cssSelector("[automation-id=search-destination]");
          public static final By destinazione = By.cssSelector("[automation-id=checklist-item-0]");
          public static final By buttonData = By.cssSelector("[automation-id=search-dates]");
          public static final By data = By.cssSelector("[automation-id=datepicker-month-3-2026]");
          public static final By buttonPorti = By.cssSelector("[automation-id=search-departures]");
          public static final By porto = By.cssSelector("[automation-value=bri]");
          public static final By cerca = By.cssSelector("[automation-id=search-button]");

          public static final By listTariffe = By.cssSelector("[automation-id^=price-type-selection-button]");
          public static final By listCabin = By.cssSelector("[automation-id^=cabin-type-selection-button]");
          public static final By listEsperienze = By.cssSelector("[automation-id^=cabin-experience-selection-button]");
          public static final By positionCabin = By.cssSelector("[automation-id^=cabin-type-selection-button]");
          public static final By cabine = By.cssSelector("#Cabins");

          public static final By name1_1 = By.cssSelector("[name*=first-name]");
          public static final By name2_1 = By.cssSelector("#FirstName_2_1");
          public static final By lastName1_1 = By.cssSelector("#LastName_1_1");
          public static final By lastName2_1 = By.cssSelector("#LastName_2_1");
          public static final By DataBirth1_1 = By.cssSelector("#DateOfBirth_1_1");
          public static final By DataBirth2_1 = By.cssSelector("#DateOfBirth_2_1");
          public static final By gender1_1 = By.cssSelector("#Gender_1_1");
          public static final By gender2_1 = By.cssSelector("#Gender_2_1");
          public static final By email1_1 = By.cssSelector("#Email__1_1");
          public static final By confirmEmail1_1 = By.cssSelector("#ConfirmEmail_1_1");
          public static final By phoneNumber_1_1 = By.cssSelector("#PhoneNumber_1_1");
          public static final By residence2_1 = By.cssSelector("#CountryOfResidence_2_1");

          public static final By documentiFirstP = By.cssSelector("#DocumentType_1_1");
          public static final By numeroDocument = By.cssSelector("#DocumentNumber_1_1");
          public static final By dataScadenza = By.cssSelector("##DateOfExpiry_1_1");
          public static final By nazionalita = By.cssSelector("#Nationality_1_1");

         public static final By documentiFirstP2_1 = By.cssSelector("#DocumentType_2_1");
         public static final By numeroDocument2_1 = By.cssSelector("#DocumentNumber_2_1");
         public static final By dataScadenza2_1 = By.cssSelector("##DateOfExpiry_2_1");
         public static final By nazionalita2_1 = By.cssSelector("#Nationality_2_1");

         public static final By emergencyName = By.cssSelector("#EmergencyName_1");
         public static final By emergencyNumber = By.cssSelector("#EmergencyNumber_1");
         public static final By phoneEmergency = By.cssSelector("#PhoneNumber_1_1");
}
