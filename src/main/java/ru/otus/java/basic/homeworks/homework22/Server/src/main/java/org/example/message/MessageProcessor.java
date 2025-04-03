package ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.message;

import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.commands.Commands;

public class MessageProcessor {

    public static Message parse(String inputText) {

        if (inputText.startsWith("/")) {
            Commands command = Commands.enumForValue(inputText.substring(0, inputText.indexOf(' ') == -1 ? inputText.length() : inputText.indexOf(' ')));
            String[] params = inputText.replace(command.getCommand() + " ", "").split(" ", command.getNumberOfParameters());
            return new Message(command, params);
        } else {
            return new Message(Commands.BROADCAST_MESSAGE, new String[]{inputText});
        }
    }
}
