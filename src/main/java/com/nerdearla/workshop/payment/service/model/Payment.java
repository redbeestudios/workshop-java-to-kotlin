package com.nerdearla.workshop.payment.service.model;


import com.nerdearla.workshop.authorization.PaymentAuthorization;
import com.nerdearla.workshop.operation.PaymentOperation;

import java.util.Objects;

public class Payment {

    private final String paymentId;
    private final String authorizationId;
    private final String traceNumber;
    private final String qrId;
    private final String paymentMethodId;
    private final Double amount;
    private final String buyerId;
    private final String sellerId;

    public Payment(PaymentBuilder builder) {
        this.paymentId = builder.paymentId;
        this.authorizationId = builder.authorizationId;
        this.traceNumber = builder.traceNumber;
        this.qrId = builder.qrId;
        this.paymentMethodId = builder.paymentMethodId;
        this.amount = builder.amount;
        this.buyerId = builder.buyerId;
        this.sellerId = builder.sellerId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getAuthorizationId() {
        return authorizationId;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public String getQrId() {
        return qrId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public Double getAmount() {
        return amount;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public static class PaymentBuilder {

        private final String paymentId;
        private final String authorizationId;
        private final String traceNumber;
        private final String qrId;
        private final String paymentMethodId;
        private final String sellerId;
        private final String buyerId;
        private final Double amount;

        public PaymentBuilder(PaymentOperation operation, PaymentAuthorization authorization) {
            this.paymentId = operation.getPaymentId();
            this.authorizationId = authorization.getId();
            this.traceNumber = operation.getPaymentRequest().getTerminalData().getTraceNumber();
            this.qrId = operation.getQr().getId();
            this.paymentMethodId = operation.getPaymentMethod().getId();
            this.buyerId = operation.getBuyer().getId();
            this.sellerId = operation.getSeller().getId();
            this.amount = operation.getPaymentRequest().getAmount();
        }

        public Payment build() {
            return new Payment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentId, payment.paymentId) && Objects.equals(authorizationId, payment.authorizationId) && Objects.equals(traceNumber, payment.traceNumber) && Objects.equals(qrId, payment.qrId) && Objects.equals(paymentMethodId, payment.paymentMethodId) && Objects.equals(amount, payment.amount) && Objects.equals(buyerId, payment.buyerId) && Objects.equals(sellerId, payment.sellerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, authorizationId, traceNumber, qrId, paymentMethodId, amount, buyerId, sellerId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", authorizationId='" + authorizationId + '\'' +
                ", traceNumber='" + traceNumber + '\'' +
                ", qrId='" + qrId + '\'' +
                ", paymentMethodId='" + paymentMethodId + '\'' +
                ", amount=" + amount +
                ", buyerId='" + buyerId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                '}';
    }
}
