package com.nerdearla.workshop.operation;

import com.nerdearla.workshop.payment.PaymentRequest;
import com.nerdearla.workshop.paymentMethod.BuyerPaymentMethod;
import com.nerdearla.workshop.qr.QR;
import com.nerdearla.workshop.user.buyer.Buyer;
import com.nerdearla.workshop.user.seller.Seller;

import java.util.Objects;

public class PaymentOperation {

    private final PaymentRequest paymentRequest;
    private String paymentId;
    private QR qr;
    private Buyer buyer;
    private Seller seller;
    private BuyerPaymentMethod buyerPaymentMethod;

    public PaymentOperation(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public BuyerPaymentMethod getPaymentMethod() {
        return buyerPaymentMethod;
    }

    public void setPaymentMethod(BuyerPaymentMethod buyerPaymentMethod) {
        this.buyerPaymentMethod = buyerPaymentMethod;
    }

    public QR getQr() {
        return qr;
    }

    public void setQr(QR qr) {
        this.qr = qr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentOperation that = (PaymentOperation) o;
        return Objects.equals(paymentRequest, that.paymentRequest) && Objects.equals(paymentId, that.paymentId) && Objects.equals(qr, that.qr) && Objects.equals(buyer, that.buyer) && Objects.equals(seller, that.seller) && Objects.equals(buyerPaymentMethod, that.buyerPaymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentRequest, paymentId, qr, buyer, seller, buyerPaymentMethod);
    }

    @Override
    public String toString() {
        return "PaymentOperation{" +
                "paymentRequest=" + paymentRequest +
                ", paymentId='" + paymentId + '\'' +
                ", qr=" + qr +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", buyerPaymentMethod=" + buyerPaymentMethod +
                '}';
    }
}
