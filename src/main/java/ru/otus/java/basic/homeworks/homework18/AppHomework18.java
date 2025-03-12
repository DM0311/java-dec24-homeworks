package ru.otus.java.basic.homeworks.homework18;

import ru.otus.java.basic.homeworks.homework18.advanced.BinaryTree;
import ru.otus.java.basic.homeworks.homework18.advanced.MergeSort;
import ru.otus.java.basic.homeworks.homework18.advanced.TreeElement;
import ru.otus.java.basic.homeworks.homework18.basic.BubbleSort;
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

        int[]testArray1 = new int[]{4,6,8,2,10,5};
        BubbleSort.sort(testArray1);
        for (int value:testArray1){
            System.out.print(value+" ");

        }
        System.out.println();

        int[]testArray2 = new int[]{4,6,8,2,10,5,3};
        int[]sortedArray = MergeSort.sort(testArray2);
        for (int value:sortedArray){
            System.out.print(value+" ");
        }
        System.out.println();

        List<Integer> testList = List.of(6,4,8,2,10,5);
        BinaryTree tree = new BinaryTree<>(testList);
        var test = tree.find(8);
        System.out.println(test);


    }
}
