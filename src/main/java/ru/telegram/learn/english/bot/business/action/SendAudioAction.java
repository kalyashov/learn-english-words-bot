package ru.telegram.learn.english.bot.business.action;

import org.telegram.telegrambots.meta.api.methods.send.SendAudio;

/**
 * Отправка аудио
 */
public class SendAudioAction implements BotAction<SendAudio> {

    private final SendAudio sa;

    public SendAudioAction(SendAudio sa) {
        this.sa = sa;
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.SEND_AUDIO;
    }

    @Override
    public SendAudio getAction() {
        return sa;
    }

    @Override
    public String toString() {
        return "SendAudioAction{" +
                "sa=" + sa +
                '}';
    }
}
