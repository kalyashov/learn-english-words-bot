package ru.telegram.learn.english.bot.util;

import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateUtil {

    public static Boolean checkUpdate(Update update) {
        if (update != null && ((update.hasMessage() && update.getMessage().getChatId() != null)
                || update.getCallbackQuery() != null)) {
            return true;
        } else
            return update != null && update.hasChatMember() && update.getChatMember().getChat().getId() != null;
    }

    public static String extractChatId(Update update) {
        if (checkUpdate(update)) {
            if (update.hasMessage() && update.getMessage().getChatId() != null) {
                return update.getMessage().getChatId().toString();
            } else
                return update.getChatMember().getChat().getId().toString();
        }

        return null;
    }
}
