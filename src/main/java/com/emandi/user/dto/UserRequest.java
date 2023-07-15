package com.emandi.user.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserRequest {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private Integer mobileNumber;
    @NotNull
    private Integer password;
    private Integer gender;
    private String userName;
    private String roleName;
    private AddressRequest addressRequest;
//    private Role role;
//    private Cart cart;

}
	

