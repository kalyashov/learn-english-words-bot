package ru.telegram.learn.english.bot.api.dto.payment;

import lombok.Data;
import ru.telegram.learn.english.bot.entity.payment.PaymentType;

/**
 * Подготовка платежа (запрос)
 */
@Data
public class PaymentPrepareRq {
    private final AmountDto amount;
    private final boolean capture;
    private final PaymentConfirmationRq confirmation;
    private final String description;
    private final PaymentMetadataDto metadata;
    private final String CONFIRMATION_TYPE = "redirect";

    public PaymentPrepareRq(String amount, String currency, String returnUrl,
                            String description, String userId, PaymentType paymentType) {
        this.amount = new AmountDto(amount, currency);
        this.capture = true;
        this.confirmation = new PaymentConfirmationRq(CONFIRMATION_TYPE, returnUrl);
        this.description = description;
        this.metadata = new PaymentMetadataDto(userId, paymentType);
    }
}