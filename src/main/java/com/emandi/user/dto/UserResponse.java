package com.emandi.user.dto;

import com.emandi.user.model.Cart;
import com.emandi.user.model.User;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private Integer id;
//    private String userName;
    private String firstName;
    private String lastName;
    private Integer mobileNumber;
//
//    private String fatherName;
//    private Integer gender;
//    private List<CartResponse> cartResponseList;


    public UserResponse(User user) {
        this.id=user.getId();
      //  this.userName = user.getUserName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        //this.fatherName = user.getFatherName();
        this.mobileNumber = user.getMobileNumber();
        //this.gender = user.getGender();
    }
}
