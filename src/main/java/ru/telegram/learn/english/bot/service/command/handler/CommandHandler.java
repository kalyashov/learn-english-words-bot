package ru.telegram.learn.english.bot.service.command.handler;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.CommandActions;

public interface CommandHandler<T extends PartialBotApiMethod<?>> {
    CommandActions handle(Update update);
}
