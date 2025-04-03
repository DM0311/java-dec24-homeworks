package ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example;

import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.message.Message;
import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.message.MessageProcessor;
import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.commands.ResponseCommands;
import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.model.Role;
import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.model.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;
    private User user;
    private boolean authenticated;


    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {

            try {

                boolean working = true;

                while (working && !authenticated) {
                    sendMsg("Перед работой с чатом необходимо выполнить аутентификацию "
                            + "/auth Login Password \n" +
                            "или регистрацию /reg login password user");
                    Message message = MessageProcessor.parse(in.readUTF());
                    switch (message.getCommand()) {
                        case EXIT -> {
                            sendMsg(ResponseCommands.EXIT.getCommand());
                            working = false;
                        }
                        case AUTH -> {
                            if (message.getParameters().length != 2) {
                                sendMsg("Неверный формат команды /auth");
                                continue;
                            }
                            if (server.getAuthenticationProvider().authenticate(
                                    this,
                                    message.getParameters()[0],
                                    message.getParameters()[1])) {
                                authenticated = true;
                            }
                        }
                        case REGISTER -> {
                            if (message.getParameters().length != 3) {
                                sendMsg("Неверный формат команды /reg");
                                continue;
                            }
                            if (server.getAuthenticationProvider().register(
                                    this,
                                    message.getParameters()[0],
                                    message.getParameters()[1],
                                    message.getParameters()[2])) {
                                authenticated = true;
                            }
                        }
                    }
                }

                System.out.println("Клиент " + user.getUsername() + " прошел аутентификацию и подключился ...");

                while (working && authenticated) {
                    Message message = MessageProcessor.parse(in.readUTF());
                    switch (message.getCommand()) {
                        case EXIT -> {
                            sendMsg(ResponseCommands.EXIT.getCommand());
                            working = false;
                        }
                        case DIRECT_MESSAGE -> {
                            server.sendDirectMessage(message.getParameters()[1],
                                    user.getUsername(),
                                    message.getParameters()[0]);
                        }
                        case BROADCAST_MESSAGE -> {
                            server.sendBroadcastMessage("[" + user.getUsername() + "]: " + message.getParameters()[0]);
                        }
                        case KICK -> {
                            if (message.getParameters().length != 1) {
                                sendMsg("Неверный формат команды /kick");
                                continue;
                            }
                            if (!user.getRole().equals(Role.ADMIN)) {
                                sendMsg("Недостаточно прав чтобы исключить участника");
                                continue;
                            }
                            ClientHandler kickedUser = server.getClientHandle(message.getParameters()[0]);
                            kickedUser.sendMsg(ResponseCommands.KICK.getCommand());
                            server.sendBroadcastMessage("[SERVER]: "
                                    + "пользователь с именем "
                                    + message.getParameters()[0]
                                    + " исключен из чата");
                            kickedUser.disconnect();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }

        }).start();
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void disconnect() {
        server.unSubscribe(this);
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }

        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }
}
