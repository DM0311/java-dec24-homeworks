package ru.otus.java.basic.authentification;

import ru.otus.java.basic.ClientHandler;
import ru.otus.java.basic.Server;
import ru.otus.java.basic.model.Role;
import ru.otus.java.basic.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryAuthProvider implements AuthenticationProvider {

    private Server server;
    private List<User> users;

    public InMemoryAuthProvider(Server server) {
        this.server = server;
        this.users = new CopyOnWriteArrayList<>();
        users.add(new User("tom", "qwe", "Tom", Role.USER));
        users.add(new User("bob", "asd", "Bob", Role.USER));
        users.add(new User("admin", "zxc", "ADMIN", Role.ADMIN));
    }

    private User getUsernameByLoginAndPassword(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private boolean isLoginExists(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsernameExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(user)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void initialize() {
        System.out.println("Initialization of InMemoryAuthProvider ...");
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        User authUser = getUsernameByLoginAndPassword(login, password);
        if (authUser == null) {
            clientHandler.sendMsg("Некорректный логин/пароль");
            return false;
        }
        if (server.isLoggedIn(login)) {
            clientHandler.sendMsg("Данная учетная запись уже занята");
            return false;
        }
        clientHandler.setUser(authUser);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/auth_ok " + authUser.getUsername());
        return true;
    }

    @Override
    public boolean register(ClientHandler clientHandler, String login, String password, String username) {
        if (login.trim().length() < 3 && login.trim().length() < 3 && login.trim().length() < 3) {
            clientHandler.sendMsg("Логин 3+ символа, пароль 3+ символа, имя пользователя 3+ символа");
            return false;
        }
        if (isLoginExists(login)) {
            clientHandler.sendMsg("Указанный логин уже занят");
            return false;
        }
        if (isUsernameExists(username)) {
            clientHandler.sendMsg("Указанное имя пользователя уже занято");
            return false;
        }
        User newUser = new User(login, password, username, Role.USER);
        users.add(newUser);
        clientHandler.setUser(newUser);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/reg_ok " + newUser.getUsername());
        return true;
    }
}
