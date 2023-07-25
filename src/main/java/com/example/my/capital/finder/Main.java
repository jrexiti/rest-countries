package com.example.my.capital.finder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "https://restcountries.com/v3.1/name/";

        Scanner scnr = new Scanner(System.in);

        System.out.println("please enter an country or enter 'exit' to exit the program.");

        String userInput = scnr.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url + userInput))
                .build();

        HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

    }

}
