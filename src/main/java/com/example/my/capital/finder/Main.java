package com.example.my.capital.finder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

    public static String fetchCapitalCity(String countryName) throws IOException, InterruptedException {
        String url = "https://restcountries.com/v3.1/name/" + countryName;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());

        try {
            JSONArray jsonArray = new JSONArray(response.body());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            JSONArray capitalArray = jsonObject.getJSONArray("capital");
            return capitalArray.getString(0);
        } catch (JSONException e) {
            return null;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scnr = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter a country or enter 'exit' to exit the program.");
            String userInput = scnr.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            String capitalCity = fetchCapitalCity(userInput);
            if (capitalCity != null) {
                System.out.println("The capital city of " + userInput + " is: " + capitalCity);
            } else {
                System.out.println(userInput + " not found");
            }
        }
    }
}
