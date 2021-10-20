package com.nerdearla.workshop.user.buyer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nerdearla.workshop.user.shared.Address;

import java.util.Objects;

public class Buyer {
    private final String id;
    private final String identification;
    private final Boolean enabled;
    private final String name;
    private final String lastName;
    private final String email;
    private final String dateOfBirth;
    private final Address address;

    @JsonCreator
    public Buyer(
            @JsonProperty("id") String id,
            @JsonProperty("identification") String identification,
            @JsonProperty("enabled") Boolean enabled,
            @JsonProperty("name") String name,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("email") String email,
            @JsonProperty("dateOfBirth") String dateOfBirth,
            @JsonProperty("address") Address address) {
        this.id = id;
        this.identification = identification;
        this.enabled = enabled;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getIdentification() {
        return identification;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(id, buyer.id) && Objects.equals(identification, buyer.identification) && Objects.equals(enabled, buyer.enabled) && Objects.equals(name, buyer.name) && Objects.equals(lastName, buyer.lastName) && Objects.equals(email, buyer.email) && Objects.equals(dateOfBirth, buyer.dateOfBirth) && Objects.equals(address, buyer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identification, enabled, name, lastName, email, dateOfBirth, address);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id='" + id + '\'' +
                ", identification='" + identification + '\'' +
                ", enabled=" + enabled +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address=" + address +
                '}';
    }
}
