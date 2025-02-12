package ru.otus.java.basic.homeworks.homework11.animals;

public class Cat extends Animal {
    public Cat(String name, int runSpeed, int stamina) {
        this.name = name;
        this.runSpeed = runSpeed > 0 ? runSpeed : 1;
        this.stamina = stamina > 0 ? stamina : 1;
    }
}
