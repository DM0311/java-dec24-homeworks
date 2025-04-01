package ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private int port;
    private ConcurrentHashMap<String, ClientHandler> clients;

    public Server(int port) {
        this.port = port;
        this.clients = new ConcurrentHashMap<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.put(clientHandler.getUserName(), clientHandler);
    }

    public void unSubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler.getUserName());
        System.out.println("Клиент " + clientHandler.getUserName() + " отключился");
    }

    public void sendBroadcastMessage(String message) {
        for (Map.Entry<String, ClientHandler> element : clients.entrySet()) {
            element.getValue().sendMsg(message);
        }
    }

    public void sendDirectMessage(String message, String fromUserName, String toUserName) {
        if(clients.containsKey(toUserName)){
            clients.get(toUserName).sendMsg(fromUserName+": "+message);
        }else {
            clients.get(fromUserName).sendMsg("SERVER: Пользователь "+toUserName+" не найден");
        }
    }
}
