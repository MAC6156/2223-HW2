package com.company;

import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        HashMap sumList = new HashMap<Integer, Integer>();
//        int[] sumArray = new int[133];


        int[] subirach = {1, 14, 14, 4, 11, 7, 6, 9, 8, 10, 10, 5, 13, 2, 3, 15};
        int specifiedSums = 0; //Sums of four numbers that add to 33
        int combination = 1;

        int mostCombos = 0;
        int sumWithMostCombos = 0;

        String binary;
        while (combination <= 0b1111111111111111) {
            int sum = 0;
            int numElements = 0;
            binary = Integer.toBinaryString(combination);
            while (binary.length() < 16){
                binary = "0" + binary;
            }
            for (int i = binary.length()-1; i >= 0; i--) {
                if (binary.charAt(i) == '1') {
                    sum += subirach[i];
                    numElements++;
                }
            }
            int tempCombos = 1;
            if (!sumList.containsKey(sum)) {
                sumList.put(sum, 1);
            } else {
                tempCombos = (int) sumList.get(sum) + 1;
                sumList.put(sum, tempCombos);
            }
            if (tempCombos > mostCombos) {
                mostCombos = tempCombos;
                sumWithMostCombos = sum;
            }
            if (sum == 33 && numElements == 4) {
                specifiedSums++;
            }
            combination++;
        }
        sumList.put(0,0);
        System.out.println("There are " + sumList.get(33) + " combinations to get 33");
        System.out.println(specifiedSums + " of them are from exactly 4 squares");
        System.out.println("Most combinations: " + sumWithMostCombos + " has " + mostCombos);
        System.out.println("Full combo list:\n" + sumList);

    }


}


