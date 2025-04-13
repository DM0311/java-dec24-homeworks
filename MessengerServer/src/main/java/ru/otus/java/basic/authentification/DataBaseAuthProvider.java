package ru.otus.java.basic.authentification;

import ru.otus.java.basic.ClientHandler;
import ru.otus.java.basic.Server;
import ru.otus.java.basic.model.Role;
import ru.otus.java.basic.model.User;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DataBaseAuthProvider implements AuthenticationProvider {

    private final Connection connection;

    private Server server;

    private List<User> users;

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String USERS_QUERY = "select u.\"password\", u.login, u.username, r.\"rolename\" \n" +
            "from users_to_roles utr \n" +
            "join users u on id = user_id\n" +
            "join roles r on r.id = role_id";


    public DataBaseAuthProvider(Server server) throws SQLException {
        this.server = server;
        this.users = new CopyOnWriteArrayList<>();
        this.connection = DriverManager.getConnection(DATABASE_URL,
                "postgres",
                "admin");

        try (Statement statement = connection.createStatement()) {
            
            ResultSet rs = statement.executeQuery(USERS_QUERY);
            while (rs.next()) {

                Role role = Role.enumForValue(rs.getString("rolename"));
                if (role == null) {
                    throw new RuntimeException("Unknown role");
                }
                users.add(new User(rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("username"),
                        role));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        System.out.println("Initialization of DataBaseAuthProvider ...");
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
        throw new RuntimeException("Function not implemented yet ...");
    }
}
