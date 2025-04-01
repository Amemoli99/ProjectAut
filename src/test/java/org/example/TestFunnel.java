package org.example;

import org.example.action.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.time.Duration;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFunnel {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
        driver.manage().window().maximize();
        driver.get("https://qacm-it.msccruises.com/");
        //Runtime.getRuntime().exec("C:\\Users\\anton\\Desktop\\scriptCertificato.exe");

        try{
            Thread.sleep(5000);

        } catch (RuntimeException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(1)
    public void cookieActionTest() {
        CookieAction cookie = new CookieAction(driver);
        cookie.cookie();
    }

    @Test
    @Order(2)
    public void fYCActionTest() {
        FindYourCruiseAction fyc = new FindYourCruiseAction(driver);
        fyc.searchCruise();
    }

    @Test
    @Order(3)
    public void cruiseCardActionTest() {
        CruiseCardAction card = new CruiseCardAction(driver);
        card.openCardAction();
    }

    @Test
    @Order(4)
    public void offerCardActionTest() {
        OfferCardAction offer = new OfferCardAction(driver);
        offer.selezionaOffer();
    }


    @Test
    @Order(5)
    public void testSelectCabin() {
        TypeCabinAction cabin = new TypeCabinAction(driver);
        PositionCabinAction pageCabin = new PositionCabinAction(driver);
        DeckPlaneAction deckPlane = new DeckPlaneAction(driver);
        GuestInfoAction form = new GuestInfoAction(driver);
        SpecialOfferCabinAction specialOffer = new SpecialOfferCabinAction(driver);
        InsuranceAction insurance = new InsuranceAction(driver);

        String cabinType = cabin.selectCabin();
        if ("MSC Yacht Club".equals(cabinType)) {
            pageCabin.positionCabin();
            deckPlane.setDeckPlane();
            if (form.url().contains("#/optional-items"))
                specialOffer.choose();
            insurance.selectIncurace();
        }
        testSelectExperience();

    }

    public void testSelectExperience() {
        GuestInfoAction form = new GuestInfoAction(driver);
        SpecialOfferCabinAction specialOffer = new SpecialOfferCabinAction(driver);
        InsuranceAction insurance = new InsuranceAction(driver);
        ExperenceAction exp = new ExperenceAction(driver);
        PositionCabinAction pageCabin = new PositionCabinAction(driver);
        DeckPlaneAction deckPlane = new DeckPlaneAction(driver);


        String experienceType = exp.selectExp();
        if ((experienceType).equals("BELLA")) {
            specialOffer.choose();
            insurance.selectIncurace();
        } else {
            pageCabin.positionCabin();
            deckPlane.setDeckPlane();
            if (form.url().contains("#/optional-items")) {
                specialOffer.choose();
                insurance.selectIncurace();
            }
        }

    }

   /* @AfterAll
    public static void quit()
    {
        driver.quit();
    }*/
}
