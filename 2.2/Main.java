package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = null;

        /**Scan data.txt file for policy and password list*/
        try {
            scanner = new Scanner(new File("src/com/company/data.txt"));;
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }

        /**Counter used for correct passwords*/
        int passwordsThatPass = 0;

        //Patterns used
        Pattern policyPattern = Pattern.compile(".*:");
        Pattern policyLetterMinPattern = Pattern.compile("\\d+");

        /**Iterate over policy and password strings*/
        while (scanner.hasNext()) {

            String policyAndPasswordString = scanner.nextLine();

            /**Separate policy and password*/
            Matcher policyMatcher = policyPattern.matcher(policyAndPasswordString);
            policyMatcher.find();
            String policy = policyMatcher.group();

            String password = policyAndPasswordString.substring(policy.length() + 1);

            /**Get parameters out of policy String*/
            Character policyLetter = policy.charAt(policy.length() - 2);

            Matcher policyLetterPosOneMatcher = policyLetterMinPattern.matcher(policy);
            policyLetterPosOneMatcher.find();
            String policyLetterPosOneString = policyLetterPosOneMatcher.group();

            String policyLetterPosTwoString = policy.substring(policyLetterPosOneString.length() + 1, policy.length() - 3);

            Integer policyLetterPosOne = Integer.parseInt(policyLetterPosOneString);
            Integer policyLetterPosTwo = Integer.parseInt(policyLetterPosTwoString);

            /**If it passes, increase counter for number of passwords that pass*/
            boolean itPasses = itPasses(password, policyLetter, policyLetterPosOne, policyLetterPosTwo);
            if (itPasses) {
                passwordsThatPass++;
            }
        }

        /**Answer! c;*/
        int answer = passwordsThatPass;
        System.out.println(answer);

    }

    /**Creates empty int array and fills with positions only if policy letter is at that position. Booleans are used to
    see if policy letter is in the first and second specified positions. Returns true only if letter is in one and only
     one of the positions*/
    private static boolean itPasses(String password, Character policyLetter, int policyLetterPosOne, int policyLetterPosTwo) {
        int[] policyLetterPositions = new int[password.length() + 1];
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == policyLetter) {
                policyLetterPositions[i] = i + 1;
            }
        }
        boolean policyLetterAtPosOne = policyLetterPositions[policyLetterPosOne - 1] == policyLetterPosOne;
        boolean policyLetterAtPosTwo = policyLetterPositions[policyLetterPosTwo - 1] == policyLetterPosTwo;
        return policyLetterAtPosOne != policyLetterAtPosTwo;
    }

}


