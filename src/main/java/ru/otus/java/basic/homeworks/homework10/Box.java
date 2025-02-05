package ru.otus.java.basic.homeworks.homework10;

public class Box {
    private int width;
    private int length;
    private int height;
    private String color;
    private boolean isEmpty;
    private boolean isOpened;
    private String item;

    public Box(int width, int length, int height, String color) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.color = color;
        this.isEmpty = true;
        this.isOpened = false;
    }


    public void changeColor(String color) {
        this.color = color;
        System.out.println("Коробку перекрасили в " + color + " цвет.");
    }

    public void info() {
        System.out.println("Ширина коробки: " + width +
                           ", Высота коробки: " + height +
                           ", Длина коробки: " + length +
                           ", Цвет коробки: "+color +
                           ", Коробка открыта: "+isOpened+
                           ", Предмет внутри: "+item);
    }

    public void putIn(String item) {
        if (isEmpty && isOpened) {
            this.item = item;
            isEmpty = false;
            System.out.println("В коробку положили предмет: " + item);
        } else {
            System.out.println("В коробку нельзя поместить предмет!");
        }
    }

    public void takeOut() {
        if (!isEmpty && isOpened) {
            isEmpty = false;
            System.out.println("Из коробки выкинули предмет.");
        } else {
            System.out.println("Невозможно выкинуть предмет!");
        }

    }

    public void openBox() {
        if (!isOpened) {
            isOpened = true;
            System.out.println("Коробка открылась.");
        } else {
            System.out.println("Коробка уже открыта!");
        }
    }

    public void closeBox() {
        if (isOpened) {
            isOpened = false;
            System.out.println("Коробка закрылась.");
        } else {
            System.out.println("Коробка уже закрыта!");
        }
    }
}
