package com.nerdearla.workshop.payment;

import java.util.Objects;

public class PaymentResponse {

    private final String paymentId;

    public PaymentResponse(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentResponse that = (PaymentResponse) o;
        return Objects.equals(paymentId, that.paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "paymentId='" + paymentId + '\'' +
                '}';
    }
}
