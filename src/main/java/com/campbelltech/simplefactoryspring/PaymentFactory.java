package com.campbelltech.simplefactoryspring;

public interface PaymentFactory {
    Payment create(PaymentMethod paymentMethod) throws ClassNotFoundException;
}
