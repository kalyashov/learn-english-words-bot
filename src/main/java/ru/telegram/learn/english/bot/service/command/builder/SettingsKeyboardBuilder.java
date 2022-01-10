package ru.telegram.learn.english.bot.service.command.builder;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.telegram.learn.english.bot.business.bot.CallbackType;
import ru.telegram.learn.english.bot.entity.AccessType;
import ru.telegram.learn.english.bot.entity.AudioType;
import ru.telegram.learn.english.bot.entity.UserSettings;

import java.util.Collections;

public class SettingsKeyboardBuilder {

    public static InlineKeyboardMarkup buildInlineKeyboard(UserSettings userSettings) {

        InlineKeyboardMarkup.InlineKeyboardMarkupBuilder builder = InlineKeyboardMarkup.builder();

        builder.keyboardRow(Collections.singletonList(
                buildBtn("Произношение UK", CallbackType.SET_UK_AUDIO.toString(),
                        userSettings.getAudioType() == AudioType.UK)
        ));

        builder.keyboardRow(Collections.singletonList(
                buildBtn("Произношение US", CallbackType.SET_US_AUDIO.toString(),
                        userSettings.getAudioType() == AudioType.US)
        ));

        builder.keyboardRow(Collections.singletonList(
                buildBtn("Полный доступ", CallbackType.GET_FULL_ACCESS.toString(),
                        userSettings.getAccessType() == AccessType.FULL)
        ));

        return builder.build();
    }

    private static InlineKeyboardButton buildBtn(String text, String callback, boolean isActive) {
        InlineKeyboardButton btn = new InlineKeyboardButton();

        if (isActive) {
            text = "✅ " + text;
        }

        btn.setText(text);
        btn.setCallbackData(callback);
        return btn;
    }
}
