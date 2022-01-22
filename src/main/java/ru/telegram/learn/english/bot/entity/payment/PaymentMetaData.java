package ru.telegram.learn.english.bot.entity.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMetaData {
    private String amount;
    private String currency;
    private String payload;
}
