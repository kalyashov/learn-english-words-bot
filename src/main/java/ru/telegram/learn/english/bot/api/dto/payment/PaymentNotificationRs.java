package ru.telegram.learn.english.bot.api.dto.payment;

import lombok.Data;

/**
 * Уведомление об изменении статуса платежа (ответ)
 */
@Data
public class PaymentNotificationRs {
    private final String result = "success";
}
