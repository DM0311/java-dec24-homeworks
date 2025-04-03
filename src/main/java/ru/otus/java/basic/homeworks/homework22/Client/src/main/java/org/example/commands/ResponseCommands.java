package org.example.commands;

public enum ResponseCommands {
    EXIT("/exit_ok"),
    AUTH("/auth_ok"),
    KICK("/kick_ok");

    private final String command;

    ResponseCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
