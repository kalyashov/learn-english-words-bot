package ru.telegram.learn.english.bot.api.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сумма платежа
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmountDto {
    private String value;
    private String currency;
}
