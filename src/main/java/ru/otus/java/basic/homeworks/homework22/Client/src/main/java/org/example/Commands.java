package org.example;

public enum Commands {
    EXIT("/exit"),
    DIRECT_MESSAGE("/w");

    private final String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
