package ru.otus.java.basic.homeworks.homework30;

public class SyncPrinter {
    private Object monitor = new Object();
    private String lastSymbol= new String();

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!lastSymbol.equals("C") && !lastSymbol.isEmpty()) {
                        monitor.wait();
                    }
                    lastSymbol = "A";
                    System.out.print(lastSymbol);
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!lastSymbol.equals("A")) {
                        monitor.wait();
                    }
                    lastSymbol = "B";
                    System.out.print(lastSymbol);
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!lastSymbol.equals("B")) {
                        monitor.wait();
                    }
                    lastSymbol = "C";
                    System.out.print(lastSymbol);
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
