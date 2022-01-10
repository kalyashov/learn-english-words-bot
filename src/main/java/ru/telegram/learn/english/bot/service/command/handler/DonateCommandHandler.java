package ru.telegram.learn.english.bot.service.command.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.business.action.SendMessageAction;
import ru.telegram.learn.english.bot.config.BotConfig;

import java.util.Collections;

@Component
public class DonateCommandHandler implements CommandHandler<SendMessage> {

    private final BotConfig botConfig;

    public DonateCommandHandler(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public CommandActions handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        SendMessage sm = new SendMessage(chatId, botConfig.getMessages().getDonate());
        SendMessageAction sma = new SendMessageAction(sm);

        return new CommandActions(Collections.singletonList(sma));
    }
}