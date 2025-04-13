package ru.otus.java.basic;

import ru.otus.java.basic.authentification.AuthenticationProvider;
import ru.otus.java.basic.authentification.DataBaseAuthProvider;
import ru.otus.java.basic.authentification.InMemoryAuthProvider;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private int port;
    private ConcurrentHashMap<String, ClientHandler> clients;
    private AuthenticationProvider authenticationProvider;

    public Server(int port) {
        this.port = port;
        this.clients = new ConcurrentHashMap<>();
        try {
            this.authenticationProvider = new DataBaseAuthProvider(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту " + port);
            authenticationProvider.initialize();

            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.put(clientHandler.getUser().getLogin(), clientHandler);
    }

    public void unSubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler.getUser().getLogin());
        System.out.println("Клиент " + clientHandler.getUser().getLogin() + " отключился");
    }

    public void sendBroadcastMessage(String message) {
        for (Map.Entry<String, ClientHandler> element : clients.entrySet()) {
            element.getValue().sendMsg(message);
        }
    }

    public void sendDirectMessage(String message, String fromUserName, String toUserName) {
        ClientHandler from = null;
        ClientHandler to = null;
        for (Map.Entry<String, ClientHandler> element : clients.entrySet()) {
            if (element.getValue().getUser().getUsername().equals(toUserName)) {
                to = element.getValue();
            } else if (element.getValue().getUser().getUsername().equals(fromUserName)) {
                from = element.getValue();
            }
        }

        if (to == null) {
            from.sendMsg(String.format("[%s]: %s", "SERVER", "Пользователь не найден"));
        } else {
            to.sendMsg(String.format("[%s]: %s", from.getUser().getUsername(), message));
        }
    }

    public boolean isLoggedIn(String login) {
        if (clients.containsKey(login)) {
            return true;
        } else {
            return false;
        }
    }


    public AuthenticationProvider getAuthenticationProvider() {
        return authenticationProvider;
    }

    public ClientHandler getClientHandle(String username) {
        for (Map.Entry<String, ClientHandler> element : clients.entrySet()) {
            if (element.getValue().getUser().getUsername().equals(username)) {
                return element.getValue();
            }
        }
        return null;
    }
}
