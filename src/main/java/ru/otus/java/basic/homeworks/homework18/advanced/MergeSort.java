package ru.otus.java.basic.homeworks.homework18.advanced;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int... src) {
        if (src.length <= 1) {
            return src;
        }
        int[] left = Arrays.copyOfRange(src, 0, src.length / 2);
        int[] right = Arrays.copyOfRange(src, left.length, src.length);
        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int index = 0;
        int indexLeft = 0;
        int indexRight = 0;
        int[] result = new int[left.length + right.length];
        while (indexLeft < left.length && indexRight < right.length) {
            if(left[indexLeft] < right[indexRight]){
                result[index] = left[indexLeft];
                indexLeft++;
            }else{
                result[index] = right[indexRight];
                indexRight++;
            }
            index++;
        }
        while (index < result.length) {
            if(indexLeft != left.length){
                result[index] = left[indexLeft];
                indexLeft++;
            }else{
                result[index] = right[indexRight];
                indexRight++;
            }
            index++;
        }
        return result;
    }
}
