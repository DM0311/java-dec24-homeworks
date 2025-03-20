package ru.otus.java.basic.homeworks.homework20.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("СЕРВЕР ЗАПУЩЕН!");
        while(true){
            Socket client = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            String userInput = inputStream.readUTF();
            System.out.println("Сообщение от клинета: " + userInput);
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Клиент с портом:" + client.getPort() + " отключился!");
                client.close();
                continue;
            }
            String result = calculate(userInput);
            outputStream.writeUTF(result);
            outputStream.flush();
            System.out.println("Результат вычислений " + result);
        }
    }

    public static String calculate(String inputMessage){
        Pattern pattern = Pattern.compile("^(?<element1>\\d{1,7})\\s(?<element2>\\d{1,7})\\s(?<sign>[+\\-\\*\\/])");
        Matcher matcher = pattern.matcher(inputMessage);
        if(matcher.matches()){
            int a = Integer.parseInt(matcher.group("element1"));
            int b = Integer.parseInt(matcher.group("element2"));
            String sign = matcher.group("sign");
            switch (sign){
                case "+"->{return String.valueOf(a+b);}
                case "-"->{return String.valueOf(a-b);}
                case "*"->{return String.valueOf(a*b);}
                case "/"->{return String.valueOf(a/b);}
            }
        }
        return "Некорректное выражение";
    }
}
