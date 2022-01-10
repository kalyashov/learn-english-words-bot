package ru.telegram.learn.english.bot.service.command.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendInvoice;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.payments.LabeledPrice;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.business.action.SendInvoiceAction;

import java.util.Collections;

@Component
public class FullAccessCommandHandler implements CommandHandler<SendMessage> {

    @Override
    public CommandActions handle(Update update) {
        SendInvoiceAction sendInvoiceAction = buildInvoiceAction(update.getMessage().getChatId().toString());
        return new CommandActions(Collections.singletonList(sendInvoiceAction));
    }

    public SendInvoiceAction buildInvoiceAction(String chatId) {
        SendInvoice sendInvoice = new SendInvoice();
        sendInvoice.setChatId(chatId);
        sendInvoice.setTitle("Полный доступ к функционалу Несси");
        sendInvoice.setDescription("Полный доступ");
        sendInvoice.setPayload("payload");
        sendInvoice.setProviderToken("401643678:TEST:f2619bea-6991-4240-847d-63721146fbf7");
        sendInvoice.setStartParameter("param");
        sendInvoice.setCurrency("RUB");
        LabeledPrice labeledPrice = new LabeledPrice();
        labeledPrice.setLabel("RUB");
        labeledPrice.setAmount(10000);
        sendInvoice.setPrices(Collections.singletonList(labeledPrice));

        return new SendInvoiceAction(sendInvoice);
    }
}
