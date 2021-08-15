package ru.telegram.learn.english.bot.business.action;

import org.telegram.telegrambots.meta.api.methods.send.SendInvoice;

/**
 * Отправка счета для оплаты
 */
public class SendInvoiceAction implements BotAction<SendInvoice> {

    private final SendInvoice si;

    public SendInvoiceAction(SendInvoice si) {
        this.si = si;
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.SEND_INVOICE;
    }

    @Override
    public SendInvoice getAction() {
        return si;
    }

    @Override
    public String toString() {
        return "SendInvoiceAction{" +
                "si=" + si +
                '}';
    }
}
