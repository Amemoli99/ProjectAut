package org.example.action;

import com.github.javafaker.Faker;

import org.example.Selector;
import org.example.page.GuestInfoPage;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class GuestInfoAction {

    private GuestInfoPage page;
    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor js = null;
    Random rand = new Random();
    Faker fake = new Faker();
    FooterAction avanti;
    public GuestInfoAction(WebDriver driver) {
        this.page = new GuestInfoPage(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        this.avanti= new FooterAction(driver);
    }


    private List<String> generaDati(int npax, Supplier<String> generatore) {
        List<String> datiList = new ArrayList<>();
        for (int i = 0; i < npax; i++) {
            datiList.add(generatore.get());
        }
        return datiList;
    }

    private void compilaCampi(List<WebElement> elements, String campoPrefisso, List<String> value) {
        for (int i = 0; i < elements.size(); i++) {
           WebElement utente = elements.get(i);
            String elementoId = "#" + campoPrefisso + (i + 1) + "_1";              // Genera il selettore dinamico in base al prefisso
            try {
                typeValue(value, elementoId, i);
            } catch (ElementNotInteractableException e) {
                js = (JavascriptExecutor) driver;                                                                         // Usa JavascriptExecutor se l'elemento non è interattivo
                js.executeScript("arguments[0].scrollIntoView(true);", utente);
                utente.sendKeys(value.get(i));
            } catch (Exception e) {
                                                                                                                          // Cattura eccezione e stampa il mess.
                System.out.println("Errore nel compilare il campo: " + e.getMessage());
            }
        }
    }

    private void typeValue(List<String> value, String elementoId, int i) {
        WebElement campo = driver.findElement(By.cssSelector(elementoId));                                           // Trova l'elemento dinamico
        String tagName = campo.getTagName();
        visibilityOf(campo);
        wait.until(ExpectedConditions.elementToBeClickable(campo));                      // Aspetta che l'elemento sia cliccabile
         if(campo.isEnabled()) {
             campo.click();
             if ("input".equalsIgnoreCase(tagName) || "textarea".equalsIgnoreCase(tagName)) {
                 campo.sendKeys(value.get(i));                                                                            // Clicca e inserisci il valore
             } else if ("div".equalsIgnoreCase(tagName)) {
                 WebElement gender = campo.findElement(By.tagName("select"));
                 Select dropdown = new Select(gender);
                 dropdown.selectByValue(value.get(i));
             } else {
                 System.out.println("Tipo di elemento non gestito" + tagName);
             }
         }
    }

    private void compilaPassenger() {
        String url=null;
        wait.until(ExpectedConditions.invisibilityOfElementLocated(Selector.caricamento));
        List<String> nomi = generaDati(page.nome().size(), () -> fake.name().firstName());
        List<String> cognomi = generaDati(page.cognome().size(), () -> fake.name().lastName());

        List<String> dateNascita = generaDati(page.dataNascita().size(), () -> {
            Date data = fake.date().birthday(18, 65);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            return sdf.format(data);
        });

        List<String> generi = generaDati(page.getGender().size(), () -> rand.nextBoolean() ? "M" : "F");
        List<String> residence = generaDati(page.getResidence().size() , () -> rand.nextBoolean() ? "ITA" : "DEU");
        String email = fake.name().username() + "@yopmail.com";
        List<String> telephone = generaDati(page.getphoneNumber().size(), ()-> fake.numerify("###-###-###"));

        compilaCampi(page.nome(), "FirstName_", nomi);
        compilaCampi(page.cognome(), "LastName_", cognomi);
        compilaCampi(page.dataNascita(), "DateOfBirth_", dateNascita);
        page.getEmail().sendKeys(email);
        page.getConfirmEmail().sendKeys(email);
        compilaCampi(page.getGender(), "Gender_", generi);
        compilaCampi(page.getResidence(), "CountryOfResidence_" , residence);
        compilaCampi(page.getphoneNumber(),"PhoneNumber_" , telephone);
    }

    public String url(){
        compilaPassenger();
        //elementToBeClickable(page.vaiAvanti());
        //page.vaiAvanti().click();
        avanti.vaiAvanti();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(Selector.caricamento));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selector.caricamento));
        return driver.getCurrentUrl();
    }


}

