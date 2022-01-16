package ru.telegram.learn.english.bot.business.action;

import lombok.Data;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * Редактирование разметки сообщения
 */
@Data
public class EditMessageReplyMarkupAction implements BotAction<EditMessageReplyMarkup> {

    private final EditMessageReplyMarkup editMessageReplyMarkup;

    public EditMessageReplyMarkupAction(String chatId, Integer messageId, InlineKeyboardMarkup keyboard) {
        editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                .chatId(chatId)
                .messageId(messageId)
                .replyMarkup(keyboard).build();
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.EDIT_MESSAGE_REPLY_MARKUP;
    }

    @Override
    public EditMessageReplyMarkup getAction() {
        return editMessageReplyMarkup;
    }
}
