package ru.otus.java.basic.homeworks.homework19;

import java.io.File;
import java.io.FileFilter;

public class TextFileManager {

    private final FileFilter textFileFilter;
    private final File file;
    private boolean isRunning;
    private TextFileEditor textFileEditor;
    private UserCommand userCommand;
    private String rootDir;

    public TextFileManager(String rootDir, String fileType) {
        this.rootDir = rootDir;
        this.file = new File(rootDir);
        this.isRunning = false;
        this.textFileEditor = new TextFileEditor();
        this.userCommand = new UserCommand();
        this.textFileFilter = new FileFilter() {
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
            String cmd = userCommand.readUserCommand();
            switch (cmd) {
                case "QUIT" -> {
                    isRunning = false;
                }
                default -> {
                    StringBuilder filePath = new StringBuilder(rootDir);
                    filePath.append(cmd);
                    textFileEditor.readAndPrint(filePath.toString());
                    String text = userCommand.readUserCommand();
                    if(file.exists()){
                        textFileEditor.writeFile(filePath.toString(), text);
                    }
                    System.out.println("Выбранного файла не существует!");
                }
            }
        }
    }

    private void printFilesFromDirectory() {
        System.out.println();
        System.out.printf("%-20s %-5s\n", "NAME", "SIZE");
        for (File f : file.listFiles(textFileFilter)) {
            System.out.printf("%-20s %-5s byte\n", f.getName(), f.length());
        }
        System.out.println();
        System.out.println("Для редактирования файла введите имя файла.");
        System.out.println("Для завершения работы введите команду QUIT");
    }
}
