package com.emandi.user.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
}
