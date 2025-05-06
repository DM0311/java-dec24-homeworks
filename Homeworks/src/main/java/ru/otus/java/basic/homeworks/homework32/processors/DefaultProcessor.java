package ru.otus.java.basic.homeworks.homework32.processors;

import ru.otus.java.basic.homeworks.homework32.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class DefaultProcessor implements RequestProcessor{
    @Override
    public void execute(HttpRequest request, OutputStream out) throws IOException {
        String response = "" +
                "HTTP/1.1 404 Not Found\r\n" +
                "Content-type: text/html\r\n" +
                "\r\n" +
                "<html><body><h1>PAGE NOT FOUND</h1></body></html>";
        out.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
