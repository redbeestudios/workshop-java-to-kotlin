package com.nerdearla.workshop.qr;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class QR {

    private final String id;
    private final Boolean enabled;

    @JsonCreator
    public QR(
            @JsonProperty("id") String id,
            @JsonProperty("enabled") Boolean enabled) {
        this.id = id;
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QR qr = (QR) o;
        return Objects.equals(id, qr.id) && Objects.equals(enabled, qr.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enabled);
    }

    @Override
    public String toString() {
        return "QR{" +
                "id='" + id + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
