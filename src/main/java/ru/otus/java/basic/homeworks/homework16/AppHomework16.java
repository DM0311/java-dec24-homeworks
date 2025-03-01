package ru.otus.java.basic.homeworks.homework16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppHomework16 {
    public static void main(String[] args) {

        List<Integer> test1 = generateList(2, 10);
        System.out.println("Сгенерированный массив: " + test1);

        int sum = sumElements(test1);
        System.out.println("Сумма элементов массива: " + sum);

        replaceElements(2, test1);
        System.out.println("Исправленный массив: " + test1);

        addToElemets(1, test1);
        System.out.println("Массив после увеличения элементов: " + test1);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Bob", 40));
        employees.add(new Employee("Tom", 28));
        employees.add(new Employee("John", 54));
        employees.add(new Employee("Karl", 31));
        employees.add(new Employee("Fred", 55));

        System.out.println("Список имен сотрудников:");
        System.out.println(getNames(employees));
        System.out.println("Список сотрудников старше стреднего возраста :");
        System.out.println(getOlderThan(employees, 35));
        System.out.println("Средний возраст сотрудников превышает средний возраст: " + isOlderThan(employees, 33));
        System.out.println("Самый молодй сотрудник:");
        System.out.println(getYoungest(employees));

    }

    public static List<Integer> generateList(int min, int max) {
        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    public static int sumElements(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i > 5 ? i : 0;
        }
        return sum;
    }

    public static void replaceElements(int a, List<Integer> source) {
        for (int i = 0; i < source.size(); i++) {
            source.set(i, a);
        }
    }

    public static void addToElemets(int a, List<Integer> source) {
        for (int i = 0; i < source.size(); i++) {
            source.set(i, source.get(i) + a);
        }
    }

    public static List<String> getNames(List<Employee> employees) {
        List<String> names = new ArrayList<>();
        for (Employee employee : employees) {
            names.add(employee.getName());
        }
        return names;
    }

    public static List<Employee> getOlderThan(List<Employee> employees, int minAge) {
        List<Employee> sortedEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                sortedEmployees.add(employee);
            }
        }
        return sortedEmployees;
    }

    public static boolean isOlderThan(List<Employee> employees, int averageAge) {
        if(employees.isEmpty()){
            return false;
        }
        double currentAverageAge = 0;
        int counter = 0;
        for (Employee employee : employees) {
            currentAverageAge += employee.getAge();
            counter++;
        }
        return currentAverageAge / counter > averageAge;
    }

    public static Employee getYoungest(List<Employee> employees) throws IllegalArgumentException {
        if(employees.isEmpty()){
            throw new IllegalArgumentException("List of employees is empty!");
        }
        Employee youngest = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getAge() < youngest.getAge()) {
                youngest = employee;
            }
        }
        return youngest;
    }
}
