package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = null;

        //Scan data.txt file for policy and password list
        try {
            scanner = new Scanner(new File("src/com/company/data.txt"));;
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }

        //Counter used for correct passwords
        int passwordsThatPass = 0;

        //Patterns used
        Pattern policyPattern = Pattern.compile(".*:");
        Pattern policyLetterMinPattern = Pattern.compile("\\d+");

        //Iterate over policy and password strings
        while (scanner.hasNext()) {

            String policyAndPasswordString = scanner.nextLine();

            //Separate policy and password
            Matcher policyMatcher = policyPattern.matcher(policyAndPasswordString);
            policyMatcher.find();
            String policy = policyMatcher.group();

            String password = policyAndPasswordString.substring(policy.length() + 1);

            //Get parameters out of policy String
            Character policyLetter = policy.charAt(policy.length() - 2);

            Matcher policyLetterMinMatcher = policyLetterMinPattern.matcher(policy);
            policyLetterMinMatcher.find();
            String policyLetterMinString = policyLetterMinMatcher.group();

            String policyLetterMaxString = policy.substring(policyLetterMinString.length() + 1, policy.length() - 3);

            Integer policyLetterMin = Integer.parseInt(policyLetterMinString);
            Integer policyLetterMax = Integer.parseInt(policyLetterMaxString);

            //If it passes, increase counter for number of passwords that pass
            boolean itPasses = itPasses(password, policyLetter, policyLetterMin, policyLetterMax);
            if (itPasses) {
                passwordsThatPass++;
            }
        }

        //Answer! c;
        int answer = passwordsThatPass;
        System.out.println(answer);

    }

    //Use letter, letter min, and letter max, and loop through password and see if it passes
    private static boolean itPasses(String password, Character policyLetter, int policyLetterMin, int policyLetterMax) {
        int policyLetterInstances = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == policyLetter) {
                policyLetterInstances++;
            }
        }
        return ((policyLetterInstances >= policyLetterMin) && (policyLetterInstances <= policyLetterMax));
    }

}

