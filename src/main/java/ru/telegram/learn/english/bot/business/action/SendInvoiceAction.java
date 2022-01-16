package ru.telegram.learn.english.bot.business.action;

import lombok.Data;
import org.telegram.telegrambots.meta.api.methods.send.SendInvoice;

/**
 * Отправка счета для оплаты
 */
@Data
public class SendInvoiceAction implements BotAction<SendInvoice> {

    private final SendInvoice sendInvoice;

    @Override
    public BotActionType getActionType() {
        return BotActionType.SEND_INVOICE;
    }

    @Override
    public SendInvoice getAction() {
        return sendInvoice;
    }
}
