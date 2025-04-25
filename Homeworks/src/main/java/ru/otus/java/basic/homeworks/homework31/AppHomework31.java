package ru.otus.java.basic.homeworks.homework31;

public class AppHomework31 {
    public static void main(String[] args) {

    }

    public static int[] getArrayPart(int[] sourceArray) {
        int counter = 0;
        for (int i = 0; i < sourceArray.length; i++) {
            if (sourceArray[i] == 1) {
                counter = i;
            } else {
                continue;
            }
        }
        if (counter == 0) {
            throw new RuntimeException("В массиве нету ни одной единицы.");
        } else {
            int[] arrayPart = new int[sourceArray.length - counter - 1];
            for (int i = counter + 1; i < sourceArray.length; i++) {
                arrayPart[i - counter - 1] = sourceArray[i];
            }
            return arrayPart;
        }
    }

    public static boolean checkArray(int[] sourceArray) {
        int oneCounter = 0;
        int twoCounter = 0;
        for (int i = 0; i < sourceArray.length; i++) {
            if(sourceArray[i]!=1 &&sourceArray[i]!=2){
                return false;
            }else if(sourceArray[i]==1){
                oneCounter++;
            }else {
                twoCounter++;
            }
        }
        if(oneCounter<1 || twoCounter<1){
            return false;
        }else{
            return true;
        }
    }
}
