package ru.otus.java.basic.homeworks.homework18;

import ru.otus.java.basic.homeworks.homework18.advanced.BinaryTree;
import ru.otus.java.basic.homeworks.homework18.basic.Person;
import ru.otus.java.basic.homeworks.homework18.basic.PersonDataBase;
import ru.otus.java.basic.homeworks.homework18.basic.Position;

import java.util.List;

public class AppHomework18 {
    public static void main(String[] args) {
        PersonDataBase personDataBase = new PersonDataBase();

        Person bob = new Person("Bob", Position.DIRECTOR, 123456L);
        Person john = new Person("John", Position.DRIVER, 123457L);
        Person karl = new Person("Karl", Position.BRANCH_DIRECTOR, 123458L);
        Person unknownPerson = new Person("Bubba", Position.JUNIOR, 123L);

        personDataBase.add(bob);
        personDataBase.add(john);
        personDataBase.add(karl);

        try {
            System.out.println(personDataBase.findById(123456L));
            //System.out.println(personDataBase.findById(123L));
            System.out.println(personDataBase.isEmployee(123456L));
            System.out.println(personDataBase.isManager(bob));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        List<Integer> testList = List.of(1,2,4,5,7,8,9);
        BinaryTree tree = new BinaryTree<>(testList);
        System.out.println("___");

    }
}
