package com.campbelltech.simplefactoryspring;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.MessageFormat;

@Component
public class GooglePayPayment implements Payment {
    @Override
    public String pay(BigDecimal amount) {
        return MessageFormat.format("Successfully paid ${0} to merchant using Google Pay", amount);
    }
}
