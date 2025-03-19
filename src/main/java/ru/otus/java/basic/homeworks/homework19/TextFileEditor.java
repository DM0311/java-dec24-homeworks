package ru.otus.java.basic.homeworks.homework19;

import java.io.*;

public class TextFileEditor {

    public void readAndPrint(String filePath) {
        System.out.println(read(filePath));
        System.out.println();
    }

    public String read(String filePath) {
        StringBuilder builder = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            int n;
            while ((n = reader.read()) != -1) {
                builder.append((char) n);
            }
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        return builder.toString();
    }

    public void writeFile(String filePath, String text) {
        StringBuilder builder = new StringBuilder();
        builder.append(read(filePath));
        builder.append(text);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(builder.toString());
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
