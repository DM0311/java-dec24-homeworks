package ru.otus.java.basic.homeworks.homework17;

public class AppHomework17 {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        try {
            phoneBook.add("John",123456789);
            phoneBook.add(null,123456789);
            phoneBook.add("Bob",48151623);
            phoneBook.add("Bob",48151624);
            phoneBook.add("Peter",987654);
            phoneBook.add("Tom",472106);
            phoneBook.add("Charley",451418234);
            phoneBook.add("Charley",null);
        }catch (RuntimeException e){
            System.err.println(e);
        }

        System.out.println(phoneBook.toString());
        System.out.println(phoneBook.containsPhoneNumber(48151624));
        System.out.println(phoneBook.find("Bob"));

    }
}
