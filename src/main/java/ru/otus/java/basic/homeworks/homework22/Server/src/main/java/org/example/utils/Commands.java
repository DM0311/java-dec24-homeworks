package ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.utils;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public enum Commands {
    EXIT("exit"),
    DIRECT_MESSAGE("w"),
    BROADCAST_MESSAGE("b");

    private final String command;
    private static final Map<String, Commands> map;

    static {
        map = new HashMap<>();
        for (Commands value : Commands.values()) {
            map.put(value.getCommand(), value);
        }
    }

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static Commands enumForValue(String value) {
        return map.get(value);
    }
}
