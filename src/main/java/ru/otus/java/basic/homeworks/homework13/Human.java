package ru.otus.java.basic.homeworks.homework13;


import ru.otus.java.basic.homeworks.homework13.transport.Bicycle;
import ru.otus.java.basic.homeworks.homework13.transport.Transport;

public class Human {
    private String name;
    private int endurance;
    private Transport currentTransport;

    public Human(String name, int endurance) {
        this.name = name;
        this.endurance = endurance;
    }

    public void getIn(Transport transport) {
        if (currentTransport != null) {
            System.out.println("Человек уже находится в транспортном средстве: " + this.currentTransport.toString());
            return;
        }
        this.currentTransport = transport;
        System.out.println("Человек сел в средство передвижения: " + transport.toString());
    }

    public void getOut() {
        System.out.println("Человек вылез из средства передвижения: " + currentTransport.toString());
        this.currentTransport = null;
    }

    public void ride(int distance, Terrain terrain) {
        if (this.currentTransport == null) {
            System.out.println("Человек идет пешком");
            return;
        }
        if (this.currentTransport instanceof Bicycle) {
            if (endurance <= distance / 3) {
                System.out.println("У челвоека недостаточно выносливости чтобы столько ехать на велосипеде");
                return;
            } else {
                this.endurance -= distance / 3;
            }
        }
        this.currentTransport.move(distance, terrain);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", humanEndurance=" + endurance +
                ", currentTransport=" + currentTransport +
                '}';
    }
}
