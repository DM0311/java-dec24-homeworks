package ru.otus.java.basic.authentification;

import ru.otus.java.basic.ClientHandler;

public interface AuthenticationProvider {
    void initialize();

    boolean authenticate(ClientHandler clientHandler, String login, String password);

    boolean register(ClientHandler clientHandler, String login, String password, String username);
}
