package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileResponse {

    private String phone;

    public String getPhone(){return phone;}


    private boolean isRegistered;

    public boolean getIsRegistered(){return isRegistered;}

}