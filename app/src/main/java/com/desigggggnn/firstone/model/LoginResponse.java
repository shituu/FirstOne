package com.desigggggnn.firstone.model;

public class LoginResponse {
    private String message;
    private String email;
    private String password;
    private String device_id;
    private int type;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String social_key;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSocial_key() {
        return social_key;
    }

    public void setSocial_key(String social_key) {
        this.social_key = social_key;
    }
}
