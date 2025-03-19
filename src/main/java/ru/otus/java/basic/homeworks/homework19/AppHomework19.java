package ru.otus.java.basic.homeworks.homework19;

import java.io.File;
import java.io.FileFilter;

public class AppHomework19 {
    public static void main(String[] args) {
        File file = new File(".");
        TextFileManager textFileManager = new TextFileManager(".",".txt");
        textFileManager.runTextFileManager();

    }
}
