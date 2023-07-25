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

    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "https://restcountries.com/v3.1/name/";

        Scanner scnr = new Scanner(System.in);

        while (true) {

            System.out.println("please enter an country or enter 'exit' to exit the program.");

            String userInput = scnr.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(url + userInput))
                    .build();

            HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());

            try {

                JSONArray jsonArray = new JSONArray(response.body());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                JSONArray capitalArray = jsonObject.getJSONArray("capital");
                String capital = capitalArray.getString(0);

                System.out.println("The capital city of " + userInput + " is: " + capital);
            } catch (JSONException e) {
                System.out.println(userInput + " Not found");
            }

        }

    }
}