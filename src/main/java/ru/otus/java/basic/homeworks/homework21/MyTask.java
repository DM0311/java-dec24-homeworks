package ru.otus.java.basic.homeworks.homework21;

public class MyTask implements Runnable {
    private double[] targetArray;
    private int startIndex;
    private int endIndex;

    public MyTask(double[] targetArray, int startIndex, int andIndex) {
        this.targetArray = targetArray;
        this.startIndex = startIndex;
        this.endIndex = andIndex;
    }

    private void fillArray() {
        for (int i = startIndex; i < endIndex; i++) {
            targetArray[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    ;

    @Override
    public void run() {
        fillArray();
    }
}
