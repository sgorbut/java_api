package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileResponse {

    private String phone;

    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}


    private boolean isRegistered;

    public boolean getIsRegistered(){return isRegistered;}

}