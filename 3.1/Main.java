package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /** Global variables to increment / decrement and check for */
        char tree = '#';
        int nextLocation = 0;
        int treesPassed = 0;
        Scanner scanner = null;
        
        /** Scan treemap.txt file */
        try {
            scanner = new Scanner(new File("src/com/company/treemap.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }

        /** Eat first line of slope*/
        String topOfSlope = scanner.nextLine();

        /** Loop through patterns on treemap and add to the treesPassed counter if the character one line down and three
         * to the right of the previous iteration matched the tree char (#). If going three across would go over the
         * max index, start at the beginning of the next line (as they repeat themselves), carrying over the difference.
         */
        while (scanner.hasNext()) {
            String downSlope = scanner.nextLine();
            nextLocation += 3;
            if (nextLocation > topOfSlope.length()-1) {
                nextLocation = nextLocation - topOfSlope.length();
            }
            if (downSlope.charAt(nextLocation) == tree) {
                treesPassed++;
            }
        }

        System.out.println(treesPassed);

    }
}
