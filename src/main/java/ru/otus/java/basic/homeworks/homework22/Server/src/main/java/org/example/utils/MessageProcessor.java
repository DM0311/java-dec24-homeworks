package ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.utils;

import ru.otus.java.basic.homeworks.homework22.Server.src.main.java.org.example.model.Message;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageProcessor {
    private static final Pattern DIRECT_MESSAGE_PATTERN = Pattern.compile("^\\/(?<command>\\w)\\s(?<toUser>\\w+)\\s(?<msgText>.*)");
    private static final Pattern RAW_MESSAGE_PATTERN = Pattern.compile("^(?<msgText>.+)");
    private static final Pattern RAW_COMMAND_PATTERN = Pattern.compile("^\\/(?<command>.+)");
    private static final String COMMAND = "command";

    private static final String TO_USER = "toUser";

    private static final String MSG_TEXT = "msgText";

    public static Message parse(String fromUser, String inputText){

        Matcher directMatcher = DIRECT_MESSAGE_PATTERN.matcher(inputText);
        Matcher messageMatcher = RAW_MESSAGE_PATTERN.matcher(inputText);
        Matcher commandMatcher = RAW_COMMAND_PATTERN.matcher(inputText);

        if(directMatcher.matches()){
            return new Message(directMatcher.group(MSG_TEXT),
                    fromUser,
                    directMatcher.group(TO_USER),
                    directMatcher.group(COMMAND));
        } else if (messageMatcher.matches()) {
            return new Message(messageMatcher.group(MSG_TEXT),
                    fromUser,
                    "",
                    Commands.BROADCAST_MESSAGE.getCommand());
        }else if(commandMatcher.matches()){
            return new Message("",
                    fromUser,
                    "",
                    commandMatcher.group(COMMAND));
        }else {
            throw new RuntimeException();
        }
    }
}
