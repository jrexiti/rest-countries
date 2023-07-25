package com.example.my.capital.finder;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import org.json.simple.parser.JSONParser;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        Scanner scnr = new Scanner(System.in);
        String countryName;
        String api = "https://restcountries.com/v3.1/name/";

        while (true) {
            System.out.println("please enter a country name or enter 'quit' to exit program.");
            countryName = scnr.nextLine();

            if (countryName.equalsIgnoreCase("quit")) {
                System.out.println("exiting program....");
                break;
            }

            try {
                URL url = new URL(api + countryName);
                System.out.println(url);

            } finally {

            }

        }
    }
}
