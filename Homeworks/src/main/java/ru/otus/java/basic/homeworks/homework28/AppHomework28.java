package ru.otus.java.basic.homeworks.homework28;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppHomework28 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите абсолютный путь к файлу:");
        String absPath = scanner.nextLine();
        File file = new File(absPath);
        if (!file.exists()) {
            System.out.println("Указанный файл не найден! - Укажите корректный путь");
        }
        System.out.println("Введите искомую последовательность символов");
        String searchPattern = scanner.nextLine();
        Pattern pattern = Pattern.compile(searchPattern);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
            Matcher matcher = pattern.matcher(text);
            int counter = 0;
            while (matcher.find()){
                counter++;
            }
            System.out.println("Искомая последовательность символов встретилась "+counter+ " раз");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
