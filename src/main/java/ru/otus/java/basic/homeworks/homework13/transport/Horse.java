package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Terrain;

public class Horse extends Transport {
    private int horseEndurance;

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (!(terrain.equals(Terrain.SWAMP))) {
            if (distance <= horseEndurance * 3) {
                horseEndurance -= (distance / 3);
                System.out.println(this.toString() + " пробежала " + distance);
                return true;
            }
            System.out.println("Лошадь устала");
            return false;
        }
        System.out.println("Лошадь не может передвигаться по данной местности");
        return false;
    }

    @Override
    public String toString() {
        return "Лошадь";
    }
}
