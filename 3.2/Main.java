package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /** tree character, different scanners for each method, and a answer of type Long as int
         * is too short
         */
        char tree = '#';
        Scanner scannerOne = null;
        Scanner scannerTwo = null;
        Scanner scannerThree = null;
        Scanner scannerFour = null;
        Scanner scannerFive = null;
        Long answer;

        /** Scanners for each method */
        try {
            scannerOne = new Scanner(new File("src/com/company/treemap.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }

        try {
            scannerTwo = new Scanner(new File("src/com/company/treemap.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }

        try {
            scannerThree = new Scanner(new File("src/com/company/treemap.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }

        try {
            scannerFour = new Scanner(new File("src/com/company/treemap.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }

        try {
            scannerFive = new Scanner(new File("src/com/company/treemap.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }

        answer = ((treesPassedR1D1(scannerOne, 0, tree)) *
                (treesPassedR1D2(scannerTwo, 0, tree)) *
                (treesPassedR3D1(scannerThree,  0, tree)) *
                (treesPassedR5D1(scannerFour, 0, tree)) *
                (treesPassedR7D1(scannerFive, 0, tree)));

        System.out.println(answer);

    }

    /** NOTE: R(X)D(Y) means a slope of right x units and down y units */

    /** Loop through patterns on treemap and add to the respective treesPassed counter if the character to the designated
     * slope of the previous iteration matched the tree char (#). If going the R distance across would go over the
     * max index of the line, start at the beginning (as they repeat themselves), carrying over the difference.
     */

    private static long treesPassedR1D1 (Scanner scanner, int nextLocation, char tree) {
        int treesPassed = 0;
        String topOfSlope = scanner.nextLine();
        while (scanner.hasNext()) {
            String downSlope = scanner.nextLine();
            nextLocation += 1;
            if (nextLocation > downSlope.length()-1) {
                nextLocation = nextLocation - downSlope.length();
            }
            if (downSlope.charAt(nextLocation) == tree) {
                treesPassed++;
            }
        }
        return treesPassed;
    }

    private static long treesPassedR3D1 (Scanner scanner, int nextLocation, char tree) {
        int treesPassed = 0;
        String topOfSlope = scanner.nextLine();
        while (scanner.hasNext()) {
            String downSlope = scanner.nextLine();
            nextLocation += 3;
            if (nextLocation > downSlope.length()-1) {
                nextLocation = nextLocation - downSlope.length();
            }
            if (downSlope.charAt(nextLocation) == tree) {
                treesPassed++;
            }
        }
        return treesPassed;
    }

    private static long treesPassedR5D1 (Scanner scanner, int nextLocation, char tree) {
        int treesPassed = 0;
        String topOfSlope = scanner.nextLine();
        while (scanner.hasNext()) {
            String downSlope = scanner.nextLine();
            nextLocation += 5;
            if (nextLocation > downSlope.length()-1) {
                nextLocation = nextLocation - downSlope.length();
            }
            if (downSlope.charAt(nextLocation) == tree) {
                treesPassed++;
            }
        }
        return treesPassed;
    }

    private static long treesPassedR7D1 (Scanner scanner, int nextLocation, char tree) {
        int treesPassed = 0;
        String topOfSlope = scanner.nextLine();
        while (scanner.hasNext()) {
            String downSlope = scanner.nextLine();
            nextLocation += 7;
            if (nextLocation > downSlope.length()-1) {
                nextLocation = nextLocation - downSlope.length();
            }
            if (downSlope.charAt(nextLocation) == tree) {
                treesPassed++;
            }
        }
        return treesPassed;
    }

    /** Eats an additional line on each loop, fulfilling two down slope */
    private static long treesPassedR1D2 (Scanner scanner, int nextLocation, char tree) {
        int treesPassed = 0;
        String topOfSlope = scanner.nextLine();
        while (scanner.hasNext()) {
            scanner.nextLine();
            String twoDownSlope = scanner.nextLine();
            nextLocation += 1;
            if (nextLocation > twoDownSlope.length()-1) {
                nextLocation = nextLocation - twoDownSlope.length();
            }
            if (twoDownSlope.charAt(nextLocation) == tree) {
                treesPassed++;
            }
        }
        return treesPassed;
    }
}
