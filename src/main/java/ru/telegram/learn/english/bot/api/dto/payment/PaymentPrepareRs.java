package ru.telegram.learn.english.bot.api.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPrepareRs {
    private String id;
    private String status;
    private AmountDto amount;
    private String description;
    private PaymentConfirmationRs confirmation;
}
