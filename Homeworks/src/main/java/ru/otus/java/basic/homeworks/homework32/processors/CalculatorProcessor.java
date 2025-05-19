package ru.otus.java.basic.homeworks.homework32.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.homeworks.homework32.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CalculatorProcessor implements RequestProcessor {
    private final Logger logger = LogManager.getLogger(CalculatorProcessor.class);

    @Override
    public void execute(HttpRequest request, OutputStream out) throws IOException {
        try {
            int a = Integer.parseInt(request.getParameter("a"));
            int b = Integer.parseInt(request.getParameter("b"));
            String respose = "" +
                    "HTTP/1.1 200 OK\r\n" +
                    "Content-type: text/html\r\n" +
                    "\r\n" +
                    "<html><body><h1>" + a + " + " + b + " = " + (a + b) + "</h1></body></html>";
            out.write(respose.getBytes(StandardCharsets.UTF_8));
        } catch (NumberFormatException e) {
            logger.error("Некорректные параметры запроса." + e.getMessage());
            String respose = "" +
                    "HTTP/1.1 400 Bad Request\r\n" +
                    "Content-type: text/html\r\n" +
                    "\r\n" +
                    "<html><body><h1>Only integer parameters permitted in parameters</h1></body></html>";
            out.write(respose.getBytes(StandardCharsets.UTF_8));
        } catch (RuntimeException ignored) {
            logger.error("Runtime exception " + ignored.getMessage());
            String respose = "" +
                    "HTTP/1.1 500 Internal Error\r\n" +
                    "Content-type: text/html\r\n" +
                    "\r\n";
            out.write(respose.getBytes(StandardCharsets.UTF_8));
        }

    }
}
