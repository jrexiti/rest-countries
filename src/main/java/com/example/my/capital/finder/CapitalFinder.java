package com.example.my.capital.finder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class CapitalFinder {
    private static final String API_BASE_URL = "https://restcountries.com/v3.1/name/";

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            String input;

            System.out.println("Welcome to the Capital City Finder!");
            System.out.println("Enter 'exit' to quit the program.");

            while (true) {
                System.out.print("Enter the country name or code: ");
                input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                findCapitalCity(input);
            }

            System.out.println("Goodbye! The program has been terminated.");
        }
    }

    static void findCapitalCity(String userInput) {
        String apiUrl = API_BASE_URL + userInput;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                try (Scanner scanner = new Scanner(connection.getInputStream())) {
                    StringBuilder response = new StringBuilder();
                    while (scanner.hasNextLine()) {
                        response.append(scanner.nextLine());
                    }

                    String capitalCity = response.toString().split("\"capital\":\\[\"")[1].split("\"")[0];
                    System.out.println("Capital city of " + userInput + ": " + capitalCity);
                }
            } else {
                System.out.println("Country not found. Please try again.");
            }

            connection.disconnect();
        } catch (IOException e) {
            System.out.println("Error occurred while fetching data from the API.");
        }
    }
}
