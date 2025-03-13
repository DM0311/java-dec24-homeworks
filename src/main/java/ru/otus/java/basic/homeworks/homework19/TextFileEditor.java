package ru.otus.java.basic.homeworks.homework19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFileEditor {

    private String help;

    public void editFile(String filePath){
        try(InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
                int n = reader.read();
                do{
                    System.out.print((char) n);
                    n = reader.read();
                }while(n>0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        
    }
}
