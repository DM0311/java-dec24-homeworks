package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Human;
import ru.otus.java.basic.homeworks.homework13.Terrain;

public class Bicycle extends Transport {
    @Override
    public boolean move(int distance, Terrain terrain, Human driver) {
        if (!(terrain == Terrain.SWAMP) && driver.wasteEndurance(distance)) {
            System.out.println(this.toString() + " проехал " + distance);
            return true;
        }
        System.out.println("Велосипед не может передвигаться по данной местности или недостаточно выносливости");
        return false;
    }

    @Override
    public String toString() {
        return "Велосипед";
    }
}
