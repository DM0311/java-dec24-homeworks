package ru.otus.java.basic.homeworks.homework32.processors;

import ru.otus.java.basic.homeworks.homework32.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HelloProcessor implements RequestProcessor{
    @Override
    public void execute(HttpRequest request, OutputStream out) throws IOException {
        String respose = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Content-type: text/html\r\n" +
                "\r\n" +
                "<html><body><h1>Hello World!</h1></body></html>";
        out.write(respose.getBytes(StandardCharsets.UTF_8));
    }
}
