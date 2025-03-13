package ru.otus.java.basic.homeworks.homework19;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class TextFileManager {

    private final Scanner scanner;
    private final FileFilter filter;
    private final File file;
    private boolean isRunning;
    private TextFileEditor textFileEditor;

    public TextFileManager(String rootDir, String fileType) {
        this.file = new File(rootDir);
        this.isRunning = false;
        this.scanner = new Scanner(System.in);
        this.textFileEditor = new TextFileEditor();
        this.filter = new FileFilter() {
            public boolean accept(File file) {
                if (file.getName().endsWith(fileType)) {
                    return true;
                }
                return false;
            }
        };
    }

    public void runManager() {
        this.isRunning = true;
        while (isRunning) {
            printFilesFromDirectory();
            userAction();
        }


    }

    private void printFilesFromDirectory() {
        System.out.println();
        System.out.printf("%-20s %-5s\n", "NAME", "SIZE");
        for (File f : file.listFiles(filter)) {
            System.out.printf("%-20s %-5s byte\n", f.getName(), f.length());
        }
        System.out.println();
        System.out.println("Для редактирования файла введите имя файла.");
        System.out.println("Для завершения работы введите команду QUIT");
    }

    private void userAction() {
        String command = scanner.nextLine();
        switch (command) {
            case "QUIT" -> {
                isRunning = false;
            }
            default -> {textFileEditor.editFile(command);
            }
        }
    }
}
