package ru.telegram.learn.english.bot.business.action;

import lombok.Data;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import ru.telegram.learn.english.bot.business.bot.StickerId;

/**
 * Отправка стикера
 */
@Data
public class SendStickerAction implements BotAction<SendSticker> {

    private final SendSticker sendSticker;

    public SendStickerAction(String chatId, String stickerId) {
        sendSticker = new SendSticker(chatId, new InputFile(stickerId));
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.SEND_STICKER;
    }

    @Override
    public SendSticker getAction() {
        return sendSticker;
    }
}
