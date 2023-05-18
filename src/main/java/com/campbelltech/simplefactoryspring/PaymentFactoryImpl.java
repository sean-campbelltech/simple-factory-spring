package com.campbelltech.simplefactoryspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

@Component
public class PaymentFactoryImpl implements PaymentFactory {

    @Autowired
    private final List<Payment> concretePayments;

    public PaymentFactoryImpl(List<Payment> concretePayments) {
        this.concretePayments = concretePayments;
    }

    public Payment create(PaymentMethod paymentMethod) throws ClassNotFoundException {
        switch (paymentMethod) {
            case CREDIT_CARD -> {
                return getPayment(CreditCardPayment.class);
            }
            case PAYPAL -> {
                return getPayment(PayPalPayment.class);
            }
            case GOOGLE_PAY -> {
                return getPayment(GooglePayPayment.class);
            }
            default -> throw new ClassNotFoundException(MessageFormat.format(
                    "{0} is not currently supported as a payment method.", paymentMethod
            ));
        }
    }

    private Payment getPayment(Class type) {
        return (Payment) concretePayments.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .findFirst()
                .orElse(null);
    }
}
