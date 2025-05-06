package ru.otus.java.basic.homeworks.homework32;

import ru.otus.java.basic.homeworks.homework32.processors.CalculatorProcessor;
import ru.otus.java.basic.homeworks.homework32.processors.DefaultProcessor;
import ru.otus.java.basic.homeworks.homework32.processors.HelloProcessor;
import ru.otus.java.basic.homeworks.homework32.processors.RequestProcessor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private int port;
    private Dispatcher dispatcher;
    private ExecutorService executor;


    public HttpServer(int port) {
        this.port = port;
        this.dispatcher = new Dispatcher();
        this.executor = Executors.newFixedThreadPool(3);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port);

        ) {
            System.out.println("Сервер запущен на порту: " + port);
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    byte[] buffer = new byte[8192];
                    int n = socket.getInputStream().read(buffer);
                    if (n < 0) {
                        System.out.println("Получено ");
                        continue;
                    }
                    String rawRequest = new String(buffer, 0, n);
                    HttpRequest request = new HttpRequest(rawRequest);
                    request.info(false);
                    dispatcher.execute(request, socket.getOutputStream());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
