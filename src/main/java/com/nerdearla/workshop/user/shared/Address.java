package com.nerdearla.workshop.user.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Address {
    private final String id;
    private final String city;
    private final String country;
    private final String line1;
    private final String line2;
    private final String postalCode;
    private final String state;

    @JsonCreator
    public Address(
            @JsonProperty("id") String id,
            @JsonProperty("city") String city,
            @JsonProperty("country") String country,
            @JsonProperty("line1") String line1,
            @JsonProperty("line2") String line2,
            @JsonProperty("postalCode") String postalCode,
            @JsonProperty("state") String state) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.line1 = line1;
        this.line2 = line2;
        this.postalCode = postalCode;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(city, address.city) && Objects.equals(country, address.country) && Objects.equals(line1, address.line1) && Objects.equals(line2, address.line2) && Objects.equals(postalCode, address.postalCode) && Objects.equals(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, country, line1, line2, postalCode, state);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
