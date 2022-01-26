package ru.telegram.learn.english.bot.api.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.telegram.learn.english.bot.entity.payment.PaymentType;

/**
 * Метаданные о платеже
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMetadataDto {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("payment_type")
    private PaymentType paymentType;
}
