package com.nerdearla.workshop.authorization.client;

import java.util.Objects;

public class PaymentAuthorizationRequest {

    private String paymentMethodToken;
    private String paymentMethodSecurityCode;
    private String holderIdentification;
    private String establishmentId;
    private String terminalNumber;
    private String traceNumber;
    private String ticketNumber;
    private String transactionDatetime;

    public String getPaymentMethodToken() {
        return paymentMethodToken;
    }

    public void setPaymentMethodToken(String paymentMethodToken) {
        this.paymentMethodToken = paymentMethodToken;
    }

    public String getPaymentMethodSecurityCode() {
        return paymentMethodSecurityCode;
    }

    public void setPaymentMethodSecurityCode(String paymentMethodSecurityCode) {
        this.paymentMethodSecurityCode = paymentMethodSecurityCode;
    }

    public String getHolderIdentification() {
        return holderIdentification;
    }

    public void setHolderIdentification(String holderIdentification) {
        this.holderIdentification = holderIdentification;
    }

    public String getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(String establishmentId) {
        this.establishmentId = establishmentId;
    }

    public String getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(String terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTransactionDatetime() {
        return transactionDatetime;
    }

    public void setTransactionDatetime(String transactionDatetime) {
        this.transactionDatetime = transactionDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentAuthorizationRequest that = (PaymentAuthorizationRequest) o;
        return Objects.equals(paymentMethodToken, that.paymentMethodToken) && Objects.equals(paymentMethodSecurityCode, that.paymentMethodSecurityCode) && Objects.equals(holderIdentification, that.holderIdentification) && Objects.equals(establishmentId, that.establishmentId) && Objects.equals(terminalNumber, that.terminalNumber) && Objects.equals(traceNumber, that.traceNumber) && Objects.equals(ticketNumber, that.ticketNumber) && Objects.equals(transactionDatetime, that.transactionDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentMethodToken, paymentMethodSecurityCode, holderIdentification, establishmentId, terminalNumber, traceNumber, ticketNumber, transactionDatetime);
    }

    @Override
    public String toString() {
        return "PaymentAuthorizationRequest{" +
                "paymentMethodToken='" + paymentMethodToken + '\'' +
                ", paymentMethodSecurityCode='" + paymentMethodSecurityCode + '\'' +
                ", holderIdentification='" + holderIdentification + '\'' +
                ", establishmentId='" + establishmentId + '\'' +
                ", terminalNumber='" + terminalNumber + '\'' +
                ", traceNumber='" + traceNumber + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", transactionDatetime='" + transactionDatetime + '\'' +
                '}';
    }
}
