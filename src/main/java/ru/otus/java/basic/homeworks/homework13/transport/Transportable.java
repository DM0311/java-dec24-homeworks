package ru.otus.java.basic.homeworks.homework13.transport;

import ru.otus.java.basic.homeworks.homework13.Terrain;

public interface Transportable {
    boolean move(int distance, Terrain terrain);
}
