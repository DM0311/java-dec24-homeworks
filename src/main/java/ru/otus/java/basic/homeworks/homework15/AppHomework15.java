package ru.otus.java.basic.homeworks.homework15;

import ru.otus.java.basic.homeworks.homework15.exceptions.AppArrayDataException;
import ru.otus.java.basic.homeworks.homework15.exceptions.AppArraySizeException;

public class AppHomework15 {
    public static void main(String[] args) {

        String[][] array1 =
                {
                        {"1", "2", "3", "4"},
                        {"5", "F", "7", "8"},
                        {"9", "10", "11", "12"},
                        {"13", "14", "15","16"},
                };
        String[][] array2 =
                {
                        {"1", "2", "3", "4"},
                        {"5", "6", "7", "8"},
                        {"9", "10", "11", "12"},
                        {"13", "14", "15"},
                };
        String[][] array3 =
                {
                        {"1", "2", "3", "4"},
                        {"5", "6", "7", "8"},
                        {"9", "10", "11", "12"},
                        {"13", "14", "15","16"},
                };
        try {
            System.out.println(sumArrayElements(array3));
        } catch (RuntimeException e) {
            System.out.println(e);
        }


    }

    public static int sumArrayElements(String[][] array) throws AppArraySizeException, AppArrayDataException {

        if (array.length != 4 || array[0].length != 4) {
            throw new AppArrayDataException("Превышена размерность массива");
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i].length!=4){
                    throw new AppArrayDataException("Превышена размерность массива");
                }
                try {
                    int num = Integer.parseInt(array[i][j]);
                    sum += num;
                } catch (RuntimeException e) {
                    throw new AppArrayDataException("Нвозможно преобразовать в число элемент массива с координатами [" + i + "] [" + j + "].");
                }
            }
        }
        return sum;
    }
}
