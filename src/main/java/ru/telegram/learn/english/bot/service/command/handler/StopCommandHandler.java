package ru.telegram.learn.english.bot.service.command.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.business.action.SendMessageAction;
import ru.telegram.learn.english.bot.config.BotConfig;
import ru.telegram.learn.english.bot.service.user.UserService;

import java.util.Collections;

@Component
public class StopCommandHandler implements CommandHandler<SendMessage> {

    private final BotConfig botConfig;
    private final UserService userService;

    public StopCommandHandler(UserService userService, BotConfig botConfig) {
        this.userService = userService;
        this.botConfig = botConfig;
    }

    @Override
    public CommandActions handle(Update update) {
        Message message = update.getMessage();
        String chatId = message.getChatId().toString();

        userService.stopLearnByUser(message.getFrom());

        SendMessage sm = new SendMessage(chatId, botConfig.getMessages().getStopLearning());
        SendMessageAction sma = new SendMessageAction(sm);

        return new CommandActions(Collections.singletonList(sma));
    }
}