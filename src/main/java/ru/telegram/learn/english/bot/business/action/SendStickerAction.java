package ru.telegram.learn.english.bot.business.action;

import org.telegram.telegrambots.meta.api.methods.send.SendSticker;

/**
 * Отправка стикера
 */
public class SendStickerAction implements BotAction<SendSticker> {

    private final SendSticker ss;

    public SendStickerAction(SendSticker ss) {
        this.ss = ss;
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.SEND_MESSAGE;
    }

    @Override
    public SendSticker getAction() {
        return ss;
    }

    @Override
    public String toString() {
        return "SendStickerAction{" +
                "ss=" + ss +
                '}';
    }
}
