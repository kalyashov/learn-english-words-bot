package ru.telegram.learn.english.bot.service.command.handler;

import org.springframework.stereotype.Component;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.*;

import ru.telegram.learn.english.bot.config.BotConfig;
import ru.telegram.learn.english.bot.entity.AccessType;
import ru.telegram.learn.english.bot.entity.UserEntity;
import ru.telegram.learn.english.bot.service.command.builder.SendWordsMessageActionBuilder;
import ru.telegram.learn.english.bot.service.user.UserService;

import java.util.Collections;


@Component
public class WordsCommandHandler implements CommandHandler<SendMessage> {

    private final UserService userService;
    private final SendWordsMessageActionBuilder actionBuilder;
    private final BotConfig botConfig;

    public WordsCommandHandler(UserService userService, SendWordsMessageActionBuilder actionBuilder, BotConfig botConfig) {
        this.userService = userService;
        this.actionBuilder = actionBuilder;
        this.botConfig = botConfig;
    }

    @Override
    public CommandActions handle(Update update) {
        Message message = update.getMessage();
        String chatId = message.getChatId().toString();
        Long userId = message.getFrom().getId();

        UserEntity user = userService.getById(userId);

        if (user.getUserSettings().getAccessType() != AccessType.FULL) {
            SendMessage sm = new SendMessage(chatId, botConfig.getMessages().getWordsFullAccess());
            SendMessageAction sma = new SendMessageAction(sm);
            return new CommandActions(Collections.singletonList(sma));
        }

        return actionBuilder.build(message.getChatId().toString(), userId);
    }
}
