package ru.otus.java.basic.homeworks.homework30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppHomework30 {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);

        SyncPrinter printer = new SyncPrinter();

        service.execute(() -> printer.printA());

        service.execute(() -> printer.printB());

        service.execute(() -> printer.printC());

        service.shutdown();

    }
}
