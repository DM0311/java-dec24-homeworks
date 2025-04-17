package ru.otus.java.basic.homeworks.homework20.client;

import ru.otus.java.basic.homeworks.homework20.handler.CommandHandler;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            try(Socket socket = new Socket("localhost", 8080)){
                CommandHandler handler = new CommandHandler(socket.getInputStream(),socket.getOutputStream());
                System.out.println("Введи сообщение : ");
                String userMessage = scanner.nextLine();
                if (userMessage.equalsIgnoreCase("exit")) {
                    handler.sendMessage(userMessage);
                    break;
                }
                handler.sendMessage(userMessage);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }
}
