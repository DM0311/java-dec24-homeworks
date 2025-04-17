package ru.otus.java.basic.homeworks.homework3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AppHomework3 {
    public static void main(String[] args) {

        System.out.println("Введите число от 1 до 5:");
        Scanner scanner = new Scanner(System.in);
        int methodNumber = scanner.nextInt();
        if (methodNumber == 1) {
            greetings();
        } else if (methodNumber == 2) {
            checkSign((int) (Math.random() * 10), (int) (Math.random() * 10), (int) (Math.random() * 10));
        } else if (methodNumber == 3) {
            selectColor();
        } else if (methodNumber == 4) {
            compareNumbers();
        } else if (methodNumber == 5) {
            addOrSubtractAndPrint((int) (Math.random() * 10), (int) (Math.random() * 10), Math.random() < 0.5f);
        } else {
            System.out.println("Введен недопустимый номер");
        }
    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        if (a + b + c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 21;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 16;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }
}
