package com.campbelltech.simplefactoryspring.payment;

import java.math.BigDecimal;

public interface PaymentService {
    String pay(BigDecimal amount);
}
