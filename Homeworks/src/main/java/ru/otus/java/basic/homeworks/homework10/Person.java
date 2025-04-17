package ru.otus.java.basic.homeworks.homework10;

public class Person {
    private String familyName;
    private String firstName;
    private String secondName;
    private int yearOfBirth;
    private String eMail;

    public Person(String familyName, String firstName, String secondName, int yearOfBirth, String eMail) {
        this.familyName = familyName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.yearOfBirth = yearOfBirth;
        this.eMail = eMail;
    }

    public void userInfo(){
        System.out.println("ФИО: "+familyName+" "+firstName+" "+secondName);
        System.out.println("Год рождения: "+ yearOfBirth);
        System.out.println("e-mail: "+eMail);
        System.out.println();
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
