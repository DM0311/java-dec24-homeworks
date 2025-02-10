package ru.otus.java.basic.homeworks.homework11.animal;

public abstract class Animal {
    String name;
    int runSpeed;
    int stamina;
    int staminaForRunningPerMeter = 1;

    public int run(int distance) {
        if (distance * staminaForRunningPerMeter > stamina) {
            System.out.println("Животное устало");
            return -1;
        } else {
            stamina -= distance * staminaForRunningPerMeter;
            int time = distance / runSpeed;
            System.out.println(this.name + " - чтобы пробежать дистанцию " + distance + "м затрачено секунд: " + time);
            return 1;
        }
    }

    public void info(){
        System.out.println("Имя:" + this.name +
                " Единиц выносливости:" + this.stamina +
                " Скорость бега: " + this.runSpeed);
    };
}
