package ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.commands;

import java.util.HashMap;
import java.util.Map;

public enum ResponseCommands {
    EXIT("/exit_ok"),
    KICK("/kick_ok");

    private final String command;
    private static final Map<String, ResponseCommands> map;

    static {
        map = new HashMap<>();
        for (ResponseCommands value : ResponseCommands.values()) {
            map.put(value.getCommand(), value);
        }
    }

    ResponseCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static ResponseCommands enumForValue(String value) {
        return map.get(value);
    }
}
