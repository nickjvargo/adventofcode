package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = null;
        List<Integer> data = new ArrayList<Integer>();

        //Scan data.txt file and put into ArrayList data
        try {
            scanner = new Scanner(new File("src/com/company/data.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }

        while (scanner.hasNext()) {
            Integer integer = Integer.parseInt(scanner.next());
            data.add(integer);
        }

        //Get answer from static function below
        int answer = answer(data);

        System.out.println(answer);

    }


    //Loop through data, and if numbers add to 2020 return their product for answer
    private static int answer(List<Integer> data) {
        int answer = 0;
        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < (data.size() -1); j++) {
                if (data.get(i) + data.get(j) == 2020) {
                    answer = data.get(i) * data.get(j);
                }
            }
        }
        return answer;
    }

}

