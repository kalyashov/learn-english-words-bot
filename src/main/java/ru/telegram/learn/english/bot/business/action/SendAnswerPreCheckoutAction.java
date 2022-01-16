package ru.telegram.learn.english.bot.business.action;

import lombok.Data;
import org.telegram.telegrambots.meta.api.methods.AnswerPreCheckoutQuery;

@Data
public class SendAnswerPreCheckoutAction implements BotAction<AnswerPreCheckoutQuery> {

    private final AnswerPreCheckoutQuery answerPreCheckoutQuery;

    public SendAnswerPreCheckoutAction(String preCheckoutQueryId, boolean ok) {
        answerPreCheckoutQuery = AnswerPreCheckoutQuery.builder()
                .preCheckoutQueryId(preCheckoutQueryId)
                .ok(ok)
                .build();
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.SEND_ANSWER_PRE_CHECKOUT;
    }

    @Override
    public AnswerPreCheckoutQuery getAction() {
        return answerPreCheckoutQuery;
    }
}
