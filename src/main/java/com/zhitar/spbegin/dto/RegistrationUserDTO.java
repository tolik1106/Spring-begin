package com.zhitar.spbegin.dto;


import com.zhitar.spbegin.validation.PasswordTheSame;
import com.zhitar.spbegin.validation.ValidEmail;

import javax.validation.constraints.NotEmpty;

@PasswordTheSame
public class RegistrationUserDTO {

    @NotEmpty(message = "Email is required")
    @ValidEmail
    private String login;

    @NotEmpty(message = "Password is required")
    private String password;

    private String rePassword;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
