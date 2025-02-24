package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Human;
import ru.otus.java.basic.homeworks.homework13.Terrain;

public class Rover extends Transport {
    private int fuel;

    @Override
    public boolean move(int distance, Terrain terrain, Human driver) {
        if (distance <= fuel * 5) {
            fuel -= (distance / 5);
            System.out.println(this.toString() + " проехал " + distance);
            return true;
        }
        System.out.println("У внедорожника недостаточно топлива");
        return false;
    }

    @Override
    public String toString() {
        return "Внедорожник";
    }
}
