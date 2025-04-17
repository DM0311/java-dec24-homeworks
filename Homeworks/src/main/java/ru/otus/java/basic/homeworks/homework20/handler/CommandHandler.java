package ru.otus.java.basic.homeworks.homework20.handler;

import java.io.*;

public class CommandHandler implements AutoCloseable {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public CommandHandler(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new DataInputStream(inputStream);
        this.outputStream = new DataOutputStream(outputStream);
    }

    public void sendMessage(String message)throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();
        try {
            String result = inputStream.readUTF();
            System.out.println(result);
        } catch (EOFException e) {
            System.out.println("Сервер закрыл соединение.");
        }
    }


    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
