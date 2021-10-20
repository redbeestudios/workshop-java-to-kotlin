package com.nerdearla.workshop.payment.service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TerminalData {

    private final String establishmentId;
    private final String terminalNumber;
    private final String traceNumber;
    private final String ticketNumber;
    private final String transactionDatetime;

    @JsonCreator
    public TerminalData(
            @JsonProperty("establishment_id") String establishmentId,
            @JsonProperty("terminal_number") String terminalNumber,
            @JsonProperty("trace_number") String traceNumber,
            @JsonProperty("ticket_number") String ticketNumber,
            @JsonProperty("transaction_datetime") String transactionDatetime) {
        this.establishmentId = establishmentId;
        this.terminalNumber = terminalNumber;
        this.traceNumber = traceNumber;
        this.ticketNumber = ticketNumber;
        this.transactionDatetime = transactionDatetime;
    }

    public String getEstablishmentId() {
        return establishmentId;
    }

    public String getTerminalNumber() {
        return terminalNumber;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getTransactionDatetime() {
        return transactionDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerminalData that = (TerminalData) o;
        return Objects.equals(establishmentId, that.establishmentId) && Objects.equals(terminalNumber, that.terminalNumber) && Objects.equals(traceNumber, that.traceNumber) && Objects.equals(ticketNumber, that.ticketNumber) && Objects.equals(transactionDatetime, that.transactionDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(establishmentId, terminalNumber, traceNumber, ticketNumber, transactionDatetime);
    }

    @Override
    public String toString() {
        return "TerminalData{" +
                "establishmentId='" + establishmentId + '\'' +
                ", terminalNumber='" + terminalNumber + '\'' +
                ", traceNumber='" + traceNumber + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", transactionDatetime='" + transactionDatetime + '\'' +
                '}';
    }
}
