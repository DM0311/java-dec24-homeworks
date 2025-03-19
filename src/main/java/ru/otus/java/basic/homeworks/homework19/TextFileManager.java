package ru.otus.java.basic.homeworks.homework19;

import java.io.File;
import java.io.FileFilter;
import java.sql.SQLOutput;
import java.util.Scanner;

public class TextFileManager {
    private File rootDirectory;

    private FileFilter textFilefilter;

    private Scanner scanner;
    private boolean isRunning;

    public TextFileManager(String rootDir, String fileType) {
        this.rootDirectory = new File(rootDir);
        this.scanner = new Scanner(System.in);
        this.isRunning = false;
        this.textFilefilter = new FileFilter() {
            public boolean accept(File file) {
                if (file.getName().endsWith(fileType)) {
                    return true;
                }
                return false;
            }
        };
    }

    public void printDirectory() {
        System.out.printf("%-20s %-5s\n", "NAME", "SIZE");
        for (File f : rootDirectory.listFiles(textFilefilter)) {
            if (f.isFile()) {
                System.out.printf("%-20s %-5d byte\n", f.getName(), f.length());
            }
        }
        System.out.println();
    }

    public void userAction() {

        System.out.println("Введите имя файла для редактирования");
        System.out.println("Дя завершения работы введите команду QUIT");
        String cmd = scanner.nextLine();
        switch (cmd) {
            case "QUIT" -> {
                isRunning = false;
            }
            default -> {
            }
        }
    }

    public void runTextFileManager() {
        isRunning = true;
        while (isRunning) {
            printDirectory();
            userAction();
        }
    }

}
