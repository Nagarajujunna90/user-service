package com.emandi.user.model;


import lombok.Data;

import java.util.Date;

@Data
public class Product {

    private Integer id;
    private String productDescription;
    private String name;

    private Date manufacturingDate;

    private String productCompany;

    

   /* @ManyToMany(mappedBy = "orders")
    private List<User> users;*/

}
