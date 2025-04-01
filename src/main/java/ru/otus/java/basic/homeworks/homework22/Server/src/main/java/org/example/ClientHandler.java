package ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example;

import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.model.Message;
import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.utils.Commands;
import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.utils.MessageProcessor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;
    private String userName;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {

            try {
                System.out.println("Клиент подключился...");
                out.writeUTF("SERVER: Введите имя пользователя");
                userName = in.readUTF();
                System.out.println(userName + " авторизовался");
                out.writeUTF("SERVER: Вы авторизовались как " + userName);
                server.subscribe(this);
                boolean working = true;
                while (working) {
                    Message message = MessageProcessor.parse(userName, in.readUTF());
                    switch (message.getCommand()) {
                        case EXIT -> {
                            sendMsg(Commands.EXIT.getCommand());
                            working = false;
                        }
                        case DIRECT_MESSAGE -> {
                            server.sendDirectMessage(message.getMessageText(),
                                    message.getFromUser(),
                                    message.getToUser());
                        }
                        case BROADCAST_MESSAGE -> {
                            server.sendBroadcastMessage("SERVER: " + userName + " всем - " + message.getMessageText());
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUserName() {
        return userName;
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
