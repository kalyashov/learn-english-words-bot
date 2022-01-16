package ru.telegram.learn.english.bot.business.action;

import lombok.Data;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.objects.InputFile;

/**
 * Отправка аудио
 */
@Data
public class SendAudioAction implements BotAction<SendAudio> {

    private final SendAudio sendAudio;

    public SendAudioAction(String chatId, InputFile audio) {
        sendAudio = new SendAudio(chatId, audio);
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.SEND_AUDIO;
    }

    @Override
    public SendAudio getAction() {
        return sendAudio;
    }
}
