package ru.otus.java.basic.homeworks.homework11.animals;

public class Dog extends Animal {
    int swimSpeed;
    final int staminaForSwimmingPerMeter = 2;

    public Dog(String name, int runSpeed, int swimSpeed, int stamina) {
        this.name = name;
        this.runSpeed = runSpeed > 0 ? runSpeed : 1;
        this.stamina = stamina > 0 ? stamina : 1;
        this.swimSpeed = swimSpeed > 0 ? swimSpeed : 1;
    }


    public int swim(int distance) {
        if (distance < 0) {
            System.out.println("Дистанция не может быть отрицательной");
            return -1;
        }
        if (distance * staminaForSwimmingPerMeter > stamina) {
            System.out.println("Животное устало");
            return -1;
        }
        stamina -= distance * staminaForSwimmingPerMeter;
        int time = distance / swimSpeed;
        System.out.println(this.name + " - чтобы проплыть дистанцию " + distance + "м затрачено секунд: " + time);
        return 1;
    }

    @Override
    public void info() {
        System.out.println("Имя:" + this.name +
                " Единиц выносливости:" + this.stamina +
                " Скорость бега:" + this.runSpeed +
                " Скорость плавания:" + this.swimSpeed);
    }
}
