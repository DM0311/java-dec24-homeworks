package ru.otus.java.basic.homeworks.homework19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppHomework19 {
    public static void main(String[] args) {

        /*try(InputStreamReader reader = new InputStreamReader(new FileInputStream("./Text_1.txt"))) {
            int n = reader.read();
            do{
                System.out.print((char) n);
                n= reader.read();
            }while(n>0);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        TextFileManager textFileManager = new TextFileManager("./",".txt");
        textFileManager.runManager();
    }
}
