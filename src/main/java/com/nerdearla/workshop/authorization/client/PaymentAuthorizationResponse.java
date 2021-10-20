package com.nerdearla.workshop.authorization.client;

import java.util.Objects;

public class PaymentAuthorizationResponse {

    private String id;
    private String traceNumber;
    private String status;
    private String timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentAuthorizationResponse that = (PaymentAuthorizationResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(traceNumber, that.traceNumber) && Objects.equals(status, that.status) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, traceNumber, status, timestamp);
    }

    @Override
    public String toString() {
        return "PaymentAuthorizationResponse{" +
                "id='" + id + '\'' +
                ", traceNumber='" + traceNumber + '\'' +
                ", status='" + status + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
