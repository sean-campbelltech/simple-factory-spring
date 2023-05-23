package com.campbelltech.simplefactoryspring.payment.impl;

import com.campbelltech.simplefactoryspring.payment.PaymentService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.MessageFormat;

@Component
public class PayPalPaymentService implements PaymentService {
    @Override
    public String pay(BigDecimal amount) {
        return MessageFormat.format("Successfully paid ${0} to merchant using PayPal", amount);
    }
}
