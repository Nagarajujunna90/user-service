package com.emandi.user.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDTO {
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
}
