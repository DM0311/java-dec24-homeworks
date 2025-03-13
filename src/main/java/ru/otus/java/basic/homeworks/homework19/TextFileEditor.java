package ru.otus.java.basic.homeworks.homework19;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextFileEditor {

    public void readAndPrint(String filePath) {
        System.out.println(read(filePath));
        System.out.println();
    }

    public String read(String filePath) {
        StringBuilder builder = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            int n = reader.read();
            do {
                builder.append((char) n);
                n = reader.read();
            } while (n > 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void writeFile(String filePath, String text) {
        StringBuilder builder = new StringBuilder();
        builder.append(read(filePath));
        builder.append(text);
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath))) {
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
