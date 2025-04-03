package ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.authentification;

import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.ClientHandler;

public interface AuthenticationProvider {
    void initialize();
    boolean authenticate(ClientHandler clientHandler, String login, String password);
    boolean register(ClientHandler clientHandler, String login, String password,String username);
}
