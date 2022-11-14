package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressesResponse {

    private Integer addressId;
    private String address;

    public Integer getAddressId() {
        return addressId;
    }

    public String getAddress() {
        return address;
    }

}
