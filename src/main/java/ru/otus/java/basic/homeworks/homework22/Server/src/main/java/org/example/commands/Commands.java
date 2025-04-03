package ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.commands;

import java.util.HashMap;
import java.util.Map;

public enum Commands {
    EXIT("/exit", 0),
    AUTH("/auth", 2),
    REGISTER("/reg", 3),
    KICK("/kick", 1),
    DIRECT_MESSAGE("/w", 2),
    BROADCAST_MESSAGE("/b", 1);

    private final String command;
    private final int numberOfParameters;
    private static final Map<String, Commands> map;

    static {
        map = new HashMap<>();
        for (Commands value : Commands.values()) {
            map.put(value.getCommand(), value);
        }
    }

    Commands(String command, int numberOfParameters) {
        this.command = command;
        this.numberOfParameters = numberOfParameters;
    }

    public String getCommand() {
        return command;
    }

    public int getNumberOfParameters() {
        return numberOfParameters;
    }

    public static Commands enumForValue(String value) {
        return map.get(value);
    }
}
