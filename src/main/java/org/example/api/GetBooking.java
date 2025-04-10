package org.example.api;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

public class GetBooking {

    public static void main(String[] args) throws Exception {
        getBookingApi();
    }

    public static void getBookingApi() throws Exception {

        HttpResponse<String> response = Unirest.post("http://172.16.1.27:8089/mscbee/services/cruise/itineraryDetail")
                .header("UserId", "WEBB2CESPSC")
                .header("Password", "fb090046b513c8655b6584c46c593bfca6b511f9ccfb0c6ca513d5bc0fcba35a")
                .header("AgencyId", "AS900000")
                .header("Content-Type", "application/xml")
                .body("<DtsCruiseItineraryDetailRequest xmlns=\"DTS\">\n    <BookingContext>\n        <AgencyId>AS9000000</AgencyId>\n    </BookingContext>\n    <CruiseComponent>\n        <CruiseID>VI20250405FDFSOU</CruiseID>\n        <LanguageCode>ITA</LanguageCode>\n        <OfficeCode>ITA</OfficeCode>\n    </CruiseComponent>\n</DtsCruiseItineraryDetailRequest>")
                .asString();

        String xmlResponse =response.getBody();
        formatAndPrintXML(xmlResponse);
    }

    public static void formatAndPrintXML(String xml) throws Exception {
        // Crea un parser di documenti XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // Per supportare i namespace

        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource inputSource = new InputSource(new StringReader(xml));
        Document doc = builder.parse(inputSource);

        // Usa Transformer per formattare l'XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // Imposta il formato di output (indentazione)
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Crea il flusso di output per la stampa
        StringWriter stringWriter = new StringWriter();
        StreamResult result = new StreamResult(stringWriter);

        // Trasforma e scrivi l'output formattato
        transformer.transform(new DOMSource(doc), result);

        // Ottieni il risultato formattato
        String formattedXML = stringWriter.toString();

        // Stampa l'XML formattato
        System.out.println(formattedXML);
    }
}
