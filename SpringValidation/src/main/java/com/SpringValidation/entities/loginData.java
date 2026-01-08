package com.SpringValidation.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class loginData {

    @NotBlank(message = "User name can not be empty!!")
    @Size(min = 3,max = 12,message = "User name must be between 3-12 characters")
    private String userName;

    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")
    private String email;

    @AssertTrue(message = "Must agree terms and condition")
    private boolean agreed;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @AssertTrue
    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(@AssertTrue boolean agreed) {
        this.agreed = agreed;
    }

    @Override
    public String toString() {
        return "loginData{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
