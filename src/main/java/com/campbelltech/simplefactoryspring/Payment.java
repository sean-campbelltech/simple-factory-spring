package com.campbelltech.simplefactoryspring;

import java.math.BigDecimal;

public interface Payment {
    String pay(BigDecimal amount);
}
