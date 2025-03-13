package ru.otus.java.basic.homeworks.homework19;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class TextFileManager {

    private final Scanner scanner;
    private final FileFilter filter;
    private final File file;
    private boolean isRunning;

    public TextFileManager(String rootDir, String fileType) {
        this.file = new File(rootDir);
        this.isRunning = false;
        this.scanner = new Scanner(System.in);
        this.filter = new FileFilter()
        {
            public boolean accept(File file) {
                if (file.getName().endsWith("fileType")) {
                    return true;
                }
                return false;
            }
        };
    }

    public void runManager(){
        this.isRunning=true;
        System.out.printf("%-20s %-5s\n", "NAME", "SIZE");
    }
}
