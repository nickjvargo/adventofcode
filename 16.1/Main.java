package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        //Scanners to parse data
        Scanner txtScanner = null;
        Scanner rulesScanner = null;
        Scanner yourTicketScanner = null;
        Scanner otherTicketsScanner = null;

        //2D array to hold ranges in rules
        ArrayList<int[]> rulesRanges = new ArrayList<>();

        //Answer int to add invalid ticket values to to get ticket scanning error rate
        int answer = 0;

        //Scan txt file for input
        try {
            txtScanner = new Scanner(new File("src/com/company/tickets.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found, please ensure pathname correct.");
        }

        //This divides the text file according to returns, allowing easy separation of rules, your ticket, and other tix
        txtScanner.useDelimiter("\n\r");

        //Separates tickets.txt into specified blocks, then pulls ranges from blocks
        rulesScanner = new Scanner(txtScanner.next());

        //Finding adjacent numbers in rules...
        rulesScanner.useDelimiter("\\D+");
        while (rulesScanner.hasNext()) {
            int rangeLow = Integer.parseInt(rulesScanner.next());
            int rangeHigh = Integer.parseInt(rulesScanner.next());
            int rangeNumbers = rangeLow;
            //...create ranges between the low and high...
            int[] range = new int[(rangeHigh - rangeLow) + 1];
            for (int i = 0; i < range.length; i++) {
                range[i] = rangeNumbers;
                rangeNumbers++;
            }
            //...and add range to rulesRanges ArrayList
            rulesRanges.add(range);
        }

        //Scanner for your ticket
        yourTicketScanner = new Scanner(txtScanner.next());

        //Scanner for other tickets
        otherTicketsScanner = new Scanner(txtScanner.next());
        otherTicketsScanner.useDelimiter("\\D+");

        //Loop through other tickets and compare with values kept in the rules ranges. If other ticket has a value that
        //is not within any of the rules ranges, that ticket value is false and is added to answer.
        while (otherTicketsScanner.hasNext()) {
            int otherTicketInt = Integer.parseInt(otherTicketsScanner.next());
            int rulesInt = 0;
            boolean valid = false;

            for (int i = 0; i < rulesRanges.size(); i++) {
                if (valid == true) {
                    break;
                }
                for (int j = 0; j < rulesRanges.get(i).length; j++) {
                    rulesInt = (rulesRanges.get(i)[j]);
                    if (otherTicketInt == rulesInt) {
                        valid = true;
                        break;
                    }
                }
            }

            if (valid == false) {
                answer += otherTicketInt;
            }

        }

        System.out.println(answer);

    }
}
