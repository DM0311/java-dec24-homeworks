package ru.otus.java.basic.homeworks.homework32.processors;

import ru.otus.java.basic.homeworks.homework32.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;

public interface RequestProcessor {
    void execute(HttpRequest request, OutputStream out) throws IOException;
}
