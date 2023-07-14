package com.emandi.user.dto;

import com.emandi.user.model.Cart;
import com.emandi.user.model.Role;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {
    @NotEmpty
    private Integer mobileNumber;
    @NotEmpty
    private Integer gender;
    @NotEmpty
    private String userName;
    @NotEmpty
    private Integer password;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String roleName;
//    private Role role;
//    private Cart cart;

}
	

