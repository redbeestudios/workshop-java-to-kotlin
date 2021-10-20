package com.nerdearla.workshop.paymentMethod;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BuyerPaymentMethod {

    private final String id;
    private final Boolean enabled;
    private final String type;
    private final String token;
    private final String securityCode;

    @JsonCreator
    public BuyerPaymentMethod(
            @JsonProperty("id") String id,
            @JsonProperty("enabled") Boolean enabled,
            @JsonProperty("type") String type,
            @JsonProperty("token") String token,
            @JsonProperty("securityCode") String securityCode) {
        this.id = id;
        this.enabled = enabled;
        this.type = type;
        this.token = token;
        this.securityCode = securityCode;
    }

    public String getId() {
        return id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getType() {
        return type;
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
        BuyerPaymentMethod that = (BuyerPaymentMethod) o;
        return Objects.equals(id, that.id) && Objects.equals(enabled, that.enabled) && Objects.equals(type, that.type) && Objects.equals(token, that.token) && Objects.equals(securityCode, that.securityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enabled, type, token, securityCode);
    }

    @Override
    public String toString() {
        return "BuyerPaymentMethod{" +
                "id='" + id + '\'' +
                ", enabled=" + enabled +
                ", type='" + type + '\'' +
                ", token='" + token + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }
}
