package com.emandi.customerservice.dto;

import com.emandi.customerservice.model.Cart;
import com.emandi.customerservice.model.Role;
import lombok.Data;

@Data
public class UserDTO {
   
	private String userName;
	private Integer password;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String qualification;
	private String roleName;
	private Role role;
	private Cart cart;
	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", fatherName=" + fatherName + ", qualification=" + qualification + ", roleName="
				+ roleName + "]";
	}
	
	}
	

