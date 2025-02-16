package ru.otus.java.basic.homeworks.homework13;


import ru.otus.java.basic.homeworks.homework13.transport.Bicycle;
import ru.otus.java.basic.homeworks.homework13.transport.Transport;

public class Human {
    private String name;
    private int humanEndurance;
    private Transport currentTransport;

    public Human(String name, int humanEndurance) {
        this.name = name;
        this.humanEndurance = humanEndurance;
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
            if (humanEndurance <= distance / 3) {
                System.out.println("У челвоека недостаточно выносливости чтобы столько ехать на велосипеде");
                return;
            } else {
                this.humanEndurance -= distance / 3;
            }
        }
        this.currentTransport.move(distance, terrain);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", humanEndurance=" + humanEndurance +
                ", currentTransport=" + currentTransport +
                '}';
    }
}
