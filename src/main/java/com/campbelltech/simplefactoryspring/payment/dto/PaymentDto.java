package com.campbelltech.simplefactoryspring.payment.dto;

import com.campbelltech.simplefactoryspring.payment.enums.PaymentMethod;

import java.math.BigDecimal;

public class PaymentDto {
    public BigDecimal amount;
    public PaymentMethod paymentMethod;
}
