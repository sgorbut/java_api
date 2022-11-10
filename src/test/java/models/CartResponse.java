package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartResponse {

    private String cart;

    public String getCart(){return cart;}

}
