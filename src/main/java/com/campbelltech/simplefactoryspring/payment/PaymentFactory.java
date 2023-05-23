package com.campbelltech.simplefactoryspring.payment;

import com.campbelltech.simplefactoryspring.payment.enums.PaymentMethod;

public interface PaymentFactory {
    PaymentService create(PaymentMethod paymentMethod) throws ClassNotFoundException;
}
