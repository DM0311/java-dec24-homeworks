package ru.otus.java.basic.homeworks.homework27;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<? extends Fruit> anotherBox) {
        return this.getTotalWeight() == anotherBox.getTotalWeight();
    }

    public void moveFruits(Box<? super T> anotherbox){
        if(anotherbox==this){
            System.out.println("Указана та же самая коробка!");
            return;
        }
        for (T fruit:fruits){
            anotherbox.addFruit(fruit);
        }
        System.out.println("Перемещено фруктов: "+this.fruits.size());
        this.fruits.clear();
    }

    public List<T> getFruits() {
        return fruits;
    }

    public void setFruits(List<T> fruits) {
        this.fruits = fruits;
    }
}
