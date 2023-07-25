package com.example.my.capital.finder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String countryName;

        while (true) {
            System.out.println("Please enter a country or enter Quit to exit program.");
            countryName = scnr.nextLine();

            if (countryName.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program....");
                break;
            }

        }

    }

}
