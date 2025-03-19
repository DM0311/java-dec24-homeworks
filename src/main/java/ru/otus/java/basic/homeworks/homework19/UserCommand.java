package ru.otus.java.basic.homeworks.homework19;

import java.util.Scanner;

public class UserCommand {

    private final Scanner scanner;

    public UserCommand() {
        this.scanner = new Scanner(System.in);
    }

    public String readUserCommand(){
        return scanner.nextLine();
    }
}
