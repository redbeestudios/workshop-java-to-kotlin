package com.nerdearla.workshop.user.seller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nerdearla.workshop.user.shared.Address;

import java.util.Objects;

public class Seller {

    private final String id;
    private final String identification;
    private final Boolean enabled;
    private final String name;
    private final String email;
    private final Address address;

    @JsonCreator
    public Seller(
            @JsonProperty("id") String id,
            @JsonProperty("identification") String identification,
            @JsonProperty("enabled") Boolean enabled,
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("address") Address address) {
        this.id = id;
        this.identification = identification;
        this.enabled = enabled;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id) && Objects.equals(identification, seller.identification) && Objects.equals(enabled, seller.enabled) && Objects.equals(name, seller.name) && Objects.equals(email, seller.email) && Objects.equals(address, seller.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identification, enabled, name, email, address);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id='" + id + '\'' +
                ", identification='" + identification + '\'' +
                ", enabled=" + enabled +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
