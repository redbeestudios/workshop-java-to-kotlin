package com.nerdearla.workshop.payment;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nerdearla.workshop.payment.service.model.PaymentMethodData;
import com.nerdearla.workshop.payment.service.model.TerminalData;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PaymentRequest {

    @NotBlank
    private final String qrId;
    @NotBlank
    private final String buyerId;
    @NotBlank
    private final String sellerId;
    @Min(0)
    private final Double amount;
    @Min(1)
    private final Integer installments;
    @NotNull
    private final TerminalData terminalData;
    @NotNull
    private final PaymentMethodData paymentMethodData;

    @JsonCreator
    public PaymentRequest(
            @JsonProperty("qr_id") String qrId,
            @JsonProperty("buyer_id") String buyerId,
            @JsonProperty("seller_id") String sellerId,
            @JsonProperty("amount") Double amount,
            @JsonProperty("installments") Integer installments,
            @JsonProperty("terminal_data") TerminalData terminalData,
            @JsonProperty("payment_method_data") PaymentMethodData paymentMethodData) {
        this.qrId = qrId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.amount = amount;
        this.installments = installments;
        this.terminalData = terminalData;
        this.paymentMethodData = paymentMethodData;
    }

    public String getQrId() {
        return qrId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getInstallments() {
        return installments;
    }

    public TerminalData getTerminalData() {
        return terminalData;
    }

    public PaymentMethodData getPaymentMethodData() {
        return paymentMethodData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentRequest that = (PaymentRequest) o;
        return Objects.equals(qrId, that.qrId) && Objects.equals(buyerId, that.buyerId) && Objects.equals(sellerId, that.sellerId) && Objects.equals(amount, that.amount) && Objects.equals(installments, that.installments) && Objects.equals(terminalData, that.terminalData) && Objects.equals(paymentMethodData, that.paymentMethodData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qrId, buyerId, sellerId, amount, installments, terminalData, paymentMethodData);
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "qrId='" + qrId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", amount=" + amount +
                ", installments=" + installments +
                ", terminalData=" + terminalData +
                ", paymentMethodData=" + paymentMethodData +
                '}';
    }
}
