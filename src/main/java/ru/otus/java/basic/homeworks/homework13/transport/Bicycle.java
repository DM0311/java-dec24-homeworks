package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Terrain;

public class Bicycle extends Transport {
    @Override
    public boolean move(int distance, Terrain terrain) {
        if (!(terrain.equals(Terrain.SWAMP))) {
            System.out.println(this.toString() + " проехал " + distance);
            return true;
        }
        System.out.println("Велосипед не может передвигаться по данной местности");
        return false;
    }

    @Override
    public String toString() {
        return "Велосипед";
    }
}
