package com.company;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    //Counter used for correct passwords
    private static int passwordsThatPass = 0;

    public static void main(String[] args) {

        //Patterns used
        Pattern policyPattern = Pattern.compile(".*:");
        Pattern policyLetterMinPattern = Pattern.compile("\\d+");

        //Copy and paste policy and password list
        String policyAndPasswordString;

        //Create String Array of policy and password list to iterate over
        String[] policyAndPassword = policyAndPasswordString.split("\n");

        //Iterate over policy and password strings
        for(int i = 0; i < policyAndPassword.length; i++) {

            //Separate policy and password
            Matcher policyMatcher = policyPattern.matcher(policyAndPassword[i]);
            policyMatcher.find();
            String policy = policyMatcher.group();

            String password = policyAndPassword[i].substring(policy.length() + 1);

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

