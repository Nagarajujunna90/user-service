package com.emandi.user.model;

import com.emandi.user.dto.UserRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Integer mobileNumber;
    private Integer gender;
    @OneToOne
    private Address address;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User(UserRequest userRequest) {
        this.userName = userRequest.getUserName();
        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
        this.mobileNumber = userRequest.getMobileNumber();
        this.gender = userRequest.getGender();
    }
}


