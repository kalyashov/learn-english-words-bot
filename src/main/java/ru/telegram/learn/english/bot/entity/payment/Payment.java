package ru.telegram.learn.english.bot.entity.payment;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import ru.telegram.learn.english.bot.entity.BaseEntity;

import java.time.LocalDateTime;

@Table("payments")
public class Payment extends BaseEntity {
    @Column
    private @Getter @Setter String providerPaymentId;
    @Column
    private @Getter @Setter String userId;
    @Column
    private @Getter @Setter PaymentMetaData paymentMetaData;
    @Column
    private @Getter @Setter LocalDateTime createdAt;

    public Payment(String id, String providerPaymentId, String userId, PaymentMetaData paymentMetaData) {
        super(id, true);
        this.providerPaymentId = providerPaymentId;
        this.userId = userId;
        this.paymentMetaData = paymentMetaData;
        this.createdAt = LocalDateTime.now();
    }
}
