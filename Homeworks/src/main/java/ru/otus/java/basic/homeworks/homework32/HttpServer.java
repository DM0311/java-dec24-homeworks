package ru.otus.java.basic.homeworks.homework32;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();

                /*
                * Вопрос по коду - если использовать следующий код, то сыпет ошибками Socket closed при отправке запрос.
                * Я правильно понимаю что в таком случае когда есть try-with-resources из-за того что рузультат .accept
                * отправляется в параллельный то сокет закрывается?
                *
                * try (Socket socket = serverSocket.accept()) {
                * executor.execute(() -> {
                *   try (InputStream in = socket.getInputStream();
                         OutputStream out = socket.getOutputStream()) {
                        byte[] buffer = new byte[8192];
                        ..........
                        dispatcher.execute(request, socket.getOutputStream());
                *
                * });
                * */
                System.out.println("Получено новое соединение");
                executor.execute(() -> {
                    try (InputStream in = socket.getInputStream();
                         OutputStream out = socket.getOutputStream()) {
                        byte[] buffer = new byte[8192];
                        int n = socket.getInputStream().read(buffer);
                        if (n < 0) {
                            System.out.println("Получено битое сообщение");
                            return;
                        }
                        String rawRequest = new String(buffer, 0, n);
                        HttpRequest request = new HttpRequest(rawRequest);
                        System.out.println("Поток для обработки запроса: " + Thread.currentThread().getName());
                        request.info(false);
                        dispatcher.execute(request, socket.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
