package com.emandi.user.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String street;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}
