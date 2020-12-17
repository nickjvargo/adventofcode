package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = null;
        Scanner scannerLength = null;
        int adapters = 0;
        int oneJoltJumps = 0;
        int threeJoltJumps = 0;

        //two scanners -- one to find amount of adapters, one to add values to int array
        try {
            scanner = new Scanner(new File("src/com/company/jolts.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found, please ensure pathname correct.");
        }

        try {
            scannerLength = new Scanner(new File("src/com/company/jolts.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found, please ensure pathname correct.");
        }


        //finds length of .txt file and sets it as amount of extra adapters
        while (scannerLength.hasNext()) {
            scannerLength.next();
            adapters++;
        }

        //taking into account adapters, outlet, and built-in-adapter in device, build int array with ALL adapters
        int[] adaptersIntArray = new int[adapters + 2];

        //socket has a jolt rating of 0
        adaptersIntArray[0] = 0;
        //setting last value, which is built-in-adapter, as high number so it can be properly reinitialized after sorting array
        adaptersIntArray[adaptersIntArray.length -1] = 10000;

        for (int i = 1; i < adaptersIntArray.length - 1; i++) {
            adaptersIntArray[i] = Integer.parseInt(scanner.next());
        }

        //sort adapter array so that comparing the voltage jumps becomes easier
        Arrays.sort(adaptersIntArray);

        //setting last adapter value properly
        adaptersIntArray[adaptersIntArray.length - 1] = (adaptersIntArray[adaptersIntArray.length - 2] + 3);

        //loop through array and determine numbers of jumps, whether by one or three (if not one, has to be three)
        for (int i = 0; i < adaptersIntArray.length; i++) {
            if(i == adaptersIntArray.length - 1) {
                break;
            }
            if (adaptersIntArray[i+1] - adaptersIntArray[i] == 1) {
                oneJoltJumps++;
            } else {
                threeJoltJumps++;
            }
        }

        int answer = oneJoltJumps * threeJoltJumps;

        System.out.println(oneJoltJumps);
        System.out.println(threeJoltJumps);
        System.out.println(answer);

    }
}
