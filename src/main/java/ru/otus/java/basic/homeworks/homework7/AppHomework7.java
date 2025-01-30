package ru.otus.java.basic.homeworks.homework7;

import java.util.Arrays;

public class AppHomework7 {
    public static void main(String[] args) {

        int[][] array2d = {
                {11, -3, -4},
                {14, 5, -11},
                {12, -3, 53}
        };

        //test
        System.out.println(sumOfPositiveElements(array2d));
        printSquare(3);
        int[][] result = zeroDiag(array2d);
        System.out.println(findMax(array2d));
        System.out.println(row2Sum(array2d));

    }

    public static int sumOfPositiveElements(int[][] inputArray) {
        int sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i][j] > 0) {
                    sum += inputArray[i][j];
                }
            }
        }
        return sum;
    }

    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static int[][] zeroDiag(int[][] inputSquareArray) {
        for (int i = 0; i < inputSquareArray.length; i++) {
            inputSquareArray[i][inputSquareArray.length - 1 - i] = 0;
        }
        return inputSquareArray;
    }

    public static int findMax(int[][] array) {
        int maxValue = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxValue) {
                    maxValue = array[i][j];
                }
            }
        }
        return maxValue;
    }

    public static int row2Sum(int[][] array) {
        if (array.length < 2) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < array[1].length; i++) {
            sum += array[1][i];
        }
        return sum;
    }

}

