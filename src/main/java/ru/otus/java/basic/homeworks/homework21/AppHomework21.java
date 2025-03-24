package ru.otus.java.basic.homeworks.homework21;

public class AppHomework21 {
    public static void main(String[] args) throws InterruptedException {
        fillArray();
        fillArrayMultiThread();
    }

    public static void fillArray() {
        double[] array = new double[100_000_000];

        long millis = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }

        System.out.println("Время заполнения массива мс:");
        System.out.println(System.currentTimeMillis() - millis);
    }

    public static void fillArrayMultiThread() throws InterruptedException {

        double[] array = new double[100_000_000];

        Thread t1 = new Thread(new MyTask(array,0,25_000_000));
        Thread t2 = new Thread(new MyTask(array,25_000_000,50_000_000));
        Thread t3 = new Thread(new MyTask(array,50_000_000,75_000_000));
        Thread t4 = new Thread(new MyTask(array,75_000_000,100_000_000));

        long millis = System.currentTimeMillis();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Время заполнения массива мс:");
        System.out.println(System.currentTimeMillis() - millis);
    }
}
