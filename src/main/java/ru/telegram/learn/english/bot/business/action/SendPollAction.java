package ru.telegram.learn.english.bot.business.action;

import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;

/**
 * Отправка опроса
 */
public class SendPollAction implements BotAction<SendPoll> {

    private final SendPoll sendPoll;

    public SendPollAction(SendPoll ss) {
        this.sendPoll = ss;
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.SEND_POLL;
    }

    @Override
    public SendPoll getAction() {
        return sendPoll;
    }

    @Override
    public String toString() {
        return "SendPollAction{" +
                "sendPoll=" + sendPoll +
                '}';
    }
}
