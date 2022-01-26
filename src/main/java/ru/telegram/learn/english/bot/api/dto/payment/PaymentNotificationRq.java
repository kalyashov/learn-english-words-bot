package ru.telegram.learn.english.bot.api.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Уведомление об изменении статуса платежа (запрос)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentNotificationRq {
    private String event;
    @JsonProperty("object")
    private PaymentDataDto paymentData;
}
