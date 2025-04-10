package ru.otus.java.basic;

import ru.otus.java.basic.commands.Commands;
import ru.otus.java.basic.commands.ResponseCommands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket socket = new Socket("localhost", 8090);
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    DataInputStream in = new DataInputStream(socket.getInputStream());

    public Client() throws IOException {
        Scanner scanner = new Scanner(System.in);
        try {
            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        if (message.startsWith("/")) {
                            if (message.equals(ResponseCommands.EXIT.getCommand())) {
                                break;
                            }
                            if (message.startsWith("/kick_ok")) {
                                System.out.println("Вас удалили из чата...");
                                out.writeUTF("/exit");
                                break;
                            }
                            if (message.startsWith("/auth_ok")) {
                                System.out.println("Удалось успешно войти в час с ником "
                                        + message.split(" ")[1]);
                            }
                            if (message.startsWith("/reg_ok")) {
                                System.out.println("Удалось успешно зарегистрироваться и войти в чаn с ником "
                                        + message.split(" ")[1]);
                            }
                        } else {
                            System.out.println(message);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    disconnect();
                }
            }).start();

            while (true) {
                String message = scanner.nextLine();
                out.writeUTF(message);
                if (message.equals(Commands.EXIT.getCommand())) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {

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
