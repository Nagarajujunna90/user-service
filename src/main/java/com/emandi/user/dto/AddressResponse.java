package com.emandi.user.dto;

import lombok.Data;

@Data
public class AddressResponse {
    private Integer id;
    private String street;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}
