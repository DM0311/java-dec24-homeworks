package ru.otus.java.basic.homeworks.homework11.animal;

public class Horse extends Animal {
    int swimSpeed;
    final int staminaForSwimmingPerMeter = 4;

    public Horse(String name, int runSpeed, int swimSpeed, int stamina) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.stamina = stamina;
        this.swimSpeed = swimSpeed;
    }

    public int swim(int distance) {
        if (distance * staminaForSwimmingPerMeter > stamina) {
            System.out.println("Животное устало");
            return -1;
        } else {
            stamina -= distance * staminaForSwimmingPerMeter;
            int time = distance / swimSpeed;
            System.out.println(this.name + " - чтобы проплыть дистанцию " + distance + "м затрачено секунд: " + time);
            return 1;
        }
    }

    @Override
    public void info() {
        System.out.println("Имя:" + this.name +
                           " Единиц выносливости:" + this.stamina +
                           " Скорость бега: " + this.runSpeed +
                           " Скорость плавания: " + this.swimSpeed);
    }
}
