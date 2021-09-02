package ru.telegram.learn.english.bot.service.command;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.business.bot.Command;


@Service
public class CommandService {

    public final CommandRegister commandRegister;

    public CommandService(CommandRegister commandRegister) {
       this.commandRegister = commandRegister;
    }

    public CommandActions handleCommand(Update update) {
        Command command = Command.UNKNOWN;

        if (update != null && update.hasMessage() && update.getMessage().hasText()) {
            command = Command.fromValue(update.getMessage().getText());
        }

        return commandRegister.getHandlerByCommand(command).handle(update);
    }
}
