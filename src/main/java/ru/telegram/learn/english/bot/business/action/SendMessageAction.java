package ru.telegram.learn.english.bot.business.action;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * Отправка текстового сообщения
 */
public class SendMessageAction implements BotAction<SendMessage> {

    private final SendMessage sm;

    public SendMessageAction(SendMessage sm) {
        this.sm = sm;
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.SEND_MESSAGE;
    }

    @Override
    public SendMessage getAction() {
        return sm;
    }

    @Override
    public String toString() {
        return "SendMessageAction{" +
                "sm=" + sm +
                '}';
    }
}
