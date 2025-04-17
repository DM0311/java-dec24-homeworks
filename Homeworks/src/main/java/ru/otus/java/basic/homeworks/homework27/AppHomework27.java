package ru.otus.java.basic.homeworks.homework27;

public class AppHomework27 {
    public static void main(String[] args) {
        Fruit fruit1 = new Fruit(100);
        Fruit fruit2 = new Fruit(120);
        Apple apple1 = new Apple(30);
        Apple apple2 = new Apple(70);
        Orange orange1 = new Orange(40);
        Orange orange2 = new Orange(60);

        Box<Fruit> fruitBox = new Box<>();
        fruitBox.addFruit(fruit1);
        fruitBox.addFruit(fruit2);
        System.out.println("Вес коробки с фруктами: " + fruitBox.getTotalWeight());

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(apple1);
        appleBox.addFruit(apple2);
        System.out.println("Вес коробки с яблоками: " + appleBox.getTotalWeight());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange1);
        orangeBox.addFruit(orange2);
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getTotalWeight());

        System.out.println("Сравнение коробки с фруктами " +
                "и коробки с яблоками: "+fruitBox.compare(appleBox));
        System.out.println("Сравнение коробки с фруктами " +
                "и коробки с апельсинами: "+fruitBox.compare(orangeBox));
        System.out.println("Сравнение коробки с яблкоами " +
                "и коробки с апельсинами: "+appleBox.compare(orangeBox));

        orangeBox.moveFruits(fruitBox);

        Box<Apple> appleBox1 = new Box<>();
        appleBox.moveFruits(appleBox1);

    }
}
