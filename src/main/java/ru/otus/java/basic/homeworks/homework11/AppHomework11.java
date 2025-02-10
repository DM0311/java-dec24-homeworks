package ru.otus.java.basic.homeworks.homework11;

import ru.otus.java.basic.homeworks.homework11.animal.Cat;
import ru.otus.java.basic.homeworks.homework11.animal.Dog;
import ru.otus.java.basic.homeworks.homework11.animal.Horse;

public class AppHomework11 {
    public static void main(String[] args) {
        Dog dog = new Dog("Тузик", 4, 3, 50);
        int v1 = dog.run(10);
        int v2 = dog.swim(5);
        dog.info();

        Horse horse = new Horse("Ветерок", 8, 4, 100);
        int v3 = horse.run(12);
        int v4 = horse.swim(6);
        horse.info();


        Cat cat = new Cat("Мурзик",4,45);
        int v5 = cat.run(10);
        cat.info();
    }

}
