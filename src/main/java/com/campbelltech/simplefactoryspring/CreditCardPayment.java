package com.campbelltech.simplefactoryspring;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.MessageFormat;

@Component
public class CreditCardPayment implements Payment {
    @Override
    public String pay(BigDecimal amount) {
        return MessageFormat.format("Successfully paid ${0} to merchant using a Credit Card", amount);
    }
}
