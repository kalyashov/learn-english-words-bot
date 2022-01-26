package ru.telegram.learn.english.bot.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.service.callback.CallbackService;
import ru.telegram.learn.english.bot.service.command.CommandService;
import ru.telegram.learn.english.bot.service.payment.TelegramPaymentService;


/**
 * Контроллер для обработки update'ов от бота
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class BotUpdateController {

    private final CommandService commandService;
    private final CallbackService callbackService;
    private final TelegramPaymentService paymentService;

    public CommandActions onUpdate(Update update) {
        log.info(update.toString());

        if (isMessage(update)) {
            return commandService.handleCommand(update);
        } else if (isCallback(update)) {
            return callbackService.handleCallback(update);
        } else if (isPayment(update)) {
            return paymentService.handlePayment(update);
        }

        return CommandActions.empty();
    }

    private boolean isMessage(Update update) {
        return update.hasMessage() && update.getMessage().hasText() && !update.getMessage().hasSuccessfulPayment();
    }

    private boolean isCallback(Update update) {
        return update.hasCallbackQuery() && update.getCallbackQuery().getData() != null;
    }

    private boolean isPayment(Update update) {
        return update.hasPreCheckoutQuery() || (update.hasMessage() && update.getMessage().hasSuccessfulPayment());
    }
}
