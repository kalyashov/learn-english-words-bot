package ru.telegram.learn.english.bot.business.action;

import lombok.Data;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;

/**
 * Отправка опроса
 */
@Data
public class SendPollAction implements BotAction<SendPoll> {

    private final SendPoll sendPoll;

    @Override
    public BotActionType getActionType() {
        return BotActionType.SEND_POLL;
    }

    @Override
    public SendPoll getAction() {
        return sendPoll;
    }
}
