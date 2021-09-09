package ru.telegram.learn.english.bot.service.command.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.business.action.SendMessageAction;
import ru.telegram.learn.english.bot.config.BotConfig;

import java.util.Arrays;
import java.util.Collections;

@Component
public class InfoCommandHandler implements CommandHandler<SendMessage> {

    private final BotConfig botConfig;

    public InfoCommandHandler(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public CommandActions handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        SendMessage infoMsg = new SendMessage(chatId, botConfig.getMessages().getInfo());
        SendMessage commandsMsg = new SendMessage(chatId, botConfig.getMessages().getCommands());
        SendMessageAction infoMsgAction = new SendMessageAction(infoMsg);
        SendMessageAction commandMsgAction = new SendMessageAction(commandsMsg);

        return new CommandActions(Arrays.asList(infoMsgAction, commandMsgAction));
    }
}
