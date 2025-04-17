package ru.otus.java.basic.homeworks.homework18.basic;

public class BubbleSort {

    public static void sort(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length - 1; i++) {
            for(int j = 0; j < sourceArray.length - i - 1; j++) {
                if(sourceArray[j + 1] < sourceArray[j]) {
                    int buf = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j + 1] = buf;
                }
            }
        }
    }
}
