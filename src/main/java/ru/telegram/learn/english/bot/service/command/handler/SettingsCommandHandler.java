package ru.telegram.learn.english.bot.service.command.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.business.action.SendMessageAction;
import ru.telegram.learn.english.bot.entity.*;
import ru.telegram.learn.english.bot.service.user.UserService;


import static ru.telegram.learn.english.bot.service.command.builder.SettingsKeyboardBuilder.buildInlineKeyboard;

@Component
public class SettingsCommandHandler implements CommandHandler<SendMessage> {

    private final UserService userService;

    public SettingsCommandHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandActions handle(Update update) {
        Message message = update.getMessage();
        String chatId = message.getChatId().toString();
        Long userId = message.getFrom().getId();

        UserEntity user = userService.getById(userId);

        CommandActions actions = new CommandActions();
        SendMessage sm = new SendMessage();
        sm.setChatId(chatId);
        sm.setText("Настройки");
        sm.setReplyMarkup(buildInlineKeyboard(user.getUserSettings()));

        actions.add(new SendMessageAction(sm));

        return actions;
    }

}
