package ru.telegram.learn.english.bot.business.action;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;

public class EditMessageReplyMarkupAction implements BotAction<EditMessageReplyMarkup> {

    private final EditMessageReplyMarkup editMessageReplyMarkup;

    public EditMessageReplyMarkupAction(EditMessageReplyMarkup editMessageReplyMarkup) {
        this.editMessageReplyMarkup = editMessageReplyMarkup;
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.EDIT_MESSAGE_REPLY_MARKUP;
    }

    @Override
    public EditMessageReplyMarkup getAction() {
        return editMessageReplyMarkup;
    }

    @Override
    public String toString() {
        return "EditMessageReplyMarkupAction{" +
                "editMessageReplyMarkup=" + editMessageReplyMarkup +
                '}';
    }
}
