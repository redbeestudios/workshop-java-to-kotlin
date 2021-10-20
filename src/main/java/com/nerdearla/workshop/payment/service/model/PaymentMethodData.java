package com.nerdearla.workshop.payment.service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PaymentMethodData {

    private final String token;
    private final String securityCode;

    @JsonCreator
    public PaymentMethodData(
            @JsonProperty("token") String token,
            @JsonProperty("security_code") String securityCode) {
        this.token = token;
        this.securityCode = securityCode;
    }

    public String getToken() {
        return token;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethodData that = (PaymentMethodData) o;
        return Objects.equals(token, that.token) && Objects.equals(securityCode, that.securityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, securityCode);
    }

    @Override
    public String toString() {
        return "PaymentMethodData{" +
                "token='" + token + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }
}
