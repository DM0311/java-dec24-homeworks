package org.example.commands;

public enum Commands {
    EXIT("/exit");

    private final String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
