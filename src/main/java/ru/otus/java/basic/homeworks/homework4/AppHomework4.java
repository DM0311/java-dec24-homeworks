package ru.otus.java.basic.homeworks.homework4;

public class AppHomework4 {
    public static void main(String[] args) {

        method1(2, "Hello from method1");
        method2(new int[]{1, 2, 4,78,6,3,1,4,12});
        method3(5, new int[]{1, 2, 4, 78, 6, 3, 1, 4, 12});
        method4(5, new int[]{1, 2, 4, 78, 6, 3, 1, 4, 12});
        method5(new int[]{1, 2, 44, 6, 3, 1, 4, 12});
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
}
