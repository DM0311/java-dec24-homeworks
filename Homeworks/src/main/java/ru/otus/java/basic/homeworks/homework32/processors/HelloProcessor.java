package ru.otus.java.basic.homeworks.homework32.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.homeworks.homework32.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HelloProcessor implements RequestProcessor {
    private final Logger logger = LogManager.getLogger(HelloProcessor.class);

    @Override
    public void execute(HttpRequest request, OutputStream out) throws IOException {
        try {
            String respose = "" +
                    "HTTP/1.1 200 OK\r\n" +
                    "Content-type: text/html\r\n" +
                    "\r\n" +
                    "<html><body><h1>Hello World!</h1></body></html>";
            out.write(respose.getBytes(StandardCharsets.UTF_8));
        } catch (RuntimeException e) {
            logger.error("Runtime exception " + e.getMessage());
            String respose = "" +
                    "HTTP/1.1 500 Internal Error\r\n" +
                    "Content-type: text/html\r\n" +
                    "\r\n";
            out.write(respose.getBytes(StandardCharsets.UTF_8));
        }

    }
}
