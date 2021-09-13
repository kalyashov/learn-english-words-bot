package ru.telegram.learn.english.bot.service.callback;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.business.action.EditMessageReplyMarkupAction;
import ru.telegram.learn.english.bot.business.bot.CallbackType;
import ru.telegram.learn.english.bot.entity.AudioType;
import ru.telegram.learn.english.bot.entity.UserEntity;
import ru.telegram.learn.english.bot.entity.UserSettings;
import ru.telegram.learn.english.bot.service.command.builder.SendWordsMessageActionBuilder;
import ru.telegram.learn.english.bot.service.user.UserService;

import java.util.Arrays;
import java.util.List;

import static ru.telegram.learn.english.bot.service.command.builder.SettingsKeyboardBuilder.buildInlineKeyboard;

@Component
public class CallbackService {

    private final UserService userService;
    private final SendWordsMessageActionBuilder messageActionBuilder;

    public CallbackService(UserService userService, SendWordsMessageActionBuilder messageActionBuilder) {
        this.userService = userService;
        this.messageActionBuilder = messageActionBuilder;
    }

    public CommandActions handleCallback(Update update) {
        CallbackQuery callbackQuery = update.getCallbackQuery();
        Long chatId = callbackQuery.getMessage().getChatId();
        Integer messageId = callbackQuery.getMessage().getMessageId();
        Long userId = callbackQuery.getFrom().getId();
        String callbackRaw = callbackQuery.getData();

        UserEntity user = userService.getById(userId);
        UserSettings userSettings = user.getUserSettings();

        CommandActions commandActions = new CommandActions();

        CallbackType callbackType = CallbackType.fromValue(callbackRaw);

        switch (callbackType) {
            case SET_UK_AUDIO:
                userSettings.setAudioType(AudioType.UK);
                handleSettingsAction(commandActions, messageId, chatId, user, userSettings);
                break;
            case SET_US_AUDIO:
                userSettings.setAudioType(AudioType.US);
                handleSettingsAction(commandActions, messageId, chatId, user, userSettings);
                break;
            case GET_FULL_ACCESS:
                break;
            case GA:
                handleGetAudioAction(commandActions, chatId, callbackRaw);
                break;
        }

        return commandActions;
    }

    private void handleGetAudioAction(CommandActions commandActions, Long chatId, String callbackRaw) {
        List<String> wordIds = Arrays.asList(callbackRaw.replace(CallbackType.GA.toString(), "").split(","));
        commandActions.addAll(messageActionBuilder.buildAudioMessage(chatId.toString(), wordIds).getActions());
    }

    private void handleSettingsAction(CommandActions commandActions, Integer messageId, Long chatId, UserEntity user, UserSettings userSettings) {
        user.setUserSettings(userSettings);
        userService.saveUser(user);

        InlineKeyboardMarkup keyboard = buildInlineKeyboard(userSettings);

        EditMessageReplyMarkup editMessageReplyMarkup = new EditMessageReplyMarkup();
        editMessageReplyMarkup.setChatId(chatId.toString());
        editMessageReplyMarkup.setMessageId(messageId);
        editMessageReplyMarkup.setReplyMarkup(keyboard);

        EditMessageReplyMarkupAction editMessageReplyMarkupAction = new EditMessageReplyMarkupAction(editMessageReplyMarkup);
        commandActions.add(editMessageReplyMarkupAction);
    }
}
