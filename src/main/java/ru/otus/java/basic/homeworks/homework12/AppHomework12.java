package ru.otus.java.basic.homeworks.homework12;

import java.util.List;

public class AppHomework12 {
    public static void main(String[] args) {

        Plate plate = new Plate(30);

        Cat cat1 = new Cat("Барсик", 8);
        Cat cat2 = new Cat("Мурзик", 15);
        Cat cat3 = new Cat("Пушок", 6);
        Cat cat4 = new Cat("Рыжик", 11);

        List<Cat> cats = List.of(cat1, cat2, cat3, cat4);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
            System.out.println(plate);
        }

        plate.addFood(50);
        System.out.println(plate);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
            System.out.println(plate);
        }
    }
}
