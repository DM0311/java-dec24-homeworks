package ru.otus.java.basic.homeworks.homework10;

public class AppHomework10 {
    public static void main(String[] args) {

        Person[] persons = new Person[10];
        persons[0] = new Person("Иванов","Иван","Иванович",1990,"ivanov_ii@gmail.com");
        persons[1] = new Person("Петров","Сергей","Иванович",1980,"petrov_si@gmail.com");
        persons[2] = new Person("Сидоров","Петр","Сергеевич",1997,"sidorov_ps@gmail.com");
        persons[3] = new Person("Иванова","Анна","Ивановна",1987,"ivanova_ai@gmail.com");
        persons[4] = new Person("Петрова","Анастасия","Сергеевна",1990,"petrova_as@gmail.com");
        persons[5] = new Person("Каменев","Юрий","Антонович",1960,"kamenev_ya@gmail.com");
        persons[6] = new Person("Каменева","Роксана","Бабаяновна",1962,"kameneva_rb@gmail.com");
        persons[7] = new Person("Каменев","Крис","Юрьевич",1980,"kamenev_ky@gmail.com");
        persons[8] = new Person("Каменев","Андрей","Юрьевич",1982,"kamenev_ay@gmail.com");
        persons[9] = new Person("Каменева","Антонина","Юрьевна",1984,"kameneva_ay@gmail.com");

        for (int i=0;i< persons.length;i++){
            if (2025-persons[i].getYearOfBirth()>40){
                persons[i].userInfo();
            }
        }

        //test Box class functions
        Box box1 = new Box(10,12,14,"белый");
        box1.changeColor("синий");
        box1.takeOut();
        box1.putIn("Игрушка");
        box1.open();
        box1.putIn("Игрушка");
        box1.info();
        box1.close();
        box1.takeOut();
        box1.open();
        box1.takeOut();

    }
}
