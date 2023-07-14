package com.emandi.user.model;

import com.emandi.user.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String motherName;
    private Integer mobileNumber;
    private Integer gender;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Cart> carts;

    public User(String userName, String password, String firstName, String lastName, String fatherName, String motherName) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
    }

    public User(UserDTO userDTO) {
        this.userName = userDTO.getUserName();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.mobileNumber=userDTO.getMobileNumber();
        this.gender=userDTO.getGender();
    }
}


