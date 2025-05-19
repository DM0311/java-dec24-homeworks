package ru.otus.java.basic.homeworks.homework32;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class AppHomewrork32 {
    public static void main(String[] args) {
        new HttpServer(8192).start();
    }
}
