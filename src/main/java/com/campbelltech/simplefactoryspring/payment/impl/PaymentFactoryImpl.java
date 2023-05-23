package com.campbelltech.simplefactoryspring.payment.impl;

import com.campbelltech.simplefactoryspring.payment.PaymentService;
import com.campbelltech.simplefactoryspring.payment.PaymentFactory;
import com.campbelltech.simplefactoryspring.payment.enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

@Component
public class PaymentFactoryImpl implements PaymentFactory {

    @Autowired
    private final List<PaymentService> concretePaymentServices;

    public PaymentFactoryImpl(List<PaymentService> concretePaymentServices) {
        this.concretePaymentServices = concretePaymentServices;
    }

    public PaymentService create(PaymentMethod paymentMethod) throws ClassNotFoundException {
        switch (paymentMethod) {
            case CREDIT_CARD -> {
                return getPayment(CreditCardPaymentService.class);
            }
            case PAYPAL -> {
                return getPayment(PayPalPaymentService.class);
            }
            case GOOGLE_PAY -> {
                return getPayment(GooglePayPaymentService.class);
            }
            default -> throw new ClassNotFoundException(MessageFormat.format(
                    "{0} is not currently supported as a payment method.", paymentMethod
            ));
        }
    }

    private PaymentService getPayment(Class type) {
        return (PaymentService) concretePaymentServices.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .findFirst()
                .orElse(null);
    }
}
