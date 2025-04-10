package ru.otus.java.basic.message;

import ru.otus.java.basic.commands.Commands;

public class Message {

    private Commands command;
    private String[] parameters;

    public Message(Commands command, String[] parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    public Commands getCommand() {
        return command;
    }

    public void setCommand(Commands command) {
        this.command = command;
    }

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }
}
