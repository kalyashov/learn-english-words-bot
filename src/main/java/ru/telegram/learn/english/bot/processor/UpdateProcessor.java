package ru.telegram.learn.english.bot.processor;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.service.callback.CallbackService;
import ru.telegram.learn.english.bot.service.command.CommandService;

@Service
public class UpdateProcessor {

    private final CommandService commandService;
    private final CallbackService callbackService;

    public UpdateProcessor(CommandService commandService, CallbackService callbackService) {
        this.commandService = commandService;
        this.callbackService = callbackService;
    }

    public CommandActions process(Update update) {
        if (update.getCallbackQuery() != null) {
            return callbackService.handleCallback(update);
        }

        return commandService.handleCommand(update);
    }
}
