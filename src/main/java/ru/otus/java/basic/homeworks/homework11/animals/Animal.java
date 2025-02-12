package ru.otus.java.basic.homeworks.homework11.animals;

public abstract class Animal {
    String name;
    int runSpeed;
    int stamina;
    int staminaForRunningPerMeter = 1;

    public int run(int distance) {
        if (distance < 0) {
            System.out.println("Дистанция не может быть отрицательной");
            return -1;
        }
        if (distance * staminaForRunningPerMeter > stamina) {
            System.out.println("Животное устало");
            return -1;
        }
        stamina -= distance * staminaForRunningPerMeter;
        int time = distance / runSpeed;
        System.out.println(this.name + " - чтобы пробежать дистанцию " + distance + "м затрачено секунд: " + time);
        return 1;
    }

    public void info() {
        System.out.println("Имя:" + this.name +
                " Единиц выносливости:" + this.stamina +
                " Скорость бега: " + this.runSpeed);
    }

    ;
}
