package ru.telegram.learn.english.bot.api.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Данные для подтверждения платежа
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentConfirmationRs {
    private String type;
    @JsonProperty("confirmation_url")
    private String confirmationUrl;
}
