package ru.otus.java.basic.homeworks.homework4;

public class AppHomework4 {
    public static void main(String[] args) {

        //Homework base part
        method1(2, "Hello from method1");
        method2(new int[]{1, 2, 4, 78, 6, 3, 1, 4, 12});
        method3(5, new int[]{1, 2, 4, 78, 6, 3, 1, 4, 12});
        method4(5, new int[]{1, 2, 4, 78, 6, 3, 1, 4, 12});
        method5(new int[]{1, 2, 44, 6, 3, 1, 4, 12});

        //Homework*
        int[] result = sumArrays(new int[]{1, 2, 3}, new int[]{2, 2}, new int[]{1, 1, 1, 1, 1});
        findArrayPoint(new int[]{5, 3, 4, -2});
        reverseArray(new int[]{1, 2, 5, 6, 10, 11});
        boolean isAscending = isAscending(new int[]{1, 2, 5, 6, 10, 11});
    }

    public static void method1(int number, String printString) {
        for (int i = 0; i < number; i++) {
            System.out.println(printString);
        }
    }

    public static void method2(int[] intArray) {
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > 0) {
                sum += intArray[i];
            }
        }
        System.out.println(sum);
    }

    public static void method3(int number, int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = number;
        }
    }

    public static void method4(int increment, int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] += increment;
        }
    }

    public static void method5(int[] intArray) {
        int middle = (int) intArray.length / 2;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (i < middle) {
                sum1 += intArray[i];
            } else {
                sum2 += intArray[i];
            }
        }
        if (sum1 > sum2) {
            System.out.println("Cумма элементов первой половины массива больше");
        } else {
            System.out.println("Cумма элементов второй половины массива больше");
        }
    }

    public static int[] sumArrays(int[]... args) {

        int maxArrayLength = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i].length > maxArrayLength) {
                maxArrayLength = args[i].length;
            }
        }

        int[] resultArray = new int[maxArrayLength];

        int[][] matrix = new int[args.length][maxArrayLength];
        for (int i = 0; i < args.length; i++) {
            int[] inputArray = args[i];
            for (int j = 0; j < inputArray.length; j++) {
                matrix[i][j] = inputArray[j];
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[j][i];
            }
            resultArray[i] = sum;
        }
        return resultArray;
    }

    public static void findArrayPoint(int[] inputArray) {
        int sumLeft = 0;
        int sumRight = 0;
        boolean point = false;
        for (int i = 0; i < inputArray.length; i++) {
            sumLeft += inputArray[i];
            for (int j = i + 1; j < inputArray.length; j++) {
                sumRight += inputArray[j];
            }
            if (sumLeft == sumRight) {
                System.out.println("Точка массива находится между элементами " + i + " " + (i + 1));
                return;
            } else {
                sumRight = 0;
            }
        }
        System.out.println("В массиве нет точки");
    }

    public static boolean isAscending(int[] inputArray) {
        int previousNumber = inputArray[0];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < previousNumber) {
                return false;
            } else {
                previousNumber = inputArray[i];
            }
        }
        return true;
    }

    public static void reverseArray(int[] input) {
        int[] reversedArray = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            reversedArray[input.length - 1 - i] = input[i];
        }
        input = reversedArray;
    }
}
