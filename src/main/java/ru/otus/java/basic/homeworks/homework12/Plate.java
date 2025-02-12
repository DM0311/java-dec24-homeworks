package ru.otus.java.basic.homeworks.homework12;

public class Plate {
    private int maxFoodAmount;
    private int currentFoodAmount;

    public Plate(int maxFoodAmount) {
        if (maxFoodAmount < 0) {
            System.out.println("");
            this.maxFoodAmount = 0;
            this.currentFoodAmount = 0;
        } else {
            this.maxFoodAmount = maxFoodAmount;
            this.currentFoodAmount = maxFoodAmount;
        }
    }

    public void addFood(int additionalFood) {
        if (currentFoodAmount + additionalFood > maxFoodAmount) {
            currentFoodAmount = maxFoodAmount;
        } else {
            currentFoodAmount += additionalFood;
        }
        System.out.println("В тарелку добавили еды");
    }

    public boolean wasteFood(int amount) {
        if (currentFoodAmount - amount < 0) {
            return false;
        }
        currentFoodAmount -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "В тарелке находится " + currentFoodAmount + " еды";
    }
}
