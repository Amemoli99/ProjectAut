package org.example;

import org.example.action.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Start {


    public static void main (String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.msccrociere.it/");
        //driver.get("https://www.msccrociere.it/Booking?CruiseID=OX20250704BRIBRI&Type=CROL&PriceCode=OXC00619IT5021PR&NewCruise=true&MacroCategory=&Category=IB&src=21FABB68D44445E3A9FD1D617123A4C3#/experience");

         CookieAction cookie = new CookieAction(driver);
        FindYourCruiseAction fyc = new FindYourCruiseAction(driver);
        CruiseCardAction card = new CruiseCardAction(driver);
        OfferCardAction offer = new OfferCardAction(driver);
        TypeCabinAction cabin = new TypeCabinAction(driver);
        ExperenceAction exp = new ExperenceAction(driver);
        PositionCabinAction pageCabin = new PositionCabinAction(driver);
        DeckPlaneAction deckPlane = new DeckPlaneAction(driver);
        GuestInfoAction form = new GuestInfoAction(driver);
        SpecialOfferCabinAction specialOffer = new SpecialOfferCabinAction(driver);
        InsuranceAction insurance = new InsuranceAction(driver);

             cookie.cookie();
            fyc.searchCruise();
            card.openCardAction();
            offer.selezionaOffer();
           switch (cabin.selectCabin()) {
                case "MSC Yacht Club":
                pageCabin.positionCabin();
                deckPlane.setDeckPlane();
                if(form.url().contains("#/optional-items"))
                    specialOffer.choose();
                insurance.selectIncurace();
                break;
            default:
                if (exp.selectExp().equals("BELLA")) {
                         if(form.url().contains("#/optional-items"))
                                   specialOffer.choose();
                                  insurance.selectIncurace();
                }
                else{
                    pageCabin.positionCabin();
                    deckPlane.setDeckPlane();
                    if(form.url().contains("#/optional-items"))
                        specialOffer.choose();
                    insurance.selectIncurace();







                }



        }






    }
}
