package ru.otus.java.basic.homeworks.homework12;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        satiety = plate.wasteFood(appetite);
    }

    @Override
    public String toString() {
        String m;
        m = satiety ? " сыт" : " голоден";
        return name + m;
    }
}
