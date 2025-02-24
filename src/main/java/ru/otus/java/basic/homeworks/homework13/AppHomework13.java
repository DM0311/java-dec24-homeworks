package ru.otus.java.basic.homeworks.homework13;

import ru.otus.java.basic.homeworks.homework13.transport.Bicycle;
import ru.otus.java.basic.homeworks.homework13.transport.Car;
import ru.otus.java.basic.homeworks.homework13.transport.Horse;

public class AppHomework13 {
    public static void main(String[] args) {

        Human bob = new Human("Bob", 50);
        bob.getIn(new Car(500));
        bob.ride(100, Terrain.PLAIN);
        bob.getIn(new Bicycle());
        bob.getOut();
        bob.getIn(new Horse());
        bob.ride(300, Terrain.SWAMP);
        bob.getOut();
        bob.ride(300, Terrain.FOREST);
        bob.getIn(new Bicycle());
        bob.ride(1000, Terrain.PLAIN);
        System.out.println(bob.toString());

    }
}
