package ru.telegram.learn.english.bot.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import ru.telegram.learn.english.bot.api.dto.PaymentNotificationRq;
import ru.telegram.learn.english.bot.api.dto.PaymentNotificationRs;
import ru.telegram.learn.english.bot.processor.PaymentProcessor;

@RestController
@RequestMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentProcessor paymentProcessor;

    @PostMapping(value = "/notify")
    public ResponseEntity<PaymentNotificationRs> paymentNotification(@RequestBody PaymentNotificationRq paymentNotification) {
        log.info(paymentNotification.toString());
        paymentProcessor.handlePaymentNotification(paymentNotification);
        return ResponseEntity.ok(new PaymentNotificationRs());
    }
}
