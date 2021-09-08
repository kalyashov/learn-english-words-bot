package ru.telegram.learn.english.bot.service.command;

import org.springframework.stereotype.Component;
import ru.telegram.learn.english.bot.business.bot.Command;
import ru.telegram.learn.english.bot.service.command.handler.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandRegister {

    public final Map<Command, CommandHandler<?>> botCommands = new HashMap<>();

    public CommandRegister(
            StartCommandHandler startCommandHandler,
            StopCommandHandler stopCommandHandler,
            WordsCommandHandler wordsCommandHandler,
            SettingsCommandHandler settingsCommandHandler,
            InfoCommandHandler infoCommandHandler,
            FullAccessCommandHandler fullAccessCommandHandler,
            UnknownCommandHandler unknownCommandHandler,
            DonateCommandHandler donateCommandHandler,
            SupportCommandHandler supportCommandHandler) {
        botCommands.put(Command.START, startCommandHandler);
        botCommands.put(Command.STOP, stopCommandHandler);
        botCommands.put(Command.WORDS, wordsCommandHandler);
        botCommands.put(Command.SETTINGS, settingsCommandHandler);
        botCommands.put(Command.INFO, infoCommandHandler);
        botCommands.put(Command.FULL_ACCESS, fullAccessCommandHandler);
        botCommands.put(Command.DONATE, donateCommandHandler);
        botCommands.put(Command.SUPPORT, supportCommandHandler);

        botCommands.put(Command.UNKNOWN, unknownCommandHandler);
    }

    public CommandHandler<?> getHandlerByCommand(Command command) {
        return botCommands.get(command);
    }
}
