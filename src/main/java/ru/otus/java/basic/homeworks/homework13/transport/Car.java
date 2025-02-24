package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Human;
import ru.otus.java.basic.homeworks.homework13.Terrain;

public class Car extends Transport {
    private int fuel;

    public Car(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean move(int distance, Terrain terrain, Human driver) {

        if (!(terrain.equals(Terrain.FOREST) || terrain.equals(Terrain.SWAMP))) {
            if (distance <= fuel * 2) {
                fuel -= (distance / 2);
                System.out.println(this.toString() + " проехал " + distance);
                return true;
            }
            System.out.println("У автомобиля недостаточно топлива");
            return false;
        }
        System.out.println("Автомобильне не может передвигаться по данной местности");
        return false;
    }

    @Override
    public String toString() {
        return "Атомобиль";
    }
}
