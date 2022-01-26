package ru.telegram.learn.english.bot.api.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Данные платежа
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDataDto {
    private String id;
    private String status;
    private AmountDto amount;
    private PaymentMetadataDto metadata;
    private String description;
    @JsonProperty("created_at")
    private String createdAt;
}
