package org.example.api;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class GetBooking {


   public String getBookingApi(String bookingNum , String firstName , String lastName , String dateOfBirth){
       try {
           Unirest.config().socketTimeout(10000).connectTimeout(5000);
           HttpResponse<String> response = Unirest.get("https://services-uat.msccruises.com/booking/getBookings")
                   .queryString("lang", "en-US")
                   .queryString("bookingNum", bookingNum) // Parametro dinamico
                   .queryString("isLL", "true")
                   .queryString("firstName", firstName)   // Parametro dinamico
                   .queryString("lastName", lastName)     // Parametro dinamico
                   .queryString("dateOfBirth", dateOfBirth)                   .header("Accept", "application/json, text/plain, */*")
                   .header("Accept-Language", "en")
                   .header("Cache-Control", "no-cache")
                   .header("Connection", "keep-alive")
                   .header("ContentType", "application/json")
                   .header("Origin", "https://qa4cm-us.msccruises.com")
                   .header("Pragma", "no-cache")
                   .header("Referer", "https://qa4cm-us.msccruises.com/")
                   .header("Sec-Fetch-Dest", "empty")
                   .header("Sec-Fetch-Mode", "cors")
                   .header("Sec-Fetch-Site", "same-site")
                   .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36 Edg/115.0.1901.203")
                   .header("sec-ch-ua", "\"Not/A)Brand\";v=\"99\", \"Microsoft Edge\";v=\"115\", \"Chromium\";v=\"115\"")
                   .header("sec-ch-ua-mobile", "?0")
                   .header("sec-ch-ua-platform", "\"Windows\"")
                   .asString();

           return response.getBody();
       }catch (Exception e ){
           e.printStackTrace();
           return "Errore durante la richiesta: " + e.getMessage();
       }
   }
}
