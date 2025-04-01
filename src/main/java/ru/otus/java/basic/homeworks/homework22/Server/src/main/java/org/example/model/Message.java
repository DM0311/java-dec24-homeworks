package ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.model;

import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.utils.Commands;

public class Message {
    private String messageText;
    private String fromUser;
    private String toUser;
    private Commands command;

    public Message(String messageText, String fromUser) {
        this(messageText, fromUser, "",Commands.BROADCAST_MESSAGE.getCommand());
    }

    public Message(String messageText, String fromUser, String toUser, String command) {
        this.messageText = messageText;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.command = Commands.enumForValue(command);
    }

    public String getMessageText() {
        return messageText;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public Commands getCommand() {
        return command;
    }
}
